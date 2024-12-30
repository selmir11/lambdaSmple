package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ApplicationResultsCoCoPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public ApplicationResultsCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(xpath = "//button[@id = 'ELIG-MemberPlanInfo-SaveAndContinue']")
    public WebElement continueButton;

    @FindBy(id = "ELIG-NoApplication-BackToWelcomePage")
    public WebElement backToWelcomeButton;

    @FindBy(css = ".container .header-1")
    WebElement applicationResultsHeader;

    @FindBy(css = "div.body-text-2.member-name")
    WebElement memberName;

    @FindBy(css = "div.plan-name.eligible")
    List<WebElement> healthInsuranceCoCoEligible; //SES, Limited text, Health insurance coco plans

    @FindBy(xpath = "//div[contains(text(), \"Here's what your household qualifies for\")]")
    WebElement hereIsWhatYourHouseholdQualifiesHeader;

    @FindBy(xpath = "//div[contains(text(), \"Usted y/o su familia califica para lo siguiente\")]")
    WebElement hereIsWhatYourHouseholdQualifiesHeaderSpanish;

    @FindBy(css = ".body-text-2")
    List<WebElement> doNotQualifyForHealthPlanText;

    @FindBy(css = ".c4-type-body-md-bold.plan-name.eligible.hp2Limited-container")
    WebElement sesLimitedtext;

    @FindBy(css = ".body-text-1")
    WebElement submitNewApplicationText;
    @FindBy(css = "div.plan-name.eligible")
    WebElement eligiblePlan;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    public void backToWelcomeButton() {
        basicActions.waitForElementToBeClickable(backToWelcomeButton, 5);
        backToWelcomeButton.click();
    }

    public void continueWithApplication()  {
        basicActions.waitForElementToDisappear( spinner, 100 );
        basicActions.scrollToElement( continueButton );
        basicActions.waitForElementToBePresentWithRetries( continueButton, 60);
        continueButton.click();
    }

    public void verifyHeader(String language)  {
        switch (language) {
            case "English":
                basicActions.waitForElementToBePresent(applicationResultsHeader,20);
                softAssert.assertEquals(applicationResultsHeader.getText(), "Application results");
                softAssert.assertAll();
                break;
            case "Spanish":
                basicActions.waitForElementToBePresent(applicationResultsHeader,20);
                softAssert.assertEquals(applicationResultsHeader.getText(), "Resultados de la solicitud");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyTextNotQualifyForPlanOnAppResultsPage(){
        basicActions.waitForElementToBePresent(hereIsWhatYourHouseholdQualifiesHeader,10);
        softAssert.assertEquals(hereIsWhatYourHouseholdQualifiesHeader.getText(), "Here's what your household qualifies for");
        softAssert.assertEquals(doNotQualifyForHealthPlanText.get(0).getText(), "Based on the information listed in your application, you do not qualify for a health plan at this time.");
        softAssert.assertEquals(doNotQualifyForHealthPlanText.get(1).getText(), "You must live in Colorado");
        softAssert.assertEquals(submitNewApplicationText.getText(), "If your situation changes you can submit a new application to re-apply and newly qualify.");
        softAssert.assertAll();
    }
    public void verifySESlimitedOnAppResultsPage(String language) {
        switch (language) {
            case "English":
                verifySESlimitedOnAppResultsPageEnglish();
                break;
            case "Spanish":
                verifySESlimitedOnAppResultsPageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }


    public void verifySESlimitedOnAppResultsPageEnglish(){
        basicActions.waitForElementToBePresent(hereIsWhatYourHouseholdQualifiesHeader,10);
        softAssert.assertEquals(hereIsWhatYourHouseholdQualifiesHeader.getText(), "Here's what your household qualifies for");
        softAssert.assertEquals(memberName.getText(), SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(eligiblePlan.getText(), "SilverEnhanced Savings");
        softAssert.assertEquals(sesLimitedtext.getText(), "Applications for SilverEnhanced Savings will open on November 25 at 8:00 a.m. on a first come, first served basis. Come back then to resubmit your application!");
        softAssert.assertEquals(healthInsuranceCoCoEligible.get(2).getText(), "Health insurance plans through Colorado Connect");
        softAssert.assertAll();
    }

    public void verifySESlimitedOnAppResultsPageSpanish(){
        basicActions.waitForElementToBePresent(hereIsWhatYourHouseholdQualifiesHeader,10);
        softAssert.assertEquals(hereIsWhatYourHouseholdQualifiesHeaderSpanish.getText(), "Usted y/o su familia califica para lo siguiente");
        softAssert.assertEquals(memberName.getText(), SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(eligiblePlan.getText(), "Ahorros SilverEnhanced");
        softAssert.assertEquals(sesLimitedtext.getText(), "Las solicitudes para Ahorros SilverEnhanced se abrir\u00E1n el 25 de noviembre a las 8:00 a.m. y se atender\u00E1n por orden de llegada. No olvide regresar en esa fecha para reenviar su solicitud.");
        softAssert.assertEquals(healthInsuranceCoCoEligible.get(2).getText(), "Planes de seguro de salud a trav\u00E9s de Colorado Connect");
        softAssert.assertAll();
    }

    public void verifySESClosedOnAppResultsPage(String language) {
        switch (language) {
            case "English":
                verifySESClosedOnAppResultsPageEnglish();
                break;
            case "Spanish":
                verifySESClosedOnAppResultsPageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifySESClosedOnAppResultsPageEnglish(){
        basicActions.waitForElementToBePresent(hereIsWhatYourHouseholdQualifiesHeader,10);
        softAssert.assertEquals(hereIsWhatYourHouseholdQualifiesHeader.getText(), "Here's what your household qualifies for");
        softAssert.assertEquals(memberName.getText(), SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(eligiblePlan.getText(), "SilverEnhanced Savings");
        softAssert.assertEquals(sesLimitedtext.getText(), "SilverEnhanced Savings is currently closed. It may reopen next open enrollment period. We encourage you to continue, as you\u2019ll still be able to enroll in plans at regular cost.");
        softAssert.assertEquals(healthInsuranceCoCoEligible.get(2).getText(), "Health insurance plans through Colorado Connect");
        softAssert.assertAll();
    }

    public void verifySESClosedOnAppResultsPageSpanish(){
        basicActions.waitForElementToBePresent(hereIsWhatYourHouseholdQualifiesHeaderSpanish,10);
        softAssert.assertEquals(hereIsWhatYourHouseholdQualifiesHeaderSpanish.getText(), "Usted y/o su familia califica para lo siguiente");
        softAssert.assertEquals(memberName.getText(), SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(eligiblePlan.getText(), "Ahorros SilverEnhanced");
        softAssert.assertEquals(sesLimitedtext.getText(), "Actualmente, Ahorros SilverEnhanced se encuentra cerrado. Es posible que vuelva a abrirse para el pr\u00F3ximo periodo de inscripci\u00F3n abierta. Lo animamos a que contin\u00FAe con la solicitud, ya que a\u00FAn puede inscribirse en planes con costo regular.");
        softAssert.assertEquals(healthInsuranceCoCoEligible.get(2).getText(), "Planes de seguro de salud a trav\u00E9s de Colorado Connect");
        softAssert.assertAll();
    }

    public void verifySESOpenOnAppResultsPage(String language) {
        switch (language) {
            case "English":
                verifySESOpenOnAppResultsPageEnglish();
                break;
            case "Spanish":
                verifySESOpenOnAppResultsPageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifySESOpenOnAppResultsPageEnglish(){
        basicActions.waitForElementToBePresent(hereIsWhatYourHouseholdQualifiesHeader,10);
        softAssert.assertEquals(hereIsWhatYourHouseholdQualifiesHeader.getText(), "Here's what your household qualifies for");
        softAssert.assertEquals(memberName.getText(), SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(eligiblePlan.getText(), "SilverEnhanced Savings");
        softAssert.assertEquals(sesLimitedtext.getText(), "You qualify for SilverEnhanced Savings! Next, choose a plan and enroll as soon as possible!");
        softAssert.assertEquals(healthInsuranceCoCoEligible.get(2).getText(), "Health insurance plans through Colorado Connect");
        softAssert.assertAll();
    }

    public void verifySESOpenOnAppResultsPageSpanish(){
        basicActions.waitForElementToBePresent(hereIsWhatYourHouseholdQualifiesHeaderSpanish,10);
        softAssert.assertEquals(hereIsWhatYourHouseholdQualifiesHeaderSpanish.getText(), "Usted y/o su familia califica para lo siguiente");
        softAssert.assertEquals(memberName.getText(), SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(eligiblePlan.getText(), "Ahorros SilverEnhanced");
        softAssert.assertEquals(sesLimitedtext.getText(), "\u00A1Usted califica para Ahorros SilverEnhanced! A continuaci\u00F3n, elija un plan e inscr\u00EDbase lo antes posible.");
        softAssert.assertEquals(healthInsuranceCoCoEligible.get(2).getText(), "Planes de seguro de salud a trav\u00E9s de Colorado Connect");
        softAssert.assertAll();
    }

    public void verifyEligibleplans(){
        basicActions.waitForElementToBePresent(hereIsWhatYourHouseholdQualifiesHeader,10);
        if(SharedData.getSes().equals("yes")){
            softAssert.assertEquals(eligiblePlan.getText(), "SilverEnhanced Savings");
        } else{
            softAssert.assertEquals(eligiblePlan.getText(), "Health insurance plans through Colorado Connect");
        }
        softAssert.assertAll();
        }
}
