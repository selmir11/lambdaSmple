package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AssistnetPortalPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

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
    @FindBy(id = "AN-ProgramManagerDashboard-AccountSummary-Cancel")
    WebElement cancelBTN;
    @FindBy(id = "AN-ProgramManagerDashboard-AccountSummary-Save")
    WebElement saveBTN;

    @FindBy(id = "button-new-org")
    WebElement addNewOrganizationButton;


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
}
