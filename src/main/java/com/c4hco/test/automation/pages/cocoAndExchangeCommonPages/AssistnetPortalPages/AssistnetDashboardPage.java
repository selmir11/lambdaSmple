package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AssistnetPortalPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;

public class AssistnetDashboardPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    public AssistnetDashboardPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "viewMyClients")
    WebElement viewMyClientBTN ;
    @FindBy(xpath = "//span[@class='mdc-button__label']")
    WebElement printBtn;
    @FindBy(id = "user-first-name")
    WebElement usernamedrp;
    @FindBy(id = "logout-link")
    WebElement logoutLnk;
    @FindBy(id = "AN-ProgramManagerDashboard-AccountSummary-Edit")
    WebElement editBTN;
    @FindBy(id = "acctUsernameData")
    WebElement username;
    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstNameAP;

    @FindBy(id = "acctFirstNameData")
    WebElement acctFirstname;
    @FindBy(id = "last-name")
    WebElement lastNameAP;
    @FindBy(id = "phoneNumber-name")
    WebElement phoneNumberAP;
    @FindBy(id = "emailAddress-name")
    WebElement emailAP;
    @FindBy(id = "EmailData")
    WebElement emailText;
    @FindBy(id = "AN-ProgramManagerDashboard-AccountSummary-Cancel")
    WebElement cancelBTN;
    @FindBy(id = "AN-ProgramManagerDashboard-AccountSummary-Save")
    WebElement saveBTN;

    @FindBy(id = "button-new-org")
    WebElement addNewOrganizationButton;
    @FindBy(id = "AN-ProgramManagerDashboard-AccountSummary-CompleteProfile")
    WebElement completeProfileButton;
    @FindBy(id = "AN-MyInformation-SaveandContinue")
    WebElement saveAndContinueButton;
    @FindBy(id = "dashboard-button")
    WebElement goBckToMyDashboardButton;
    @FindBy(xpath = "//div[@class='row justify-content-center dashboard-header']")
    WebElement dashboardWelcomeHeader;
    @FindBy(xpath = "//div[2]/div[3]/div[2]/div")
    WebElement certificationStatus;
    @FindBy(xpath = "//*[@id='userNameLabel']/span")
    WebElement accountNumber;


    public void ClickOnViewMyClients() {
        basicActions.waitForElementToBePresent(viewMyClientBTN,15);
        viewMyClientBTN.click();
    }

    public void verifyPrintButtonInAP() {
            basicActions.waitForElementToBePresent(printBtn,10);
            softAssert.assertTrue(printBtn.isDisplayed());
            softAssert.assertTrue(printBtn.isEnabled());
            softAssert.assertAll();}

    public void ClickOnUsernameDropdown() {
        basicActions.waitForElementToBePresent(usernamedrp,20);
        usernamedrp.click();
    }

    public void ClickSignOutFromTheAP() {
        basicActions.waitForElementToBePresent(logoutLnk,20);
        logoutLnk.click();
    }

    public void ClickEditButtonOnAssistnetDashboardPage() {
        basicActions.waitForElementToBePresent(editBTN,20);
        editBTN.click();
    }

    public void verifyUsernameIsNotEditable() {
        softAssert.assertTrue(username.isDisplayed());
        try {
            username.sendKeys("Test");
            System.out.println("Element is editable");
        } catch (Exception e) {
            System.out.println("Element is not editable");
        }
        softAssert.assertAll();
    }


    public void editBasicDetails(String username,String email) {
        basicActions.waitForElementToBePresent(usernamedrp, 20);
        firstNameAP.clear();
        firstNameAP.sendKeys(username);
        lastNameAP.sendKeys("TestLAstName");
        phoneNumberAP.sendKeys("7899876789");
        emailAP.clear();
        emailAP.sendKeys(email);

    }

    public void verifyTheFirstNameAP(String firstnameText) {
        basicActions.waitForElementToBePresent(acctFirstname,50);
        softAssert.assertEquals(acctFirstname.getText(),firstnameText);
    }

    public void editBasicDetailsAndClickSave(String email) {
        basicActions.waitForElementToBePresent(usernamedrp, 20);
        firstNameAP.sendKeys("TestFirstName");
        lastNameAP.sendKeys("TestLAstName");
        phoneNumberAP.sendKeys("7899876789");
        emailAP.clear();
        emailAP.sendKeys(email);
    }

    public void clickCancelBtnInAP() {
        cancelBTN.click();
    }

    public void clickSaveBtnInAP() {
        saveBTN.click();
    }

    public void clickAddNewOrganization() {
        basicActions.waitForElementToBePresent(addNewOrganizationButton, 20);

        softAssert.assertEquals(addNewOrganizationButton.getText(), "Add New Organization");
        softAssert.assertAll();

        addNewOrganizationButton.click();
    }

    public void clickEditOrganization() {
        basicActions.waitForElementToBePresent(addNewOrganizationButton, 20);

        int rows = basicActions.getDriver().findElements(By.xpath("//*[@id='myOrganizations']/app-organizations/div/div[2]/table/tbody/tr")).size();
        System.out.println("Rows found " +rows);
        System.out.println("Searching for " +SharedData.getProgramManager().getOrganizationSiteName());

        for(int r=1; r<rows; r++){
            String orgName = basicActions.getDriver().findElement(By.xpath("//tbody/tr["+r+"]/td[1]")).getText();

            if(orgName.equals(SharedData.getProgramManager().getOrganizationSiteName())){
                System.out.println("Found at row " +r);
                basicActions.getDriver().findElement(By.xpath("//*[@id='myOrganizations']/app-organizations/div/div[2]/table/tbody/tr[" + r + "]/td[5]/a")).click();
                break;
            }
        }
    }

    public void validateUpdatedOrgNameListed() {
        basicActions.waitForElementToBePresent(addNewOrganizationButton, 20);

        int rows = basicActions.getDriver().findElements(By.xpath("//*[@id='myOrganizations']/app-organizations/div/div[2]/table/tbody/tr")).size();
        System.out.println("Rows found " +rows);
        System.out.println("Searching for " +SharedData.getProgramManager().getOrganizationSiteName());

        for(int r=1; r<rows; r++){
            String orgName = basicActions.getDriver().findElement(By.xpath("//tbody/tr["+r+"]/td[1]")).getText();

            if(orgName.equals(SharedData.getProgramManager().getOrganizationSiteName())){
                System.out.println("Found at row " +r);
                break;
            }
        }
    }

    public void validateTheEmailIsUpdatedCorrectly() {
        basicActions.waitForElementToBePresentWithRetries(emailText,30);
        softAssert.assertEquals(emailText.getText(),SharedData.getAssisterDetails().getEmail());
        softAssert.assertAll();
    }


    public void clickCompleteProfileOnAssistnetDashboardPage() {
        basicActions.waitForElementToBePresent(completeProfileButton,50);
        completeProfileButton.click();
    }


    public void validateTheSaveAndContinueIsDisplayed() {
        basicActions.waitForElementToBeClickable(saveAndContinueButton,60);
        softAssert.assertEquals(saveAndContinueButton.getText(), "Save and Continue");
        softAssert.assertAll();
    }


    public void clickSaveAndContinueOnMyInformationAssistnetPage() {
        basicActions.waitForElementToBePresentWithRetries(saveAndContinueButton,60);
        saveAndContinueButton.click();
    }

    public void clickGoBackToMyDashboardButtonFromAssistNetDashboaredPage() {
        basicActions.waitForElementToBePresent(goBckToMyDashboardButton,60);
        goBckToMyDashboardButton.click();
    }

    public void verifyPMDashboardWelcomeText() {
        basicActions.waitForElementToBePresent(dashboardWelcomeHeader,60);
        softAssert.assertEquals(dashboardWelcomeHeader.getText(), "Welcome " + SharedData.getAssisterDetails().getFirstName() + " " + SharedData.getAssisterDetails().getLastName() + "!");
        softAssert.assertAll();
    }

    public void verifyPMCertificationStatus(String certStatus) {
        basicActions.refreshPage();
        basicActions.waitForElementToBePresentWithRetries(certificationStatus,60);
        switch (certStatus){
            case "Approved" :
                softAssert.assertEquals(certificationStatus.getText(), "Approved");
                break;
            case "Not Approved" :
                softAssert.assertEquals(certificationStatus.getText(), "Not Approved");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + certStatus);
        }
        softAssert.assertAll();
    }

    public void savePmAccount() {
        basicActions.waitForElementToBePresentWithRetries(accountNumber,60);
        MemberDetails programManager = new MemberDetails();
        programManager.setAccount_id(new BigDecimal(accountNumber.getText()));
        SharedData.setPrimaryMember(programManager);
    }
}
