package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CompletedPeakApplicationPage {
    private BasicActions basicActions;
    public CompletedPeakApplicationPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id="completedApplicationQYes")
    WebElement yesImNew;

    @FindBy(id = "completedApplicationQNo")
    WebElement noThanksRadioButton;

    @FindBy(xpath = "//*[@name='saveAndContinue']")
    WebElement saveAndContinueButton;

    @FindBy(css = "h1")
    //h1.c4PageHeader
    WebElement pageHeaderLetUsGuideYou;

    @FindBy(css = ".c4BodyText1")
    List<WebElement> bodyText;

    @FindBy(xpath = "//a[@class='icon-link language']")
    WebElement languageToggleLink;

    @FindBy(css = ".language-dropdown-content li")
    List<WebElement> languageLocaleLink;

    public void setYesImNew(){
        yesImNew.click();
    }

    public void selectNoThanksOption(){
        noThanksRadioButton.click();
    }

    public void clickSaveAndContinueButton(){
        saveAndContinueButton.click();
    }

    public void selectLocale(String locale) {
        // Click on the language toggle link to open the language dropdown
        languageToggleLink.click();

        // Determine the locale to select based on the parameter
        switch (locale.toLowerCase()) {
            case "spanish":
                // Click on the Spanish locale link
                languageLocaleLink.get(1).click();
                break;
            case "english":
                // Click on the English locale link
                languageLocaleLink.get(0).click();
                break;
            default:
                // Handle invalid locale parameter (Optional: throw an exception or log a warning)
                System.out.println("Invalid locale parameter provided: " + locale);
                break;
        }
    }

    public void validateTheVerbiageOnLetUsGuideYouPage(String language){
        switch (language){
            case "English":
                validateTheVerbiageEn();
                break;
            case "Spanish":
                validateTheVerbiageEs();
                break;
        }
    }

    public void validateTheVerbiageEn() {
        basicActions.waitForElementToBePresent(pageHeaderLetUsGuideYou,30);
        basicActions.assertContainsText(pageHeaderLetUsGuideYou.getText(), "Let us guide you");
        basicActions.assertContainsText(bodyText.get(0).getText(), "If you have never enrolled with us before but have completed an application for Health First Colorado (Colorado's Medicaid Program) or Child Health Plan Plus (CHP+), we can save you time and pull the information you submitted previously. You will have a chance to review and change your information as needed. Would you like to search for a previously completed application?");
        basicActions.assertContainsText(bodyText.get(1).getText(), "You will need your Case ID, which can be found on your Health First Colorado eligibility notice.");
        basicActions.assertContainsText(bodyText.get(2).getText(), "new to Connect for Health Colorado and I have completed an application for Health First Colorado or Child Health Plan Plus");
        basicActions.assertContainsText(bodyText.get(3).getText(), "No thanks, take me to the application");
    }

    public void validateTheVerbiageEs() {
        basicActions.waitForElementToBePresent(pageHeaderLetUsGuideYou,30);
        basicActions.assertContainsText(pageHeaderLetUsGuideYou.getText(), "tanos guiarlo");
        basicActions.assertContainsText(bodyText.get(0).getText(), "Si nunca se ha inscrito con nosotros antes pero ya present");
        basicActions.assertContainsText(bodyText.get(1).getText(), "del caso que aparece en su aviso de elegibilidad de Health First Colorado.");
        basicActions.assertContainsText(bodyText.get(2).getText(), "soy nuevo a Connect for Health Colorado y ya present");
        basicActions.assertContainsText(bodyText.get(3).getText(), "No gracias, ll");
    }

    public void iSelectOption(String option) {
        switch (option.toLowerCase()) {
            case "yes":
                setYesImNew();
                break;
            case "no":
                selectNoThanksOption();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + option);
        }
    }
}
