package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CacScreenerPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    Actions builder;
    public CacScreenerPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        builder  = new Actions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "h1")
    WebElement cacScreenerHeader;

    @FindBy(css = ".subheader > span")
    WebElement cacScreenerSubHeader;

    @FindBy(css = "#anyoneUnderEighteen-container .cac-question-label-row label")
    WebElement under19Question;

    @FindBy(css = "#anyoneUnderEighteen-container .cac-question-label-row em")
    WebElement under19SubQuestion;

    @FindBy(css = "#anyoneUnderEighteen-container div.c4hes-lib-tooltip")
    WebElement under19TootlTip;

    @FindBy(css = "#anyoneUnderEighteen-container lib-option-radio-buttons label")
    List<WebElement> under19Answer;

    @FindBy(css = "#anyoneUnderEighteen-container input")
    List<WebElement> under19AnswerStatus;

    @FindBy(css = "#anyonePregnant-container .row span")
    WebElement pregnantQuestion;

    @FindBy(css = "#anyonePregnant-container lib-option-radio-buttons label")
    List<WebElement> pregnantAnswer;

    @FindBy(css = "#anyonePregnant-container input")
    List<WebElement> pregnantAnswerStatus;

    @FindBy(css = "#anyoneDacaRecipient-container .cac-question-label-row label")
    WebElement dacaQuestion;

    @FindBy(css = "#anyoneDacaRecipient-container .label-row.cac-question-label-row em")
    WebElement dacaSubQuestion;

    @FindBy(css = "#anyoneDacaRecipient-container div.c4hes-lib-tooltip")
    WebElement dacaTootlTip;

    @FindBy(css = "#anyoneDacaRecipient-container lib-option-radio-buttons label")
    List<WebElement> dacaAnswer;

    @FindBy(css = "#anyoneDacaRecipient-container input")
    List<WebElement> dacaAnswerStatus;

    @FindBy(css = "#anyoneEnrolledInSes-container .cac-question-label-row label")
    WebElement sesQuestion;

    @FindBy(css = "#anyoneEnrolledInSes-container .label-row.cac-question-label-row em")
    WebElement sesSubQuestion;

    @FindBy(css = "#anyoneEnrolledInSes-container div.c4hes-lib-tooltip")
    WebElement sesTootlTip;

    @FindBy(css = "#anyoneEnrolledInSes-container lib-option-radio-buttons label")
    List<WebElement> sesAnswer;

    @FindBy(css = "#anyoneEnrolledInSes-container input")
    List<WebElement> sesAnswerStatus;

    @FindBy(css = ".see-results-button-container button")
    WebElement seeResultsBtn;

    @FindBy(css = ".need-help-deciding-banner")
    WebElement needHelpBanner;

    @FindBy(css = ".need-help-deciding-banner a")
    WebElement needHelpLnk;

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
        answerMap.put("under 19", under19AnswerStatus);
        answerMap.put("pregnant", pregnantAnswerStatus);
        answerMap.put("DACA", dacaAnswerStatus);
        answerMap.put("SES", sesAnswerStatus);
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
    public void QuestionsDisabledEnabled(String status, String language) {
        switch (status) {
            case "Disabled":
                QuestionsDisabled(language);
                break;
            case "Enabled":
                QuestionsEnabled(language);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + status);
        }
    }

    public void QuestionsDisabled(String language) {
        basicActions.waitForElementToBePresent(resultsHeaderTxt, 40);

        softAssert.assertFalse(under19AnswerStatus.get(0).isEnabled(), "under19Answer No should be disabled");
        softAssert.assertFalse(under19AnswerStatus.get(1).isEnabled(), "under19Answer Yes should be disabled");
        softAssert.assertFalse(pregnantAnswerStatus.get(0).isEnabled(), "pregnantAnswer No should be disabled");
        softAssert.assertFalse(pregnantAnswerStatus.get(1).isEnabled(), "pregnantAnswer Yes should be disabled");
        softAssert.assertFalse(dacaAnswerStatus.get(0).isEnabled(), "dacaAnswer No should be disabled");
        softAssert.assertFalse(dacaAnswerStatus.get(1).isEnabled(), "dacaAnswer Yes should be disabled");
        softAssert.assertFalse(sesAnswerStatus.get(0).isEnabled(), "sesAnswer No should be disabled");
        softAssert.assertFalse(sesAnswerStatus.get(1).isEnabled(), "sesAnswer Yes should be disabled");

        softAssert.assertFalse(basicActions.waitForElementPresence(seeResultsBtn, 30), "See results button should not be present");
        switch (language){
            case "English":
                softAssert.assertEquals(retakeQuizBtn.getText(), "Retake quiz", "Retake quiz button text mismatch");
                break;
            case "Spanish":
                softAssert.assertEquals(retakeQuizBtn.getText(), "Repetir la encuesta", "Retake quiz button text mismatch");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }

        softAssert.assertAll();
    }

    public void QuestionsEnabled(String language) {
        basicActions.waitForElementToBePresent(resultsHeaderTxt, 40);

        softAssert.assertTrue(under19AnswerStatus.get(0).isEnabled(), "under19Answer No should be enabled");
        softAssert.assertTrue(under19AnswerStatus.get(1).isEnabled(), "under19Answer Yes should be enabled");
        softAssert.assertTrue(pregnantAnswerStatus.get(0).isEnabled(), "pregnantAnswer No should be enabled");
        softAssert.assertTrue(pregnantAnswerStatus.get(1).isEnabled(), "pregnantAnswer Yes should be enabled");
        softAssert.assertTrue(dacaAnswerStatus.get(0).isEnabled(), "dacaAnswer No should be enabled");
        softAssert.assertTrue(dacaAnswerStatus.get(1).isEnabled(), "dacaAnswer Yes should be enabled");
        softAssert.assertTrue(sesAnswerStatus.get(0).isEnabled(), "sesAnswer No should be enabled");
        softAssert.assertTrue(sesAnswerStatus.get(1).isEnabled(), "sesAnswer Yes should be enabled");

        softAssert.assertFalse(basicActions.waitForElementPresence(retakeQuizBtn, 30), "Retake quiz should not be present");
        switch (language){
            case "English":
                softAssert.assertEquals(seeResultsBtn.getText(), "See results", "See results button text mismatch");
                break;
            case "Spanish":
                softAssert.assertEquals(seeResultsBtn.getText(), "Ver resultados", "See results button text mismatch");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }

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
                expectedTexts.put("header", "Estas son las opciones de cobertura disponibles para su familia:"); // Add actual Spanish text
                expectedTexts.put("HealthFirst", "Health First Colorado o Child Health Plan Plus (CHP+)");
                expectedTexts.put("C4HCO", "Connect for Health Colorado");
                expectedTexts.put("SES", "El programa de OmniSalud (a trav\u00E9s de Colorado Connect)");
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
        answerMap.put("under 19", under19AnswerStatus);
        answerMap.put("pregnant", pregnantAnswerStatus);
        answerMap.put("DACA", dacaAnswerStatus);
        answerMap.put("SES", sesAnswerStatus);
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

    public void validatePageText(String section, String language) {
        basicActions.waitForElementToBePresent(resultsHeaderTxt, 40);
        switch (language) {
            case "English":
                validatePageTextEnglish(section);
                break;
            case "Spanish":
                validatePageTextSpanish(section);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validatePageTextEnglish(String section) {
        basicActions.waitForElementToBePresent(resultsHeaderTxt, 40);
            switch (section) {
                case "Main":
                    validatePageTextMainEnglish();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + section);
            }
    }

    public void validatePageTextSpanish(String section) {
        basicActions.waitForElementToBePresent(resultsHeaderTxt, 40);
            switch (section) {
                case "Main":
                    validatePageTextMainSpanish();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + section);
            }
    }

    public void validatePageTextMainEnglish(){
        basicActions.waitForElementToBePresent(cacScreenerHeader,10);
        softAssert.assertEquals(cacScreenerHeader.getText(), "Important news for undocumented Coloradans");
        softAssert.assertEquals(cacScreenerSubHeader.getText(), "There are several important health policy changes this year. You may have new coverage options for 2024. To see if these changes affect you and your family, answer a few quick questions.");
        softAssert.assertEquals(under19Question.getText(), "Is anyone in your household under 19?");
        softAssert.assertEquals(under19SubQuestion.getText(), "What if someone turns 19 in 2025?");
        builder.moveToElement(under19SubQuestion).perform();
        softAssert.assertEquals(under19TootlTip.getText(), "People who are undocumented and will turn 19 years old during 2025 should re-enroll in their OmniSalud coverage for 2025 because they will not qualify for other forms of financial help for the entire year of 2025.");
        softAssert.assertEquals(under19Answer.get(1).getText(), "Yes");
        softAssert.assertEquals(under19Answer.get(2).getText(), "No");
        softAssert.assertEquals(pregnantQuestion.getText(), "Is anyone in your household currently pregnant?");
        softAssert.assertEquals(pregnantAnswer.get(1).getText(), "Yes");
        softAssert.assertEquals(pregnantAnswer.get(2).getText(), "No");
        softAssert.assertEquals(dacaQuestion.getText(), "Is anyone in your household a Deferred Action for Childhood Arrivals (DACA) recipient?");
        softAssert.assertEquals(dacaSubQuestion.getText(), "What is DACA?");
        builder.moveToElement(dacaSubQuestion).perform();
        softAssert.assertEquals(dacaTootlTip.getText(), "DACA is a federal policy that protects eligible immigrants who came to the United States when they were children from deportation, among other things.");
        softAssert.assertEquals(dacaAnswer.get(1).getText(), "Yes");
        softAssert.assertEquals(dacaAnswer.get(2).getText(), "No");
        softAssert.assertEquals(sesQuestion.getText(), "Is anyone in your household currently receiving SilverEnhanced Savings financial help through the OmniSalud program?");
        softAssert.assertEquals(sesSubQuestion.getText(), "How do I know if I\u0027m receiving SilverEnhanced Savings?");
        builder.moveToElement(sesSubQuestion).perform();
        softAssert.assertEquals(sesTootlTip.getText(), "If you are enrolled in SilverEnhanced Savings, your health insurance plan will have the words \u201CSilver Enhanced 94\u0025\u201D in the name.");
        softAssert.assertEquals(sesAnswer.get(1).getText(), "Yes");
        softAssert.assertEquals(sesAnswer.get(2).getText(), "No");
        softAssert.assertEquals(seeResultsBtn.getText(), "See results");
        softAssert.assertEquals(needHelpBanner.getText(), "Need help deciding what to do?\nContact a certified enrollment expert!");
        softAssert.assertEquals(continueSignInBtn.getText(), "Continue signing in");
        softAssert.assertAll();
    }

    public void validatePageTextMainSpanish(){
        basicActions.waitForElementToBePresent(cacScreenerHeader,10);
        softAssert.assertEquals(cacScreenerHeader.getText(), "Noticia importante para los habitantes indocumentados de Colorado");
        softAssert.assertEquals(cacScreenerSubHeader.getText(), "Este a\u00F1o, se han dado lugar varios cambios significativos en las pol\u00EDticas de salud. Es posible que en 2024 cuente con opciones de cobertura nuevas. Para saber si los cambios le afectar\u00E1n a usted y a su familia, responda unas breves preguntas.");
        softAssert.assertEquals(under19Question.getText(), "\u00BFAlg\u00FAn miembro de su familia es menor de 19 a\u00F1os?");
        softAssert.assertEquals(under19SubQuestion.getText(), "\u00BFQu\u00E9 sucede si alguien cumple 19 a\u00F1os en 2025?");
        builder.moveToElement(under19SubQuestion).perform();
        softAssert.assertEquals(under19TootlTip.getText(), "Las personas indocumentadas que cumplen 19 a\u00F1os en 2025 deben reinscribirse en la cobertura de OmniSalud para 2025, ya que no calificar\u00E1n para recibir otras formas de ayuda financiera durante todo el a\u00F1o 2025.");
        softAssert.assertEquals(under19Answer.get(1).getText(), "S\u00ED");
        softAssert.assertEquals(under19Answer.get(2).getText(), "No");
        softAssert.assertEquals(pregnantQuestion.getText(), "\u00BFAlguna persona de su familia est\u00E1 embarazada actualmente?");
        softAssert.assertEquals(pregnantAnswer.get(1).getText(), "S\u00ED");
        softAssert.assertEquals(pregnantAnswer.get(2).getText(), "No");
        softAssert.assertEquals(dacaQuestion.getText(), "\u00BFAlg\u00FAn miembro de su familia recibe la Consideraci\u00F3n de Acci\u00F3n Diferida para los Llegados en la Infancia (DACA, por su sigla en ingl\u00E9s)?");
        softAssert.assertEquals(dacaSubQuestion.getText(), "\u00BFQu\u00E9 es DACA?");
        builder.moveToElement(dacaSubQuestion).perform();
        softAssert.assertEquals(dacaTootlTip.getText(), "DACA es una pol\u00EDtica federal que protege a los inmigrantes elegibles que llegaron a los Estados Unidos cuando eran ni\u00F1os contra la deportaci\u00F3n, entre otras cosas.");
        softAssert.assertEquals(dacaAnswer.get(1).getText(), "S\u00ED");
        softAssert.assertEquals(dacaAnswer.get(2).getText(), "No");
        softAssert.assertEquals(sesQuestion.getText(), "\u00BFAlg\u00FAn miembro de su familia recibe actualmente ayuda financiera de Ahorros SilverEnhanced a trav\u00E9s del programa de OmniSalud?");
        softAssert.assertEquals(sesSubQuestion.getText(), "\u00BFC\u00F3mo puedo saber si estoy recibiendo Ahorros SilverEnhanced?");
        builder.moveToElement(sesSubQuestion).perform();
        softAssert.assertEquals(sesTootlTip.getText(), "Si est\u00E1 inscrito en Ahorros SilverEnhanced, su plan de seguro de salud mostrar\u00E1 las palabras \u201CSilver Enhanced 94\u0025\u201D en el nombre.");
        softAssert.assertEquals(sesAnswer.get(1).getText(), "S\u00ED");
        softAssert.assertEquals(sesAnswer.get(2).getText(), "No");
        softAssert.assertEquals(seeResultsBtn.getText(), "Ver resultados");
        softAssert.assertEquals(needHelpBanner.getText(), "\u00BFNecesita ayuda para decidir qu\u00E9 hacer?\nContacte a un experto en inscripci\u00F3n certificado.");
        softAssert.assertEquals(continueSignInBtn.getText(), "Continuar con el inicio de sesi\u00F3n");
        softAssert.assertAll();
    }

    public void SeeResultsDisabledEnabled(String status) {
        basicActions.waitForElementToBePresent(cacScreenerHeader, 40);
        switch (status) {
            case "Disabled":
                softAssert.assertFalse(seeResultsBtn.isEnabled(), "See Results should be disabled");
                softAssert.assertAll();
                break;
            case "Enabled":
                softAssert.assertTrue(seeResultsBtn.isEnabled(), "See Results should be disabled");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + status);
        }
    }




}
