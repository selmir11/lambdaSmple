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

    private boolean taxNoFlag = false;

    public SelfAttestationPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements((basicActions.getDriver()), this);
    }

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

    public void clickHousehold(String householdIncome){
        basicActions.waitForElementToBeClickable(householdIncomeYes, 10);

        if (householdIncome.equals("Yes")) {
            householdIncomeYes.click();
        } else {householdIncomeNo.click();}
    }

    public void clickFederal(String federalIncome){
        basicActions.waitForElementToBeClickable(federalIncomeYes, 10);

        if (federalIncome.equals("Yes")) {
            federalIncomeYes.click();
        } else {federalIncomeNo.click();}
    }


    public void clickTax(String taxFiling){
        basicActions.waitForElementToBeClickable(taxYes, 10);

        if (taxFiling.equals("Yes")){
            taxYes.click();
        } else if (taxFiling.equals("NoWillFile")) {
            taxNoWillFile.click();
        } else {
            taxNo.click();
            taxNoFlag = true;
        }
    }

    public void clickSubmit() {
        basicActions.waitForElementToBeClickable(submit, 10);
        ScrollAction.scrollToElement(submit);
        submit.click();
    }

    public void checkText() {
        basicActions.waitForElementToBePresent(pageText, 10);
        if (!taxNoFlag) {
            softAssert.assertEquals(pageText.getText(), "Your income and tax filing information were successfully confirmed.");
        } else {softAssert.assertEquals(pageText1.getText(), expected);}
    }

    public void clickFinish() {
        basicActions.waitForElementToBeClickable(finish, 10);
        ScrollAction.scrollToElement(finish);
        finish.click();
    }
}