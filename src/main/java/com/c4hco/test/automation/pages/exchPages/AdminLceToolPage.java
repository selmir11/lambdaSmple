package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.SharedData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(id="changeEffDate")
    WebElement changeEffectiveDt;

    @FindBy(id="addAdminButton")
    WebElement submitBtn;

        public void lookUpAccId(){
            tabs = new ArrayList<String> (basicActions.getDriver().getWindowHandles());
           basicActions.getDriver().switchTo().window(tabs.get(1)) ;
            softAssert.assertEquals(basicActions.getCurrentUrl().contains("adminLce"), true);
            softAssert.assertAll();
            basicActions.waitForElementToBePresent(adminLCEToolAccountIdInput, 10);
            adminLCEToolAccountIdInput.sendKeys(SharedData.getAccountId());
            lookUpBtn.click();
            // validate look up returned results
            basicActions.waitForElementToBePresent(lookUpSearchResults, 10);
        }

        public void changeEffectiveDate(String effectiveDate){
            basicActions.waitForElementToBePresent(planYrDropdown, 10);
            planYrDropdown.click();

            planYrDrpdwnOptions.get(1).click(); // selects current year

            changeEffectiveDt.sendKeys(effectiveDate);
            submitBtn.click();
            basicActions.waitForElementToDisappear(lookUpSearchResults, 10);
            SharedData.setSelectedMedicalPlanStartDate("01/01/2024"); // TO DO: send the year as current year dynamically
            SharedData.setSelectedMedicalPlanEndDate("12/31/2024");
            SharedData.setSelectedDentalPlanStartDate("01/01/2024");
            SharedData.setSelectedDentalPlanEndDate("12/31/2024");
            SharedData.setFinancialStartDate("01/01/2024");
            closeTabAndSwitchToCurrentWindow();
        }

        public void closeTabAndSwitchToCurrentWindow(){
            // TO DO: Check if this can be made re-usable by moving it to basicActions.
            basicActions.closeBrowserTab();
            basicActions.getDriver().switchTo().window(tabs.get(0));
        }
}
