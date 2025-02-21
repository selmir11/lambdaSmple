package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class MaEligibleMembersSelfEmploymentExpensesPage {

    private BasicActions basicActions;
    private SoftAssert softAssert;

    public MaEligibleMembersSelfEmploymentExpensesPage(WebDriver webDriver) {
        this.softAssert = new SoftAssert();
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public BasicActions getDriver() {
        return BasicActions.getInstance();
    }

    @FindBy(id = "isAnyoneMACriteriaYes")
    WebElement rdoYes;

    @FindBy(id = "isAnyoneMACriteriaNo")
    WebElement rdoNo;

    @FindBy(id = "continueButton")
    WebElement btnSaveAndContinue;

    @FindBy(id = "criteriaApplicableLabel")
    WebElement criteriaApplicableLebel;
    @FindBy(id = "criteriaApplicableLabel")
    WebElement criteriaApplicableLebelsp;

    @FindBy(xpath = "//a[@id='overviewButton']//preceding::h1")
    WebElement selfEmpH1Label;

    @FindBy(id = "overviewButton")
    WebElement overviewButton;
    @FindBy(xpath = "//a[text()='Ayuda para entender esta página']")
    WebElement overviewButtonsp;

    @FindBy(xpath = "//span[text()='Yes']")
    WebElement yesLabel;
    @FindBy(xpath = "//input[@id='isAnyoneMACriteriaYes']//following::span")
    WebElement yesLabelsp;

    @FindBy(xpath = "//span[text()='No']")
    WebElement noLabel;



    public void answerSelfEmployed(String nextOption) {
        basicActions.waitForElementToBePresent(rdoYes, 20);
        switch (nextOption) {
            case "Yes":
                rdoYes.click();
                break;
            case "No":
                rdoNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + nextOption);
        }
        btnSaveAndContinue.click();
    }

    /// ///////////////////////////VALIDATIONS/////////////////////////

    public void validateMaSelfEmploymentPage(String language, List<String> dataText) {

        switch (language.toLowerCase()) {
            case "english":
                basicActions.waitForElementToBePresent(criteriaApplicableLebel, 2);
                basicActions.waitForElementToBePresent(selfEmpH1Label, 1);
                basicActions.waitForElementToBePresent(overviewButton, 1);
                basicActions.waitForElementToBePresent(yesLabel, 1);
                basicActions.waitForElementToBePresent(noLabel, 1);
                softAssert.assertEquals(criteriaApplicableLebel.getText(), dataText.get(1),"Label Not matching");
                softAssert.assertEquals(selfEmpH1Label.getText(), dataText.get(2),"Label Not matching");
                softAssert.assertEquals(overviewButton.getText(), dataText.get(3),"label not matching");
                softAssert.assertEquals(yesLabel.getText(), dataText.get(4),"Yes button label not matching");
                softAssert.assertEquals(noLabel.getText().trim(), dataText.get(5),"No button label not matching");
                break;
            case "spanish":
                basicActions.waitForElementToBePresent(criteriaApplicableLebelsp, 2);
                basicActions.waitForElementToBePresent(selfEmpH1Label, 1);
                basicActions.waitForElementToBePresent(overviewButton, 1);
                basicActions.waitForElementToBePresent(yesLabelsp, 1);
                basicActions.waitForElementToBePresent(noLabel, 1);
                softAssert.assertEquals(criteriaApplicableLebelsp.getText(), dataText.get(1),"Label Not matching");
                softAssert.assertEquals(selfEmpH1Label.getText(), dataText.get(2),"Label Not matching");
                softAssert.assertEquals(overviewButton.getText(), dataText.get(3),"label not matching");
                softAssert.assertEquals(yesLabelsp.getText(), dataText.get(4),"Yes button label not matching");
                softAssert.assertEquals(noLabel.getText().trim(), dataText.get(5),"No button label not matching");
                break;
            default:
                throw new IllegalArgumentException("Invalid language: " + language);
        }
        softAssert.assertAll();
    }
}
