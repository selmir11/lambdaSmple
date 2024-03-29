package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.math.BigDecimal;
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

    @FindBy(xpath = "//img[@title='Connect for Health Colorado']")
    WebElement connectForHealthLogo;
    @FindBy(id = "title")
    WebElement Title;
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
    @FindBy(id = "accountId")
    WebElement acctIdWidget;
    @FindBy(css = "#broker")
    WebElement broker;
    @FindBy(id = "programManager")
    WebElement programManager;
    @FindBy(css = "#agency")
    WebElement agency;
    @FindBy(id = "cocoIndividual")
    WebElement coco;
    @FindBy(id = "individual")
    WebElement individual;
    @FindBy(css = "tbody td:nth-child(1)")
    WebElement searchAcctResults;

    public void searchForUser() {
        // TO DO: Make this re-usable if we search for users other than subscriber. Pass the values as param
        basicActions.waitForElementListToBePresent(searchInputList, 10);
        MemberDetails subscriber = SharedData.getPrimaryMember();
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

        String accId = currentUrl.substring(currentUrl.lastIndexOf("/") + 1);
        MemberDetails subscriber = SharedData.getPrimaryMember();
        subscriber.setAccount_id(new BigDecimal(accId));
        SharedData.setPrimaryMember(subscriber);
    }
    public void clickFromApplicationLinksDropdown(String dropdownOption){
        basicActions.waitForElementToBePresent(appLinksDropDown, 10);
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", appLinksDropDown);
        basicActions.waitForElementListToBePresent(appLinksDropdownOptions, 10);
        appLinksDropdownOptions.stream().filter(appLinksDropdownOptions -> appLinksDropdownOptions.getText().equals(dropdownOption)).findFirst().ifPresent(WebElement::click);
    }
    public void logoutFromAdmin(){
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
    public void ConnectForHealthLogoDisplay(){
        softAssert.assertTrue(basicActions.waitForElementToBePresent(connectForHealthLogo,10));
        softAssert.assertAll();
    }
    public void navigateConnectForHealthPage(){
        connectForHealthLogo.click();
        navigateToPreviousPage();
    }
    public void titleTextValidate(){
        Title.isDisplayed();
        softAssert.assertEquals(Title.getText(), "Sign in to your account");
        softAssert.assertAll();
    }
    public void SelectUserTypeToSearch(String selectUserTypeToSearch){
        switch (selectUserTypeToSearch) {
            case "individual":
                basicActions.waitForElementToBePresent(individual, 15);
                individual.click();
                break;
            case "cocoBroker":
                basicActions.waitForElementToBePresent(broker, 15);
                broker.click();
                break;
            case "cocoProgramManager":
                basicActions.waitForElementToBePresent(programManager, 15);
                programManager.click();
                break;
            case "cocoAgency":
                basicActions.waitForElementToBePresent(agency, 15);
                agency.click();
                break;
            case "coco":
                basicActions.waitForElementToBePresent(coco, 15);
                coco.click();
                break;
            default:
                throw new IllegalArgumentException("Unsupported user type: " + selectUserTypeToSearch);
        }
    }
    public void clickAccountLinkSearchResults() {
        basicActions.waitForElementToBePresent(searchAcctResults, 10);
        searchAcctResults.click();
        }
}
