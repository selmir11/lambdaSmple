package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages;

import com.c4hco.test.automation.Dto.BrokerDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class YourClientsPage {
    public BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public YourClientsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "print-link")
    WebElement printBtn;
    @FindBy(xpath = "//a[@id='ngb-nav-0']")
    WebElement connectForHealthColoradoTab;
    @FindBy(xpath= "//a[.='Colorado Connect']")
    WebElement coloradoConnectTab;
    @FindBy(id = "clientSearchBox")
    WebElement searchClient;
    @FindBy(id = "remove-client-link")
    WebElement removeClient;
    @FindBy(id = "transfer-link")
    WebElement transferClient;
    @FindBy(id = "manage-button")
    WebElement manageClient;
    @FindBy(xpath = "//button[.='Ok']")
    WebElement okBtn;
    @FindBy(xpath = "//button[.='Cancel']")
    WebElement cancelBtn;
    @FindBy(xpath = "//div[normalize-space()='Remove Client(s)?']")
    WebElement removeClientModalTitle;
    @FindBy(xpath = "//div[contains(text(), 'Removing a total')]")
    WebElement removeClientModalCountText;
    @FindBy(xpath = "//div[@class='cdk-overlay-container']//div[@id='client-information-table']//div[2]")
    WebElement removeClientModalConfirmationText;
    @FindBy(xpath = "//*[@id='client-information-table']/app-view-clients-table/div[2]")
    WebElement emptyTable;
    @FindBy(xpath = "//*[@id='clientCheck-checkAll']")
    WebElement allClientsCheckBox;
    @FindBy(xpath = "//a[normalize-space()='Remove Selected Clients']")
    WebElement removedSelectedClients;
    @FindBy(xpath = "//span[normalize-space()='Transfer Selected Clients']")
    WebElement TransferSelectedClients;
    @FindBy(xpath = "//span[contains(@class, 'col-2 align-content-center')]")
    WebElement selectedClientCount;
    @FindBy(id = "user-first-name")
    WebElement brokerUserName;
    @FindBy(id = "logout-link")
    WebElement logout;

    @FindBy(id = "client-data-title-row")
    WebElement clientRow;

    @FindBy(css = ".mat-content #client-data-title-row")
    List<WebElement> clientsList;

    @FindBy(xpath = "//div[@id='client-data-title-row']/span[@class='col-2 body-text-1 text-align-center ow']")
    List<WebElement> clientNamesList;

    @FindBy(xpath = "(//mat-expansion-panel-header[contains(@id, 'mat-expansion-panel-header')])[2]")
    WebElement clientSecondRow;

    @FindBy(id = "status0")
    WebElement clientStatus;

    @FindBy(id = "status")
    WebElement secondClientStatus;

    @FindBy(id = "fullName0")
    WebElement secondClientFullName;

    @FindBy(xpath = "(//span[@id='fullName0'])[2]")
    WebElement thirdClientFullName;

    @FindBy(xpath = "(//span[@id='status'])[2]")
    WebElement thirdClientStatus;

    @FindBy(id = "premium-amount")
    WebElement clientPremium;

    @FindBy(xpath = "//*[@id='client-data-title-row']/span[1]")
    WebElement clientFullName;

    @FindBy(id = "home-address-zip")
    List<WebElement> clientZipCode;

    @FindBy(xpath = "//*[@id='phone-number']/div[2]")
    WebElement clientPhoneNumber;

    @FindBy(xpath = "//*[@id='account-number']/div[2]")
    WebElement clientAccountNumber;

    @FindBy(id = "plan-year")
    List<WebElement> clientPlanYear;

    @FindBy(id = "program-eligibility")
    List<WebElement> clientEligResults;

    @FindBy(xpath = "//*[@id='plan-name']/div[2]/span")
    List<WebElement> clientPlanName;

    @FindBy(xpath = "//*[@id='elem']/app-view-clients/div/div[1]")
    WebElement yourClientsTitle;

    @FindBy(id = "pagination-curr-page")
    WebElement yourClientCurrentPage;

    @FindBy(id = "pagination-next-page-btn")
    WebElement yourClientNextPage;

    @FindBy(id = "pagination-prev-page-btn")
    WebElement yourClientPreviousPage;

    @FindBy(xpath = "//input[contains(@id, 'clientCheck')]")
    List<WebElement> clientCheckboxes;

    @FindBy(xpath = "//*[@id='view-your-clients-table']/form/div")
    WebElement clientTransferSuccessfulMessage;

    @FindBy(id = "transferAllBTN")
    WebElement transferAllClientsButton;



    @FindBy(id = "openVerificationRequests")
    WebElement mvrContainerTitle;
    @FindBy(id = "searchParam-label")
    WebElement searchLabel;

    @FindBy(xpath = "//button[@type='searchParam-btn']")
    WebElement searchBtn;
    @FindBy(id = "searchParam-input")
    WebElement searchInput;
    @FindBy(id = "searchParam-errorMsg")
    WebElement speacialCharactersError;
    @FindBy(xpath = "//table[@id='mvr-table']/tr[1]//th")
    List<WebElement> mvrTableHeader;
    @FindBy(id = "pagination-mvr-next-page-btn")
    WebElement nextPage;
    @FindBy(id = "pagination-mvr-curr-page")
    WebElement currentPageText;
    @FindBy(id = "pagination-mvr-prev-page-btn")
    WebElement PaginationLeft;
    @FindBy(xpath = "//table[@id='mvr-table']//tr[2]//td")
    List<WebElement> firstRowsOptions;
    @FindBy(xpath = "//table[@id='mvr-table']//tr//td[3]")
    List<WebElement> mvrTypesOptions;




    public void validateYourClientsPageTitle(){
        basicActions.waitForElementToBePresent(yourClientsTitle, 10);
        softAssert.assertEquals(yourClientsTitle.getText(),"Your Clients");
        softAssert.assertAll();
    }

    public void clickUserTab(String userTab) {
        Actions actions = new Actions(basicActions.getDriver());
        switch (userTab){
            case "connect For Health Colorado" :
                connectForHealthColoradoTab.click();
                break;
            case "colorado Connect" :
                basicActions.wait(3000);
                actions.click(coloradoConnectTab).perform();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + userTab);
        }
    }
    public void verifyPrintButtonIsDisplayed() {
        basicActions.waitForElementToBePresent(printBtn,10);
        softAssert.assertTrue(printBtn.isDisplayed());
        softAssert.assertTrue(printBtn.isEnabled());
        softAssert.assertAll();}

    public void clickPrintButton() {
        basicActions.waitForElementToBePresent(printBtn, 10);
        printBtn.click();
    }

    public void searchForClient(){
        basicActions.waitForElementListToBePresent(clientsList, 1000);
        basicActions.waitForElementToBePresent(searchClient, 1000);
        String firstName =SharedData.getPrimaryMember().getFirstName();
        searchClient.sendKeys(firstName);
        searchClient.sendKeys(Keys.ENTER);
    }

    public void searchForTheSecondaryClient(){
        basicActions.waitForElementToBePresent(searchClient, 1000);
        String firstName =SharedData.getMembers().get(0).getFirstName();
        searchClient.sendKeys(firstName);
        searchClient.sendKeys(Keys.ENTER);
    }


    public void clickClientResult() {
        basicActions.waitForElementToDisappear(clientSecondRow, 10);
        basicActions.waitForElementToBePresent(clientRow,10);
        Actions actions = new Actions(basicActions.getDriver());
        WebElement firstClientResult = basicActions.getDriver().findElement(By.xpath("//*[@id='plan-year']"));
        basicActions.waitForElementToBePresent(firstClientResult,100);
        actions.click(firstClientResult).perform();
    }

    public void clickFirstClient() {
        basicActions.waitForElementToBePresent(clientRow,10);
        Actions actions = new Actions(basicActions.getDriver());
        WebElement firstClientResult = basicActions.getDriver().findElement(By.xpath("//*[@id='plan-year']"));
        basicActions.waitForElementToBePresent(firstClientResult,100);
        actions.click(firstClientResult).perform();
    }

    public void searchClientNamed(String clientName) {
        basicActions.waitForElementListToBePresentWithRetries(clientsList, 1000);
        basicActions.waitForElementToBePresentWithRetries(searchClient, 1000);

        searchClient.sendKeys(clientName);
        searchClient.sendKeys(Keys.ENTER);
    }

    public void resetClientSearchBox() {
        basicActions.waitForElementListToBePresent(clientsList, 1000);
        basicActions.waitForElementToBePresent(searchClient, 1000);

        searchClient.clear();
        searchClient.sendKeys(" ");
        searchClient.sendKeys(Keys.ENTER);
    }

    public void verifyCurrentClientStatus(String expectedClientStatus){
        basicActions.waitForElementToBePresent(clientRow,10);
        switch (expectedClientStatus){
            case "NO ELIGIBILITY":
                softAssert.assertEquals(clientStatus.getText(), "NO ELIGIBILITY");
                break;
            case "ELIGIBILITY ONLY":
                softAssert.assertEquals(clientStatus.getText(), "ELIGIBILITY ONLY");
                break;
            case "POLICY SUBMITTED":
                softAssert.assertEquals(clientStatus.getText(), "POLICY SUBMITTED");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + expectedClientStatus);
        }
        softAssert.assertAll();
    }

    public void verifyClientFullName(){
        basicActions.waitForElementToBePresent(clientRow,10);
        basicActions.waitForElementToBePresent(clientFullName, 200);
        softAssert.assertEquals(clientFullName.getText(),SharedData.getPrimaryMember().getFullName());
        softAssert.assertAll();
    }

    public void verifySecondSubscriberName(){
        basicActions.waitForElementToBePresent(clientRow,10);
        basicActions.waitForElementToBePresent(secondClientFullName,10);
        String clientName = SharedData.getMembers().get(0).getFirstName() + " " + SharedData.getMembers().get(0).getLastName();
        softAssert.assertEquals(secondClientFullName.getText(), clientName);
        softAssert.assertAll();
    }

    public void verifySecondClientStatus(){
        basicActions.waitForElementToBePresent(clientRow,10);
        basicActions.waitForElementToBePresent(secondClientStatus,10);
        softAssert.assertEquals(secondClientStatus.getText(), "POLICY SUBMITTED");
        softAssert.assertAll();
    }

    public void verifyThirdSubscriberName(){
        basicActions.waitForElementToBePresent(clientRow,10);
        basicActions.waitForElementToBePresent(thirdClientFullName,10);
        String clientName = SharedData.getMembers().get(1).getFirstName() + " " + SharedData.getMembers().get(1).getLastName();
        softAssert.assertEquals(thirdClientFullName.getText(), clientName);
        softAssert.assertAll();
    }

    public void verifyThirdClientStatus(){
        basicActions.waitForElementToBePresent(clientRow,10);
        basicActions.waitForElementToBePresent(thirdClientStatus,10);
        softAssert.assertEquals(thirdClientStatus.getText(), "POLICY SUBMITTED");
        softAssert.assertAll();

    }

    public void clickOptionToHandelClient(String option) {
        basicActions.waitForElementToBePresent(clientRow,100);

        switch (option){
            case "remove Client":
                basicActions.waitForElementToBePresent(removeClient,100);
                removeClient.click();
                break;
            case "transfer":
                transferClient.click();
                break;
            case "manage":
                basicActions.scrollToElement(manageClient);
                manageClient.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + option);
        }
    }

    public void clickPOPUPOption(String popupBtn) {
        basicActions.waitForElementToBePresent(okBtn,5000);
        basicActions.waitForElementToBePresent(cancelBtn,5000);
        switch (popupBtn){
            case "ok":
                basicActions.waitForElementToBeClickable(okBtn,100);
                okBtn.click();
                break;
            case "cancel":
                basicActions.waitForElementToBeClickable(cancelBtn,100);
                cancelBtn.click();
                break;

            default:
                throw new IllegalArgumentException("Invalid option: " + popupBtn);
        }
    }

    public void validateRemoveClientModalTitle() {
        basicActions.waitForElementToBePresent( removeClientModalTitle,100);
        softAssert.assertEquals(removeClientModalTitle.getText(), "Remove Client(s)?");
        softAssert.assertAll();
    }

    public void validateRemoveClientModalCountText() {
        basicActions.waitForElementToBePresent( removeClientModalCountText,100);
        softAssert.assertEquals(removeClientModalCountText.getText(), "Removing a total of 1 client(s).");
        softAssert.assertAll();
    }

    public void validateRemoveClientModalConfirmationText() {
        basicActions.waitForElementToBePresent( removeClientModalConfirmationText,100);
        softAssert.assertEquals(removeClientModalConfirmationText.getText(), "Are you sure you want to end the client's relationship with the Agency?");
        softAssert.assertAll();
    }

    public void validateRemoveClientCountMatchesSelectedClients() {
        basicActions.waitForElementToBePresent( selectedClientCount,100);
        String selectedClients = selectedClientCount.getText().replace(" Clients Selected", "");
        removedSelectedClients.click();

        basicActions.waitForElementToBePresent( removeClientModalCountText,100);
        softAssert.assertEquals(removeClientModalCountText.getText(), "Removing a total of " + selectedClients + " client(s).");
        softAssert.assertAll();
    }

    public void validateClientIsRemoved() {
        softAssert.assertTrue(emptyTable.isDisplayed());
        softAssert.assertAll();
    }

    public void selectTheClient() {
        Actions actions = new Actions(basicActions.getDriver());
        WebElement selectOneElement =  basicActions.getDriver().findElement(By.id("clientCheck-0-input"));
        actions.click(selectOneElement).perform();
    }

    public void selectOptionFromBrokerContainer(String optionSelected) {
        basicActions.waitForElementToBePresent( removedSelectedClients,100);
        switch (optionSelected){
            case "Remove Selected Clients":
                removedSelectedClients.click();
                break;
            case "Transfer Selected Clients":
                TransferSelectedClients.click();
                break;

            default:
                throw new IllegalArgumentException("Invalid option: " + optionSelected);
        }

    }

    public void logoutFromBrokerAccount() {
        basicActions.waitForElementToBePresentWithRetries(brokerUserName,10);
        brokerUserName.click();
        basicActions.waitForElementToBePresentWithRetries(logout,10);
        logout.click();
    }

    public void selectAllTheClientsCheckBox() {
        basicActions.waitForElementToBePresent(allClientsCheckBox, 200);
        basicActions.waitForElementToBeClickable(allClientsCheckBox, 200);
        allClientsCheckBox.click();
    }

    public void saveSelectedClientCount() {
        basicActions.waitForElementToBePresent(selectedClientCount, 200);
        String selectedClients = selectedClientCount.getText().replace(" Clients Selected", "");

        BrokerDetails owner = new BrokerDetails();
        owner.setAgencyClientCount(selectedClients);
        SharedData.setAgencyOwner(owner);
    }

    public void validateClientPremiumAmount(){
        String premiumAmt =SharedData.getPrimaryMember().getMedicalPremiumAmt();
        String clientName =SharedData.getPrimaryMember().getFullName();
        basicActions.waitForElementToBePresent(clientRow, 200);

        basicActions.waitForElementToBePresent(clientFullName, 200);
        softAssert.assertEquals(clientFullName.getText(),clientName);

        basicActions.waitForElementToBePresent(clientPremium, 200);
        softAssert.assertEquals((clientPremium.getText().replace("$", "")), premiumAmt);
        softAssert.assertAll();
    }

    public void verifyClientNameAsPrimary() {
        basicActions.waitForElementToBePresent(clientFullName,20);
        softAssert.assertTrue(clientFullName.getText().contains(SharedData.getPrimaryMember().getFirstName()));
        softAssert.assertAll();
    }

    public void validateSearchBoxSpecialCharacters() {
        basicActions.waitForElementToBePresent(searchClient,20);
        searchClient.sendKeys("#$%!@&*()");
        softAssert.assertEquals(searchClient.getAttribute("value"), "");
        softAssert.assertAll();
    }

    public void validateNumbersNotAllowedSearchBox() {
        basicActions.waitForElementToBePresent(searchClient,20);
        searchClient.sendKeys("0123456789");
        softAssert.assertEquals(searchClient.getAttribute("value"), "");
        softAssert.assertAll();
    }

    public void validateSpacesNotAllowedSearchBox() {
        basicActions.waitForElementToBePresent(searchClient,20);
        searchClient.sendKeys("FirstName LastName");
        softAssert.assertEquals(searchClient.getAttribute("value"), "FirstNameLastName");
        softAssert.assertAll();
    }

    public void verifyCurrentClientListPage(String currentPage) {
        basicActions.waitForElementToBePresent(yourClientCurrentPage,30);
        softAssert.assertEquals(yourClientCurrentPage.getText(), currentPage);
        softAssert.assertAll();
    }

    public void clickRightPaginationArrowButton() {
        basicActions.waitForElementToBePresent(yourClientNextPage,30);
        yourClientNextPage.click();
    }

    public void verifyClientsAlphabeticalOrder() {
        basicActions.waitForElementListToBePresentWithRetries(clientNamesList, 1000);

        List<String> originalList = new ArrayList<>();
        System.out.println("The following list of clients was found");
        for(WebElement clientName : clientNamesList){
            System.out.println(clientName.getText());
            originalList.add(clientName.getText());
        }

        List<String> sortedList = new ArrayList<>(originalList);
        Collections.sort(sortedList);

        softAssert.assertEquals(sortedList,originalList);
        softAssert.assertAll();
    }

    public void clickLeftPaginationArrowButton() {
        basicActions.waitForElementToBePresent(yourClientPreviousPage,30);
        yourClientPreviousPage.click();
    }

    public void validateClientOptionsDisplayed(String clientOption){
        basicActions.waitForElementToBePresent(clientRow,100);

        switch (clientOption) {
            case "Remove Client":
                basicActions.waitForElementToBePresent(removeClient,100);
                softAssert.assertEquals(removeClient.getText(),"Remove Client");
                break;
            case "Transfer":
                basicActions.waitForElementToBePresent(transferClient,100);
                softAssert.assertEquals(transferClient.getText(),"Transfer");
                break;
            case "Manage":
                basicActions.waitForElementToBePresent(manageClient,100);
                softAssert.assertEquals(manageClient.getText(),"Manage");
                break;
        }
        softAssert.assertAll();
    }

    public void validateClientOptionsNotDisplayed(String clientOption){
        basicActions.waitForElementToBePresent(clientRow,100);

        switch (clientOption) {
            case "Remove Client":
                softAssert.assertFalse(basicActions.waitForElementPresence(removeClient,30));
                break;
            case "Transfer":
                softAssert.assertFalse(basicActions.waitForElementPresence(transferClient,30));
                break;
            case "Manage":
                softAssert.assertFalse(basicActions.waitForElementPresence(manageClient,30));
                break;
        }
        softAssert.assertAll();
    }

    public void validateHeaderOptionsNotDisplayed(String headerOption){
        basicActions.waitForElementToBePresent(removedSelectedClients,100);

        switch (headerOption) {
            case "Remove Selected Clients":
                softAssert.assertFalse(basicActions.waitForElementPresence(removedSelectedClients,30));
                break;
            case "Transfer Selected Clients":
                softAssert.assertFalse(basicActions.waitForElementPresence(TransferSelectedClients,30));
                break;
        }
        softAssert.assertAll();
    }

    public void validateHeaderOptionsDisplayed(String headerOption){
        basicActions.waitForElementToBePresent(removedSelectedClients,100);

        switch (headerOption) {
            case "Remove Selected Clients":
                basicActions.waitForElementToBePresent(removedSelectedClients,100);
                softAssert.assertEquals(removedSelectedClients.getText(),"Remove Selected Clients");
                break;
            case "Transfer Selected Clients":
                basicActions.waitForElementToBePresent(TransferSelectedClients,100);
                softAssert.assertEquals(TransferSelectedClients.getText(),"Transfer Selected Clients");
                break;
        }
        softAssert.assertAll();
    }

    public void validateTotalSelectedClientCount(String expectedCount){
        basicActions.waitForElementToBePresent(selectedClientCount,30);
        softAssert.assertEquals(selectedClientCount.getText(), expectedCount + " Clients Selected");
        softAssert.assertAll();
    }

    public void selectRandomClientCheckbox(){
        basicActions.waitForElementListToBePresentWithRetries(clientCheckboxes,30);

        Random randomIndex = new Random();
        int randomClient = randomIndex.nextInt(1, clientCheckboxes.size()-1);

        clientCheckboxes.get(randomClient).click();
    }

    public void verifyCheckAllClientsCheckboxDisabled(){
        basicActions.waitForElementToBePresent(allClientsCheckBox,30);

        softAssert.assertEquals(allClientsCheckBox.getAttribute("class"),"mat-mdc-checkbox mat-accent mdc-checkbox--disabled mat-mdc-checkbox-disabled mat-mdc-checkbox-checked");
        softAssert.assertAll();
    }

    public void validateClientTransferSuccessfulMessage(){
        basicActions.waitForElementToBePresent(clientTransferSuccessfulMessage,30);

        softAssert.assertEquals(clientTransferSuccessfulMessage.getText(), "Client Transfer Successful");
        softAssert.assertAll();
    }

    public void clickTransferAllClients(){
        basicActions.waitForElementToBePresent(transferAllClientsButton,30);
        transferAllClientsButton.click();
    }

    public void validateTransferAllClients(){
        basicActions.waitForElementToBePresent(transferAllClientsButton,30);
        softAssert.assertEquals(transferAllClientsButton.getText(),"Transfer All Clients");
        softAssert.assertAll();
    }

    public void verifyExistingClientDetails(String clientName, String clientZip, String phoneNumber, String clientAccountStg, String clientAccountQA){
        basicActions.waitForElementToBePresent(clientFullName,30);
        softAssert.assertEquals(clientFullName.getText(), clientName);
        softAssert.assertEquals(clientZipCode.get(0).getText(), clientZip);
        softAssert.assertEquals(clientPhoneNumber.getText(), phoneNumber);

        if(SharedData.getEnv().equals("staging")){
            softAssert.assertEquals(clientAccountNumber.getText(), clientAccountStg);
        } else{
            softAssert.assertEquals(clientAccountNumber.getText(), clientAccountQA);
        }
        softAssert.assertAll();
    }

    public void verifyExistingClientPlanDetails(String planYear, String eligResults1, String eligResults2, String eligResults3, String issuerName){
        basicActions.waitForElementListToBePresentWithRetries(clientPlanYear,30);
        softAssert.assertEquals(clientPlanYear.get(0).getText(), planYear);
        softAssert.assertTrue(clientEligResults.get(0).getText().contains(eligResults1));
        softAssert.assertTrue(clientEligResults.get(0).getText().contains(eligResults2));
        softAssert.assertTrue(clientEligResults.get(0).getText().contains(eligResults3));
        softAssert.assertEquals(clientPlanName.get(0).getText(), issuerName);
        softAssert.assertAll();
    }

    public void verifyExistingSecondaryClientDetails(String clientName, String clientZip, String planYear, String eligResults1, String eligResults2, String eligResults3, String issuerName){
        basicActions.waitForElementListToBePresentWithRetries(clientPlanYear,30);
        softAssert.assertEquals(secondClientFullName.getText(), clientName);
        softAssert.assertEquals(clientZipCode.get(1).getText(), clientZip);
        softAssert.assertEquals(clientPlanYear.get(1).getText(), planYear);
        softAssert.assertTrue(clientEligResults.get(1).getText().contains(eligResults1));
        softAssert.assertTrue(clientEligResults.get(1).getText().contains(eligResults2));
        softAssert.assertTrue(clientEligResults.get(1).getText().contains(eligResults3));
        softAssert.assertEquals(clientPlanName.get(1).getText(), issuerName);
        softAssert.assertAll();
    }



    public void validateTheMVRContainerTextInTheDashboardPage() {
        basicActions.waitForElementToBePresentWithRetries(mvrContainerTitle,50);
        basicActions.scrollToElement(mvrContainerTitle);
        softAssert.assertEquals(mvrContainerTitle.getText(),"Open Verification Requests");
        softAssert.assertEquals(searchLabel.getText(),"Search By First Name or Last Name:");
        softAssert.assertEquals(searchBtn.getText(),"Search");
        List<String> actualTitleHeader = new ArrayList<>();
        List<String> expectedTitleHeader = new ArrayList<>(Arrays.asList("First Name","Last Name","Type","Due Date",""));

        for (WebElement each : mvrTableHeader) {
            actualTitleHeader.add(each.getText());
            System.out.println(each.getText());
        }
        softAssert.assertEquals(expectedTitleHeader,actualTitleHeader);
        softAssert.assertAll();
    }

    public void validateTheICanTSearchForSpecialCharactersOnSearchBar() {
        basicActions.waitForElementToBePresentWithRetries(speacialCharactersError,100);
        basicActions.isElementDisplayed(speacialCharactersError,100);
        softAssert.assertEquals(speacialCharactersError.getText(),"No special characters allowed");
        softAssert.assertAll();
    }

    public void searchForInSearchMvrContainer(String STGClient, String QAClient) {
        basicActions.waitForElementToBeClickableWithRetries(searchBtn,50);
        basicActions.waitForElementToBePresentWithRetries(searchInput,30);
        if (SharedData.getEnv().equals("staging")){
            searchInput.sendKeys(STGClient);
        }else{
            searchInput.sendKeys(QAClient);
        }

        basicActions.waitForElementToBePresentWithRetries(searchBtn,30);
        searchBtn.click();
    }

    public void clearTheMVRSearchBoxInBrokerDashboardPage() {
        Actions actions = new Actions(basicActions.getDriver());
        basicActions.waitForElementToBePresentWithRetries(searchInput,30);
        searchInput.click();
        actions.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
        searchInput.sendKeys(Keys.BACK_SPACE);
        basicActions.wait(500);
        searchInput.sendKeys(Keys.ENTER);
        basicActions.waitForElementToBePresentWithRetries(searchBtn,60);
        basicActions.waitForElementToBeClickableWithRetries(searchBtn,60);
    }

    public void clickTheRightPaginationArrowButtonTimesInMvrContainer(int numberTimes) {
        basicActions.waitForElementToBePresent(nextPage,30);
        for(int i=0; i<=numberTimes; i++){
            basicActions.waitForElementToBeClickable(nextPage,10);
            basicActions.waitForElementToBeClickable(searchBtn,30);
            nextPage.click();
            basicActions.wait(10);
        }
    }

    public void verifyTheCurrentResultPageIsInMvrContainer(String currentPage) {
        basicActions.waitForElementToBePresent(currentPageText,30);
        basicActions.waitForElementToBeClickable(currentPageText,10);
        softAssert.assertEquals(currentPageText.getText(), currentPage);
        softAssert.assertAll();
    }

    public void clickTheLeftPaginationArrowButtonTimesInMvrContainer(int numberTimes) {
        basicActions.waitForElementToBePresent(PaginationLeft,30);
        for(int i=0; i<numberTimes; i++){
            basicActions.waitForElementToBeClickable(PaginationLeft,10);
            PaginationLeft.click();
            basicActions.wait(10);
        }
    }

    public void validateTheResultContains(String search) {
        basicActions.waitForElementListToBePresentWithRetries(firstRowsOptions,300);
        basicActions.wait(500);
        basicActions.waitForElementToBeClickableWithRetries(searchBtn,500);
        boolean found = false;
        for (WebElement each : firstRowsOptions) {
            if (each.getText().contains(search)){
                found = true;
                break;
            }
        }
        softAssert.assertTrue(found, "element is not found");
        softAssert.assertAll();
    }

    public void validateTheMvrContainerIsNotDisplayed() {
        basicActions.waitForElementToBePresentWithRetries(mvrContainerTitle,30);
        basicActions.scrollToElement(mvrContainerTitle);
        softAssert.assertFalse(basicActions.waitForElementListToBePresent(firstRowsOptions,30));
        softAssert.assertAll();
    }

    public void validateTheFirstNameLastNameTypeDueDateAndActionType(String firstName, String lastName, String Type,String dueDate, String actionType) {
        basicActions.waitForElementToBeClickable(searchBtn,30);
        basicActions.waitForElementListToBePresent(firstRowsOptions,60);
        softAssert.assertEquals(firstRowsOptions.get(0).getText(),firstName);
        softAssert.assertEquals(firstRowsOptions.get(1).getText(),lastName);
        softAssert.assertEquals(firstRowsOptions.get(2).getText(),Type);
        softAssert.assertEquals(firstRowsOptions.get(3).getText(),dueDate);
        softAssert.assertEquals(firstRowsOptions.get(4).getText(),actionType);
        softAssert.assertAll();

    }

    public void clickVerifyInfoButtonOnMVRContainer() {
        basicActions.waitForElementListToBePresent(firstRowsOptions,30);
        firstRowsOptions.get(4).click();
    }

    public void searchForTheClientCreatedInSearchMvrContainer() {
        basicActions.waitForElementToBeClickableWithRetries(searchBtn,50);
        basicActions.waitForElementToBePresentWithRetries(searchInput,30);
        searchInput.sendKeys(SharedData.getPrimaryMember().getFirstName());
        basicActions.waitForElementToBePresentWithRetries(searchBtn,30);
        searchBtn.click();
    }

    public void validateTheClientDataOnTheMVRContainer(String actionBtn) {
        LocalDate date = LocalDate.now().plusDays(90);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        String formattedDate = date.format(formatter);
        System.out.println("The date 90 days from today is: " + formattedDate);

        basicActions.waitForElementToBeClickable(searchBtn,30);
        basicActions.waitForElementListToBePresent(firstRowsOptions,60);
        softAssert.assertEquals(firstRowsOptions.get(0).getText(),SharedData.getPrimaryMember().getFirstName());
        softAssert.assertEquals(firstRowsOptions.get(1).getText(),SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(firstRowsOptions.get(2).getText(),"Income");
        softAssert.assertEquals(firstRowsOptions.get(3).getText(), formattedDate);
        softAssert.assertEquals(firstRowsOptions.get(4).getText(),actionBtn);
        softAssert.assertAll();
    }

    public void validateTheMVRTypeAndActionType(String mvrType, String actionButton) {
        basicActions.waitForElementToBeClickable(searchBtn,30);
        basicActions.waitForElementListToBePresent(firstRowsOptions,60);

        boolean isMvrTypeFound = false;


        for (int i = 0; i < mvrTypesOptions.size(); i++) {
            if (mvrTypesOptions.get(i).getText().equals(mvrType)) {
                isMvrTypeFound = true;
                i=i+2;
                String actionButtonText = basicActions.getDriver().findElement(By.xpath("//table[@id='mvr-table']//tr["+i+"]//td[5]")).getText();
                softAssert.assertEquals(actionButtonText, actionButton);
                softAssert.assertAll();
                i=0;
                break;

            }
        }
        softAssert.assertTrue(isMvrTypeFound, "The specified MVR type was not found.");
        softAssert.assertAll();

    }
}
