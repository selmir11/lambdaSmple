package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DashboardPage {
    SoftAssert softAssert = new SoftAssert();
    @FindBy(xpath = "//strong[normalize-space()='Agency Dashboard']")
    WebElement agencyDashboard ;

    @FindBy(xpath = "//strong[normalize-space()='Broker Dashboard']")
    WebElement brokerDashboard;

    @FindBy(id = "manage-account-button")
    WebElement completeProfile;

    @FindBy(id = "agency-manage-account-button")
    WebElement agencyCompleteProfile;

    @FindBy(xpath = "//a[@class='action-link']")
    WebElement c4ULink;

    @FindBy(xpath = "//button[normalize-space()='Manage Brokers']")
    WebElement manageBrokersButton;

    @FindBy(xpath = "//button[normalize-space()='Manage Users']")
    WebElement manageUsersButton;

    @FindBy(xpath = "//button[normalize-space()='View Your Clients']")
    WebElement ViewYourClientsButton;

    @FindBy(xpath = "//a[normalize-space()='View']")
    WebElement myAgencyView;

    @FindBy(xpath = "//a[@class='skipGroup']")
    WebElement editAgencyInformation;

    @FindBy(id = "agency-manage-account-button")
    WebElement editAccountSummary;

    @FindBy(id = "client-info-search-input")
    WebElement clientInformationSearchBox;

    @FindBy(id = "client-first-0")
    WebElement clientInformationClientFirstName;

    @FindBy(id = "client-last-0")
    WebElement clientInformationClientLastName;

    @FindBy(id = "broker-select-0")
    WebElement clientInformationCurrentBrokerAssignment;

    @FindBy(id = "broker-submit-0")
    WebElement clientInformationBrokerAssignmentSubmit;
    @FindBy(xpath= "//*[@id='accountSummary-data-Email']")
    WebElement communicationPrefrencesEmail;

    @FindBy(id = "accountSummary-data-agencyOwner")
    WebElement accountSummaryAgencyOwnerName;
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
    @FindBy(id = "pagination-next-page-btn")
    WebElement nextPage;
    @FindBy(id = "pagination-curr-page")
    WebElement currentPageText;
    @FindBy(id = "pagination-prev-page-btn")
    WebElement PaginationLeft;
    @FindBy(xpath = "//table[@id='mvr-table']//tr[2]//td")
    List<WebElement> firstRowsOptions;

    private BasicActions basicActions;
    public DashboardPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }


    public void clickAgencyDashboard(){
        basicActions.waitForElementToBePresent(agencyDashboard,10);
        agencyDashboard.click();
    }

    public void clickBrokerDashboard(){
        basicActions.waitForElementToBePresent(brokerDashboard,10);
        brokerDashboard.click();
    }

    public void clickCompleteProfile(){
        basicActions.waitForElementToBePresent(completeProfile,10);
        completeProfile.click();
    }

    public void clickAgencyCompleteProfile(){
        basicActions.waitForElementToBePresent(agencyCompleteProfile,10);
        agencyCompleteProfile.click();
    }

    public void clickC4ULink(){
        basicActions.waitForElementToBeClickable(c4ULink,10);
        c4ULink.click();
        for (String handle : basicActions.getDriver().getWindowHandles()) {
            basicActions.getDriver().switchTo().window(handle);
        }
    }

    public void clickManageBrokersButton(){
        basicActions.waitForElementToBePresent(manageBrokersButton, 10);
        manageBrokersButton.click();
    }

    public void clickManageUsersButton(){
        basicActions.waitForElementToBePresent(manageUsersButton, 10);
        manageUsersButton.click();
    }

    public void clickViewYourClientsButton(){
        basicActions.waitForElementToBePresent(ViewYourClientsButton, 10);
        ViewYourClientsButton.click();
    }

    public void clickMyAgencyView(){
        basicActions.waitForElementToBePresent(myAgencyView, 10);
        myAgencyView.click();
    }

    public void clickEditAgencyInformation(){
        basicActions.waitForElementToBePresent(editAgencyInformation, 10);
        editAgencyInformation.click();
    }

    public void clickEditAccountSummary(){
        basicActions.waitForElementToBePresent(editAccountSummary, 10);
        softAssert.assertEquals(editAccountSummary.getText(), "Edit");
        editAccountSummary.click();
    }

    public void clientInformationSearch(){
        basicActions.waitForElementToBePresent(clientInformationSearchBox, 10);
        String firstName = SharedData.getPrimaryMember().getFirstName();
        clientInformationSearchBox.sendKeys(firstName);
    }

    public void clientNameClientInformation(){
        basicActions.waitForElementToBePresent(clientInformationClientFirstName, 10);
        softAssert.assertEquals(clientInformationClientFirstName.getText(),SharedData.getPrimaryMember().getFirstName());
        softAssert.assertEquals(clientInformationClientLastName.getText(),SharedData.getPrimaryMember().getLastName());
        softAssert.assertAll();
    }

    public void currentAssignedBroker(String assignedBroker){
        basicActions.waitForElementToBePresent(clientInformationCurrentBrokerAssignment, 10);
        String currentBroker = clientInformationCurrentBrokerAssignment.getText().split("\n")[0].trim();

        softAssert.assertEquals(currentBroker,assignedBroker);
        softAssert.assertAll();
    }

    public void changeAssignedBroker(String assignedBroker){
        basicActions.waitForElementToBePresent(clientInformationCurrentBrokerAssignment, 10);

        Select brokerDropdown = new Select(clientInformationCurrentBrokerAssignment);
        clientInformationCurrentBrokerAssignment.click();
        brokerDropdown.selectByVisibleText(assignedBroker);
        clientInformationCurrentBrokerAssignment.click();

        clientInformationBrokerAssignmentSubmit.click();
    }

    public void validateTheEmailOnTheCommunicationPrefrencesContainerOnBrokerDashboardPage(String brokerType) {
        basicActions.waitForElementToBePresent(communicationPrefrencesEmail,50);
        switch (brokerType){
            case "Agency":
                softAssert.assertEquals(communicationPrefrencesEmail.getText(),SharedData.getBroker().getAgencyEmail());

                break;
            case "Broker":
            softAssert.assertEquals(communicationPrefrencesEmail.getText(),SharedData.getBroker().getEmail());
                break;
        }
        softAssert.assertAll();}

    public void saveAgencyDetails(){
        basicActions.waitForElementToBePresent(accountSummaryAgencyOwnerName, 10);
        SharedData.getAgencyOwner().setBroker_name(accountSummaryAgencyOwnerName.getText());
        SharedData.getAgencyOwner().setFirstName(accountSummaryAgencyOwnerName.getText().split(" ")[0].trim());

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

    public void searchForInSearchMvrContainer(String client) {
        basicActions.waitForElementToBePresentWithRetries(searchBtn,50);
        basicActions.waitForElementToBePresentWithRetries(searchInput,30);
        searchInput.sendKeys(client);
        basicActions.waitForElementToBePresentWithRetries(searchBtn,30);
        searchBtn.click();
    }

    public void clearTheMVRSearchBoxInBrokerDashboardPage() {
        basicActions.waitForElementToBePresentWithRetries(searchInput,30);
        searchInput.clear();
        basicActions.waitForElementToBePresentWithRetries(searchBtn,30);
        searchBtn.click();
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
        basicActions.waitForElementListToBePresent(firstRowsOptions,100);
        for (WebElement each : firstRowsOptions) {
           if (each.getText().contains(search)){
               softAssert.assertTrue(each.getText().contains(search));
               softAssert.assertAll();
               break;
           }
        }
    }

    public void validateTheMvrContainerIsNotDisplayed() {
        basicActions.waitForElementToBePresentWithRetries(ViewYourClientsButton,30);
        basicActions.scrollToElement(ViewYourClientsButton);
        softAssert.assertFalse(basicActions.isElementDisplayed(mvrContainerTitle,30));
        softAssert.assertAll();
    }
}
