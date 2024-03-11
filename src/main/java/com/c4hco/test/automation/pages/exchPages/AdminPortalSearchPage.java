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

    public void searchForUser(){
        basicActions.waitForElementListToBePresent(searchInputList, 10);
        searchInputList.get(1).sendKeys(SharedData.getFirstName());
        searchInputList.get(2).sendKeys(SharedData.getLastName());
        searchInputList.get(3).sendKeys(SharedData.getEmailId());
        buttonsList.get(0).click();
        setAccountId();
    }

    public void clickEmailLinkFrmSrchResults(){
        basicActions.waitForElementToBePresent(searchTable, 10);
        primaryEmail.click();
    }

    public void setAccountId(){
        basicActions.waitForElementToBePresent(accIdAndCaseId, 10);
        String currentUrl = basicActions.getCurrentUrl();
        String accId = currentUrl.substring(currentUrl.lastIndexOf("/")+1);
        SharedData.setAccountId(accId);
    }

    public void clickAdminLceFromDropdown(){
        // click AdminLce - click based on the option/Text we pass && should this/step be moved to a toolbar page?  -- TO DO
        basicActions.waitForElementToBePresent(appLinksDropDown, 10);
        appLinksDropDown.click();
        appLinksDropdownOptions.get(4).click(); //opens new tab
    }
}
