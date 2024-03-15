package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.PolicyMember;
import com.c4hco.test.automation.utils.SharedData;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPortalSearchPage {
    // TO DO:: Update the locators based on - if the search table will have more than 1 row
    // check the locators will work as a list and convert to list - else - find a list locator to make them re-usable

    private BasicActions basicActions;

    public AdminPortalSearchPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".search-input-and-label .search-input")
    List<WebElement> searchInputList;

    @FindBy(css = ".form-btn-group.big-screen button")
    List<WebElement> buttonsList; // search, reset, create Account buttons

    @FindBy(css = ".search-results-container .search-results-table")
    WebElement searchResults;

    @FindBy(id = "email-shortened")
    WebElement primaryEmail;

    @FindBy(css = ".dashboardHeader2")
    WebElement accIdAndCaseId;

    @FindBy(css = ".tollbar-app-links span")
    WebElement appLinksDropDown;

    @FindBy(css = "#toolbar-app-dropdown .dropdown-option")
    List<WebElement> appLinksDropdownOptions;

    @FindBy(css = "#header-user span:nth-child(3)")
    WebElement dropdownArrow;

    @FindBy(id = "logout-link")
    WebElement logoutAdmin;

    public void searchForUser(){
        // TO DO: Make this re-usable if we search for users other than subscriber. Pass the values as param
        basicActions.waitForElementListToBePresent(searchInputList, 10);
        PolicyMember subscriber = SharedData.getSubscriber();
        searchInputList.get(1).sendKeys(subscriber.getFirstName());
        searchInputList.get(2).sendKeys(subscriber.getLastName());
        searchInputList.get(3).sendKeys(subscriber.getEmailId());
        buttonsList.get(0).click();
    }

    public void clickEmailLinkFrmSrchResults(){
        basicActions.waitForElementToBePresent(searchResults, 10);
        primaryEmail.click();
        setAccountId();
    }

    public void setAccountId(){
        basicActions.waitForElementToBePresent(accIdAndCaseId, 10);
        String currentUrl = basicActions.getCurrentUrl();
        String accId = currentUrl.substring(currentUrl.lastIndexOf("/")+1);
        PolicyMember subscriber = SharedData.getSubscriber();
        subscriber.setAccountId(accId);
        SharedData.setSubscriber(subscriber);
    }

    public void clickFromApplicationLinksDropdown(String dropdownOption){
        basicActions.waitForElementToBePresent(appLinksDropDown, 10);
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", appLinksDropDown);
        basicActions.waitForElementListToBePresent(appLinksDropdownOptions, 10);
        appLinksDropdownOptions.stream().filter(appLinksDropdownOptions -> appLinksDropdownOptions.getText().equals(dropdownOption)).findFirst().ifPresent(WebElement::click);
    }

    public void logoutFromAdmin() {
        navigateToPreviousPage();
        basicActions.waitForElementToBePresent(dropdownArrow,100);
        dropdownArrow.click();
        basicActions.waitForElementToBePresent(logoutAdmin,100);
        logoutAdmin.click();
    }

    public void navigateToPreviousPage(){
        basicActions.getDriver().navigate().back();
    }

    public void clickCreateAccount(){
        basicActions.waitForElementListToBePresent(buttonsList,10);
        buttonsList.get(2).click();
    }
}
