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

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

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

    @FindBy(css = "#healthFirstColorado-enrollment-option img")
    WebElement resultsHealthFirstColoradoImg;

    @FindBy(css = "#healthFirstColorado-enrollment-option .c4-type-header-sm")
    WebElement resultsHealthFirstColoradoHdrTxt;

    @FindBy(css = "#healthFirstColorado-enrollment-option .main-text")
    WebElement resultsHealthFirstColoradoMainTxt;

    @FindBy(css = "#healthFirstColorado-enrollment-option .next-step")
    WebElement resultsHealthFirstColoradoNextTxt;

    @FindBy(css = "#healthFirstColorado-enrollment-option .next-step a")
    WebElement resultsHealthFirstColoradoNextLnk;

    @FindBy(css = "#healthFirstColorado-enrollment-option .nav-link")
    WebElement resultsHealthFirstColoradoBtn;

    @FindBy(css = "#connectForHealthColorado-enrollment-option img")
    WebElement resultsC4HCOImg;

    @FindBy(css = "#connectForHealthColorado-enrollment-option .c4-type-header-sm")
    WebElement resultsC4HCOHdrTxt;

    @FindBy(css = "#connectForHealthColorado-enrollment-option .main-text")
    WebElement resultsC4HCOMainTxt;

    @FindBy(css = "#connectForHealthColorado-enrollment-option .next-step")
    WebElement resultsC4HCONextTxt;

    @FindBy(css = "#connectForHealthColorado-enrollment-option .nav-link")
    WebElement resultsC4HCOBtn;

    @FindBy(css = "#cocoReenroll-enrollment-option img")
    WebElement resultsSESRenewalImg;

    @FindBy(css = "#cocoReenroll-enrollment-option .c4-type-header-sm")
    WebElement resultsSESRenewalHdrTxt;

    @FindBy(css = "#cocoReenroll-enrollment-option .main-text")
    WebElement resultsSESRenewalMainTxt;

    @FindBy(css = "#cocoReenroll-enrollment-option .next-step")
    WebElement resultsSESRenewalNextTxt;

    @FindBy(css = "#cocoReenroll-enrollment-option .nav-link")
    WebElement resultsSESRenewalBtn;

    @FindBy(css = "#cocoNewEnroll-enrollment-option img")
    WebElement resultsSESNewImg;

    @FindBy(css = "#cocoNewEnroll-enrollment-option .c4-type-header-sm")
    WebElement resultsSESNewHdrTxt;

    @FindBy(css = "#cocoNewEnroll-enrollment-option .main-text")
    WebElement resultsSESNewMainTxt;

    @FindBy(css = "#cocoNewEnroll-enrollment-option .next-step")
    WebElement resultsSESNewNextTxt;

    @FindBy(css = "#cocoNewEnroll-enrollment-option .nav-link")
    WebElement resultsSESNewBtn;

    @FindBy(css = ".footer-buttons button")
    WebElement continueSignInBtn;





    public void clickSaveAndContinue(){
        basicActions.waitForElementToDisappear( spinner, 40 );
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

    public void clickResultBtn(String option){
        basicActions.waitForElementToBePresent(resultsHeaderTxt, 40);
        switch(option) {
            case "HealthFirst button":
                basicActions.scrollToElement(resultsHealthFirstColoradoBtn);
                resultsHealthFirstColoradoBtn.click();
                break;
            case "HealthFirst link":
                basicActions.scrollToElement(resultsHealthFirstColoradoNextLnk);
                resultsHealthFirstColoradoNextLnk.click();
                break;
            case "C4HCO":
                basicActions.scrollToElement(resultsC4HCOBtn);
                resultsC4HCOBtn.click();
                break;
            case "SES Renewal":
                basicActions.scrollToElement(resultsSESRenewalBtn);
                resultsSESRenewalBtn.click();
                break;
            case "SES New":
                basicActions.scrollToElement(resultsSESNewBtn);
                resultsSESNewBtn.click();
                break;
            case "Enrollment Expert":
                basicActions.scrollToElement(needHelpLnk);
                needHelpLnk.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + option);
        }
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
                expectedTexts.put("SES Renewal", "The OmniSalud program (through Colorado Connect)");
                expectedTexts.put("SES New", "The OmniSalud program (through Colorado Connect)");
                break;
            case "Spanish":
                expectedTexts.put("header", "Estas son las opciones de cobertura disponibles para su familia:"); // Add actual Spanish text
                expectedTexts.put("HealthFirst", "Health First Colorado o Child Health Plan Plus (CHP+)");
                expectedTexts.put("C4HCO", "Connect for Health Colorado");
                expectedTexts.put("SES Renewal", "El programa de OmniSalud (a trav\u00E9s de Colorado Connect)");
                expectedTexts.put("SES New", "El programa de OmniSalud (a trav\u00E9s de Colorado Connect)");
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
                softAssert.assertEquals(resultsHealthFirstColoradoHdrTxt.getText(), expectedText);
                break;
            case "C4HCO":
                softAssert.assertEquals(resultsC4HCOHdrTxt.getText(), expectedText);
                break;
            case "SES Renewal":
                softAssert.assertEquals(resultsSESRenewalHdrTxt.getText(), expectedText);
                break;
            case "SES New":
                softAssert.assertEquals(resultsSESNewHdrTxt.getText(), expectedText);
                break;
        }
        softAssert.assertAll();
    }

    public void validateResultsNotDisplay(String screenerOption) {
        basicActions.waitForElementToBePresent(resultsHeaderTxt, 40);
        switch (screenerOption) {
            case "HealthFirst":
                softAssert.assertFalse(basicActions.waitForElementPresence(resultsHealthFirstColoradoHdrTxt,30));
                break;
            case "C4HCO":
                softAssert.assertFalse(basicActions.waitForElementPresence(resultsC4HCOHdrTxt,30));
                break;
            case "SES":
                softAssert.assertFalse(basicActions.waitForElementPresence(resultsSESRenewalHdrTxt,30));
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
                case "HealthFirst":
                    validatePageHealthFirstTextEnglish();
                    break;
                case "C4HCO":
                    validatePageC4HCOTextEnglish();
                    break;
                case "SES Renewal":
                    validatePageSESRenewalTextEnglish();
                    break;
                case "SES New":
                    validatePageSESNewTextEnglish();
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
                case "HealthFirst":
                    validatePageHealthFirstTextSpanish();
                    break;
                case "C4HCO":
                    validatePageC4HCOTextSpanish();
                    break;
                case "SES Renewal":
                    validatePageSESRenewalTextSpanish();
                    break;
                case "SES New":
                    validatePageSESNewTextSpanish();
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
        basicActions.scrollToElement(dacaSubQuestion);
        builder.moveToElement(dacaSubQuestion).perform();
        softAssert.assertEquals(dacaTootlTip.getText(), "DACA es una pol\u00EDtica federal que protege a los inmigrantes elegibles que llegaron a los Estados Unidos cuando eran ni\u00F1os contra la deportaci\u00F3n, entre otras cosas.");
        softAssert.assertEquals(dacaAnswer.get(1).getText(), "S\u00ED");
        softAssert.assertEquals(dacaAnswer.get(2).getText(), "No");
        softAssert.assertEquals(sesQuestion.getText(), "\u00BFAlg\u00FAn miembro de su familia recibe actualmente ayuda financiera de Ahorros SilverEnhanced a trav\u00E9s del programa de OmniSalud?");
        softAssert.assertEquals(sesSubQuestion.getText(), "\u00BFC\u00F3mo puedo saber si estoy recibiendo Ahorros SilverEnhanced?");
        basicActions.scrollToElement(sesSubQuestion);
        builder.moveToElement(sesSubQuestion).perform();
        softAssert.assertEquals(sesTootlTip.getText(), "Si est\u00E1 inscrito en Ahorros SilverEnhanced, su plan de seguro de salud mostrar\u00E1 las palabras \u201CSilver Enhanced 94\u0025\u201D en el nombre.");
        softAssert.assertEquals(sesAnswer.get(1).getText(), "S\u00ED");
        softAssert.assertEquals(sesAnswer.get(2).getText(), "No");
        softAssert.assertEquals(seeResultsBtn.getText(), "Ver resultados");
        softAssert.assertEquals(needHelpBanner.getText(), "\u00BFNecesita ayuda para decidir qu\u00E9 hacer?\nContacte a un experto en inscripci\u00F3n certificado.");
        softAssert.assertEquals(continueSignInBtn.getText(), "Continuar con el inicio de sesi\u00F3n");
        softAssert.assertAll();
    }

    public void validatePageHealthFirstTextEnglish(){
        basicActions.waitForElementToBePresent(resultsHeaderTxt,10);
        basicActions.scrollToElement(resultsHeaderTxt);

        softAssert.assertTrue(resultsHealthFirstColoradoImg.isDisplayed(), "Image is NOT displayed on the page.");
        softAssert.assertEquals(resultsHealthFirstColoradoHdrTxt.getText(), "Health First Colorado or Child Health Plan Plus (CHP+)");
        softAssert.assertEquals(resultsHealthFirstColoradoMainTxt.getText(), "Anyone in your household who is under 19 or pregnant may qualify for Health First Colorado or CHP+ as of January 1st, 2025. This is because of a new Colorado law that makes these individuals eligible for Medicaid programs, regardless of documentation status.");
        softAssert.assertEquals(resultsHealthFirstColoradoNextTxt.getText(), "Next step: Visit HealthFirstColorado.com to see if your income qualifies and get started.");
        softAssert.assertEquals(resultsHealthFirstColoradoBtn.getText(), "Go to Health First Colorado");
        softAssert.assertAll();
    }

    public void validatePageHealthFirstTextSpanish(){
        basicActions.waitForElementToBePresent(resultsHeaderTxt,10);
        basicActions.scrollToElement(resultsHeaderTxt);

        softAssert.assertTrue(resultsHealthFirstColoradoImg.isDisplayed(), "Image is NOT displayed on the page.");
        softAssert.assertEquals(resultsHealthFirstColoradoHdrTxt.getText(), "Health First Colorado o Child Health Plan Plus (CHP+)");
        softAssert.assertEquals(resultsHealthFirstColoradoMainTxt.getText(), "Alguna persona de su familia que est\u00E9 embarazada o sea menor de 19 a\u00F1os podr\u00EDa calificar para el programa Health First Colorado o CHP+ a partir del 1\u00BA de enero de 2025 gracias a una nueva ley de Colorado que permite que estas personas sean elegibles para programas de Medicaid, independientemente del estado de su documentaci\u00F3n.");
        softAssert.assertEquals(resultsHealthFirstColoradoNextTxt.getText(), "Paso siguiente: Paso siguiente: visite HealthFirstColorado.com para saber si su ingreso califica e iniciar el proceso.");
        softAssert.assertEquals(resultsHealthFirstColoradoBtn.getText(), "Ir a Health First Colorado");
        softAssert.assertAll();
    }

    public void validatePageC4HCOTextEnglish(){
        basicActions.waitForElementToBePresent(resultsHeaderTxt,10);
        basicActions.scrollToElement(resultsHeaderTxt);

        softAssert.assertTrue(resultsC4HCOImg.isDisplayed(), "Image is NOT displayed on the page.");
        softAssert.assertEquals(resultsC4HCOHdrTxt.getText(), "Connect for Health Colorado");
        softAssert.assertEquals(resultsC4HCOMainTxt.getText(), "Due to a new regulation, anyone in your household that has DACA status can enroll in health coverage through Connect for Health Colorado. They may also qualify for financial help to reduce the cost of health coverage.");
        softAssert.assertEquals(resultsC4HCONextTxt.getText(), "Next step: Log out and create a new account through Connect for Health Colorado, using a different email than your Colorado Connect account.");
        softAssert.assertEquals(resultsC4HCOBtn.getText(), "Create Connect for Health Colorado Account");
        softAssert.assertAll();
    }

    public void validatePageC4HCOTextSpanish(){
        basicActions.waitForElementToBePresent(resultsHeaderTxt,10);
        basicActions.scrollToElement(resultsHeaderTxt);

        softAssert.assertTrue(resultsC4HCOImg.isDisplayed(), "Image is NOT displayed on the page.");
        softAssert.assertEquals(resultsC4HCOHdrTxt.getText(), "Connect for Health Colorado");
        softAssert.assertEquals(resultsC4HCOMainTxt.getText(), "Debido a una nueva reglamentaci\u00F3n, cualquier miembro de su familia que tenga un estado DACA puede inscribirse en una cobertura de salud a trav\u00E9s de Connect for Health Colorado. Es posible que tambi\u00E9n califique para obtener ayuda financiera que le permitir\u00E1 reducir el costo de dicha cobertura.");
        softAssert.assertEquals(resultsC4HCONextTxt.getText(), "Paso siguiente: Paso siguiente: cierre la sesi\u00F3n y cree una cuenta nueva a trav\u00E9s de Connect for Health Colorado usando un correo electr\u00F3nico diferente al de su cuenta de Colorado Connect.");
        softAssert.assertEquals(resultsC4HCOBtn.getText(), "Crear una cuenta de Connect for Health Colorado");
        softAssert.assertAll();
    }

    public void validatePageSESRenewalTextEnglish(){
        basicActions.waitForElementToBePresent(resultsHeaderTxt,10);
        basicActions.scrollToElement(resultsHeaderTxt);

        softAssert.assertTrue(resultsSESRenewalImg.isDisplayed(), "Image is NOT displayed on the page.");
        softAssert.assertEquals(resultsSESRenewalHdrTxt.getText(), "The OmniSalud program (through Colorado Connect)");
        softAssert.assertEquals(resultsSESRenewalMainTxt.getText(), "Anyone in your household who receives SilverEnhanced Savings has a chance to claim the same financial help for 2025. You should submit an application by November 22nd to claim it.");
        softAssert.assertEquals(resultsSESRenewalNextTxt.getText(), "Next step: Continue to your Colorado Connect account");
        softAssert.assertEquals(resultsSESRenewalBtn.getText(), "Re-enroll for 2025");
        softAssert.assertAll();
    }

    public void validatePageSESRenewalTextSpanish(){
        basicActions.waitForElementToBePresent(resultsHeaderTxt,10);
        basicActions.scrollToElement(resultsHeaderTxt);

        softAssert.assertTrue(resultsSESRenewalImg.isDisplayed(), "Image is NOT displayed on the page.");
        softAssert.assertEquals(resultsSESRenewalHdrTxt.getText(), "El programa de OmniSalud (a trav\u00E9s de Colorado Connect)");
        softAssert.assertEquals(resultsSESRenewalMainTxt.getText(), "Cualquier miembro de su familia que reciba Ahorros SilverEnhanced tiene la oportunidad de solicitar la misma ayuda financiera para 2025. Para reclamarla, debe enviar una solicitud a m\u00E1s tardar el 22 de noviembre.");
        softAssert.assertEquals(resultsSESRenewalNextTxt.getText(), "Paso siguiente: Paso siguiente: contin\u00FAe a su cuenta de Colorado Connect.");
        softAssert.assertEquals(resultsSESRenewalBtn.getText(), "Reinscribirse para 2025");
        softAssert.assertAll();
    }

    public void validatePageSESNewTextEnglish(){
        basicActions.waitForElementToBePresent(resultsHeaderTxt,10);
        basicActions.scrollToElement(resultsHeaderTxt);

        softAssert.assertTrue(resultsSESNewImg.isDisplayed(), "Image is NOT displayed on the page.");
        softAssert.assertEquals(resultsSESNewHdrTxt.getText(), "The OmniSalud program (through Colorado Connect)");
        softAssert.assertEquals(resultsSESNewMainTxt.getText(), "Some individuals in your household may qualify for coverage offered through the OmniSalud Program. This program is provided through a separate, secure marketplace \u2013 called Colorado Connect \u2013 where people can enroll in private health plans and apply for financial help regardless of immigration status.");
        softAssert.assertEquals(resultsSESNewNextTxt.getText(), "Next step: Continue to your Colorado Connect account");
        softAssert.assertEquals(resultsSESNewBtn.getText(), "Continue to Colorado Connect");
        softAssert.assertAll();
    }

    public void validatePageSESNewTextSpanish(){
        basicActions.waitForElementToBePresent(resultsHeaderTxt,10);
        basicActions.scrollToElement(resultsHeaderTxt);

        softAssert.assertTrue(resultsSESNewImg.isDisplayed(), "Image is NOT displayed on the page.");
        softAssert.assertEquals(resultsSESNewHdrTxt.getText(), "El programa de OmniSalud (a trav\u00E9s de Colorado Connect)");
        softAssert.assertEquals(resultsSESNewMainTxt.getText(), "Es posible que algunos miembros de su familia califiquen para obtener la cobertura que se ofrece a trav\u00E9s del programa de OmniSalud. Este programa se ofrece a trav\u00E9s de un mercado seguro independiente (llamado Colorado Connect) donde las personas se pueden inscribir en planes de salud privados y solicitar ayuda financiera independientemente de su estatus migratorio.");
        softAssert.assertEquals(resultsSESNewNextTxt.getText(), "Paso siguiente: Paso siguiente: contin\u00FAe a su cuenta de Colorado Connect.");
        softAssert.assertEquals(resultsSESNewBtn.getText(), "Contin\u00FAe a su cuenta de Colorado Connect");
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
