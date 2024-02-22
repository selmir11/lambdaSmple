package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
public class GroupingMembersMedical {
    @FindBy(xpath = "//*[text() = 'Medical Group # 1']")
    WebElement medicalGroup1;
    @FindBy(xpath = "//*[text() = ' Medical Enrollment Groups ']")
    WebElement medicalEnrollmentGroupPageTitle;
    @FindBy(xpath = "//*[text() = 'It may be cheaper to separate your household into groups and enroll in different plans. We suggest the following groups, but you can use what works best for you. ']")
    WebElement groupingPageText;
    @FindBy(xpath = "//*[text() = 'Remember: Costs within a group count towards each group’s deductible and out of pocket maximum.']")
    WebElement rememberText;
    @FindBy(id="SHP-MedicalGroupingMembers-EditMyEnrollmentGroups")
    WebElement editMyEnrollmentGroupsButton;
    @FindBy(xpath = "//div/button[@id='SHP-MedicalGroupingMembers-GoBack']")
    WebElement goBackButton;
    @FindBy(id= "SHP-MedicalGroupingMembers-SaveAndExit")
    WebElement saveAndExitButton;
    @FindBy(id = "SHP-MedicalGroupingMembers-Continue")
    WebElement continueButton;
    @FindBy(id = "globe-image")
    WebElement glodeImageDropdown;
    @FindBy(xpath = "//*[text()='English']")
    WebElement selectEnglishText;
    @FindBy(xpath = "//*[@id='globe']/div/p[2]")
    WebElement selectSpanish;
    @FindBy(xpath = "//*[text() = ' Grupos de inscripción en el plan médico ']")
    WebElement groupingPageTitleSpanish;
    @FindBy(xpath = "//*[text() = 'Puede ser más barato separar a su familia en grupos e inscribirlos en diferentes planes. Le sugerimos los grupos a continuación, pero puede hacerlo como mejor funcione para usted. ']")
    WebElement spanishSuggestionText;
    @FindBy(xpath = "//*[text() = 'Recuerde: Los costos dentro de un grupo cuentan hacia el deducible y desembolso máximo de cada grupo.']")
    WebElement rememberTextSpanish;
    @FindBy(xpath = "//*[text() = 'Número de Grupo médico # 1']")
    WebElement medicalSpanishGroup1;
    @FindBy(xpath = "//*[text() = 'Número de Grupo médico # 2']")
    WebElement medicalSpanishGroup2;
    @FindBy(xpath = "//*[text()='Volver']")
    WebElement volverButtonInSpanish;
    @FindBy(xpath = "//*[text() = 'Guardar y salir ']")
    WebElement saveAndExitSpanish;
    @FindBy(xpath = "//*[text() = 'Continuar']")
    WebElement continueSpanish;
    @FindBy(xpath = "//*[contains(text(),'Cerrar')]")
    WebElement signOutOnGroupingPageSpanish;

    private BasicActions basicActions;
    public GroupingMembersMedical() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }
    SoftAssert softAssert = new SoftAssert();
    public void clickContinue(){
        continueButton.click();
    }

    public void clickGoBackButton(){
        softAssert.assertTrue(basicActions.waitForElementToBePresent(goBackButton, 20));
        basicActions.waitForElementToBeClickable(goBackButton,10);
        goBackButton.click();
    }
    public void clickContinuarSpanish(){
        continueSpanish.click();
    }
    public void selectGlobalImageDropdown(){
        basicActions.waitForElementToBeClickable(glodeImageDropdown,10);
        glodeImageDropdown.click();
    }
    public void selectSpanishLanguage(){
        basicActions.waitForElementToBePresent(selectSpanish,10);
        selectSpanish.click();
    }
    public void clickOnEditMedicalGroupinglink(){
        basicActions.waitForElementToBeClickable(editMyEnrollmentGroupsButton,30);
        editMyEnrollmentGroupsButton.click();
    }
    public void clickSignOut(){
        basicActions.waitForElementToBeClickable(signOutOnGroupingPageSpanish,10);
        signOutOnGroupingPageSpanish.click();
    }
    //--------------------------validations------------------------
    public void verifyMedicalGroupingPage(){
        softAssert.assertEquals(medicalEnrollmentGroupPageTitle, "Medical Enrollment Groups");
        softAssert.assertEquals(groupingPageText,"It may be cheaper to separate your household into groups and enroll in different plans. We suggest the following groups, but you can use what works best for you.");
        softAssert.assertEquals(rememberText,"Remember: Costs within a group count towards each group’s deductible and out of pocket maximum.");
        softAssert.assertEquals(medicalGroup1,"Medical Group # 1");
        softAssert.assertEquals(editMyEnrollmentGroupsButton,"Edit my enrollment groups");
        softAssert.assertEquals(goBackButton,"Go Back");
        softAssert.assertEquals(saveAndExitButton,"Save and Exit");
        softAssert.assertEquals(continueButton,"Continue");
        softAssert.assertTrue(glodeImageDropdown.isEnabled());
    }
    public void verifySpanishTextMedicalGroupingPage(){
        basicActions.waitForElementToBePresent(groupingPageTitleSpanish,10);
        softAssert.assertEquals(groupingPageTitleSpanish,"Grupos de inscripción en el plan médico");
        softAssert.assertEquals(spanishSuggestionText,"Puede ser más barato separar a su familia en grupos e inscribirlos en diferentes planes. Le sugerimos los grupos a continuación, pero puede hacerlo como mejor funcione para usted.");
        softAssert.assertEquals(rememberTextSpanish,"Recuerde: Los costos dentro de un grupo cuentan hacia el deducible y desembolso máximo de cada grupo.");
        softAssert.assertEquals(medicalSpanishGroup1,"Número de Grupo médico # 1");
        softAssert.assertEquals(medicalSpanishGroup2,"Número de Grupo médico # 2");
        softAssert.assertEquals(editMyEnrollmentGroupsButton,"Editar mis grupos de inscripción");
        softAssert.assertEquals(volverButtonInSpanish,"Volver");
        softAssert.assertEquals(saveAndExitSpanish,"Guardar y salir");
        softAssert.assertEquals(continueSpanish,"Continuar");
        softAssert.assertTrue(volverButtonInSpanish.isEnabled());
        softAssert.assertTrue(saveAndExitSpanish.isEnabled());
        softAssert.assertTrue(continueSpanish.isEnabled());
    }
}
