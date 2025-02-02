package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.HeaderAndFooterPage;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class MemberIdProofingPage {

    private BasicActions basicActions;
    private WhoAreYouPage whoAreYouPage;
    private HeaderAndFooterPage headerandFooterpage;

    SoftAssert softAssert = new SoftAssert();


    public MemberIdProofingPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        whoAreYouPage = new WhoAreYouPage(webDriver);
        headerandFooterpage = new HeaderAndFooterPage(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy (css = ".container h1")
    WebElement textIdProofingInitialQuestionHeader;

    @FindBy (css = ".form-group .control-label")
    List<WebElement> textQuestions;

    @FindBy(css = ".radioGrp label")
    List<WebElement> textAnswers;

    @FindBy(xpath = "//div/input[@id='answer11']")
    WebElement firstOptionInEmployerName;
    @FindBy(xpath = "//div/input[@id='answer12']")
    WebElement secondOptionInEmployerName;
    @FindBy(xpath = "//div/input[@id='answer21']")
    WebElement firstOptionInHomeAddress;
    @FindBy(xpath = "//div/input[@id='answer22']")
    WebElement secondOptionInHomeAddress;
    @FindBy(xpath = "//div/input[@id='answer22']")
    WebElement incorrectOptionInHomeAddress;
    @FindBy(xpath = "//div/input[@id='answer31']")
    WebElement firstOptionInCarLoanBank;
    @FindBy(xpath = "//div/input[@id='answer32']")
    WebElement incorrectOptionInCarLoanBank;
    @FindBy(id = "submitButton")
    WebElement saveContinue;
    @FindBy(xpath = "//div[@id='ridpErrorContainer']")
    WebElement idProofingError;

    @FindBy(xpath = "//div[@class='successContainer']")
    WebElement congradulationMessage;

    @FindBy(xpath = "//input[contains(@class,'inputAsText')]")
    WebElement lookforExpertLink;

    @FindBy(xpath = "//h1[contains(@class,'c4PageHeader1')]")
    WebElement lookforHeaderInfo;

    public void selectFirstOptionToAll(){
        basicActions.waitForElementToDisappear( spinner, 30  );
        basicActions.waitForElementToBePresent(firstOptionInEmployerName, 30);
        firstOptionInEmployerName.click();
        firstOptionInHomeAddress.click();
        firstOptionInCarLoanBank.click();
        saveContinue.click();
    }

    public void selectRequiredOptionsToUploadDocuments(){
        basicActions.waitForElementToDisappear( spinner, 30  );
        basicActions.waitForElementToBePresent(firstOptionInEmployerName, 30);
        firstOptionInEmployerName.click();
        secondOptionInHomeAddress.click();
        firstOptionInCarLoanBank.click();
        saveContinue.click();
    }

    public void validateTheVerbiageOnTheIdentityProofingInitialPage(String language) {
        switch (language){
            case "English":
                validateTheVerbiageEn();
                break;
            case "Spanish":
                validateTheVerbiageEs();
                break;
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
    }

    private void validateTheVerbiageEn() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(textIdProofingInitialQuestionHeader.getText(), "Identity Proofing - Initial Questions", "Identity Proofing - Initial Questions text mismatch");

        softAssert.assertEquals(textQuestions.get(0).getText(), "01 What is your Employer Name", "01 What is your Employer Name text mismatch");
        softAssert.assertEquals(textQuestions.get(1).getText(), "02 What is your Home Address", "02 What is your Home Address text mismatch");
        softAssert.assertEquals(textQuestions.get(2).getText(), "03 Do you have car loan with any of the following bank", "03 Do you have car loan with any of the following bank text mismatch");

        softAssert.assertEquals(textAnswers.get(0).getText(), "01 CGI", "01 CGI text mismatch");
        softAssert.assertEquals(textAnswers.get(1).getText(), "02 Accenture", "02 Accenture text mismatch");
        softAssert.assertEquals(textAnswers.get(2).getText(), "03 C4HCO", "03 C4HCO text mismatch");
        softAssert.assertEquals(textAnswers.get(3).getText(), "04 CapGemini", "04 CapGemini text mismatch");
        softAssert.assertEquals(textAnswers.get(4).getText(), "01 Littleton Address", "01 Littleton Address text mismatch");
        softAssert.assertEquals(textAnswers.get(5).getText(), "02 Lakewood Address", "02 Lakewood Address text mismatch");
        softAssert.assertEquals(textAnswers.get(6).getText(), "03 Englewood Address", "03 Englewood Address text mismatch");
        softAssert.assertEquals(textAnswers.get(7).getText(), "04 Denver Address", "04 Denver Address text mismatch");
        softAssert.assertEquals(textAnswers.get(8).getText(), "01 Bank Of America", "01 Bank Of America text mismatch");
        softAssert.assertEquals(textAnswers.get(9).getText(), "02 CHASE", "02 CHASE text mismatch");
        softAssert.assertEquals(textAnswers.get(10).getText(), "03 DCU", "03 DCU text mismatch");
        softAssert.assertEquals(textAnswers.get(11).getText(), "04 First Bank", "04 First Bank text mismatch");
    }

    public void validateTheVerbiageEs() {
        SoftAssert softAssert = new SoftAssert();
        whoAreYouPage.ContinueId(); // This should not be referenced here - please move from here :: TO DO

        basicActions.waitForElementToBePresent(textIdProofingInitialQuestionHeader, 30);

        softAssert.assertEquals(textIdProofingInitialQuestionHeader.getText(), "Identity Proofing - Initial Questions", "Identity Proofing - Initial Questions text mismatch");

        softAssert.assertEquals(textQuestions.get(0).getText(), "01 What is your Employer Name", "01 What is your Employer Name text mismatch");
        softAssert.assertEquals(textQuestions.get(1).getText(), "02 What is your Home Address", "02 What is your Home Address text mismatch");
        softAssert.assertEquals(textQuestions.get(2).getText(), "03 Do you have car loan with any of the following bank", "03 Do you have car loan with any of the following bank text mismatch");

        softAssert.assertEquals(textAnswers.get(0).getText(), "01 CGI", "01 CGI text mismatch");
        softAssert.assertEquals(textAnswers.get(1).getText(), "02 Accenture", "02 Accenture text mismatch");
        softAssert.assertEquals(textAnswers.get(2).getText(), "03 C4HCO", "03 C4HCO text mismatch");
        softAssert.assertEquals(textAnswers.get(3).getText(), "04 CapGemini", "04 CapGemini text mismatch");
        softAssert.assertEquals(textAnswers.get(4).getText(), "01 Littleton Address", "01 Littleton Address text mismatch");
        softAssert.assertEquals(textAnswers.get(5).getText(), "02 Lakewood Address", "02 Lakewood Address text mismatch");
        softAssert.assertEquals(textAnswers.get(6).getText(), "03 Englewood Address", "03 Englewood Address text mismatch");
        softAssert.assertEquals(textAnswers.get(7).getText(), "04 Denver Address", "04 Denver Address text mismatch");
        softAssert.assertEquals(textAnswers.get(8).getText(), "01 Bank Of America", "01 Bank Of America text mismatch");
        softAssert.assertEquals(textAnswers.get(9).getText(), "02 CHASE", "02 CHASE text mismatch");
        softAssert.assertEquals(textAnswers.get(10).getText(), "03 DCU", "03 DCU text mismatch");
        softAssert.assertEquals(textAnswers.get(11).getText(), "04 First Bank", "04 First Bank text mismatch");
        softAssert.assertAll();
    }

    public void answerTheWrongIdProofingAnswersAndClickContinue() {
        basicActions.waitForElementToDisappear( spinner, 30  );
        basicActions.waitForElementToBePresent(firstOptionInEmployerName, 30);
        secondOptionInEmployerName.click();
        incorrectOptionInHomeAddress.click();
        incorrectOptionInCarLoanBank.click();
        saveContinue.click();
    }

    public void validateTheIdProofingErrorMessageIsDisplayed() {
        basicActions.waitForElementToBePresentWithRetries(idProofingError,30);
        basicActions.isElementDisplayed(idProofingError,30);
    }

    public void validateCongratulationsMessage(String messageOne, String messageTwo, String language){
        basicActions.waitForElementToDisappear(spinner,20);
        headerandFooterpage.changeLanguage(language+" NonElmo");
        basicActions.waitForElementToBePresent(congradulationMessage,10);
        String[] messageDetails = congradulationMessage.getText().split(SharedData.getPrimaryMember().getFirstName());
        softAssert.assertEquals(messageDetails[0]+SharedData.getPrimaryMember().getFirstName()+messageDetails[1]+" "+lookforExpertLink.getAttribute("value").trim(),messageOne+" "+SharedData.getPrimaryMember().getFirstName()+". "+messageTwo+".");
        softAssert.assertAll();
    }
}
