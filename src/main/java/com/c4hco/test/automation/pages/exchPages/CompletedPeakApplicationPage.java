package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import  java.time.Duration;

public class CompletedPeakApplicationPage {
    private BasicActions basicActions;
    public CompletedPeakApplicationPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(xpath = "//*[@id='completedApplicationQYes']")
    WebElement yesImNew;

    @FindBy(id = "completedApplicationQNo")
    WebElement noThanksRadioButton;
    @FindBy(xpath = "//*[@name='saveAndContinue']")
    WebElement saveAndContinueButton;

    @FindBy(xpath = "//input[@class='back-button-link']")
    WebElement backButtonLink;

    @FindBy(xpath = "//h1[@class='c4PageHeader'][text()='Let us guide you']")
    WebElement pageHeaderLetUsGuideYou;

    @FindBy(xpath = "//span[@class='c4BodyText1']")
    WebElement enrollmentInfoMessage;

    @FindBy(xpath = "//span[@class='c4BodyText1' and contains(text(), 'You will need your Case ID')]")
    WebElement caseIDInfoMessage;

    @FindBy(xpath = "//a[@class='icon-link language']")
    WebElement languageToggleLink;

    @FindBy(xpath = "//nav//ul/li[2]/ul/li[2]") //this is the only locator that is working
    WebElement spanishLocaleLink;

    @FindBy(xpath = "a[onclick*='changeLocale\\('en'\\);']")
    WebElement englishLocaleLink;

    @FindBy(css = "span.c4BodyText1[onclick*=\"'Yes, I have a completed application'\"]")
    WebElement pageHeaderPermitanosGuiarlo;

    @FindBy(xpath = "//span[contains(@class, 'c4BodyText1') and contains(text(),'Si nunca se ha')]")
    WebElement enrollmentInfoMessageEs;

    @FindBy(xpath = "//span[contains(text(),'Necesitar')]")
    WebElement caseIDInfoMessageEs;

    @FindBy(css = "span.c4BodyText1[onclick*=\"'Yes, I have a completed application'\"]")
    WebElement yesImNewEs;

    @FindBy(css = "span.c4BodyText1[onclick*='No, I have not completed an application and need to start one']")
    WebElement noThanksRadioButtonEs;

    @FindBy(css = "input.back-button-link")
    WebElement backButtonLinkEs;

    @FindBy(css = "input.btn.btn-c4primary[value='Guardar y Continuar']")
    WebElement saveAndContinueButtonEs;
    public void setYesImNew(){
        yesImNew.click();
    }

    public void selectNoThanksOption(){
        noThanksRadioButton.click();
    }

    public void clickSaveAndContinueButton(){
        saveAndContinueButton.click();

    }

    public boolean verifyPageHeaderLetUsGuideYouText(String expectedText) {
        return basicActions.verifyElementText(pageHeaderLetUsGuideYou, expectedText);
    }

    public boolean verifyEnrollmentInfoMessageText(String expectedText) {
        return basicActions.verifyElementText(enrollmentInfoMessage, expectedText);
    }

    public boolean verifyCaseIDInfoMessageText(String expectedText) {
        return basicActions.verifyElementText(caseIDInfoMessage, expectedText);
    }

    public boolean verifyYesImNewText(String expectedText) {
        return basicActions.verifyElementText(yesImNew, expectedText);
    }

    public boolean verifyNoThanksRadioButtonText(String expectedText) {
        return basicActions.verifyElementText(noThanksRadioButton, expectedText);
    }

    public boolean verifyBackButtonLinkText(String expectedText) {
        return basicActions.verifyElementText(backButtonLink, expectedText);
    }

    public boolean isSaveAndContinueButtonInteractable() {
        return saveAndContinueButton.isEnabled();
    }

    public void selectLocale(String locale) {
        // Click on the language toggle link to open the language dropdown
        languageToggleLink.click();

        // Determine the locale to select based on the parameter
        if (locale.equalsIgnoreCase("Spanish")) {
            // Click on the Spanish locale link
            spanishLocaleLink.click();
        } else if (locale.equalsIgnoreCase("English")) {
            // Click on the English locale link
            englishLocaleLink.click();
        } else {
            // Handle invalid locale parameter (Optional: throw an exception or log a warning)
            System.out.println("Invalid locale parameter provided: " + locale);
        }
    }

    public boolean verifyPageHeaderPermitanosGuiarlo(String expectedText){
        return basicActions.verifyElementText(pageHeaderPermitanosGuiarlo, expectedText);
    }

    public boolean verifyEnrollmentInfoMessageEs(String expectedText){
        return basicActions.verifyElementText(enrollmentInfoMessageEs, expectedText);
    }

    public boolean verifyCaseIDInfoMessageEs(String expectedText){
        return basicActions.verifyElementText(caseIDInfoMessageEs, expectedText);
    }

    public boolean verifyYesImNewTextEs(String expectedText){
        return basicActions.verifyElementText(yesImNewEs, expectedText);
    }

    public boolean verifyNoGraciasEs(String expectedText){
        return basicActions.verifyElementText(noThanksRadioButtonEs, expectedText);
    }

    public boolean verifyBackButtonEs(String expectedText){
        return basicActions.verifyElementText(backButtonLinkEs, expectedText);
    }

    public boolean isSaveAndContinueButtonInteractableEs(){
        return saveAndContinueButtonEs.isEnabled();
    }
}
