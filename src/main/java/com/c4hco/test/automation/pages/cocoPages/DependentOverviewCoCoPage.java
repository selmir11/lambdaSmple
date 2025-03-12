package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class DependentOverviewCoCoPage {

    private BasicActions basicActions;

    SoftAssert softAssert = new SoftAssert();

    public DependentOverviewCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "ELIG-DependentOverview-SaveAndContinue")
    WebElement saveAndContinueButton;

    @FindBy(id = "ELIG-DependentOverview-GoBack")
    WebElement goBackButton;

    @FindBy(css = "div.header-1.content-center.content-margin")
    WebElement hdr_DependentOverview;

    @FindBy(css = "button.button.yes-button")
    WebElement dependentOverviewYesButton;

    @FindBy(css = "button.button.no-button")
    WebElement dependentOverviewNoButton;

    @FindBy(css = "span.body-text-1")
    WebElement dependentOverviewQuestionText;

    public void clickSaveAndContinueButton() {
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 30);
        saveAndContinueButton.click();
    }

    public void clickGoBackButton() {
        basicActions.waitForElementToBePresent(goBackButton, 30);
        goBackButton.click();
    }

    public void verifyTextOnDependentOverview(String language) {
        basicActions.waitForElementToBePresent(saveAndContinueButton, 10);
        switch (language) {
            case "English":
                verifyTextOnDependentOverviewPageEnglish();
                break;
            case "Spanish":
                verifyTextOnDependentOverviewPageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " +language );
        }
    }

    public void verifyTextOnDependentOverviewPageEnglish() {
        basicActions.waitForElementToBePresent(hdr_DependentOverview,15);
        softAssert.assertEquals(hdr_DependentOverview.getText(), "Dependent Overview");
        softAssert.assertEquals(dependentOverviewQuestionText.getText(), "Is " + Character.toUpperCase(SharedData.getMembers().get(0).getFirstName().charAt(0)) + SharedData.getMembers().get(0).getFirstName().substring(1) + " " + Character.toUpperCase(SharedData.getMembers().get(0).getMiddleName().charAt(0)) + ". " + Character.toUpperCase(SharedData.getMembers().get(0).getLastName().charAt(0)) + SharedData.getMembers().get(0).getLastName().substring(1) + " disabled, not married and a dependent in your household?");
        softAssert.assertEquals(dependentOverviewYesButton.getText(), "Yes");
        softAssert.assertEquals(dependentOverviewNoButton.getText(), "  No");
        softAssert.assertEquals(saveAndContinueButton.getText(), "Save and continue");
        softAssert.assertEquals(goBackButton.getText(), " Go Back");
        softAssert.assertAll();
        }

    public void verifyTextOnDependentOverviewPageSpanish() {
        basicActions.waitForElementToBePresent(hdr_DependentOverview,15);
        softAssert.assertEquals(hdr_DependentOverview.getText(), "Resumen del dependiente");
        softAssert.assertEquals(dependentOverviewQuestionText.getText(), "\u00BFEs " + Character.toUpperCase(SharedData.getMembers().get(0).getFirstName().charAt(0)) + SharedData.getMembers().get(0).getFirstName().substring(1) + " " + Character.toUpperCase(SharedData.getMembers().get(0).getMiddleName().charAt(0)) + ". " + Character.toUpperCase(SharedData.getMembers().get(0).getLastName().charAt(0)) + SharedData.getMembers().get(0).getLastName().substring(1) + " una persona discapacitada no casado y dependiente en su familia?");
        softAssert.assertEquals(dependentOverviewYesButton.getText(), "S\u00ED");
        softAssert.assertEquals(dependentOverviewNoButton.getText(), "  No");
        softAssert.assertEquals(saveAndContinueButton.getText(), "Guardar y continuar");
        softAssert.assertEquals(goBackButton.getText(), " Volver");
        softAssert.assertAll();
    }

}
