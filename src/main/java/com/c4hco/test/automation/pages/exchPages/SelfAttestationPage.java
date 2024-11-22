package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.actions.ClickAction;
import com.c4hco.test.automation.actions.ScrollAction;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SelfAttestationPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public SelfAttestationPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements((basicActions.getDriver()), this);
    }

    private boolean taxNoFlag = false;

    String expected =
            "Action Required: Additional Information Needed\n" +
            "\n" +
            "\n" +
            "Thank you for verifying your information. Unfortunately, we still need additional documentation to confirm the details you provided. This step ensures you receive the correct financial assistance. If you received premium tax credits but did not report them, you must first file and reconcile past credits with the IRS.\n" +
            "\n" +
            "\n" +
            "Next Steps:\n" +
            "\n" +
            "File an amended return with the IRS to correct your tax information.\n" +
            "Submit documents to confirm that: (a) you have now filed federal income taxes and reported the premium tax credit that you received and (b) your income is correct.\n" +
            "For more details, please review the information here, contact our support team at 855-752-6749, or get help from an Expert.\n" +
            "\n" +
            "Remember:The documents you submit must confirm both your household income and that you have appropriately filed a federal income tax return and reported the premium tax credits you received. You may lose the financial help you’re receiving if you do not provide us with both documents.";


   String expectedUpdateText =
           "Thank you!\n"+
           "\n" +
           "\n" +
           "It looks like we need updated information about what your household income will be for 2025. Please go here and click on “Apply for 2025” to submit a new application.\n" +
           "\n" +
           "\n" +
           "Need more help?   Contact our support team at 855-752-6749 or find an expert near you.";

    @FindBy(id ="household_income-MVR.HOUSEHOLD_INCOME.YESButton")
    WebElement householdIncomeYes;

    @FindBy(id = "household_income-MVR.HOUSEHOLD_INCOME.NOButton")
    WebElement householdIncomeNo;

    @FindBy(id = "federal_income-MVR.FEDERAL_INCOME.YESButton")
    WebElement federalIncomeYes;

    @FindBy(id = "federal_income-MVR.FEDERAL_INCOME.NOButton")
    WebElement federalIncomeNo;

    @FindBy(id = "federal_history-MVR.FEDERAL_HISTORY.FH_YESButton")
    WebElement taxYes;

    @FindBy(id = "federal_history-MVR.FEDERAL_HISTORY.NO_PLANButton")
    WebElement taxNoWillFile;

    @FindBy(id = "federal_history-MVR.FEDERAL_HISTORY.FH_NOButton")
    WebElement taxNo;

    @FindBy(id = "Attestation-SaveAndContinue")
    WebElement submit;

    @FindBy(xpath = "/html/body/app-root/lib-base-layout/div/main/div/app-post-attestation/app-container/div/div/div[2]/p")
    WebElement pageText;

    @FindBy(xpath = "/html/body/app-root/lib-base-layout/div/main/div/app-post-attestation/app-container/div/div/div[2]/section")
    WebElement pageText1;

    @FindBy(id = "undefined-SaveAndContinue")
    WebElement finish;

    @FindBy(xpath = "//button[text()='here']")
    WebElement btnClickHereToUpdateApp;

    @FindBy(xpath = "//a[text()='expert near you']")
    WebElement btnFindExpertHelp;

    public void clickHousehold(String householdIncome) {
        basicActions.waitForElementToBeClickable(householdIncomeYes, 10);

        switch (householdIncome) {
            case "Yes":
                householdIncomeYes.click();
                break;
            case "No":
                householdIncomeNo.click();
                break;
            default:
                System.out.println("Unexpected value: " + householdIncome);
                break;
        }
    }

    public void clickFederal(String federalIncome) {
        basicActions.waitForElementToBeClickable(federalIncomeYes, 10);

        switch (federalIncome) {
            case "Yes":
                federalIncomeYes.click();
                break;
            case "No":
                federalIncomeNo.click();
                break;
            default:
                System.out.println("Unexpected value for federalIncome: " + federalIncome);
                break;
        }
    }

    public void clickTax(String taxFiling) {
        basicActions.waitForElementToBeClickable(taxYes, 10);

        switch (taxFiling) {
            case "Yes":
                taxYes.click();
                break;
            case "NoWillFile":
                taxNoWillFile.click();
                break;
            default:
                taxNo.click();
                taxNoFlag = true;
                break;
        }
    }

    public void clickSubmit() {
        basicActions.waitForElementToBeClickable(submit, 10);
        ScrollAction.scrollToElement(submit);
        submit.click();
    }

    public void checkText(String scenario){
        basicActions.waitForElementToBePresent(pageText, 10);
        switch(scenario){
            case "Success":
                softAssert.assertEquals(pageText.getText(), "Your income and tax filing information were successfully confirmed.");
                break;
            case "Action Required":
                softAssert.assertEquals(pageText1.getText(), expected);
                break;
            case "Update Application":
                softAssert.assertEquals(pageText1.getText(), expectedUpdateText);
                break;
        }
    }

    public void checkUpdateAppMsgText(){
        basicActions.waitForElementToBePresent(pageText,10);
        softAssert.assertEquals(pageText1.getText(), expectedUpdateText);
    }

    public void clickFinish() {
        basicActions.waitForElementToBeClickable(finish, 10);
        ScrollAction.scrollToElement(finish);
        finish.click();
    }

    public void clickHereToUpdate(){
        basicActions.waitForElementToBeClickable(btnClickHereToUpdateApp, 10);
        ScrollAction.scrollToElement(btnClickHereToUpdateApp);
        btnClickHereToUpdateApp.click();
    }

    public void clickExpertHelp(){
        basicActions.waitForElementToBeClickable(btnFindExpertHelp, 10);
        ScrollAction.scrollToElement(btnFindExpertHelp);
        btnFindExpertHelp.click();
    }
}