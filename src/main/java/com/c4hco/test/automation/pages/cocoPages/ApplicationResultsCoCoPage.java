package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ApplicationResultsCoCoPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public ApplicationResultsCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "#ELIG-MemberPlanInfo-SaveAndContinue")
    public WebElement continueButton;

    @FindBy(id = "ELIG-NoApplication-BackToWelcomePage")
    public WebElement backToWelcomeButton;

    @FindBy(css = ".container .header-1")
    WebElement applicationResultsHeader;

    @FindBy(css = ".member-name")
    WebElement memberName;

    @FindBy(css = ".member-name")
    List<WebElement> memberNames;

    @FindBy(css = ".plan-name")
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

    @FindBy(css = ".plan-name")
    WebElement eligiblePlan;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(id = "currentYear_link")
    WebElement currentYr;

    @FindBy(id = "nextYear_link")
    WebElement nextYr;

    @FindBy(css=".overview-title")
    WebElement overviewTitle;

    @FindBy(css=".overview-text p")
    List<WebElement> overviewTxt;

    @FindBy(css="app-container .message-row div div")
    List<WebElement> yellowBanner;

    @FindBy(css="app-container .no-application-text")
    WebElement noAppTxt;

    @FindBy(css=".not-qualified-text p")
    List<WebElement> notEligibleOverviewTxt;

    @FindBy(css="app-not-eligible-shop .warning-container")
    WebElement warningModalHeader;

    @FindBy(css="app-not-eligible-shop .contact-us-text")
    List<WebElement> contactUsTxt;

    @FindBy(css="app-not-eligible-shop .contact-us-link-text a")
    WebElement contactUsLink;

    @FindBy(css="app-not-eligible-shop .contact-us-text span:nth-child(2)")
    WebElement contactUsText2;

    @FindBy(css="not-elig-shop-close-button")
    WebElement warningModalCloseBtn;

    public void backToWelcomeButton() {
        basicActions.waitForElementToBeClickable(backToWelcomeButton, 5);
        backToWelcomeButton.click();
    }

    public void continueWithApplication()  {
        basicActions.waitForElementToDisappear( spinner, 100 );
        basicActions.waitForElementToBePresentWithRetries( continueButton, 60);
        basicActions.scrollToElement( continueButton );
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
        // WIP - we should not rely on ses value from application.properties. That field should go away
        basicActions.waitForElementToBePresent(hereIsWhatYourHouseholdQualifiesHeader,10);
        if(SharedData.getSes().equals("yes")){
            softAssert.assertEquals(eligiblePlan.getText(), "SilverEnhanced Savings");
        } else{
            softAssert.assertEquals(eligiblePlan.getText(), "Health insurance plans through Colorado Connect");
        }
        softAssert.assertAll();
        }

    public void validateResultsOfYr(String year){
        String expectedYr = "";
        String actualYr = "";
        switch(year){
            // WIP - For both the cases, the locators are different when we have both current year and next year and on Jan 1st (new year) - the locators change
            // We need to handle below based on time period
            case "current year":
                expectedYr = String.valueOf(Year.now().getValue());
                basicActions.wait(2000);
                Assert.assertTrue(basicActions.waitForElementToBePresentWithRetries(currentYr, 10));
                actualYr = currentYr.getText();
                softAssert.assertTrue(currentYr.getAttribute("class").contains("disable"), "showing results for next year");
                break;
            case "next year":
                expectedYr = String.valueOf(Year.now().getValue()+1);
                basicActions.wait(2000);
                Assert.assertTrue(basicActions.waitForElementToBePresentWithRetries(nextYr, 10));
                actualYr = nextYr.getText();
                softAssert.assertTrue(nextYr.getAttribute("class").contains("disable"), "showing results for current year");
                break;
            default: Assert.fail("Invalid argument");
        }
        softAssert.assertEquals(expectedYr, actualYr, "Results displayed for the improper year");
        softAssert.assertAll();
    }

    public void validateTextOnPage() {
        validateNameAndPlan();
        validateOverviewContainerTxt();
        validateYellowBannerTxt();
        softAssert.assertAll();
    }
    public void validateSpanishTextOnPage(){
        validateSpanishNameAndPlan();
        validateSpanishOverviewContainerTxt();
        validateSpanishYellowBannerTxt();
        softAssert.assertAll();
    }

    private void validateSpanishYellowBannerTxt() {
        softAssert.assertEquals(yellowBanner.get(0).getText(), "Si alguien en su familia no es indocumentado, es posible que califique para otras opciones de cobertura y ayuda financiera. Este a\u00F1o, tambi\u00E9n hay nuevas", "Spanish Yellow banner text - line 1 did not match");
        softAssert.assertEquals(yellowBanner.get(1).getText(), "opciones de cobertura para personas indocumentadas que est\u00E1n embarazadas, son menores de 19 a\u00F1os o son beneficiarios de DACA.", "Yellow banner text - line 2 did not match");
        softAssert.assertEquals(yellowBanner.get(2).getText(), "Para encontrar la mejor opci\u00F3n para usted, puede obtener ayuda de un experto sin costo", "Yellow banner text - line 3 did not match");
    }

    private void validateSpanishOverviewContainerTxt() {
        softAssert.assertEquals(overviewTitle.getText(), "Resumen", "Spanish: Overview Title did not match");
        softAssert.assertEquals(overviewTxt.get(0).getText(), "Planes de seguro de salud a trav\u00E9s de Colorado Connect", "Overview text line 1 did not match");
        softAssert.assertEquals(overviewTxt.get(1).getText(), "Planes con primas mensuales que ofrecen protecciones y beneficios esenciales de salud", "Overview text line 2 did not match");
    }

    private void validateSpanishNameAndPlan() {
        basicActions.waitForElementToBePresent(memberName, 10);
        validateEligibleMembers();
        validatePlaneNameSpanish();
    }
    public void validatePlaneNameSpanish(){
       for(WebElement element: healthInsuranceCoCoEligible){
           softAssert.assertEquals(element.getText(), "Planes de seguro de salud a trav\u00E9s de Colorado Connect", "Spanish COCO Text under name did not match");
           softAssert.assertAll();
       }
    }
    public void verifyNotEligibleSpanishText(){
        basicActions.waitForElementToBePresent(hereIsWhatYourHouseholdQualifiesHeaderSpanish,10);
        softAssert.assertEquals(hereIsWhatYourHouseholdQualifiesHeaderSpanish.getText(), "Usted y/o su familia califica para lo siguiente");
        softAssert.assertEquals(notEligibleOverviewTxt.get(0).getText(), "De acuerdo con la informaci\u00F3n indicada en su solicitud, usted no califica para obtener un plan de salud en este momento.", "Spanish- not eligible- overview text 0 does not match.");
        softAssert.assertEquals(notEligibleOverviewTxt.get(1).getText(), "Si su situaci\u00F3n cambia, usted puede volver a presentar una solicitud nueva para calificar nuevamente.","Spanish- not eligible- overview text 1 does not match.");
        softAssert.assertEquals(notEligibleOverviewTxt.get(2).getText(), "Estos son los requisitos b\u00E1sicos para calificar", "Spanish- not eligible- overview text 2 does not match.");
        softAssert.assertEquals(notEligibleOverviewTxt.get(3).getText(),"Debe vivir en Colorado", "Spanish- not eligible- overview text 3 does not match.");
        softAssert.assertEquals(notEligibleOverviewTxt.get(4).getText(),"Recursos para usted", "Spanish- not eligible- overview text 4 does not match.");
        softAssert.assertEquals(notEligibleOverviewTxt.get(5).getText(),"Ll\u00E1menos al 855-675-2626 para revisar los resultados de su solicitud y las calificaciones para adquirir un plan de salud.", "Spanish- not eligible- overview text 5 does not match.");
        softAssert.assertEquals(notEligibleOverviewTxt.get(6).getText(),"Tambi\u00E9n puede contactar a un agente o asistente certificado para obtener ayuda de un experto.", "Spanish- not eligible- overview text 6 does not match.");
        softAssert.assertAll();
    }

    private void validateOverviewContainerTxt() {
        softAssert.assertEquals(overviewTitle.getText(), "Overview", "Overview Title did not match");
        softAssert.assertEquals(overviewTxt.get(0).getText(), "Health insurance plans through Colorado Connect", "Overview text line 1 did not match");
        softAssert.assertEquals(overviewTxt.get(1).getText(), "Plans with monthly premiums offering essential health benefits and protections", "Overview text line 2 did not match");
    }

    private void validateYellowBannerTxt(){
        softAssert.assertEquals(yellowBanner.get(0).getText(), "If someone in your family is not undocumented, they may qualify for other coverage options and financial help. This year, there are also new", "Yellow banner text - line 1 did not match");
        softAssert.assertEquals(yellowBanner.get(1).getText(), "coverage options for undocumented people who are pregnant, under age 19, or DACA recipients.", "Yellow banner text - line 2 did not match");
        softAssert.assertEquals(yellowBanner.get(2).getText(), "To find the best option for you, you can get free, expert help", "Yellow banner text - line 3 did not match");
    }

    private void validateNameAndPlan(){
        basicActions.waitForElementToBePresent(memberName, 10);
        softAssert.assertEquals(memberName.getText(), SharedData.getPrimaryMember().getSignature(), "Member name did not match");
        softAssert.assertEquals(eligiblePlan.getText(), "Health insurance plans through Colorado Connect", "COCO Text under name did not match");
    }

    public void validateEligibleMembers(){
        basicActions.waitForElementListToBePresent(memberNames, 10);
        List<String> allMemNames = basicActions.getAllMemCompleteNames();
        List<String> memNamesFromUi = new ArrayList<>();
        for(WebElement memName: memberNames){
            memNamesFromUi.add(memName.getText());
        }
        softAssert.assertEquals(new HashSet<>(allMemNames), new HashSet<>(memNamesFromUi), "Names are not matching!");
        softAssert.assertAll();
    }

    public void validatePageTextWithoutApplication(String language){
        basicActions.waitForElementToBePresent(noAppTxt, 10);
        switch(language){
            case "Spanish":
             softAssert.assertEquals(noAppTxt.getText().trim(), "Presente una solicitud para consultar sus resultados", "NoAppText did not match in spanish");
             softAssert.assertEquals(backToWelcomeButton.getText().trim(), "Regresar a la Página de bienvenida", "Back to welcome button text doesn't match in spanish");
             break;

             default: Assert.fail("Invalid argument passed");
        }
        softAssert.assertAll();
    }

    public void validateOeEndPopup() {
        basicActions.waitForElementToBePresent(warningModalHeader, 10);
        softAssert.assertEquals(contactUsTxt.get(0).getText(), "You can't enroll in health insurance because it is currently not Open Enrollment.", "The text line 1 did not match");
        softAssert.assertEquals(contactUsTxt.get(1).getText(), "The annual Open Enrollment Period for health insurance is from November 1 to January 15. Outside of this timeframe, you can only enroll if you have a ", "Part1 of the text highlighted in yellow did not match");
        softAssert.assertEquals(contactUsLink.getText(), "qualifying life change event", "The link text did not match");
        softAssert.assertEquals(contactUsText2.getText(), " If you have any questions, call our Customer Service Center 855-675-2626.", "The text after the link on pop up did not match");
        softAssert.assertAll();
    }

    public void clickCloseOnPopup(){
        basicActions.waitForElementToBePresent(warningModalCloseBtn, 10);
        warningModalCloseBtn.click();
    }
}
