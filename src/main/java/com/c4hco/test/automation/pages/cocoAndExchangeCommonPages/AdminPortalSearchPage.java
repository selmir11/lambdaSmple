package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;
import com.c4hco.test.automation.Dto.BrokerDetails;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class AdminPortalSearchPage {
    // TO DO:: Update the locators based on - if the search table will have more than 1 row
    // check the locators will work as a list and convert to list - else - find a list locator to make them re-usable

    private BasicActions basicActions;
    static SoftAssert softAssert = new SoftAssert();

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

    @FindBy(css = ".col-name")
    List<WebElement> searchResultsTitles;

    @FindBy(xpath = "//tr[@class='clickable']/td")
    List<WebElement> aactsearchResults;

    @FindBy(css = ".invalid-form")
    WebElement messagemorethan100records;

    @FindBy(css = ".svg-inline--fa.fa-angle-down.fa-w-10")
    WebElement sortDropdown;

    @FindBy(css = "div.option.option")
    List<WebElement> sortOption;

    @FindBy(xpath = "//tbody/tr/td[1]")
    List<WebElement> AccountsID;
    @FindBy(xpath = "//tbody/tr/td[2]")
    List<WebElement> FirstName;
    @FindBy(xpath = "//tbody/tr/td[3]")
    List<WebElement> LastName;

    @FindBy(css = "tbody td:nth-child(4)")
    List<WebElement> primaryAccountHolderName;

    @FindBy(css = "tbody td:nth-child(6)")
    List<WebElement> emailAddress;

    @FindBy(css = "tbody td:nth-child(7)")
    List<WebElement> phoneNumber;

    @FindBy(xpath = "//table[1]/tbody[1]/tr[3]/td[1]") // This locator just using to avoid hard wait
    WebElement rowTenth;

    @FindBy(xpath = "(//button[@type='button'][normalize-space()='Reset'])[2]")
    WebElement Reset;

    @FindBy(xpath = "//div[@class='invalid-form']")
    WebElement searchCriteriaError;

    @FindBy(xpath = "//app-search-container/form/div[3]/div/p")
    WebElement statusMessage;
    @FindBy(xpath = "//tr[@class='clickable']/td[1]")
    WebElement firstBrokerResult;

    @FindBy(xpath = "//*[@class='search-title']")
    WebElement searchTitle;

    @FindBy(xpath = "//*[@id='heading']")
    WebElement cbmsTitle;
    @FindBy(xpath = "//label[@for='exchangePersonId']")
    WebElement personIdLabel;
    @FindBy(xpath = "//label[@for='firstname']")
    WebElement firstNameLabel;
    @FindBy(xpath = "//label[@for='lastname']")
    WebElement lastNameLabel;
    @FindBy(xpath = "//label[@for='cbmsPersonId']")
    WebElement cbmsPersonIdLabel;
    @FindBy(xpath = "//label[@for='ssn']")
    WebElement ssnLabel;
    @FindBy(xpath = "//label[@for='dateOfBirth']")
    WebElement dobLabel;
    @FindBy(css = "label[for='middleInitial']")
    WebElement middleLabel;
    @FindBy(css = "label[for='suffix']")
    WebElement suffixLabel;
    @FindBy(css = "label[for='stateId']")
    WebElement stateIdLabel;
    @FindBy(css = "label[for='gender']")
    WebElement sexLabel;
    @FindBy(xpath = "//div[contains(text(),'Please enter Exchange Person ID')]")
    WebElement personIdError;
    @FindBy(xpath = "//div[contains(text(),'Please enter First Name')]")
    WebElement firstNameError;
    @FindBy(xpath = "//div[contains(text(),'Please enter Last Name')]")
    WebElement lastNameError;
    @FindBy(xpath = "//div[contains(text(),'Please enter Date of Birth')]")
    WebElement dobError;
    @FindBy(css = ".btn-primary-action-button.search-button")
    WebElement cbmsSearchButton;
    @FindBy(css = ".btn-second-action-button.reset-button")
    WebElement cbmsResetButton;

    @FindBy(id = "header-user-dropdown")
    WebElement userDropdownColor;

    @FindBy(id = "toolbar-app-dropdown")
    WebElement applicationLinkColor;

    @FindBy(id = "header-user")
    WebElement userName;




    public void searchForUser() {
        // TO DO: Make this re-usable if we search for users other than subscriber. Pass the values as param
        basicActions.waitForElementListToBePresent(searchInputList, 10);
        MemberDetails subscriber = SharedData.getPrimaryMember();
        searchInputList.get(1).sendKeys(subscriber.getFirstName());
        searchInputList.get(2).sendKeys(subscriber.getLastName());
        searchInputList.get(3).sendKeys(subscriber.getEmailId());
        buttonsList.get(0).click();
    }

    public void searchWithAccId(){
        basicActions.waitForElementListToBePresent(searchInputList, 10);
        searchInputList.get(0).sendKeys(String.valueOf(SharedData.getPrimaryMember().getAccount_id()));
        buttonsList.get(0).click();
    }


    public void clickEmailLinkFrmSrchResults() {
        basicActions.waitForElementToBePresent(searchResults, 10);
        primaryEmail.click();
        setAccountId();
    }

    public void setAccountId() {
        basicActions.waitForElementToBePresent(accIdAndCaseId, 10);
        String currentUrl = basicActions.getCurrentUrl();

        String accId = currentUrl.substring(currentUrl.lastIndexOf("/") + 1);
        MemberDetails subscriber = SharedData.getPrimaryMember();
        if (subscriber == null) {
            subscriber = new MemberDetails();
        }
        subscriber.setAccount_id(new BigDecimal(accId));
        SharedData.setPrimaryMember(subscriber);
    }

    public void clickFromApplicationLinksDropdown(String dropdownOption) {
        basicActions.waitForElementToBePresent(appLinksDropDown, 10);
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", appLinksDropDown);
        basicActions.waitForElementListToBePresent(appLinksDropdownOptions, 10);
        appLinksDropdownOptions.stream().filter(appLinksDropdownOptions -> appLinksDropdownOptions.getText().equals(dropdownOption)).findFirst().ifPresent(WebElement::click);
    }

    public void logoutFromAdmin() {
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

    public void navigateConnectForHealthPage() {
        connectForHealthLogo.click();
        navigateToPreviousPage();
    }

    public void titleTextValidate() {
        Title.isDisplayed();
        softAssert.assertEquals(Title.getText(), "Sign in to your account");
        softAssert.assertAll();
    }

    public void userNameDisplay() {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(APtxtHello, 10));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(txtAPUserFName, 10));
        softAssert.assertAll();
    }

    public void PersonSymbolDisplay() {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(pnlAPPersonSymbol, 10));
        softAssert.assertAll();
    }

    public void UserDropDownDisplay() {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(userDropdown, 10));
        softAssert.assertTrue(userDropdown.isDisplayed(), "Account Information is not displaying on Search page");
        userDropdown.click();
        softAssert.assertAll();
    }

    public void accountInformationDisplay() {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(pnlAccountInformation, 10));
        softAssert.assertTrue(pnlAccountInformation.isDisplayed(), "Account Information is not displaying on Search page");
        softAssert.assertAll();
    }

    public void adminPortalTextDisplay() {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(txtAdminPortal, 10));
        softAssert.assertTrue(txtAdminPortal.isDisplayed(), "Admin Portal Text is not displaying on Search page ");
        softAssert.assertAll();
    }

    public void applicationLinksTextDisplay() {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(AppLinkText, 10));
        softAssert.assertTrue(AppLinkText.isDisplayed(), "Application Link Text is not displaying on Search page");
        softAssert.assertAll();
    }

    public void applinkdroodowndisplay() {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(ApplicationLinksdropdown, 10));
        softAssert.assertTrue(ApplicationLinksdropdown.isDisplayed(), "Application Link Arrow is displaying on Search page");
        softAssert.assertAll();
    }

    public void selectRecord() {
        basicActions.waitForElementToBeClickableWithRetries(primaryEmail, 20);
        primaryEmail.click();
    }

    public void logoutButtonDisplay() {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(logoutAdmin, 10));
        softAssert.assertTrue(logoutAdmin.isDisplayed(), "Logout is not visible on search page");
        softAssert.assertAll();
    }

    public void selectCocoIndiviual() {
        basicActions.waitForElementToBePresent(coco, 20);
        basicActions.waitForElementToBeClickable(coco, 20);
        coco.click();
    }

    public void SelectUserTypeToSearch(String selectUserTypeToSearch) {
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

    public void entersearchdata(DataTable dataTable) {
        List<Map<String, String>> dataRows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : dataRows) {
            String userdata = row.get("FieldName");
            String qaValue  = row.get("QA Value");
            String STGValue = row.get("STG Value");
            this.enterUserDataAnyENV(userdata,qaValue,STGValue);
        }
    }

    public void enterUserData(String userdata, String type) {
        basicActions.waitForElementToBePresentWithRetries(searchUser, 10);
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
                searchInputList.get(4).sendKeys(type);
                break;
            case "OrganisationName":
                searchInputList.get(5).sendKeys(type);
                break;
            case "siteID":
                searchInputList.get(6).sendKeys(type);
                break;
            case "LicenseNumber":
                searchInputList.get(5).sendKeys(type);
                break;
            case "AgencyName":
                searchInputList.get(0).sendKeys(type);
                break;
            case "StateLicenseNumber":
                searchInputList.get(1).sendKeys(type);
                break;
            case "BusinessAddressCity":
                searchInputList.get(3).sendKeys(type);
                break;
            case "BusinessAddressZipCode":
                searchInputList.get(4).sendKeys(type);
                break;
            case "AgencyEmail":
                searchInputList.get(2).sendKeys(type);
                break;
            case "PrimaryPhoneNumber":
                searchInputList.get(5).sendKeys(type);
                break;
            default:
                throw new IllegalArgumentException("Invalid header option : " + userdata);
        }
    }

    public void enterUserDataAnyENV(String userdata, String QAType, String STGType) {
        basicActions.waitForElementToBePresentWithRetries(searchUser, 10);
        if (SharedData.getEnv().equals("qa")) {
            enterUserData(userdata, QAType);
        } else {
            enterUserData(userdata, STGType);
        }
    }

    public void verifyblankfield(DataTable dataTable) {
        List<String> fieldNames = dataTable.asList(String.class);
        if (fieldNames.size() > searchInputList.size()) {
            throw new IllegalArgumentException("There are more fields in the DataTable than the available fields in the searchInputList.");
        }
        for (int i = 0; i < fieldNames.size(); i++) {
            String fieldName = fieldNames.get(i);
            if (i >= searchInputList.size()) {
                System.out.println("No corresponding field for '" + fieldName + "' at index " + i + ", skipping.");
                continue;
            }
            WebElement field = searchInputList.get(i);
            String actualValue = field.getAttribute("value");
            if (!actualValue.isEmpty()) {
                throw new AssertionError(String.format("Field '%s' should be blank, but found: '%s'", fieldName, actualValue));
            }
        }
    }

    public void enterAccountIdToAnyENV(String accountIdSTG, String accountIdQA) {
        basicActions.wait(4000);
        basicActions.waitForElementListToBePresentWithRetries(searchInputList,60);
        if (SharedData.getEnv().equals("staging")) {
            searchInputList.get(0).sendKeys(accountIdSTG);
        } else {
            searchInputList.get(0).sendKeys(accountIdQA);
        }
    }

    public void clickAccountLinkFirstRowFromSearchResults() {
        basicActions.waitForElementToBePresent(searchAcctResults, 10);
        searchAcctResults.click();
        basicActions.wait(500);
        setAccountId();
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

    public void requiredSearchCriteria() {
        basicActions.waitForElementToBePresent(searchCriteriaError, 50);
        softAssert.assertEquals(searchCriteriaError.getText(), "Search criteria for at least one field is required.");
        softAssert.assertAll();
    }

    public void selectSortOption(String text) {
        basicActions.waitForElementToBePresent(sortDropdown, 100);
        basicActions.selectValueFromDropdown(sortDropdown, sortOption, text);
    }

    public void verifysort(String category, String sortOrder) {
        basicActions.waitForElementToBePresent(rowTenth, 10000);
        verifySortascdesc(category, sortOrder);
    }

    public void verifySortascdesc(String category, String sortOrder) {
        List<WebElement> selectorList;
        switch (category) {
            case "First Name":
                selectorList = FirstName;
                break;
            case "Last Name":
                selectorList = LastName;
                break;
            case "Account ID":
                selectorList = AccountsID;
                break;
            case "Agency Name":
                selectorList = AccountsID;
                break;
            case "Agent":
                selectorList = FirstName;
                break;
            default:
                throw new IllegalArgumentException("Invalid sort option: " + sortOrder);
        }

        verifySortOrder(selectorList, sortOrder);
    }


    public void verifySortOrder(List<WebElement> selectorList, String sortOrder) {
        List<String> originalList = selectorList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> newList;
        switch (sortOrder.toLowerCase()) {
            case "asc":
                newList = Collections.unmodifiableList(originalList.stream()
                        .sorted()
                        .collect(Collectors.toList()));
                break;

            case "desc":
                newList = Collections.unmodifiableList(originalList.stream()
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList()));
                break;

            default:
                throw new IllegalArgumentException("Invalid sort order: " + sortOrder);
        }

        softAssert.assertEquals(originalList, newList, "The list is not sorted correctly.");
        softAssert.assertAll();
    }

    public void morethan100records() {
        basicActions.waitForElementToBePresent(messagemorethan100records, 4000);
        softAssert.assertTrue(messagemorethan100records.isDisplayed(), "message should display");
        softAssert.assertEquals(messagemorethan100records.getText(), "More than 100 search results were found and only the first 100 are shown. Please enter more specific search criteria if your desired result is not included.");
        softAssert.assertAll();
    }

    public void clickResetButton() {
        basicActions.waitForElementToBePresent(Reset, 500);
        Reset.click();
    }

    public void verifyAccountDetails(String category) {
        switch (category) {
            case "Program Manager":
                verifyPMAccountTitledetails();
                verifyPMData();
                break;
            case "Broker":
                verifyBrokerAccountTitledetails();
                verifyBrokerData();
                break;
            case "Agency":
                verifyAgencyAccountTitledetails();
                verifyAgencyData();
                break;
            case "coco":
                verifycocoAccountTitledetails();
                verifycocoData();
                break;
            case "indiviual":
                verifyIndiviualAccountTitledetails();
                verifyIndiviualData();
                break;


            default:
                throw new IllegalStateException("Unexpected value: " + category);
        }

    }

    public void verifyIndiviualAccountTitledetails(){
        basicActions.waitForElementListToBePresent(searchResultsTitles, 20);
        List<String> expectedTitles = List.of("Account ID", "First Name", "Last Name", "Primary Account Holder", "Date of Birth", "Email", "Phone Number", "Broker Association");
        List<String> actualTitles = searchResultsTitles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        softAssert.assertEquals(actualTitles, expectedTitles);
        softAssert.assertAll();
    }

    public void verifyIndiviualData(){
        basicActions.waitForElementListToBePresent(aactsearchResults, 30);
        List<String> qaexpectedTitles = List.of("9083564085", "Jack", "Sprat", "Jack Sprat", "03/01/1990", "Jack.Sprat@invali..", "567-898-7654", "Diamond Broker..");
        List<String> stgexpectedTitles = List.of("9083564085", "Jack", "Sprat", "Jack Sprat", "01/13/2020", "Jack.Sprat@invali..", "567-898-7654", "Diamond Broker..");
        List<String> actualTitles = aactsearchResults.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        if(SharedData.getEnv().equals("qa")) {
            softAssert.assertEquals(qaexpectedTitles,actualTitles);
        } else {
            softAssert.assertEquals(stgexpectedTitles,actualTitles);
        }
        softAssert.assertAll();
    }

    public void verifycocoAccountTitledetails(){
        basicActions.waitForElementListToBePresent(searchResultsTitles, 20);
        List<String> expectedTitles = List.of("Account ID", "First Name", "Last Name", "Primary Account Holder", "Date of Birth", "Email", "Phone Number", "Broker Association");
        List<String> actualTitles = searchResultsTitles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        softAssert.assertEquals(actualTitles, expectedTitles);
        softAssert.assertAll();
    }

    public void verifycocoData(){
        basicActions.waitForElementListToBePresent(aactsearchResults, 30);
        List<String> qaexpectedTitles = List.of("2008008265", "Betty", "Bertha", "Betty Bertha", "03/05/1989", "tspellnoticetesti..", "719-555-1212", "");
        List<String> stgexpectedTitles = List.of("6703170627", "apeliznjsxs", "apindaikibrk", "apeliznjsxs ap..", "02/01/1983", "MGC4Test+apindaik..", "374-649-8737", "");
        List<String> actualTitles = aactsearchResults.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        if(SharedData.getEnv().equals("qa")) {
            softAssert.assertEquals(qaexpectedTitles,actualTitles);
        } else {
            softAssert.assertEquals(stgexpectedTitles,actualTitles);
        }
        softAssert.assertAll();
    }

        public void verifyPMAccountTitledetails() {
            basicActions.waitForElementListToBePresent(searchResultsTitles, 20);
            List<String> expectedTitles = List.of("Account ID", "First Name", "Last Name", "Email", "Phone Number", "Organization Name", "Site ID", "User Type");
            List<String> actualTitles = searchResultsTitles.stream()
                    .map(WebElement::getText)
                    .collect(Collectors.toList());
            softAssert.assertEquals(actualTitles, expectedTitles);
            softAssert.assertAll();
        }

    public void verifyPMData() {
        basicActions.waitForElementListToBePresent(aactsearchResults, 30);
        List<String> qaexpectedTitles = List.of("2640006565", "John", "Winterhouse", "johnc4hcoautomation+..", "760-579-8438", "Twoeightsevennine", "jrzvp", "PROGRAM_MANAGER");
        List<String> stgexpectedTitles = List.of("9005375045", "adszcnkgvl", "adsdzazuqql", "c4assistorportal+Rqn..", "333-328-9892", "apifwjbuifspducrphut..", "eNrQP", "PROGRAM_MANAGER");
        List<String> actualTitles = aactsearchResults.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        if(SharedData.getEnv().equals("qa")) {
            softAssert.assertEquals(qaexpectedTitles,actualTitles);
        } else {
            softAssert.assertEquals(stgexpectedTitles,actualTitles);
        }
        softAssert.assertAll();
    }


    public void verifyBrokerAccountTitledetails() {
        basicActions.waitForElementListToBePresent(searchResultsTitles, 20);
        List<String> expectedTitles = List.of("Account ID", "First Name", "Last Name", "Email", "Phone Number", "License Number", "User Type");
        List<String> actualTitles = searchResultsTitles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        softAssert.assertEquals(actualTitles, expectedTitles);
        softAssert.assertAll();
    }


    public void verifyBrokerData() {
        basicActions.waitForElementListToBePresent(aactsearchResults, 30);
        List<String> qaexpectedTitles = List.of("8510935600", "Amethyst", "Broker", "ops.testing+Dsvsp@ou..", "432-432-5555", "456787654", "OWNER");
        List<String> stgexpectedTitles = List.of("8510935600", "Amethyst", "Broker", "ops.testing+Dsvsp@ou..", "432-432-5555", "456787654", "OWNER");
        List<String> actualTitles = aactsearchResults.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        if(SharedData.getEnv().equals("qa")) {
            softAssert.assertEquals(qaexpectedTitles,actualTitles);
        } else {
            softAssert.assertEquals(stgexpectedTitles,actualTitles);
        }
        softAssert.assertAll();
    }

    public void verifyAgencyAccountTitledetails() {
        basicActions.waitForElementListToBePresent(searchResultsTitles, 20);
        List<String> expectedTitles = List.of("Agency Name", "Agent", "Business Address City", "State License Number");

        List<String> actualTitles = searchResultsTitles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        softAssert.assertEquals(actualTitles, expectedTitles);
        softAssert.assertAll();
    }

    public void verifyAgencyData() {
        basicActions.waitForElementListToBePresent(aactsearchResults, 30);
    List<String> qaexpectedTitles = List.of("Quantum Gemerald Age..", "Gem Agency", "Denver", "3453534543543");
    List<String> stgexpectedTitles = List.of("Quantum Gemerald Age..", "Gem Agency", "Denver", "798567889");
    List<String> actualTitles = aactsearchResults.stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
        if(SharedData.getEnv().equals("qa")) {
        softAssert.assertEquals(qaexpectedTitles,actualTitles);
    } else {
        softAssert.assertEquals(stgexpectedTitles,actualTitles);
    }
        softAssert.assertAll();
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

    public void selectTheFirstBrokerRecordFromTheSearchResults() {
        basicActions.waitForElementToBeClickableWithRetries(firstBrokerResult,30);
        firstBrokerResult.click();
    }
    public void validateCoCoDashboardButtons() {
        basicActions.waitForElementToBePresent(coco, 20);
        softAssert.assertEquals(buttonsList.get(0).getText(), "Search", "Search button as expected");
        softAssert.assertEquals(buttonsList.get(1).getText(), "Reset", "Reset button as expected");
        softAssert.assertEquals(buttonsList.get(2).getText(), "Create Account", "Create Account button as expected");
        softAssert.assertAll();
    }

    public void searchForTheBrokerGenerated(String brokerPortal) {

        basicActions.waitForElementListToBePresent(searchInputList, 10);
        switch (brokerPortal){
            case "Broker":
          BrokerDetails broker = SharedData.getBroker();
          searchInputList.get(1).sendKeys(broker.getFirstName());
          searchInputList.get(2).sendKeys(broker.getLastName());
          buttonsList.get(0).click();
          break;
            case "Agency":
          BrokerDetails agency = SharedData.getAgencyOwner();
                searchInputList.get(1).sendKeys(agency.getFirstName());
                searchInputList.get(2).sendKeys(agency.getLastName());
                buttonsList.get(0).click();
          break;
            default:
                throw new IllegalArgumentException("Invalid option: " + brokerPortal);
      }
    }

    public void validateSearchTitle(String title) {
        basicActions.waitForElementToBePresent(individual, 15);
        switch (title) {
            case "individual":
                softAssert.assertEquals(searchTitle.getText(), "Individual Search" ,"Title not match");
                break;
            case "Broker":
                softAssert.assertEquals(searchTitle.getText(), "Broker Search" ,"Title not match");
                break;
            case "Program Manager":
                softAssert.assertEquals(searchTitle.getText(), "Program Manager Search" ,"Title not match");
                break;
            case "Agency":
                softAssert.assertEquals(searchTitle.getText(), "Agency Search" ,"Title not match");
                break;
            case "coco":
                softAssert.assertEquals(searchTitle.getText(), "Colorado Connect Individual Search" ,"Title not match");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + title);
        }
        softAssert.assertAll();
    }
    public void verifyCBMSTitle(){
        basicActions.switchtoactiveTab();
        basicActions.waitForElementToBePresent(cbmsTitle, 100);
        softAssert.assertEquals(cbmsTitle.getText(), "CBMS Case ID Search");        }
    public void verifySearchLabels(){
        basicActions.waitForElementToBePresent(personIdLabel, 30);
        softAssert.assertTrue(personIdLabel.isDisplayed());
        softAssert.assertTrue(firstNameLabel.isDisplayed());
        softAssert.assertTrue(lastNameLabel.isDisplayed());
        softAssert.assertTrue(cbmsPersonIdLabel.isDisplayed());
        softAssert.assertTrue(ssnLabel.isDisplayed());
        softAssert.assertTrue(dobLabel.isDisplayed());
        softAssert.assertTrue(middleLabel.isDisplayed());
        softAssert.assertTrue(suffixLabel.isDisplayed());
        softAssert.assertTrue(stateIdLabel.isDisplayed());
        softAssert.assertTrue(sexLabel.isDisplayed());
        softAssert.assertAll();     }
    public void clickCBMSSearchButton() {
        basicActions.waitForElementToBePresent(cbmsSearchButton,30);
        cbmsSearchButton.click();
    }
    public void verifyRequiredFieldsErrors(){
        basicActions.waitForElementToBePresent(personIdError, 30);
        softAssert.assertTrue(personIdError.isDisplayed());
        softAssert.assertTrue(firstNameError.isDisplayed());
        softAssert.assertTrue(lastNameError.isDisplayed());
        softAssert.assertTrue(dobError.isDisplayed());
        softAssert.assertAll();     }
    public void clickCBMSResetButton() {
        basicActions.waitForElementToBePresent(cbmsResetButton,30);
        cbmsResetButton.click();        }

    public void clickDropDownArrow(String dropdownarrow) {
        switch (dropdownarrow) {
            case "userDropdown":
                basicActions.waitForElementToBePresent(dropdownArrow, 50);
                basicActions.click(dropdownArrow);
                break;
            case "applicationDropDown":
                basicActions.waitForElementToBePresent(appLinksDropDown, 50);
                basicActions.click(appLinksDropDown);
                break;
            default:
                throw new IllegalArgumentException("Invalid header option : " + dropdownarrow);
        }
    }

    public void verifyHeaderDisplayAndStyles(String headerName) {
        switch (headerName) {
            case "Logo":
                ConnectForHealthLogoDisplay();
                navigateConnectForHealthPage();
                break;
            case "UserDropdown":
                userNameDisplay();
                PersonSymbolDisplay();
                UserDropDownDisplay();
                break;
            case "applicationDropDown":
                clickDropDownArrow(headerName);
                break;
            case "Admin Portal", "FirstName Display":
                getElementfor(headerName);
                break;

            default:
                throw new IllegalArgumentException("Invalid header option : " + headerName);
        }
    }

    public void verifyElementStyles(String elementName, List<Map<String, String>> styles) {
        WebElement element = getElementfor(elementName);
        for (Map<String, String> style : styles) {
            String property = style.get("property");
            String expectedValue = style.get("value");
            String actualValue;
            if (property.equalsIgnoreCase("text")) {
                actualValue = element.getText();
                if (actualValue.isEmpty()) {
                    actualValue = element.getAttribute("title").trim();
                }
            } else {
                actualValue = element.getCssValue(property);
            }

            softAssert.assertEquals(actualValue, expectedValue, property + " not match for " + elementName);
        }
        softAssert.assertAll();
    }

    public WebElement getElementfor(String elementName) {
        switch (elementName) {
            case "Logo":
                basicActions.waitForElementToBePresent(connectForHealthLogo, 50);
                return connectForHealthLogo;
            case "Admin Portal":
                basicActions.waitForElementToBePresent(txtAdminPortal, 50);
                return txtAdminPortal;
            case "FirstName Display":
                basicActions.waitForElementToBePresent(userName, 50);
                return userName;
            case "UserDropdown":
                basicActions.waitForElementToBePresent(userDropdownColor, 50);
                return userDropdownColor;
            case "applicationDropDown":
                basicActions.waitForElementToBePresent(applicationLinkColor, 50);
                return applicationLinkColor;
            default:
                throw new IllegalArgumentException("Invalid option : " + elementName);
        }
    }
}




