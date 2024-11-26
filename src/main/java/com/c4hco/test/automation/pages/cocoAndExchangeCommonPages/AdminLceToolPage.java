package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdminLceToolPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    private ArrayList<String> tabs;

    public AdminLceToolPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "accountId")
    WebElement adminLCEToolAccountIdInput; // Admin LCE Tool PAGE

    @FindBy(id = "submitButton")
    WebElement lookUpBtn;

    @FindBy(css = ".panel-body #adminLceSubmit")
    WebElement lookUpSearchResults;

    @FindBy(id = "planYear")
    WebElement planYrDropdown;

    @FindBy(css = "#planYear option")
    List<WebElement> planYrDrpdwnOptions; // includes default text and years

    @FindBy(id = "changeEffDate")
    WebElement changeEffectiveDt;

    @FindBy(id = "addAdminButton")
    WebElement submitBtn;
    @FindBy(css = "body > div.outer-container > div.container > h1")
    WebElement titleAdminLceTool;
    @FindBy(xpath = "//b[normalize-space()='Account Number']")
    WebElement acctNumberLceTool;
    @FindBy(css = "#header-user span:nth-child(3)")
    WebElement dropdownArrow;
    @FindBy(id = "logout-link")
    WebElement logoutAdmin;

    public void lookUpAccId() {
        tabs = new ArrayList<>(basicActions.getDriver().getWindowHandles());
        basicActions.getDriver().switchTo().window(tabs.get(1));
        softAssert.assertEquals(basicActions.getCurrentUrl().contains("adminLce"), true);
        softAssert.assertAll();
        basicActions.waitForElementToBePresent(adminLCEToolAccountIdInput, 10);
        System.out.println("Account ID ::" + SharedData.getPrimaryMember().getAccount_id());
        adminLCEToolAccountIdInput.sendKeys(String.valueOf(SharedData.getPrimaryMember().getAccount_id()));
        lookUpBtn.click();
        // validate look up returned results
        basicActions.waitForElementToBePresent(lookUpSearchResults, 10);
    }

    public void validatePlanYearOptions() {
        basicActions.waitForElementToBePresent(planYrDropdown, 10);

        int currentYear = Year.now().getValue();
        List<String> expectedOptions = List.of("Select Option", String.valueOf(currentYear), String.valueOf(currentYear - 1), String.valueOf(currentYear - 2), String.valueOf(currentYear - 3));

        planYrDropdown.click();
        Select dropdown = new Select(planYrDropdown);
        basicActions.waitForElementListToBePresent(dropdown.getOptions(), 10);
        List<String> actualOptions = dropdown.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());

        Assert.assertEquals(actualOptions, expectedOptions, "Plan Year options in the dropdown did not match");
    }

    public void changeEffectiveDate(String effectiveDate) {
        MemberDetails subscriber = SharedData.getPrimaryMember();
        basicActions.waitForElementToBePresent(planYrDropdown, 10);
        planYrDropdown.click();

        planYrDrpdwnOptions.get(1).click(); // selects current year

        changeEffectiveDt.sendKeys(effectiveDate);
        submitBtn.click();
        basicActions.waitForElementToDisappear(lookUpSearchResults, 10);

        SharedData.setPrimaryMember(subscriber);

        closeTabAndSwitchToCurrentWindow();
    }

    public void closeTabAndSwitchToCurrentWindow() {
        // TO DO: Check if this can be made re-usable by moving it to basicActions.
        basicActions.closeBrowserTab();
        basicActions.getDriver().switchTo().window(tabs.get(0));
    }

    public void verifyAdminLceContainerTitle() {
        titleAdminLceTool.isDisplayed();
        softAssert.assertEquals(titleAdminLceTool.getText(), "Admin LCE Tool");
        softAssert.assertTrue(acctNumberLceTool.isDisplayed());
        softAssert.assertAll();
    }
    public void logoutFromAdminLce() {
        basicActions.switchToParentPage("C4HCO Admin Portal");
        basicActions.waitForElementToBePresent(dropdownArrow, 100);
        dropdownArrow.click();
        basicActions.waitForElementToBePresent(logoutAdmin, 100);
        logoutAdmin.click();
    }
    public void initiateIncomingPage() {
        basicActions.switchtoactiveTab();   }
}
