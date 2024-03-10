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

        public void lookUp(){
            // TO DO:: rename method and split into smaller methods based on fucntionality
            ArrayList<String> tabs = new ArrayList<String> (basicActions.getDriver().getWindowHandles());
           basicActions.getDriver().switchTo().window(tabs.get(1)) ;
            softAssert.assertEquals(basicActions.getCurrentUrl().contains("adminLce"), true);
            softAssert.assertAll();
            basicActions.waitForElementToBePresent(adminLCEToolAccountIdInput, 10);
            adminLCEToolAccountIdInput.sendKeys(SharedData.getAccountId());
            lookUpBtn.click();
            // validate look up returned results
            basicActions.waitForElementToBePresent(lookUpSearchResults, 10);
            basicActions.waitForElementToBePresent(planYrDropdown, 10);
            planYrDropdown.click();

            //FIND OUT :: First plan is going to be current year always??
            planYrDrpdwnOptions.get(1).click();

            changeEffectiveDt.sendKeys("0101");
            submitBtn.click();
            basicActions.waitForElementToDisappear(lookUpSearchResults, 10);
            basicActions.closeBrowserTab();
            basicActions.getDriver().switchTo().window(tabs.get(0));

        }
}
