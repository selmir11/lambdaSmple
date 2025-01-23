package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalPages;

import com.c4hco.test.automation.Dto.AssisterDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AdminPortalProgramManagerPage {
    private BasicActions basicActions;
    static SoftAssert softAssert = new SoftAssert();

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

}
