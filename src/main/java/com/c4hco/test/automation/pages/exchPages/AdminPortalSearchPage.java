package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.SharedData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AdminPortalSearchPage {
    // TO DO:: Update the locators based on - if the search table will have more than 1 row
    // check the locators will work as a list and convert to list - else - find a list locator to make them re-usable

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public AdminPortalSearchPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".search-input-and-label .search-input")
    List<WebElement> searchInputList;

    @FindBy(css = ".form-btn-group.big-screen button")
    List<WebElement> buttonsList; // search, reset, create Account buttons

    @FindBy(css = ".search-results-container .search-results-table")
    WebElement searchTable;

    @FindBy(id = "email-shortened")
    WebElement primaryEmail;

    @FindBy(css = ".dashboardHeader2")
    WebElement accIdAndCaseId;

    @FindBy(css = ".tollbar-app-links span")
    WebElement appLinksDropDown;

    @FindBy(css = "#toolbar-app-dropdown .dropdown-option")
    List<WebElement> appLinksDropdownOptions;

    @FindBy(id = "accountId")
    WebElement adminLCEToolAccountIdInput; // Admin LCE Tool PAGE

    @FindBy(id = "#submitButton")
    WebElement lookUpBtn; // Admin LCE Tool PAGE

    public void changeEffectiveDate(){
        basicActions.waitForElementListToBePresent(searchInputList, 10);
        searchInputList.get(1).sendKeys(SharedData.getFirstName());
        searchInputList.get(2).sendKeys(SharedData.getLastName());
        searchInputList.get(3).sendKeys(SharedData.getEmailId());

        buttonsList.get(0).click();

        basicActions.waitForElementToBePresent(searchTable, 10);

            primaryEmail.click();

            basicActions.waitForElementToBePresent(accIdAndCaseId, 10);
            System.out.println("--dashboardHearder text"+accIdAndCaseId.getText());
        accIdAndCaseId.getText();
       String currentUrl = basicActions.getCurrentUrl();
       System.out.println("getAccIdFromUrl----"+ currentUrl.substring(currentUrl.lastIndexOf("/")+1));
       String accId = currentUrl.substring(currentUrl.lastIndexOf("/")+1);
       SharedData.setAccountId(accId);

        appLinksDropDown.click();

        // click AdminLce - click based on the option we pass -- TO DO
        appLinksDropdownOptions.get(4).click(); //opens new tab

        // validte adminLCE page is opened
//        softAssert.assertEquals(basicActions.getCurrentUrl().contains("adminLce"), true);

        // FIND OUT -- ADMIN LCE Tool page - does this have to be a separate page?
        // OPTIMISE THE BELOW CODE
        // Switch window handle to newly opened tab - make this re-usable-it is also used in basic steps.
//        String origin = basicActions.getDriver().getWindowHandle();
//        for (String handle : basicActions.getDriver().getWindowHandles()) {
//            basicActions.getDriver().switchTo().window(handle);
//            basicActions.waitForElementToBePresent(adminLCEToolAccountIdInput, 10);
//            adminLCEToolAccountIdInput.sendKeys(SharedData.getAccountId());
//            lookUpBtn.click();
         /*   adminLCEToolPage.selectCurrentYear();
            adminLCEToolPage.enterEffectiveDate();

            state.getSubscriber().setFinancialEffectiveDate("%s0101".formatted(Year.now().toString()));

            adminLCEToolPage.clickSubmitButton();
            adminLCEToolPage.closeWindow();
            driver.switchTo().window(rootHandle); */
//            break;
//        }
//        basicActions.closeBrowserTab();
//        basicActions.getDriver().switchTo().window(origin);


      //  softAssert.assertAll();
            /*


             */

    }
}
