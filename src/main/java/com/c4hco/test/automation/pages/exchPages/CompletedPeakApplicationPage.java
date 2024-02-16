package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletedPeakApplicationPage {
    private BasicActions basicActions;
    public CompletedPeakApplicationPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(id="completedApplicationQYes")
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

    @FindBy(xpath = "//h1[@class='c4PageHeader']")
    WebElement pageHeaderPermitanosGuiarlo;

    @FindBy(xpath = "//span[contains(@class, 'c4BodyText1') and contains(text(),'Si nunca se ha')]")
    WebElement enrollmentInfoMessageEs;

    @FindBy(xpath = "//span[contains(text(),'Necesitar')]")
    WebElement caseIDInfoMessageEs;

    @FindBy(xpath = "//span[@class='c4BodyText1' and contains(text(),'I have completed an application for Health First Colorado or Child Health Plan Plus')]")
    WebElement yesImNewTextEn;

    @FindBy(css = "span.c4BodyText1[onclick*='No, I have not completed an application and need to start one']")
    WebElement noThanksTextEn;

    @FindBy(css = "span.c4BodyText1[onclick*=\"'Yes, I have a completed application'\"]")
    WebElement yesImNewTextEs;

    @FindBy(css = "span.c4BodyText1[onclick*='No, I have not completed an application and need to start one']")
    WebElement noThanksTextEs;

    @FindBy(css = "input.back-button-link[type='submit'][name='back']")
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

    public boolean verifyTheText(String expectedText) {
        WebElement pageElement = switch (expectedText) {
            case "Let us guide you" -> pageHeaderLetUsGuideYou;
            case "If you have never enrolled with us before" -> enrollmentInfoMessage;
            case "You will need your Case ID, which can be found on your Health First Colorado eligibility notice." -> caseIDInfoMessage;
            case "I have completed an application for Health First Colorado or Child Health Plan Plus" -> yesImNewTextEn;
            case "No thanks, take me to the application" -> noThanksTextEn;
            case "< Back" -> backButtonLink;
            case "Save and Continue" -> saveAndContinueButton;
            case "guiarlo" -> pageHeaderPermitanosGuiarlo;
            case "Si nunca se ha inscrito con nosotros antes pero ya" -> enrollmentInfoMessageEs;
            case "Necesitar" -> caseIDInfoMessageEs;
            case "soy nuevo a Connect for Health Colorado y ya" -> yesImNewTextEs;
            case "No gracias" -> noThanksTextEs;
            case "< Atr" -> backButtonLinkEs;
            case "Guardar y Continuar" -> saveAndContinueButton;
            default ->
                // Throw NoSuchElementException when WebElement is not found
                    throw new NoSuchElementException("WebElement for '" + expectedText + "' not found.");
        };

        // Verify the text on the WebElement
        return basicActions.verifyElementText(pageElement, expectedText);
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
}
