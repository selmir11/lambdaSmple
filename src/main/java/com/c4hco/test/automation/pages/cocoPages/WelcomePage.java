package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.ExpectedCalculatedDates;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.ScenarioDetails;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.*;

public class WelcomePage {

    Actions actions = new Actions(WebDriverManager.getDriver());

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(css = ".header-1")
    WebElement welcomeToConnectText;

    @FindBy(css = ".c4-alert-icon-column svg")
    WebElement notificationBannerIcon;

    @FindBy(css = "lib-notification-banner:nth-child(1) > div")
    WebElement notificationBannerTxt;

    @FindBy(css = "lib-notification-banner .c4-alert-title")
    WebElement cacBannerHdr;

    @FindBy(css = "lib-notification-banner .c4-alert-content")
    WebElement cacBannerTxt;

    @FindBy(css = "div.c4-alert-content a")
    WebElement takeQuizLnk;

    @FindBy(xpath = "//div[contains(@class, 'c4-type-header')]")
    WebElement containerMainHeaderText;

    @FindBy(css = ".container .header-2")
    List<WebElement> containerHeaderText;

    @FindBy(xpath = "//div[@class='col text-center']")
    WebElement theAnnualOpenEnrollmentText;

    @FindBy(xpath = "//div[@class='text-center']")
    WebElement theClickButtonBelowText;

    @FindBy(css = "button#ELIG-WelcomePage-ApplyForInsurance-2025")
    WebElement applyForCurrentYearButton;

    @FindBy(id = "ELIG-WelcomePage-ApplyForInsurance-2025")
    WebElement makeChangeButton;

    @FindBy(css = ".plan-year-control-container > label")
    WebElement planYearText;

    @FindBy(css = "#plan-year-selector")
    WebElement planYearSelectorDp;

    @FindBy(css = "#plan-year-selector option")
    List<WebElement> planYearSelectorOptions;

    @FindBy(css = "app-plans > div > div")
    WebElement youHaveNotEnrolled;

    @FindBy(css = ".plan-member-container .plan-member-first-names")
    WebElement enrolledFirstNames;

    @FindBy(css = ".plan-member-container .plan-member-full-names")
    WebElement enrolledFullNames;

    @FindBy(css = ".plan-inner-container > strong")
    WebElement policyMedicalPlan;

    @FindBy(css = ".plan-inner-container > div > div")
    List<WebElement> policyMedicalDetails;

    @FindBy(css = ".premium-container > span")
    List<WebElement> policyMonthlyDetails;

    @FindBy(css = ".resources-container > div > div.resources-text")
    List<WebElement> viewAdditionalResourcesText;

    @FindBy(css = ".action-link, .c4-type-links-lg")
    List<WebElement> actionLinks;

    @FindBy(css = ".plan-member-names-container .plan-member-full-names")
    WebElement medicalMemberNames;

    SoftAssert softAssert = new SoftAssert();

    private BasicActions basicActions;

    public WelcomePage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickApplyForInsurance() {
        basicActions.waitForElementToDisappear( spinner, 40 );
        basicActions.waitForElementToBePresent(welcomeToConnectText, 20);
        WebElement applyForYrCoco = applyForCurrentYearButton;
        basicActions.waitForElementToBePresent(applyForYrCoco, 40);
        String year = applyForYrCoco.getText().replace("Apply for ", "");
        SharedData.setPlanYear(year);
        applyForYrCoco.click();
    }

    public void applyForNextYear() {
//        basicActions.waitForElementToDisappear( spinner, 40 );
//        basicActions.waitForElementToBePresent(welcomeToConnectText, 20);
//        WebElement applyForYrCoco = btnApplyForNextYearCoco;
//        basicActions.waitForElementToBePresent(applyForYrCoco, 40);
//        String year = applyForYrCoco.getText().replace("Apply for ", "");
//        SharedData.setPlanYear(year);
//        applyForYrCoco.click();
    }
    public void iClickMakeChangeButton() {
        basicActions.waitForElementToBePresent(makeChangeButton, 20);
        makeChangeButton.click();
    }

    public void selectPlanyear(String planYear) {
        basicActions.waitForElementToBeClickable(planYearSelectorDp, 10);
        basicActions.scrollToElement(planYearSelectorDp);
        selectValueFromDropdown(planYearSelectorDp, planYear);
    }
    public void selectValueFromDropdown(WebElement dropdownElement,String PlanYear) {
        String SelectYear = basicActions.getDateBasedOnRequirement(PlanYear);
        dropdownElement.click();
        System.out.println("Selecting plan year " + SelectYear);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(SelectYear);
    }

