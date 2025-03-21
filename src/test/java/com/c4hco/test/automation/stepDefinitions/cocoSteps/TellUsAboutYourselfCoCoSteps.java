package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.TellUsAboutYourselfCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class TellUsAboutYourselfCoCoSteps {
    TellUsAboutYourselfCoCoPage tellUsAboutYourselfCoCoPage = new TellUsAboutYourselfCoCoPage(WebDriverManager.getDriver());

    @Then("I enter details on tell us about yourself page and continue with {string}, {string}, and applying {string}")
    public void EnterSpecificMemberDetailsCoCo(String dateOfBirth, String gender, String applying){tellUsAboutYourselfCoCoPage.specificMemberDetailsCoCo(dateOfBirth, gender, applying); }

    @Then("I click Save and Continue only on the tell us about yourself page")
    public void iClickSaveAndContinueButton(){tellUsAboutYourselfCoCoPage.clickSaveAndContinueButton();}

    @Then("I click Go Back on the tell us about yourself page")
    public void clickGoBack() {
        tellUsAboutYourselfCoCoPage.clickGoBackButton();
    }

    @Then("I enter first name and last name on Tell Us About Yourself Page Coco")
    public void ienterPrimaryFirstLastInfo() {
        tellUsAboutYourselfCoCoPage.enterPrimaryFirstLastInfo();
    }

    @Then("I enter new first name and last name on Tell Us About Yourself Page Coco")
    public void ienterPrimaryNewFirstLastInfo() {
        tellUsAboutYourselfCoCoPage.enterPrimaryNewFirstLastInfo();
    }

    @And("I enter the primary member middle name on tell us about yourself page coco")
    public void enterMiddleName(){
        tellUsAboutYourselfCoCoPage.enterPrimaryMemMiddleName();
    }

    @And("I enter the primary member new middle name on tell us about yourself page coco")
    public void enterNewMiddleName(){
        tellUsAboutYourselfCoCoPage.enterPrimaryMemNewMiddleName();
    }

    @And("I enter the primary member suffix as {string} on tell us about yourself page coco")
    public void enterSuffix(String suffix){
        tellUsAboutYourselfCoCoPage.enterSuffix(suffix);
    }

    @And("I enter details on tell us about yourself page with dob {string}, gender {string}, and applying {string}")
    public void enterMemberDetailsCoCo(String dateOfBirth, String gender, String applying){tellUsAboutYourselfCoCoPage.addMemberDetailsCoCo(dateOfBirth, gender, applying); }

    @And("I validate the page text on Tell us about Yourself {string}")
    public void iverifyTextOnTellUsAboutYourselfPage(String language)  { tellUsAboutYourselfCoCoPage.verifyTextOnTellUsAboutYourselfPage(language); }

    @Then("I validate errors are displaying on Tell Us About Yourself Page CoCo {string}")
    public void iverifyErrorTextOnTellUsAboutYourselfPage(String language){tellUsAboutYourselfCoCoPage.verifyErrorTextOnTellUsAboutYourselfPage(language); }

    @Then("I validate the member names displayed in the label text above relationship dropdown field in Tell us About yourself page")
    public void iValidateRelationshipLabel() {
        tellUsAboutYourselfCoCoPage.validateRelationshipLabel();
    }

    @Then("I validate the data entered is saved on tell us about yourself page")
    public void validateData(){
        tellUsAboutYourselfCoCoPage.validateDataEntered();
    }

    @Then("I validate the auto-populated option in the relationship dropdown field on the Tell us About Yourself page")
    public void iValidateRelationshipOption(List<String> Relationship) {
        tellUsAboutYourselfCoCoPage.validateAutoPopRelationshipOption(Relationship);
    }
    @Then("I update full name of member with prefix {string} in coco")
    public void updateName(String namePrefix) {
        tellUsAboutYourselfCoCoPage.updateFullName(namePrefix);
    }

    @And("I update applying for coverage to {string} in coco")
    public void applyingForCoverage(String applying) {tellUsAboutYourselfCoCoPage.applyingForCoverage(applying);}

    @And("I update the gender selection to {string} in coco")
    public void genderSelection(String gender) {tellUsAboutYourselfCoCoPage.genderSelection(gender);
    }
}
