package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DashboardPage {
    SoftAssert softAssert = new SoftAssert();
    @FindBy(xpath = "//strong[normalize-space()='Agency Dashboard']")
    WebElement agencyDashboard ;

    @FindBy(xpath = "//strong[normalize-space()='Broker Dashboard']")
    WebElement brokerDashboard;

    @FindBy(xpath = "//*[@id='elem']/app-broker-dashboard/div/div[1]")
    WebElement dashboardPageTitle;

    @FindBy(xpath = "//*[@id='elem']/app-agency-dashboard/div/div[1]")
    WebElement agencyDashboardPageTitle;

    @FindBy(xpath = "//app-broker-certification/div/div[2]/div[3]/div[4]/div")
    WebElement brokerCertifcationStatus;

    @FindBy(id = "accountSummary-data-agencyCertification")
    WebElement agencyCertificationStatus;

    @FindBy(id = "accountSummary")
    WebElement accountSummaryTitle;

    @FindBy(id = "accountSummary-title-username")
    WebElement accountSummaryName;

    @FindBy(id = "accountSummary-data-username")
    WebElement accountSummaryUsername;

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

    @FindBy(id = "agencyInformation")
    WebElement agencyInformationContainerTitle;

    @FindBy(id = "agencyName-data")
    WebElement agencyInformationAgencyName;

    @FindBy(id = "agencyEmail-data")
    WebElement agencyInformationAgencyEmail;

    @FindBy(id = "phoneNumber-data")
    WebElement agencyInformationAgencyPhone;

    @FindBy(id = "enter-InviteCode-label")
    WebElement agencyInformationEnterInviteCodeText;

    @FindBy(id = "enter-InviteCode-input")
    WebElement agencyInformationEnterInviteCodefield;

    @FindBy(id = "inviteCode-errorMsg")
    WebElement agencyInformationEnterInviteCodeError;

    @FindBy(xpath = "//*[@id='button-177']")
    WebElement viewReportButton;

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

    public void verifyBrokerDashboard(){
        basicActions.waitForElementToBePresent(brokerDashboard,10);
        softAssert.assertEquals(brokerDashboard.getText(),"Broker Dashboard");
        softAssert.assertAll();
    }

    public void verifyAgencyDashboard(){
        basicActions.waitForElementToBePresent(agencyDashboard,10);
        softAssert.assertEquals(agencyDashboard.getText(),"Agency Dashboard");
        softAssert.assertAll();
    }

    public void verifyBrokerDashboardTitle(String portalUserType){
        basicActions.waitForElementToBePresentWithRetries(accountSummaryTitle,10);
        switch (portalUserType){
            case "Agency Owner":
                softAssert.assertEquals(dashboardPageTitle.getText(),SharedData.getAgencyOwner().getFirstName() + " " + SharedData.getAgencyOwner().getLastName());
                break;
            case "Broker":
                softAssert.assertEquals(dashboardPageTitle.getText(),SharedData.getBroker().getFirstName() + " " + SharedData.getBroker().getLastName());
                break;
            case "Admin Staff":
                softAssert.assertEquals(agencyDashboardPageTitle.getText(),SharedData.getAdminStaff().getFirstName() + " " + SharedData.getAdminStaff().getLastName());
                break;
            case "Agency Owner Completed Profile":
                softAssert.assertEquals(agencyDashboardPageTitle.getText(),SharedData.getAgencyOwner().getFirstName() + " " + SharedData.getAgencyOwner().getLastName());
                break;
        }
        softAssert.assertAll();
    }

    public void verifyBrokerCertStatus(String certificationStatus){
        basicActions.waitForElementToBePresentWithRetries(brokerCertifcationStatus,10);
        softAssert.assertEquals(brokerCertifcationStatus.getText(), certificationStatus);
        softAssert.assertAll();
    }

    public void verifyAgencyCertStatus(String certificationStatus){
        basicActions.waitForElementToBePresentWithRetries(agencyCertificationStatus,10);
        softAssert.assertEquals(agencyCertificationStatus.getText(), certificationStatus);
        softAssert.assertAll();
    }

    public void verifyBrokerCertStatusNotDisplayed(){
        softAssert.assertFalse(basicActions.waitForElementPresence(brokerCertifcationStatus,30));
        softAssert.assertAll();
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

    public void verifyAgencyOwnerAccountSummaryDetails(){
        basicActions.waitForElementToBePresent(accountSummaryTitle, 10);
        softAssert.assertEquals(accountSummaryTitle.getText(), "Account Summary");
        softAssert.assertEquals(accountSummaryName.getText(), SharedData.getAgencyOwner().getFirstName() + " " + SharedData.getAgencyOwner().getLastName());
        softAssert.assertEquals(accountSummaryUsername.getText(), SharedData.getAgencyOwner().getEmail());
        softAssert.assertEquals(accountSummaryAgencyOwnerName.getText(), SharedData.getAgencyOwner().getFirstName() + " " + SharedData.getAgencyOwner().getLastName());
        softAssert.assertAll();
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

    public void verifyAgencyInformationDetails(String agencyName, String agencyEmail, String agencyPhone){
        basicActions.waitForElementToBePresent(agencyInformationContainerTitle, 10);
        softAssert.assertEquals(agencyInformationContainerTitle.getText(), "Agency Information");
        softAssert.assertEquals(agencyInformationAgencyName.getText(), agencyName);
        softAssert.assertEquals(agencyInformationAgencyEmail.getText(), agencyEmail);
        softAssert.assertEquals(agencyInformationAgencyPhone.getText(), agencyPhone);
        softAssert.assertAll();
    }

    public void verifyAgencyInformationInviteCode(){
        basicActions.waitForElementToBePresent(agencyInformationContainerTitle, 10);
        softAssert.assertEquals(agencyInformationEnterInviteCodeText.getText(), "Enter Agency invitation code:");
        softAssert.assertTrue(agencyInformationEnterInviteCodefield.isDisplayed());
        softAssert.assertAll();
    }

    public void verifyAgencyInfoInviteCodeError(){
        basicActions.waitForElementToBePresent(agencyInformationContainerTitle, 10);
        agencyInformationEnterInviteCodefield.sendKeys("BBBBB");
        agencyInformationEnterInviteCodefield.sendKeys(Keys.ENTER);

        basicActions.waitForElementToBePresent(agencyInformationEnterInviteCodeError, 10);
        softAssert.assertEquals(agencyInformationEnterInviteCodeError.getText(), "Please enter valid invitation code");
        softAssert.assertAll();
    }

    public void enterAgencyInfoInviteCode(){
        basicActions.waitForElementToBePresent(agencyInformationContainerTitle, 10);
        agencyInformationEnterInviteCodefield.clear();
        agencyInformationEnterInviteCodefield.sendKeys(SharedData.getAdminStaff().getAdminStaffInviteCode());
        agencyInformationEnterInviteCodefield.sendKeys(Keys.ENTER);
    }

    public void verifyNewAgencyInformation(){
        basicActions.waitForElementToBePresent(agencyInformationContainerTitle, 10);
        softAssert.assertEquals(agencyInformationContainerTitle.getText(), "Agency Information");
        softAssert.assertEquals(agencyInformationAgencyName.getText(), SharedData.getAgencyOwner().getAgencyName());
        softAssert.assertEquals(agencyInformationAgencyEmail.getText(), SharedData.getAgencyOwner().getAgencyEmail());
        softAssert.assertEquals(agencyInformationAgencyPhone.getText(), SharedData.getAgencyOwner().getAgencyPhoneNumber());
        softAssert.assertAll();
    }

    public void verifyNoAgencyInformation(){
        basicActions.waitForElementToBePresent(agencyInformationContainerTitle, 10);
        softAssert.assertEquals(agencyInformationContainerTitle.getText(), "Agency Information");
        softAssert.assertFalse(basicActions.waitForElementPresence(agencyInformationAgencyName,10));
        softAssert.assertFalse(basicActions.waitForElementPresence(agencyInformationAgencyEmail,10));
        softAssert.assertFalse(basicActions.waitForElementPresence(agencyInformationAgencyPhone,10));
        softAssert.assertAll();
    }

    public void verifyCompleteProfileButtonDisplays(){
        basicActions.waitForElementToBePresentWithRetries(agencyCompleteProfile, 10);
        softAssert.assertEquals(agencyCompleteProfile.getText(), "Complete your profile");
        softAssert.assertAll();
    }
    public void clickViewReports() {
        basicActions.waitForElementToBePresent(viewReportButton, 20);
        viewReportButton.click();
    }
}