    public void clickTakeQuiz() {
        basicActions.waitForElementToBePresent(welcomeToConnectText, 10);
        basicActions.waitForElementToBeClickable(takeQuizLnk, 10);
        takeQuizLnk.click();
    }

    public void clickActionLinks(String actionLink) {
        basicActions.waitForElementListToBePresentWithRetries(actionLinks, 10);
        basicActions.wait(2000);
        switch (actionLink) {
            case "My Profile":
                actionLinks.get(0).click();
                break;
            case "Application Results":
                actionLinks.get(1).click();
                break;
            case "My Plans":
                actionLinks.get(2).click();
                break;
            case "My Documents and Letters":
                actionLinks.get(3).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + actionLink);
        }
    }

    public void clickMakeChanges() {
        basicActions.waitForElementToDisappear( spinner, 40 );
        basicActions.waitForElementToBePresent(welcomeToConnectText, 20);
        WebElement applyForYrCoco = applyForCurrentYearButton;
        basicActions.waitForElementToBePresent(applyForYrCoco, 40);
        applyForYrCoco.click();
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

    public void verifyTextOnWelcomePageFirstTimeEnglish() {
        basicActions.waitForElementToBePresent(applyForCurrentYearButton, 10);
        softAssert.assertEquals(welcomeToConnectText.getText(), "Welcome to Colorado Connect!");
        softAssert.assertEquals(containerMainHeaderText.getText(), "Apply for health insurance");
        String currentUrl = basicActions.getCurrentUrl();
        if (currentUrl == "https://staging") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "The annual Open Enrollment period for health insurance (October 3 - January 15) is over. However, you may still be eligible to enroll in health insurance if you have a Qualifying Life Event, such as moving to Colorado, getting married or the birth of a child.");
            softAssert.assertEquals(theClickButtonBelowText.getText(), "Click the button below to make changes.");
        } else if (currentUrl == "https://qa") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "The annual Open Enrollment period for health insurance (August 6 - January 8) is over. However, you may still be eligible to enroll in health insurance if you have a Qualifying Life Event, such as moving to Colorado, getting married or the birth of a child. Click the button below to get started.");
        }
        softAssert.assertEquals(applyForCurrentYearButton.getText(), "Apply for 2025");
        softAssert.assertEquals(containerHeaderText.get(0).getText(), "Your current plan(s)");
        softAssert.assertEquals(planYearText.getText(), "Plan Year");
        softAssert.assertEquals(planYearSelectorDp.getText(), "2025\n2024\n2023");
        softAssert.assertEquals(youHaveNotEnrolled.getText(), "You have not yet enrolled in a plan for 2025");
        softAssert.assertEquals(containerHeaderText.get(1).getText(), "Additional Resources");
        softAssert.assertEquals(actionLinks.get(0).getText(), "My Profile");
        softAssert.assertEquals(viewAdditionalResourcesText.get(0).getText(), "View and update your account information");
        softAssert.assertEquals(actionLinks.get(1).getText(), "Application Results");
        softAssert.assertEquals(viewAdditionalResourcesText.get(1).getText(), "View the benefits you're qualified for");
        softAssert.assertEquals(actionLinks.get(2).getText(), "My Plans");
        softAssert.assertEquals(viewAdditionalResourcesText.get(2).getText(), "View past plans. View and cancel current plans.");
        softAssert.assertEquals(actionLinks.get(3).getText(), "My Documents and Letters");
        softAssert.assertEquals(viewAdditionalResourcesText.get(3).getText(), "View your documents");
        softAssert.assertAll();
    }

    public void verifyTextOnWelcomePageFirstTimeSpanish() {
        basicActions.waitForElementToBePresent(applyForCurrentYearButton, 10);
        softAssert.assertEquals(welcomeToConnectText.getText(), "\u00A1Bienvenido a Colorado Connect!");
        softAssert.assertEquals(containerMainHeaderText.getText(), "Solicite un seguro de salud");
        String currentUrl = basicActions.getCurrentUrl();
        if (currentUrl == "https://staging") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "El per\u00EDodo anual de inscripci\u00F3n abierta en el seguro de salud (3\u00BA de octubre a 15 de enero) termin\u00F3. Sin embargo, a\u00FAn puede ser elegible para inscribirse en el seguro de salud si se presenta un evento de vida calificado, como mudarse a Colorado, casarse o el nacimiento de un hijo.");
            softAssert.assertEquals(theClickButtonBelowText.getText(), "Haga clic en el bot\u00F3n de abajo para comenzar.");
        } else if (currentUrl == "https://qa") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "El per\u00EDodo anual de inscripci\u00F3n abierta en el seguro de salud (6\u00BA de agosto a 8 de enero) termin\u00F3. Sin embargo, a\u00FAn puede ser elegible para inscribirse en el seguro de salud si se presenta un evento de vida calificado, como mudarse a Colorado, casarse o el nacimiento de un hijo. Haga clic en el bot\u00F3n de abajo para comenzar.");
        }
        softAssert.assertEquals(applyForCurrentYearButton.getText(), "Solicitar para 2025");
        softAssert.assertEquals(containerHeaderText.get(0).getText(), "Sus planes actuales");
        softAssert.assertEquals(planYearText.getText(), "A\u00F1o del plan");
        softAssert.assertEquals(planYearSelectorDp.getText(), "2025\n2024\n2023");
        softAssert.assertEquals(youHaveNotEnrolled.getText(), "A\u00FAn no se ha inscrito en un plan para 2025");
        softAssert.assertEquals(containerHeaderText.get(1).getText(), "Otros recursos");
        softAssert.assertEquals(actionLinks.get(0).getText(), "Mi perfil");
        softAssert.assertEquals(viewAdditionalResourcesText.get(0).getText(), "Ver y actualizar la informaci\u00F3n de su cuenta");
        softAssert.assertEquals(actionLinks.get(1).getText(), "Resultados de la solicitud");
        softAssert.assertEquals(viewAdditionalResourcesText.get(1).getText(), "Ver los beneficios a los que califica");
        softAssert.assertEquals(actionLinks.get(2).getText(), "Mis Planes");
        softAssert.assertEquals(viewAdditionalResourcesText.get(2).getText(), "Ver sus planes anteriores. Ver y cancelar sus planes actuales.");
        softAssert.assertEquals(actionLinks.get(3).getText(), "Mis Documentos y Cartas");
        softAssert.assertEquals(viewAdditionalResourcesText.get(3).getText(), "Vea sus documentos");
        softAssert.assertAll();
    }

    public void verifyTextOnWelcomePageNoPolicy(String language) {
        switch (language) {
            case "English":
                verifyTextOnWelcomePageNoPolicyEnglish();
                break;
            case "Spanish":
                verifyTextOnWelcomePageNoPolicySpanish();
                break;
            case "Header English":
                basicActions.waitForElementToBePresent(welcomeToConnectText, 10);
                softAssert.assertEquals(welcomeToConnectText.getText(), "Welcome back, " + SharedData.getPrimaryMember().getFirstName() + "!");
                softAssert.assertAll();
                break;
            case "Header Spanish":
                basicActions.waitForElementToBePresent(welcomeToConnectText, 10);
                softAssert.assertEquals(welcomeToConnectText.getText(), "\u00A1Bienvenido/a de nuevo, " + SharedData.getPrimaryMember().getFirstName() + "!");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyTextOnWelcomePageNoPolicyEnglish() {
        basicActions.waitForElementToBePresent(applyForCurrentYearButton, 10);
        softAssert.assertEquals(welcomeToConnectText.getText(), "Welcome back, " + SharedData.getPrimaryMember().getFirstName() + "!");
        softAssert.assertEquals(containerMainHeaderText.getText(), "Apply for health insurance");
        String currentUrl = basicActions.getCurrentUrl();
        if (currentUrl == "https://staging") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "The annual Open Enrollment period for health insurance (October 3 - January 15) is over. However, you may still be eligible to enroll in health insurance if you have a Qualifying Life Event, such as moving to Colorado, getting married or the birth of a child.");
            softAssert.assertEquals(theClickButtonBelowText.getText(), "Click the button below to make changes.");
        } else if (currentUrl == "https://qa") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "The annual Open Enrollment period for health insurance (August 6 - January 8) is over. However, you may still be eligible to enroll in health insurance if you have a Qualifying Life Event, such as moving to Colorado, getting married or the birth of a child. Click the button below to get started.");
        }
        softAssert.assertEquals(applyForCurrentYearButton.getText(), "Apply for 2025");
        softAssert.assertEquals(containerHeaderText.get(0).getText(), "Your current plan(s)");
        softAssert.assertEquals(planYearText.getText(), "Plan Year");
        softAssert.assertEquals(planYearSelectorDp.getText(), "2025\n2024\n2023");
        softAssert.assertEquals(youHaveNotEnrolled.getText(), "You have not yet enrolled in a plan for 2025");
        softAssert.assertEquals(containerHeaderText.get(1).getText(), "Additional Resources");
        softAssert.assertEquals(actionLinks.get(0).getText(), "My Profile");
        softAssert.assertEquals(viewAdditionalResourcesText.get(0).getText(), "View and update your account information");
        softAssert.assertEquals(actionLinks.get(1).getText(), "Application Results");
        softAssert.assertEquals(viewAdditionalResourcesText.get(1).getText(), "View the benefits you're qualified for");
        softAssert.assertEquals(actionLinks.get(2).getText(), "My Plans");
        softAssert.assertEquals(viewAdditionalResourcesText.get(2).getText(), "View past plans. View and cancel current plans.");
        softAssert.assertEquals(actionLinks.get(3).getText(), "My Documents and Letters");
        softAssert.assertEquals(viewAdditionalResourcesText.get(3).getText(), "View your documents");
        softAssert.assertAll();
    }

    public void verifyTextOnWelcomePageNoPolicySpanish() {
        basicActions.waitForElementToBePresent(applyForCurrentYearButton, 10);
        softAssert.assertEquals(welcomeToConnectText.getText(), "\u00A1Bienvenido/a de nuevo, " + SharedData.getPrimaryMember().getFirstName() + "!");
        softAssert.assertEquals(containerMainHeaderText.getText(), "Solicite un seguro de salud");
        String currentUrl = basicActions.getCurrentUrl();
        if (currentUrl == "https://staging") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "El per\u00EDodo anual de inscripci\u00F3n abierta en el seguro de salud (3\u00BA de octubre a 15 de enero) termin\u00F3. Sin embargo, a\u00FAn puede ser elegible para inscribirse en el seguro de salud si se presenta un evento de vida calificado, como mudarse a Colorado, casarse o el nacimiento de un hijo.");
            softAssert.assertEquals(theClickButtonBelowText.getText(), "Haga clic en el bot\u00F3n de abajo para comenzar.");
        } else if (currentUrl == "https://qa") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "El per\u00EDodo anual de inscripci\u00F3n abierta en el seguro de salud (6\u00BA de agosto a 8 de enero) termin\u00F3. Sin embargo, a\u00FAn puede ser elegible para inscribirse en el seguro de salud si se presenta un evento de vida calificado, como mudarse a Colorado, casarse o el nacimiento de un hijo. Haga clic en el bot\u00F3n de abajo para comenzar.");
        }
        softAssert.assertEquals(applyForCurrentYearButton.getText(), "Solicitar para 2025");
        softAssert.assertEquals(containerHeaderText.get(0).getText(), "Sus planes actuales");
        softAssert.assertEquals(planYearText.getText(), "A\u00F1o del plan");
        softAssert.assertEquals(planYearSelectorDp.getText(), "2025\n2024\n2023");
        softAssert.assertEquals(youHaveNotEnrolled.getText(), "A\u00FAn no se ha inscrito en un plan para 2025");
        softAssert.assertEquals(containerHeaderText.get(1).getText(), "Otros recursos");
        softAssert.assertEquals(actionLinks.get(0).getText(), "Mi perfil");
        softAssert.assertEquals(viewAdditionalResourcesText.get(0).getText(), "Ver y actualizar la informaci\u00F3n de su cuenta");
        softAssert.assertEquals(actionLinks.get(1).getText(), "Resultados de la solicitud");
        softAssert.assertEquals(viewAdditionalResourcesText.get(1).getText(), "Ver los beneficios a los que califica");
        softAssert.assertEquals(actionLinks.get(2).getText(), "Mis Planes");
        softAssert.assertEquals(viewAdditionalResourcesText.get(2).getText(), "Ver sus planes anteriores. Ver y cancelar sus planes actuales.");
        softAssert.assertEquals(actionLinks.get(3).getText(), "Mis Documentos y Cartas");
        softAssert.assertEquals(viewAdditionalResourcesText.get(3).getText(), "Vea sus documentos");
        softAssert.assertAll();
    }

    public void validateActionLinksText(String language) {
        basicActions.waitForElementListToBePresent(actionLinks, 5);
        switch (language) {
            case "English":
                softAssert.assertEquals(actionLinks.get(1).getText(), "Application Results");
                softAssert.assertEquals(actionLinks.get(2).getText(), "My Plans");
                softAssert.assertEquals(actionLinks.get(3).getText(), "My Documents and Letters");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(actionLinks.get(1).getText(), "Resultados de la solicitud");
                softAssert.assertEquals(actionLinks.get(2).getText(), "Mis Planes");
                softAssert.assertEquals(actionLinks.get(3).getText(), "Mis Documentos y Cartas");
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

    public void verifyTextOnWelcomePagePolicyEnglish(String policyName, String policyLevel, String policyPremium) {
        basicActions.waitForElementToBePresent(applyForCurrentYearButton, 10);
        softAssert.assertEquals(welcomeToConnectText.getText(), "Welcome back, " + SharedData.getPrimaryMember().getFirstName() + "!");
        softAssert.assertEquals(containerMainHeaderText.getText(), "Make changes to your health insurance");
        String currentUrl = basicActions.getCurrentUrl();
        if (currentUrl == "https://staging") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "The annual Open Enrollment period for health insurance (October 3 - January 15) is over. However, you may still be eligible to enroll in health insurance if you have a Qualifying Life Event, such as moving to Colorado, getting married or the birth of a child.");
            softAssert.assertEquals(theClickButtonBelowText.getText(), "Click the button below to make changes.");
        } else if (currentUrl == "https://qa") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "The annual Open Enrollment period for health insurance (August 6 - January 8) is over. However, you may still be eligible to enroll in health insurance if you have a Qualifying Life Event, such as moving to Colorado, getting married or the birth of a child. Click the button below to make changes.");
        }
        softAssert.assertEquals(applyForCurrentYearButton.getText(), "Make changes");
        //softAssert.assertEquals(btnApplyForNextYearCoco.getText(), "Make changes for 2025");
        softAssert.assertEquals(containerHeaderText.get(0).getText(), "Your current plan(s)");
        softAssert.assertEquals(planYearText.getText(), "Plan Year");
        softAssert.assertEquals(planYearSelectorDp.getText(), "2025\n2024\n2023");
        softAssert.assertEquals(enrolledFirstNames.getText(), SharedData.getPrimaryMember().getFirstName());
        softAssert.assertEquals(enrolledFullNames.getText(), SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(policyMedicalPlan.getText(), "Medical Plan");
        softAssert.assertEquals(policyMedicalDetails.get(0).getText(), policyName);
        softAssert.assertEquals(policyMedicalDetails.get(1).getText(), policyLevel);
        softAssert.assertEquals(policyMedicalDetails.get(3).getText(), "1-877-900-1237");
        softAssert.assertEquals(policyMonthlyDetails.get(0).getText(), "Monthly Plan Payment");
        softAssert.assertEquals(policyMonthlyDetails.get(1).getText(), "$" + policyPremium + "/mo");
        softAssert.assertEquals(containerHeaderText.get(1).getText(), "Additional Resources");
        softAssert.assertEquals(actionLinks.get(0).getText(), "My Profile");
        softAssert.assertEquals(viewAdditionalResourcesText.get(0).getText(), "View and update your account information");
        softAssert.assertEquals(actionLinks.get(1).getText(), "Application Results");
        softAssert.assertEquals(viewAdditionalResourcesText.get(1).getText(), "View the benefits you're qualified for");
        softAssert.assertEquals(actionLinks.get(2).getText(), "My Plans");
        softAssert.assertEquals(viewAdditionalResourcesText.get(2).getText(), "View past plans. View and cancel current plans.");
        softAssert.assertEquals(actionLinks.get(3).getText(), "My Documents and Letters");
        softAssert.assertEquals(viewAdditionalResourcesText.get(3).getText(), "View your documents");
        softAssert.assertAll();
    }

    public void verifyTextOnWelcomePagePolicySpanish(String policyName, String policyLevel, String policyPremium) {
        basicActions.waitForElementToBePresent(applyForCurrentYearButton, 10);
        softAssert.assertEquals(welcomeToConnectText.getText(), "\u00A1Bienvenido/a de nuevo, " + SharedData.getPrimaryMember().getFirstName() + "!");
        softAssert.assertEquals(containerMainHeaderText.getText(), "Hacer cambios a su seguro de salud");
        String currentUrl = basicActions.getCurrentUrl();
        if (currentUrl == "https://staging") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "El per\u00EDodo anual de inscripci\u00F3n abierta en el seguro de salud (3\u00BA de octubre a 15 de enero) termin\u00F3. Sin embargo, a\u00FAn puede ser elegible para inscribirse en el seguro de salud si se presenta un evento de vida calificado, como mudarse a Colorado, casarse o el nacimiento de un hijo.");
            softAssert.assertEquals(theClickButtonBelowText.getText(), "Haga clic en el bot\u00F3n de abajo para comenzar.");
        } else if (currentUrl == "https://qa") {
            softAssert.assertEquals(theAnnualOpenEnrollmentText.getText(), "El per\u00EDodo anual de inscripci\u00F3n abierta en el seguro de salud (6\u00BA de agosto a 8 de enero) termin\u00F3. Sin embargo, a\u00FAn puede ser elegible para inscribirse en el seguro de salud si se presenta un evento de vida calificado, como mudarse a Colorado, casarse o el nacimiento de un hijo. Haga clic en el bot\u00F3n de abajo para hacer cambios.");
        }
        softAssert.assertEquals(applyForCurrentYearButton.getText(), "Hacer cambios");
       // softAssert.assertEquals(btnApplyForNextYearCoco.getText(), "Hacer cambios para 2025");
        softAssert.assertEquals(containerHeaderText.get(0).getText(), "Sus planes actuales");
        softAssert.assertEquals(planYearText.getText(), "A\u00F1o del plan");
        softAssert.assertEquals(planYearSelectorDp.getText(), "2025\n2024\n2023");
        softAssert.assertEquals(enrolledFirstNames.getText(), SharedData.getPrimaryMember().getFirstName());
        softAssert.assertEquals(enrolledFullNames.getText(), SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(policyMedicalPlan.getText(), "Plan m\u00E9dico");
        softAssert.assertEquals(policyMedicalDetails.get(0).getText(), policyName);
        softAssert.assertEquals(policyMedicalDetails.get(1).getText(), policyLevel);
        softAssert.assertEquals(policyMedicalDetails.get(3).getText(), "1-877-900-1237");
        softAssert.assertEquals(policyMonthlyDetails.get(0).getText(), "Pago mensual del plan");
        softAssert.assertEquals(policyMonthlyDetails.get(1).getText(), "$" + policyPremium + "/mes");
        softAssert.assertEquals(containerHeaderText.get(1).getText(), "Otros recursos");
        softAssert.assertEquals(actionLinks.get(0).getText(), "Mi perfil");
        softAssert.assertEquals(viewAdditionalResourcesText.get(0).getText(), "Ver y actualizar la informaci\u00F3n de su cuenta");
        softAssert.assertEquals(actionLinks.get(1).getText(), "Resultados de la solicitud");
        softAssert.assertEquals(viewAdditionalResourcesText.get(1).getText(), "Ver los beneficios a los que califica");
        softAssert.assertEquals(actionLinks.get(2).getText(), "Mis Planes");
        softAssert.assertEquals(viewAdditionalResourcesText.get(2).getText(), "Ver sus planes anteriores. Ver y cancelar sus planes actuales.");
        softAssert.assertEquals(actionLinks.get(3).getText(), "Mis Documentos y Cartas");
        softAssert.assertEquals(viewAdditionalResourcesText.get(3).getText(), "Vea sus documentos");
        softAssert.assertAll();
    }

    public void validateCacBannerText(String language) {
        basicActions.waitForElementToBePresent(containerMainHeaderText, 5);
        switch (language) {
            case "English":
                softAssert.assertEquals(cacBannerHdr.getText(), "Health Insurance News");
                softAssert.assertEquals(cacBannerTxt.getText(), "There have been several important changes to health coverage policies this year. You may have new coverage options for 2025. To see if these changes affect you and your family, take a short quiz.");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(cacBannerHdr.getText(), "Noticia sobre seguros de salud");
                softAssert.assertEquals(cacBannerTxt.getText(), "Este a\u00F1o, se han dado varios cambios importantes en las pol\u00EDticas de cobertura de salud. \u200CEs posible que en 2025 cuente con opciones de cobertura nuevas. Para saber si los cambios le afectan a usted y a su familia, complete la siguiente encuesta breve.");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    private void verifyMemberNamesOnWelcomePage() {
        basicActions.waitForElementToBePresent(welcomeToConnectText, 20);
        basicActions.waitForElementToBePresent(planYearText, 20);
        basicActions.waitForElementToBePresent(medicalMemberNames, 10);
        List<String> memberNamesList = basicActions.getAllMemNames();
        List<String> memberNamesListWelcomePage = new ArrayList<>(Arrays.asList(medicalMemberNames.getText().split(", ")));
        Collections.sort(memberNamesList);
        Collections.sort(memberNamesListWelcomePage);
        softAssert.assertEquals(memberNamesListWelcomePage.size(), memberNamesList.size(), "total names count from sharedData and UI did not match");
        softAssert.assertEquals(memberNamesListWelcomePage, memberNamesList, "Names of members did not match");
    }

    private void verifyMyPlanDetails() {
        MemberDetails primaryMember = SharedData.getPrimaryMember();
        softAssert.assertEquals(planYearSelectorOptions.get(0).getText(), SharedData.getPlanYear(), "Plan Year does not match");
        softAssert.assertEquals(policyMedicalDetails.get(0).getText(), primaryMember.getMedicalPlan(), "Primary Medical Plan Name does not match");
        softAssert.assertEquals(policyMonthlyDetails.get(1).getText().substring(0, 7), "$" + primaryMember.getMedicalPremiumAmt(), "Primary Medical premium amount does not match");
    }
    public void validateMemAndPlanInfo(){
        verifyMemberNamesOnWelcomePage();
        verifyMyPlanDetails();
        softAssert.assertAll();
    }

    public void setScenarioDetailsCoco(List<Map<String, String>> expectedResult) {
        String noOfGroups = expectedResult.get(0).get("totalGroups");
        String totalMembers = expectedResult.get(0).get("totalMembers");
        String totalSubscribers = expectedResult.get(0).get("total_subscribers");
        String totalDependents = expectedResult.get(0).get("total_dependents");
        String totalEnrollees = expectedResult.get(0).get("total_enrollees");
        ScenarioDetails scenarioDetails = new ScenarioDetails();
        scenarioDetails.setTotalGroups(Integer.parseInt(noOfGroups));
        scenarioDetails.setTotalMembers(Integer.parseInt(totalMembers));
        scenarioDetails.setSubscribers(totalSubscribers);
        scenarioDetails.setDependents(totalDependents);
        scenarioDetails.setEnrollees(totalEnrollees);
        SharedData.setScenarioDetails(scenarioDetails);
    }
    public void setDates(List<Map<String, String>> expectedResult) {
        MemberDetails subscriber = SharedData.getPrimaryMember();
        ExpectedCalculatedDates expectedCalculatedDates = new ExpectedCalculatedDates();
        String policyStartDate;
        String policyEndDate;
        String coverageStartDate;
        String coverageEndDate;
        String financialStartDate;
        String financialEndDate;

        if(SharedData.getIsOpenEnrollment().equals("yes")){
            policyStartDate = SharedData.getPlanYear()+"-01-01";
            policyEndDate = SharedData.getPlanYear()+"-12-31";
            coverageStartDate = SharedData.getPlanYear()+"-01-01";
            coverageEndDate = SharedData.getPlanYear()+"-12-31";
            financialStartDate = SharedData.getPlanYear()+"-01-01";
            financialEndDate = SharedData.getPlanYear()+"-12-31";
        } else {
            policyStartDate = basicActions.getDateBasedOnRequirement(expectedResult.get(0).get("PolicyStartDate"));
            policyEndDate = basicActions.getDateBasedOnRequirement(expectedResult.get(0).get("PolicyEndDate"));
            coverageStartDate = basicActions.getDateBasedOnRequirement(expectedResult.get(0).get("CoverageStartDate"));
            coverageEndDate = basicActions.getDateBasedOnRequirement(expectedResult.get(0).get("CoverageEndDate"));
            financialStartDate = basicActions.getDateBasedOnRequirement(expectedResult.get(0).get("FinancialStartDate"));
            financialEndDate = basicActions.getDateBasedOnRequirement(expectedResult.get(0).get("FinancialEndDate"));
        }
        String planStartDate =  basicActions.changeDateFormat(policyStartDate, "yyyy-MM-dd", "MM/dd/yyyy");
        String planEndDate = basicActions.changeDateFormat(policyEndDate, "yyyy-MM-dd", "MM/dd/yyyy");

        expectedCalculatedDates.setPolicyStartDate(policyStartDate);
        expectedCalculatedDates.setPolicyEndDate(policyEndDate);
        expectedCalculatedDates.setCoverageStartDate(coverageStartDate);
        expectedCalculatedDates.setCoverageEndDate(coverageEndDate);
        expectedCalculatedDates.setFinancialStartDate(financialStartDate);
        expectedCalculatedDates.setFinancialEndDate(financialEndDate);

        SharedData.setExpectedCalculatedDates_medicalPlan(expectedCalculatedDates);
        subscriber.setMedicalPlanStartDate(planStartDate);
        subscriber.setMedicalPlanEndDate(planEndDate);

        SharedData.setPrimaryMember(subscriber);

    }

    public void validateNotificationBanner(String language) {
        basicActions.waitForElementToBePresent(containerMainHeaderText, 60);
        basicActions.waitForElementToBePresent(notificationBannerIcon, 60);

        softAssert.assertTrue(notificationBannerIcon.getAttribute("class").contains("feather-alert-triangle"));
        softAssert.assertEquals(notificationBannerIcon.getCssValue("left"), "auto","left error (icon)");
        if (language.equals("English")){
            softAssert.assertEquals(notificationBannerTxt.getText(), "Unable to go to the requested page. Please continue with your application.");
        }else if (language.equals("Spanish")){
            softAssert.assertEquals(notificationBannerTxt.getText(), "No se puede acceder a la p\u00E1gina solicitada. Contin\u00FAe con su solicitud.");
        }
        softAssert.assertEquals(notificationBannerTxt.getCssValue("font"), "16px / 24px \"PT Sans\", sans-serif","font error");
        softAssert.assertEquals(notificationBannerTxt.getCssValue("color"), "rgba(43, 49, 60, 1)","color error"); //#2b313c
        softAssert.assertEquals(notificationBannerTxt.getCssValue("border-color"), "rgb(201, 123, 51)","border-color error"); //#C97B33
        softAssert.assertEquals(notificationBannerTxt.getCssValue("background"), "rgb(248, 239, 229) none repeat scroll 0% 0% / auto padding-box border-box","background error"); //#F8EFE5
        softAssert.assertEquals(notificationBannerTxt.getCssValue("left"), "auto","left error");
        softAssert.assertAll();
    }

    public void validateNoNotificationBanner() {
        basicActions.waitForElementToBePresent(containerMainHeaderText, 5);
        basicActions.waitForElementToDisappear(notificationBannerIcon,5);
        basicActions.waitForElementToDisappear(notificationBannerTxt,5);
    }

    public void validateActionLinks(){
        basicActions.waitForElementToBePresent(applyForCurrentYearButton, 10);
        softAssert.assertEquals(actionLinks.get(0).getCssValue("font-size"),"18px");
        softAssert.assertEquals(actionLinks.get(0).getCssValue("font-weight"),"700");
        softAssert.assertEquals(actionLinks.get(0).getCssValue("line-height"),"28px");
        softAssert.assertEquals(actionLinks.get(0).getCssValue("color"),"rgba(26, 112, 179, 1)");
        softAssert.assertEquals(actionLinks.get(1).getCssValue("font-size"),"18px");
        softAssert.assertEquals(actionLinks.get(1).getCssValue("font-weight"),"700");
        softAssert.assertEquals(actionLinks.get(1).getCssValue("line-height"),"28px");
        softAssert.assertEquals(actionLinks.get(1).getCssValue("color"),"rgba(26, 112, 179, 1)");
        softAssert.assertEquals(actionLinks.get(2).getCssValue("font-size"),"18px");
        softAssert.assertEquals(actionLinks.get(2).getCssValue("font-weight"),"700");
        softAssert.assertEquals(actionLinks.get(2).getCssValue("line-height"),"28px");
        softAssert.assertEquals(actionLinks.get(2).getCssValue("color"),"rgba(26, 112, 179, 1)");
        softAssert.assertAll();
        actions.moveToElement(actionLinks.get(0)).perform();
        basicActions.wait(300);
        softAssert.assertEquals(actionLinks.get(0).getCssValue("color"),"rgba(22, 156, 216, 1)");
        softAssert.assertAll();
        actions.moveToElement(actionLinks.get(1)).perform();
        basicActions.wait(300);
        softAssert.assertEquals(actionLinks.get(1).getCssValue("color"),"rgba(22, 156, 216, 1)");
        softAssert.assertAll();
        actions.moveToElement(actionLinks.get(1)).perform();
        basicActions.wait(300);
        softAssert.assertEquals(actionLinks.get(1).getCssValue("color"),"rgba(22, 156, 216, 1)");
        softAssert.assertAll();
    }
}


