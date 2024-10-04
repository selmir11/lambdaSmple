package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.c4hco.test.automation.utils.WebDriverManager.getDriver;


public class CacScreenerPage {
    private BasicActions basicActions;
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    SoftAssert softAssert = new SoftAssert();
    public CacScreenerPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "h1")
    WebElement cacScreenerHeader;

    @FindBy(css = "#anyoneUnderEighteen-container input")
    List<WebElement> under19Answer;

    @FindBy(css = "#anyonePregnant-container input")
    List<WebElement> pregnantAnswer;

    @FindBy(css = "#anyoneDacaRecipient-container input")
    List<WebElement> dacaAnswer;

    @FindBy(css = "#anyoneEnrolledInSes-container input")
    List<WebElement> sesAnswer;

    @FindBy(css = ".see-results-button-container button")
    WebElement seeResultsBtn;

    @FindBy(css = ".retake-quiz-button-container button")
    WebElement retakeQuizBtn;

    @FindBy(css = ".results.ng-star-inserted > div")
    WebElement resultsHeaderTxt;

    @FindBy(xpath = "//app-enrollment-option[contains(@keyprefix, 'healthFirstColorado')]//div[contains(@class, 'c4-type-header-sm')]")
    WebElement resultsHealthFirstColoradoTxt;

    @FindBy(xpath = "//app-enrollment-option[contains(@keyprefix, 'connectForHealthColorado')]//div[contains(@class, 'c4-type-header-sm')]")
    WebElement resultsC4HCOtxt;

    @FindBy(xpath = "//app-enrollment-option[contains(@keyprefix, 'coloradoConnectReenroll')]//div[contains(@class, 'c4-type-header-sm')]")
    WebElement resultsSEStxt;

    @FindBy(css = ".footer-buttons button")
    WebElement continueSignInBtn;





    public void clickSaveAndContinue(){
        basicActions.waitForElementToBePresent(cacScreenerHeader, 40);
        basicActions.waitForElementToBeClickable(continueSignInBtn, 20);
        basicActions.scrollToElement(continueSignInBtn);
        continueSignInBtn.click();
    }

    public void answerQuestions(String answer, String question) {
        basicActions.waitForElementToBePresent(cacScreenerHeader, 5);

        Map<String, List<WebElement>> answerMap = new HashMap<>();
        answerMap.put("under 19", under19Answer);
        answerMap.put("pregnant", pregnantAnswer);
        answerMap.put("DACA", dacaAnswer);
        answerMap.put("SES", sesAnswer);
        if (!answerMap.containsKey(question)) {
            throw new IllegalArgumentException("Invalid option: " + question);
        }

        List<WebElement> answerElements = answerMap.get(question);

        switch (answer) {
            case "Yes":
                answerElements.get(0).click();
                break;
            case "No":
                answerElements.get(1).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid answer: " + answer);
        }
    }

    public void clickSeeResults(){
        basicActions.waitForElementToBePresent(cacScreenerHeader, 40);
        basicActions.waitForElementToBeClickable(seeResultsBtn, 20);
        basicActions.scrollToElement(seeResultsBtn);
        seeResultsBtn.click();
    }

    public void clickRetakeQuiz(){
        basicActions.waitForElementToBePresent(cacScreenerHeader, 40);
        basicActions.waitForElementToBeClickable(retakeQuizBtn, 20);
        basicActions.scrollToElement(retakeQuizBtn);
        retakeQuizBtn.click();
    }






    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line
    public void QuestionsDisabledEnabled(String status) {
        switch (status) {
            case "Disabled":
                QuestionsDisabled();
                break;
            case "Enabled":
                QuestionsEnabled();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + status);
        }
    }

    public void QuestionsDisabled() {
        basicActions.waitForElementToBePresent(resultsHeaderTxt, 40);

        softAssert.assertFalse(under19Answer.get(0).isEnabled(), "under19Answer No should be disabled");
        softAssert.assertFalse(under19Answer.get(1).isEnabled(), "under19Answer Yes should be disabled");
        softAssert.assertFalse(pregnantAnswer.get(0).isEnabled(), "pregnantAnswer No should be disabled");
        softAssert.assertFalse(pregnantAnswer.get(1).isEnabled(), "pregnantAnswer Yes should be disabled");
        softAssert.assertFalse(dacaAnswer.get(0).isEnabled(), "dacaAnswer No should be disabled");
        softAssert.assertFalse(dacaAnswer.get(1).isEnabled(), "dacaAnswer Yes should be disabled");
        softAssert.assertFalse(sesAnswer.get(0).isEnabled(), "sesAnswer No should be disabled");
        softAssert.assertFalse(sesAnswer.get(1).isEnabled(), "sesAnswer Yes should be disabled");

        softAssert.assertFalse(basicActions.waitForElementPresence(seeResultsBtn, 30), "See results button should not be present");
        softAssert.assertEquals(retakeQuizBtn.getText(), "Retake quiz", "Retake quiz button text mismatch");

        softAssert.assertAll();
    }

    public void QuestionsEnabled() {
        basicActions.waitForElementToBePresent(resultsHeaderTxt, 40);

        softAssert.assertTrue(under19Answer.get(0).isEnabled(), "under19Answer No should be enabled");
        softAssert.assertTrue(under19Answer.get(1).isEnabled(), "under19Answer Yes should be enabled");
        softAssert.assertTrue(pregnantAnswer.get(0).isEnabled(), "pregnantAnswer No should be enabled");
        softAssert.assertTrue(pregnantAnswer.get(1).isEnabled(), "pregnantAnswer Yes should be enabled");
        softAssert.assertTrue(dacaAnswer.get(0).isEnabled(), "dacaAnswer No should be enabled");
        softAssert.assertTrue(dacaAnswer.get(1).isEnabled(), "dacaAnswer Yes should be enabled");
        softAssert.assertTrue(sesAnswer.get(0).isEnabled(), "sesAnswer No should be enabled");
        softAssert.assertTrue(sesAnswer.get(1).isEnabled(), "sesAnswer Yes should be enabled");

        softAssert.assertFalse(basicActions.waitForElementPresence(retakeQuizBtn, 30), "Retake quiz button should not be present");
        softAssert.assertEquals(seeResultsBtn.getText(), "See results", "See results button text mismatch");

        softAssert.assertAll();
    }

    public void validateSearchResults(String screenerOption, String language) {
        basicActions.waitForElementToBePresent(cacScreenerHeader, 40);
        Map<String, String> expectedTexts = new HashMap<>();

        switch (language) {
            case "English":
                expectedTexts.put("header", "These are the coverage options available to your household:");
                expectedTexts.put("HealthFirst", "Health First Colorado or Child Health Plan Plus (CHP+)");
                expectedTexts.put("C4HCO", "Connect for Health Colorado");
                expectedTexts.put("SES", "The OmniSalud program (through Colorado Connect)");
                break;
            case "Spanish":
                expectedTexts.put("header", "Spanish text for header"); // Add actual Spanish text
                expectedTexts.put("HealthFirst", "Spanish text for HealthFirst");
                expectedTexts.put("C4HCO", "Spanish text for C4HCO");
                expectedTexts.put("SES", "Spanish text for SES");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }

        String expectedText = expectedTexts.get(screenerOption);
        if (expectedText == null) {
            throw new IllegalArgumentException("Invalid option: " + screenerOption);
        }

        switch (screenerOption) {
            case "header":
                softAssert.assertEquals(resultsHeaderTxt.getText(), expectedText);
                break;
            case "HealthFirst":
                softAssert.assertEquals(resultsHealthFirstColoradoTxt.getText(), expectedText);
                break;
            case "C4HCO":
                softAssert.assertEquals(resultsC4HCOtxt.getText(), expectedText);
                break;
            case "SES":
                softAssert.assertEquals(resultsSEStxt.getText(), expectedText);
                break;
        }
        softAssert.assertAll();
    }

    public void validateResultsNotDisplay(String screenerOption) {
        basicActions.waitForElementToBePresent(resultsHeaderTxt, 40);
        switch (screenerOption) {
            case "HealthFirst":
                softAssert.assertFalse(basicActions.waitForElementPresence(resultsHealthFirstColoradoTxt,30));
                break;
            case "C4HCO":
                softAssert.assertFalse(basicActions.waitForElementPresence(resultsC4HCOtxt,30));
                break;
            case "SES":
                softAssert.assertFalse(basicActions.waitForElementPresence(resultsSEStxt,30));
                break;
        }
        softAssert.assertAll();
    }

    public void validateQuestions(String answer, String question, String status) {
        //status = true/false
        basicActions.waitForElementToBePresent(cacScreenerHeader, 5);
        basicActions.waitForElementListToBePresent(under19Answer, 5);

        Map<String, List<WebElement>> answerMap = new HashMap<>();
        answerMap.put("under 19", under19Answer);
        answerMap.put("pregnant", pregnantAnswer);
        answerMap.put("DACA", dacaAnswer);
        answerMap.put("SES", sesAnswer);
        if (!answerMap.containsKey(question)) {
            throw new IllegalArgumentException("Invalid option: " + question);
        }

        List<WebElement> answerElements = answerMap.get(question);

        boolean expectedStatus = Boolean.parseBoolean(status);
        switch (answer) {
            case "Yes":
                softAssert.assertEquals(answerElements.get(0).isSelected(), expectedStatus);
                softAssert.assertAll();
                break;
            case "No":
                softAssert.assertEquals(answerElements.get(1).isSelected(), expectedStatus);
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid answer: " + answer);
        }
    }




}
