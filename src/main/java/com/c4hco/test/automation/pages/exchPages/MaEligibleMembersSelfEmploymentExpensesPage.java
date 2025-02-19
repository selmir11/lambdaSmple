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

    @FindBy(xpath = "//h1[text()='Self-Employment']")
    WebElement selfEmpH1Label;
    @FindBy(xpath = "//h1[text()='Trabajador independiente")
    WebElement selfEmpH1Labelsp;


    @FindBy(id = "overviewButton")
    WebElement overviewButton;
    @FindBy(xpath = "//a[text()='Ayuda para entender esta página")
    WebElement overviewButtonsp;

    @FindBy(xpath = "//span[text()='Yes']")
    WebElement yesLabel;
    @FindBy(xpath = "//span[text()='Sí']")
    WebElement yesLabelsp;

    @FindBy(xpath = "//span[text()='No']")
    WebElement noLabel;
    @FindBy(xpath = "//span[text()='No']")
    WebElement noLabelsp;


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

    public void validateMaSelfEmploymentPage(List<String> dataText, String language) {

        switch (language.toLowerCase()) {
            case "english":
                basicActions.waitForElementToBePresent(criteriaApplicableLebel, 10);
                basicActions.waitForElementToBePresent(selfEmpH1Label, 10);
                basicActions.waitForElementToBePresent(overviewButton, 10);
                basicActions.waitForElementToBePresent(yesLabel, 10);
                basicActions.waitForElementToBePresent(noLabel, 10);
                softAssert.assertEquals(criteriaApplicableLebel.getText(), dataText.get(1),"Label Not matching");
                softAssert.assertEquals(selfEmpH1Label.getText(), dataText.get(2),"Label Not matching");
                softAssert.assertEquals(overviewButton.getText(), dataText.get(3),"label not matching");
                softAssert.assertEquals(yesLabel.getText(), dataText.get(4),"Yes button label not matching");
                softAssert.assertEquals(noLabel.getText().trim(), dataText.get(5),"No button label not matching");
                break;
            case "spanish":
                basicActions.waitForElementToBePresent(criteriaApplicableLebelsp, 10);
                basicActions.waitForElementToBePresent(selfEmpH1Labelsp, 10);
                basicActions.waitForElementToBePresent(overviewButtonsp, 10);
                basicActions.waitForElementToBePresent(yesLabelsp, 10);
                basicActions.waitForElementToBePresent(noLabelsp, 10);
                softAssert.assertEquals(criteriaApplicableLebelsp.getText(), dataText.get(1),"Label Not matching");
                softAssert.assertEquals(selfEmpH1Labelsp.getText(), dataText.get(2),"Label Not matching");
                softAssert.assertEquals(overviewButtonsp.getText(), dataText.get(3),"label not matching");
                softAssert.assertEquals(yesLabelsp.getText(), dataText.get(4),"Yes button label not matching");
                softAssert.assertEquals(noLabelsp.getText().trim(), dataText.get(5),"No button label not matching");
                break;
            default:
                throw new IllegalArgumentException("Invalid language: " + language);
        }
        softAssert.assertAll();
    }
}
