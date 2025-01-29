package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.TellUsAboutAdditionalMemberPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class TellUsAboutAdditionalMembersPageSteps {

    TellUsAboutAdditionalMemberPage tellUsAboutAdditionalMemberPage = new TellUsAboutAdditionalMemberPage(WebDriverManager.getDriver());

    @And("I mark the Additional member is pregnant as {string}")
    public void selectPersonIsPregnant(String pregnant){
        tellUsAboutAdditionalMemberPage.selectIsPersonPregnant(pregnant);
    }

    @And("I click continue on Tell us about additional members page")
    public void clickSaveAndContinue(){tellUsAboutAdditionalMemberPage.clickSaveAndContinue();}

    @And("I select no SSN for {string}")
    public void selectNoSSn(String memberPrefix){tellUsAboutAdditionalMemberPage.selectNoSSn(memberPrefix);}

    @And("I get the newborn {string} dob as {string}")
    public void iGetMemberDOB(String namePrefix, String dob){tellUsAboutAdditionalMemberPage.getDob(namePrefix, dob);}

    @Then("I enter details on tell us about additional members of your household exch page and continue with {string}, {string}, {string} and applying {string}")
    public void EnterspecificAdditionalMemberDetailsExch(String Name, String DOB, String gender, String applying, List<String> Relations) {
        tellUsAboutAdditionalMemberPage.specificAdditionalMemberDetailsExch(Name, DOB, gender, Relations, applying);
    }

    @Then("I enter details on tell us about additional members same as primary")
    public void AdditionalMemberDetailsSameasPrimary(List<String> Relations) {
        tellUsAboutAdditionalMemberPage.AdditionalMemberDetailsSameasPrimary( Relations);
    }

    @Then("I update member SSN number to new SSN number {string}")
    public void iUpdateMemSSN(String updatedSSN) {tellUsAboutAdditionalMemberPage.updateMemSSN(updatedSSN);
    }
}
