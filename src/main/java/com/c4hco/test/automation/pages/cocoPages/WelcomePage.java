package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.Dto.SharedData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class WelcomePage {

    @FindBy(xpath = "//div[@class='header-1']")
    WebElement welcomeToConnectText;

    @FindBy(css = ".container .header-2")
    List <WebElement> containerHeaderText;

    @FindBy(xpath = "//div[@class='body-text-1 apply-text-body']")
    WebElement theAnnualOpenEnrollmentText;

    @FindBy(css = ".apply-button-container button")
    WebElement applyForCurrentYearButton;

    @FindBy(css = ".plan-year-control-container > label")
    WebElement planYearText;

    @FindBy(css = "#plan-year-selector")
    WebElement planYearSelectorDp;

    @FindBy(xpath = "//div[@class='no-plans plans-container']")
    WebElement youHaveNotEnrolled;

    @FindBy(css = ".plan-member-container .plan-member-first-names")
    WebElement enrolledFirstNames;

    @FindBy(css = ".plan-member-container .plan-member-full-names")
    WebElement enrolledFullNames;

    @FindBy(css = ".plan-sub-container > strong")
    WebElement policyMedicalPlan;

    @FindBy(css = ".plan-sub-container > div")
    List<WebElement> policyMedicalDetails;

    @FindBy(css = ".premium-container > span")
    List<WebElement> policyMonthlyDetails;

    @FindBy(css = "app-plan-help .contact-us")
    WebElement policyContactUs;

    @FindBy(id = "ELIG-WelcomePage-MyProfile")
    WebElement myProfileButton;

    @FindBy(xpath = "//app-additional-resources//div[2]/div[2]")
    WebElement viewAndUpdateText;

    @FindBy(id = "ELIG-WelcomePage-ApplicationResults")
    WebElement applicationResultsButton;

    //change the locator below
    @FindBy(xpath = "//app-container//div[2]/div[4]")
    WebElement viewTheBenefitsText;

    @FindBy(id = "ELIG-WelcomePage-MyDocuments")
    WebElement myDocumentsButton;

    //change the locator below
    @FindBy(xpath = "//app-container//div[2]/div[6]")
    WebElement viewYourDocumentsText;

    @FindBy(css = ".action-link")
    List<WebElement> actionLinks;

    SoftAssert softAssert = new SoftAssert();

    private BasicActions basicActions;
    public WelcomePage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickApplyForInsurance() {
        basicActions.waitForElementToBeClickable(applyForCurrentYearButton, 5);
        applyForCurrentYearButton.click(); }

    public void clickMyProfileButton() {
        basicActions.waitForElementToBeClickable(myProfileButton, 5);
        myProfileButton.click(); }

    public void clickApplicationResultsButton() {
        basicActions.waitForElementToBeClickable(applicationResultsButton, 5);
        applicationResultsButton.click(); }

    public void clickMyDocumentsButton() {
        basicActions.waitForElementToBeClickable(myDocumentsButton, 5);
        myDocumentsButton.click(); }

    public void clickActionLinks(String actionLink) {
        basicActions.waitForElementListToBePresent(actionLinks, 5);
        switch(actionLink) {
            case "Application Results":
                actionLinks.get(1).click();
                break;
            case "My Documents and Letters":
                actionLinks.get(2).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + actionLink);
        }
    }

    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line
    public void verifyTextOnWelcomePageFirstTime(String language) {
        switch (language) {
            case "English":
                verifyTextOnWelcomePageFirstTimeEnglish();
                break;
            case "Spanish":
                verifyTextOnWelcomePageFirstTimeSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyTextOnWelcomePageFirstTimeEnglish(){
        basicActions.waitForElementToBePresent(applyForCurrentYearButton,10);
        softAssert.assertEquals(welcomeToConnectText.getText(), "Welcome to Colorado Connect!");
        softAssert.assertEquals(containerHeaderText.get(0).getText(), "Apply for health insurance");
        String currentUrl = basicActions.getCurrentUrl();
        if(currentUrl == "https://staging") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "The annual Open Enrollment period for health insurance (October 11 - January 17) is over. However, you may still be eligible to enroll in health insurance if you have a Qualifying Life Event, such as moving to Colorado, getting married or the birth of a child. Click the button below to get started.");
        }
        else if (currentUrl == "https://qa") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "The annual Open Enrollment period for health insurance (August 6 - January 8) is over. However, you may still be eligible to enroll in health insurance if you have a Qualifying Life Event, such as moving to Colorado, getting married or the birth of a child. Click the button below to get started.");
        }
        softAssert.assertEquals(applyForCurrentYearButton.getText(), "Apply for 2024");
        softAssert.assertEquals(containerHeaderText.get(1).getText(), "Your current plan(s)");
        softAssert.assertEquals(planYearText.getText(), "Plan Year");
        softAssert.assertEquals(planYearSelectorDp.getText(), "2024\n2023");
        softAssert.assertEquals(youHaveNotEnrolled.getText(), "You have not yet enrolled in a plan for 2024");
        softAssert.assertEquals(containerHeaderText.get(2).getText(), "Additional Resources");
        softAssert.assertEquals(myProfileButton.getText(), "My Profile");
        softAssert.assertEquals(viewAndUpdateText.getText(), "View and update your account information");
        softAssert.assertEquals(applicationResultsButton.getText(), "Application Results");
        softAssert.assertEquals(viewTheBenefitsText.getText(), "View the benefits you're qualified for");
        softAssert.assertEquals(myDocumentsButton.getText(), "My Documents and Letters");
        softAssert.assertEquals(viewYourDocumentsText.getText(), "View your documents");
        softAssert.assertAll();
    }

    public void verifyTextOnWelcomePageFirstTimeSpanish(){
        basicActions.waitForElementToBePresent(applyForCurrentYearButton,10);
        softAssert.assertEquals(welcomeToConnectText.getText(), "\u00A1Bienvenido a Colorado Connect!");
        softAssert.assertEquals(containerHeaderText.get(0).getText(), "Solicite un seguro de salud");
        String currentUrl = basicActions.getCurrentUrl();
        if(currentUrl == "https://staging") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "El per\u00EDodo anual de inscripci\u00F3n abierta en el seguro de salud (11\u00BA de octubre a 17 de enero) termin\u00F3. Sin embargo, a\u00FAn puede ser elegible para inscribirse en el seguro de salud si se presenta un evento de vida calificado, como mudarse a Colorado, casarse o el nacimiento de un hijo. Haga clic en el bot\u00F3n de abajo para comenzar.");
        }
        else if (currentUrl == "https://qa") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "El per\u00EDodo anual de inscripci\u00F3n abierta en el seguro de salud (6\u00BA de agosto a 8 de enero) termin\u00F3. Sin embargo, a\u00FAn puede ser elegible para inscribirse en el seguro de salud si se presenta un evento de vida calificado, como mudarse a Colorado, casarse o el nacimiento de un hijo. Haga clic en el bot\u00F3n de abajo para comenzar.");
        }
        softAssert.assertEquals(applyForCurrentYearButton.getText(), "Solicitar para 2024");
        softAssert.assertEquals(containerHeaderText.get(1).getText(), "Sus planes actuales");
        softAssert.assertEquals(planYearText.getText(), "A\u00F1o del plan");
        softAssert.assertEquals(planYearSelectorDp.getText(), "2024\n2023");
        softAssert.assertEquals(youHaveNotEnrolled.getText(), "A\u00FAn no se ha inscrito en un plan para 2024");
        softAssert.assertEquals(containerHeaderText.get(2).getText(), "Otros recursos");
        softAssert.assertEquals(myProfileButton.getText(), "Mi perfil");
        softAssert.assertEquals(viewAndUpdateText.getText(), "Ver y actualizar la informaci\u00F3n de su cuenta");
        softAssert.assertEquals(applicationResultsButton.getText(), "Resultados de la solicitud");
        softAssert.assertEquals(viewTheBenefitsText.getText(), "Ver los beneficios a los que califica");
        softAssert.assertEquals(myDocumentsButton.getText(), "Mis Documentos y Cartas");
        softAssert.assertEquals(viewYourDocumentsText.getText(), "Vea sus documentos");
        softAssert.assertAll();
    }

    public void verifyTextOnWelcomePageNoPolicy(String language){
        switch(language) {
        case "English":
            verifyTextOnWelcomePageNoPolicyEnglish();
            break;
        case "Spanish":
            verifyTextOnWelcomePageNoPolicySpanish();
            break;
        default:
            throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyTextOnWelcomePageNoPolicyEnglish(){
        basicActions.waitForElementToBePresent(applyForCurrentYearButton,10);
        softAssert.assertEquals(welcomeToConnectText.getText(), "Welcome back, "+ SharedData.getPrimaryMember().getFirstName() +"!");
        softAssert.assertEquals(containerHeaderText.get(0).getText(), "Apply for health insurance");
        String currentUrl = basicActions.getCurrentUrl();
        if(currentUrl == "https://staging") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "The annual Open Enrollment period for health insurance (October 11 - January 17) is over. However, you may still be eligible to enroll in health insurance if you have a Qualifying Life Event, such as moving to Colorado, getting married or the birth of a child. Click the button below to get started.");
        }
        else if (currentUrl == "https://qa") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "The annual Open Enrollment period for health insurance (August 6 - January 8) is over. However, you may still be eligible to enroll in health insurance if you have a Qualifying Life Event, such as moving to Colorado, getting married or the birth of a child. Click the button below to get started.");
        }
        softAssert.assertEquals(applyForCurrentYearButton.getText(), "Apply for 2024");
        softAssert.assertEquals(containerHeaderText.get(1).getText(), "Your current plan(s)");
        softAssert.assertEquals(planYearText.getText(), "Plan Year");
        softAssert.assertEquals(planYearSelectorDp.getText(), "2024\n2023");
        softAssert.assertEquals(youHaveNotEnrolled.getText(), "You have not yet enrolled in a plan for 2024");
        softAssert.assertEquals(containerHeaderText.get(2).getText(), "Additional Resources");
        softAssert.assertEquals(myProfileButton.getText(), "My Profile");
        softAssert.assertEquals(viewAndUpdateText.getText(), "View and update your account information");
        softAssert.assertEquals(applicationResultsButton.getText(), "Application Results");
        softAssert.assertEquals(viewTheBenefitsText.getText(), "View the benefits you're qualified for");
        softAssert.assertEquals(myDocumentsButton.getText(), "My Documents and Letters");
        softAssert.assertEquals(viewYourDocumentsText.getText(), "View your documents");
        softAssert.assertAll();
    }

    public void verifyTextOnWelcomePageNoPolicySpanish(){
        basicActions.waitForElementToBePresent(applyForCurrentYearButton,10);
        softAssert.assertEquals(welcomeToConnectText.getText(), "\u00A1Bienvenido/a de nuevo, "+ SharedData.getPrimaryMember().getFirstName() +"!");
        softAssert.assertEquals(containerHeaderText.get(0).getText(), "Solicite un seguro de salud");
        String currentUrl = basicActions.getCurrentUrl();
        if(currentUrl == "https://staging") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "El per\u00EDodo anual de inscripci\u00F3n abierta en el seguro de salud (11\u00BA de octubre a 17 de enero) termin\u00F3. Sin embargo, a\u00FAn puede ser elegible para inscribirse en el seguro de salud si se presenta un evento de vida calificado, como mudarse a Colorado, casarse o el nacimiento de un hijo. Haga clic en el bot\u00F3n de abajo para comenzar.");
        }
        else if (currentUrl == "https://qa") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "El per\u00EDodo anual de inscripci\u00F3n abierta en el seguro de salud (6\u00BA de agosto a 8 de enero) termin\u00F3. Sin embargo, a\u00FAn puede ser elegible para inscribirse en el seguro de salud si se presenta un evento de vida calificado, como mudarse a Colorado, casarse o el nacimiento de un hijo. Haga clic en el bot\u00F3n de abajo para comenzar.");
        }
        softAssert.assertEquals(applyForCurrentYearButton.getText(), "Solicitar para 2024");
        softAssert.assertEquals(containerHeaderText.get(1).getText(), "Sus planes actuales");
        softAssert.assertEquals(planYearText.getText(), "A\u00F1o del plan");
        softAssert.assertEquals(planYearSelectorDp.getText(), "2024\n2023");
        softAssert.assertEquals(youHaveNotEnrolled.getText(), "A\u00FAn no se ha inscrito en un plan para 2024");
        softAssert.assertEquals(containerHeaderText.get(2).getText(), "Otros recursos");
        softAssert.assertEquals(myProfileButton.getText(), "Mi perfil");
        softAssert.assertEquals(viewAndUpdateText.getText(), "Ver y actualizar la informaci\u00F3n de su cuenta");
        softAssert.assertEquals(applicationResultsButton.getText(), "Resultados de la solicitud");
        softAssert.assertEquals(viewTheBenefitsText.getText(), "Ver los beneficios a los que califica");
        softAssert.assertEquals(myDocumentsButton.getText(), "Mis Documentos y Cartas");
        softAssert.assertEquals(viewYourDocumentsText.getText(), "Vea sus documentos");
        softAssert.assertAll();
    }

    public void validateActionLinksText(String language) {
        basicActions.waitForElementListToBePresent(actionLinks, 5);
        switch(language) {
            case "English":
                softAssert.assertEquals(actionLinks.get(1).getText(), "Application Results");
                softAssert.assertEquals(actionLinks.get(2).getText(), "My Documents and Letters");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(actionLinks.get(1).getText(), "Resultados de la solicitud");
                softAssert.assertEquals(actionLinks.get(2).getText(), "Mis Documentos y Cartas");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyTextOnWelcomePagePolicy(String policyName, String policyLevel, String policyPremium, String language) {
//        For 1 member enrolled in Elevate (phone number)
        switch (language) {
            case "English":
                verifyTextOnWelcomePagePolicyEnglish(policyName, policyLevel, policyPremium);
                break;
            case "Spanish":
                verifyTextOnWelcomePagePolicySpanish(policyName, policyLevel, policyPremium);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyTextOnWelcomePagePolicyEnglish(String policyName, String policyLevel, String policyPremium){
        basicActions.waitForElementToBePresent(applyForCurrentYearButton,10);
        softAssert.assertEquals(welcomeToConnectText.getText(), "Welcome back, "+SharedData.getPrimaryMember().getFirstName()+"!");
        softAssert.assertEquals(containerHeaderText.get(0).getText(), "Make changes to your health insurance");
        String currentUrl = basicActions.getCurrentUrl();
        if(currentUrl == "https://staging") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "The annual Open Enrollment period for health insurance (October 11 - January 17) is over. However, you may still be eligible to enroll in health insurance if you have a Qualifying Life Event, such as moving to Colorado, getting married or the birth of a child. Click the button below to make changes.");
        }
        else if (currentUrl == "https://qa") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "The annual Open Enrollment period for health insurance (August 6 - January 8) is over. However, you may still be eligible to enroll in health insurance if you have a Qualifying Life Event, such as moving to Colorado, getting married or the birth of a child. Click the button below to make changes.");
        }
        softAssert.assertEquals(applyForCurrentYearButton.getText(), "Make changes");
        softAssert.assertEquals(containerHeaderText.get(1).getText(), "Your current plan(s)");
        softAssert.assertEquals(planYearText.getText(), "Plan Year");
        softAssert.assertEquals(planYearSelectorDp.getText(), "2024\n2023");
        softAssert.assertEquals(enrolledFirstNames.getText(), SharedData.getPrimaryMember().getFirstName());
        softAssert.assertEquals(enrolledFullNames.getText(), SharedData.getPrimaryMember().getFirstName()+" "+SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(policyMedicalPlan.getText(), "Medical Plan");
        softAssert.assertEquals(policyMedicalDetails.get(0).getText(), policyName);
        softAssert.assertEquals(policyMedicalDetails.get(1).getText(), policyLevel);
        softAssert.assertEquals(policyMedicalDetails.get(3).getText(), "303-602-2090");
        softAssert.assertEquals(policyMonthlyDetails.get(0).getText(), "Monthly Plan Payment");
        softAssert.assertEquals(policyMonthlyDetails.get(1).getText(), "$"+policyPremium+"/mo");
        softAssert.assertEquals(policyContactUs.getText(), "If you need to cancel your plan(s), please contact our Customer Service Center at:\n855-675-2626");
        softAssert.assertEquals(containerHeaderText.get(2).getText(), "Additional Resources");
        softAssert.assertEquals(myProfileButton.getText(), "My Profile");
        softAssert.assertEquals(viewAndUpdateText.getText(), "View and update your account information");
        softAssert.assertEquals(applicationResultsButton.getText(), "Application Results");
        softAssert.assertEquals(viewTheBenefitsText.getText(), "View the benefits you're qualified for");
        softAssert.assertEquals(myDocumentsButton.getText(), "My Documents and Letters");
        softAssert.assertEquals(viewYourDocumentsText.getText(), "View your documents");
        softAssert.assertAll();
    }

    public void verifyTextOnWelcomePagePolicySpanish(String policyName, String policyLevel, String policyPremium){
        basicActions.waitForElementToBePresent(applyForCurrentYearButton,10);
        softAssert.assertEquals(welcomeToConnectText.getText(), "\u00A1Bienvenido/a de nuevo, "+ SharedData.getPrimaryMember().getFirstName() +"!");
        softAssert.assertEquals(containerHeaderText.get(0).getText(), "Hacer cambios a su seguro de salud");
        String currentUrl = basicActions.getCurrentUrl();
        if(currentUrl == "https://staging") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "El per\u00EDodo anual de inscripci\u00F3n abierta en el seguro de salud (11\u00BA de octubre a 17 de enero) termin\u00F3. Sin embargo, a\u00FAn puede ser elegible para inscribirse en el seguro de salud si se presenta un evento de vida calificado, como mudarse a Colorado, casarse o el nacimiento de un hijo. Haga clic en el bot\u00F3n de abajo para hacer cambios.");
        }
        else if (currentUrl == "https://qa") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "El per\u00EDodo anual de inscripci\u00F3n abierta en el seguro de salud (6\u00BA de agosto a 8 de enero) termin\u00F3. Sin embargo, a\u00FAn puede ser elegible para inscribirse en el seguro de salud si se presenta un evento de vida calificado, como mudarse a Colorado, casarse o el nacimiento de un hijo. Haga clic en el bot\u00F3n de abajo para hacer cambios.");
        }
        softAssert.assertEquals(applyForCurrentYearButton.getText(), "Hacer cambios");
        softAssert.assertEquals(containerHeaderText.get(1).getText(), "Sus planes actuales");
        softAssert.assertEquals(planYearText.getText(), "A\u00F1o del plan");
        softAssert.assertEquals(planYearSelectorDp.getText(), "2024\n2023");
        softAssert.assertEquals(enrolledFirstNames.getText(), SharedData.getPrimaryMember().getFirstName());
        softAssert.assertEquals(enrolledFullNames.getText(), SharedData.getPrimaryMember().getFirstName()+" "+SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(policyMedicalPlan.getText(), "Plan m\u00E9dico");
        softAssert.assertEquals(policyMedicalDetails.get(0).getText(), policyName);
        softAssert.assertEquals(policyMedicalDetails.get(1).getText(), policyLevel);
        softAssert.assertEquals(policyMedicalDetails.get(3).getText(), "303-602-2090");
        softAssert.assertEquals(policyMonthlyDetails.get(0).getText(), "Pago mensual del plan");
        softAssert.assertEquals(policyMonthlyDetails.get(1).getText(), "$"+policyPremium+"/mes");
        softAssert.assertEquals(policyContactUs.getText(), "Si necesita cancelar sus planes, comun\u00EDquese con nuestro centro de atenci\u00F3n al cliente, llamando al:\n855-675-2626");
        softAssert.assertEquals(containerHeaderText.get(2).getText(), "Otros recursos");
        softAssert.assertEquals(myProfileButton.getText(), "Mi perfil");
        softAssert.assertEquals(viewAndUpdateText.getText(), "Ver y actualizar la informaci\u00F3n de su cuenta");
        softAssert.assertEquals(applicationResultsButton.getText(), "Resultados de la solicitud");
        softAssert.assertEquals(viewTheBenefitsText.getText(), "Ver los beneficios a los que califica");
        softAssert.assertEquals(myDocumentsButton.getText(), "Mis Documentos y Cartas");
        softAssert.assertEquals(viewYourDocumentsText.getText(), "Vea sus documentos");
        softAssert.assertAll();
    }
}


