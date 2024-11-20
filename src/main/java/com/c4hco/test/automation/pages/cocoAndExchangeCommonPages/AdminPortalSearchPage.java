package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import org.openqa.selenium.JavascriptExecutor;
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

    @FindBy(xpath = "//span[contains(text(),'Hello')]")
    WebElement APtxtHello;

    @FindBy(id = "user-first-name")
    WebElement txtAPUserFName;

    @FindBy(css = "svg[data-prefix='far']")
    WebElement pnlAPPersonSymbol;

    @FindBy(xpath = "//div[normalize-space()='Account Information']")
    WebElement pnlAccountInformation;

    @FindBy(xpath = "//body//app-root//span[3]")
    WebElement userDropdown;

    //BlueBarLinks
    @FindBy(xpath = "//strong[normalize-space()='Admin Portal']")
    WebElement txtAdminPortal;

    @FindBy(xpath = "//span[contains(text(),'Application Links')]")
    WebElement AppLinkText;

    @FindBy(xpath = "//span[@class='tollbar-app-links']//span")
    public WebElement ApplicationLinksdropdown;

    @FindBy(css = "#logout-link")
    WebElement logoutAdmin;

    @FindBy(css = ".col.text-lg-right.p-0")
    WebElement searchUser;

    //Select Check box to search user types
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

    @FindBy(id = "accountId")
    WebElement acctIdWidget;

    @FindBy(css = "tbody td:nth-child(1)")
    WebElement searchAcctResults;

    @FindBy(xpath = "//app-search-container/form/div[3]/div/p")
    WebElement statusMessage;

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
        basicActions.waitForElementToBePresent(dropdownArrow, 100);
        dropdownArrow.click();
        basicActions.waitForElementToBePresent(logoutAdmin, 100);
        logoutAdmin.click();
    }

    public void navigateToPreviousPage() {
        basicActions.getDriver().navigate().back();
    }

    public void clickSearch() {
        basicActions.waitForElementToBePresent(searchUser, 10);
        searchUser.click();
    }

    public void clickCreateAccount() {
        basicActions.waitForElementListToBePresent(buttonsList, 10);
        buttonsList.get(2).click();
    }

    public void ConnectForHealthLogoDisplay() {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(connectForHealthLogo, 10));
        softAssert.assertAll();
    }

    public void navigateConnectForHealthPage () {
        connectForHealthLogo.click();
        navigateToPreviousPage();
    }
    public void titleTextValidate () {
        Title.isDisplayed();
        softAssert.assertEquals(Title.getText(), "Sign in to your account");
        softAssert.assertAll();
    }

    public void userNameDisplay () {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(APtxtHello, 10));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(txtAPUserFName, 10));
        softAssert.assertAll();
    }

    public void PersonSymbolDisplay () {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(pnlAPPersonSymbol, 10));
        softAssert.assertAll();
    }

    public void UserDropDownDisplay () {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(userDropdown, 10));
        softAssert.assertTrue(userDropdown.isDisplayed(), "Account Information is not displaying on Search page");
        userDropdown.click();
        softAssert.assertAll();
    }

    public void accountInformationDisplay () {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(pnlAccountInformation, 10));
        softAssert.assertTrue(pnlAccountInformation.isDisplayed(), "Account Information is not displaying on Search page");
        softAssert.assertAll();
    }

    public void adminPortalTextDisplay () {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(txtAdminPortal, 10));
        softAssert.assertTrue(txtAdminPortal.isDisplayed(), "Admin Portal Text is not displaying on Search page ");
        softAssert.assertAll();
    }

    public void applicationLinksTextDisplay () {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(AppLinkText, 10));
        softAssert.assertTrue(AppLinkText.isDisplayed(), "Application Link Text is not displaying on Search page");
        softAssert.assertAll();
    }

    public void applinkdroodowndisplay () {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(ApplicationLinksdropdown, 10));
        softAssert.assertTrue(ApplicationLinksdropdown.isDisplayed(), "Application Link Arrow is displaying on Search page");
        softAssert.assertAll();
    }

    public void selectRecord () {
        basicActions.waitForElementToBeClickable(primaryEmail, 20);
        primaryEmail.click();
    }

    public void logoutButtonDisplay () {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(logoutAdmin, 10));
        softAssert.assertTrue(logoutAdmin.isDisplayed(), "Logout is not visible on search page");
        softAssert.assertAll();
    }

    public void selectCocoIndiviual () {
        basicActions.waitForElementToBePresent(coco, 20);
        basicActions.waitForElementToBeClickable(coco, 20);
        coco.click();
    }

    public void SelectUserTypeToSearch (String selectUserTypeToSearch){
        switch (selectUserTypeToSearch) {
            case "individual":
                basicActions.waitForElementToBePresent(individual, 15);
                individual.click();
                break;
            case "Broker":
                basicActions.waitForElementToBePresent(broker, 15);
                broker.click();
                break;
            case "Program Manager":
                basicActions.waitForElementToBePresent(programManager, 15);
                programManager.click();
                break;
            case "Agency":
                basicActions.waitForElementToBePresent(agency,15);
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


    public void enterUserData(String userdata, String type) {
        switch (userdata) {
            case "accountID":
                searchInputList.get(0).sendKeys(type);
                break;
            case "FirstName":
                searchInputList.get(1).sendKeys(type);
                break;
            case "LastName":
                searchInputList.get(2).sendKeys(type);
                break;
            case "Email":
                searchInputList.get(3).sendKeys(type);
                break;
            case "DOB":
                searchInputList.get(4).sendKeys(type);
                break;
            case "PrimaryPhone":
                searchInputList.get(5).sendKeys(type);
                break;
            default: throw new IllegalArgumentException("Invalid header option : " + userdata);
        }
    }

    public void enterUserDataAnyENV(String userdata, String QAType ,String STGType) {
        if(SharedData.getEnv().equals("qa")){
            enterUserData(userdata, QAType);
        }else{
            enterUserData(userdata, STGType);
        }
    }
    public void enterAccountIdToAnyENV(String accountIdSTG, String accountIdQA) {
        basicActions.wait(2000);
        if (SharedData.getEnv().equals("staging")){
            searchInputList.get(0).sendKeys(accountIdSTG);
        }else {
            searchInputList.get(0).sendKeys(accountIdQA);
        }
      }

    public void clickAccountLinkFirstRowFromSearchResults() {
        basicActions.waitForElementToBePresent(searchAcctResults, 10);
        searchAcctResults.click();
    }
    public void validateAppLinksIsNotDisplay(String option) {
        basicActions.waitForElementToBePresent(appLinksDropDown, 30);
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", appLinksDropDown);
        for (int i = 0; i < appLinksDropdownOptions.size(); i++) {
            basicActions.waitForElementListToBePresent(appLinksDropdownOptions, 10);
            softAssert.assertNotEquals(appLinksDropdownOptions.get(i).getText(), option);
            softAssert.assertAll();
        }
    }
    public void logoutFromAdminPortalParentPage() {
            basicActions.switchToParentPage("C4HCO Admin Portal");
            basicActions.waitForElementToBePresent(dropdownArrow, 100);
            dropdownArrow.click();
            basicActions.waitForElementToBePresent(logoutAdmin, 100);
            logoutAdmin.click();
        }

        public void accountCreatedMessage(){
        basicActions.waitForElementToBePresent(statusMessage, 30);
        softAssert.assertEquals(statusMessage.getText(),"Account created successfully. Please search for the account.");
        softAssert.assertAll();
        }
    public void clickResetAdminPortal () {
        basicActions.waitForElementListToBePresent(buttonsList, 10);
        buttonsList.get(1).click();
    }
}
