package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalPages;

import com.c4hco.test.automation.Dto.AssisterDetails;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.util.List;

public class AdminPortalProgramManagerPage {
    private BasicActions basicActions;
    static SoftAssert softAssert = new SoftAssert();
    MemberDetails memberDetails = new MemberDetails();
    AssisterDetails assisterDetails = new AssisterDetails();

    public AdminPortalProgramManagerPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='button-container-edit']//button")
    List<WebElement> profileSummaryOptions;
    @FindBy(xpath = "//div[@class='button-container-save']//button")
    List<WebElement> profileSaveOptions;
    @FindBy(id = "program-manager-email-input")
    WebElement assistnetEmailInput;
    @FindBy(xpath = "//div[@class='body-text-1 success-message']")
    WebElement successfulErrorText;
    @FindBy(id = "EmailData")
    WebElement email;
    @FindBy(xpath = "//app-account-activity/div/a/button")
    WebElement accountActivityReport;
    @FindBy(xpath = "//div[@class='group-box summary-container']/p")
    WebElement profileSummary;
    @FindBy(xpath = "//div[@class='account-title-div']")
    WebElement assistNetName;
    @FindBy(xpath = "//td[@id='username']")
    WebElement assistNetUsername;
    @FindBy(xpath = "//td[@id='program-manager-email']")
    WebElement assistNetEmail;
    @FindBy(xpath = "//td[@id='prim-phone']")
    WebElement assistNetPhone;
    @FindBy(xpath = "//td[.='Username:']")
    WebElement assistNetUsernameLabel;
    @FindBy(xpath = "//div[2]/table/tr[2]/td[1]")
    WebElement assistNetEmailLabel;
    @FindBy(xpath = "//div[2]/table/tr[4]/td[1]")
    WebElement assistNetPhoneLabel;
    @FindBy(xpath = "//div[@class='group-box organization-container']//p[1]")
    WebElement organizationDetailsLabel;
    @FindBy(xpath = "//label[@for='organization-id']")
    WebElement orgDroupDetailsLabel;
    @FindBy(xpath = "//label[@for='name']")
    WebElement orgNameLabel;
    @FindBy(xpath = "//p[@id='id']")
    WebElement orgDroupDetails;
    @FindBy(xpath = "//p[@id='name']")
    WebElement orgName;
    @FindBy(xpath = "//td[@class='error-message']")
    WebElement emptyErrorMsg;
    @FindBy(xpath = "//td[@id='program-manager-email']")
    WebElement emailText;


    public void clickTheOnTheAPProgramManagerDashboard(String option) {
        basicActions.waitForElementListToBePresentWithRetries(profileSummaryOptions,30);
        switch (option){
            case "Edit Profile":
                profileSummaryOptions.get(1).click();
            break;
            case "Manage Account Access":
                profileSummaryOptions.get(0).click();
                break;
            case "View Report":
                accountActivityReport.click();
                break;
        }
    }
    public void clickTheSaveOptionsOnTheAPProgramManagerDashboard(String option) {
        basicActions.waitForElementListToBePresentWithRetries( profileSaveOptions,30);
        switch (option){
            case "Cancel":
                profileSaveOptions.get(0).click();
            break;
            case "Save":
                profileSaveOptions.get(1).click();
                break;
        }
    }

    public void validateTheButtonSaveAndCancelAreDisplayed() {
        basicActions.waitForElementListToBePresentWithRetries( profileSaveOptions,30);
        softAssert.assertEquals(profileSaveOptions.get(0).getText(),"Cancel");
        softAssert.assertEquals(profileSaveOptions.get(1).getText(),"Save");
        softAssert.assertAll();
    }


    public void updateTheEmailAdresseOutlookComOfTheProgramManager(String emailBase) {
        basicActions.waitForElementToBePresentWithRetries(assistnetEmailInput,30);
        assistnetEmailInput.clear();
      String email = basicActions.getUniqueString(8)+"assistNet";
        email = emailBase+"+"+email+"@outlook.com";
       assistnetEmailInput.sendKeys(email);
        AssisterDetails assisterDetails = new AssisterDetails();
        assisterDetails.setEmail(email);
        SharedData.setAssisterDetails(assisterDetails);
    }


    public void validateTheUpdateSuccessfulTextIsDisplayed() {
        basicActions.waitForElementToBePresentWithRetries(successfulErrorText,30);
        softAssert.assertEquals(successfulErrorText.getText(),"Update successful.");
        softAssert.assertAll();
    }

    public void validateTheAssistnetDataInProfileSummaryContainer() {
        basicActions.waitForElementToBePresentWithRetries(profileSummary,30);
        basicActions.waitForElementToBePresentWithRetries(assistNetEmailLabel,60);
        softAssert.assertEquals(profileSummary.getText(),"Profile Summary");
        softAssert.assertEquals(assistNetUsernameLabel.getText(),"Username:");
        softAssert.assertEquals(assistNetEmailLabel.getText(),"Email Address:");
        softAssert.assertEquals(assistNetPhoneLabel.getText(),"Phone Number:");

        if (SharedData.getEnv().equals("qa")){
            softAssert.assertEquals(assistNetName.getText(),"Morgan Martin");
            softAssert.assertEquals(assistNetUsername.getText(),"carrimautomation+PM@gmail.com");
            softAssert.assertEquals(assistNetEmail.getText(),"carrimautomation+PM@gmail.com");
            softAssert.assertEquals(assistNetPhone.getText(),"303-123-6549");

        }else{
            softAssert.assertEquals(assistNetName.getText(),"adstaygpvi adsopibhuxo");
            softAssert.assertEquals(assistNetUsername.getText(),"c4assistorportal+6D9xrQWta@gmail.com");
            softAssert.assertEquals(assistNetEmail.getText(),"c4assistorportal+nglxvkqeassistNet@outlook.com");
            softAssert.assertEquals(assistNetPhone.getText(),"317-360-5536");
        }

        softAssert.assertAll();
    }

    public void validateTheAssistNetOrganizationDetailsInAdminPortal() {
        softAssert.assertEquals(organizationDetailsLabel.getText(),"Organization Information");
        softAssert.assertEquals(orgDroupDetailsLabel.getText(),"Organization Group ID:");
        softAssert.assertEquals(orgNameLabel.getText(),"Organization Name:");

        if (SharedData.getEnv().equals("qa")){
            softAssert.assertEquals(orgDroupDetails.getText(),"133015479");
            softAssert.assertEquals(orgName.getText(),"PuppyPower");
        }else {
            softAssert.assertEquals(orgDroupDetails.getText(),"61745879");
            softAssert.assertEquals(orgName.getText(),"apvizpfcoigbwckxtepvlhctbjs");
        }

        softAssert.assertAll();
    }


    public void validateTheErrorMessageForEmptyEmailIsDisplayed() {
        basicActions.waitForElementToBePresentWithRetries(profileSaveOptions.get(0),30);
        basicActions.wait(500);
        assistnetEmailInput.sendKeys(Keys.CONTROL + "a");
        assistnetEmailInput.sendKeys(Keys.DELETE);
        assistnetEmailInput.sendKeys(Keys.ENTER);
        profileSaveOptions.get(1).click();


        basicActions.waitForElementToBePresentWithRetries(emptyErrorMsg,30);
        softAssert.assertEquals(emptyErrorMsg.getText(),"A valid Email is required.");
        softAssert.assertAll();
        basicActions.waitForElementToBePresent(profileSaveOptions.get(0),30);
        profileSaveOptions.get(0).click();
    }

    public void setEmailValueForPM(String STGAccount, String QAAccount) {
        String primaryMemberId;
        if (SharedData.getEnv().contains("qa")) {
            primaryMemberId = QAAccount;
        } else {
            primaryMemberId = STGAccount;
        }
        BigDecimal bigDecimal = new BigDecimal(primaryMemberId);

        memberDetails.setAccount_id(bigDecimal);
        SharedData.setPrimaryMember(memberDetails);
        assisterDetails.setEmail(emailText.getText());
        SharedData.setAssisterDetails(assisterDetails);
    }


}
