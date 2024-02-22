package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.TellUsAboutAdditionalMemberPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class TellUsAboutAdditionalMembersPageSteps {

    TellUsAboutAdditionalMemberPage tellUsAboutAdditionalMemberPage = new TellUsAboutAdditionalMemberPage();

    @Then("I enter member details with {string} date of birth")
    public void iEnterMemberDetailsDOB(String DOB){tellUsAboutAdditionalMemberPage.enterMemberDetails(DOB);}

    @And("I select {string} as member's sex option")
    public void selectSexOption(String sexOption){tellUsAboutAdditionalMemberPage.selectSex(sexOption);}
    @And("I mark the Additional member is pregnant as {string}")
    public void selectPersonIsPregnant(String pregnant){
        tellUsAboutAdditionalMemberPage.selectIsPersonPregnant(pregnant);
    }
    @And("I select {string} as relationship option")
    public void selectRelationship(String Relationship){tellUsAboutAdditionalMemberPage.setSelectRelationship(Relationship);}

    @And("I select {string} to Is Member Applying")
    public void isMemberApplying(String isApplying){tellUsAboutAdditionalMemberPage.isMemberApplyingForInsurance(isApplying);}

    @And("I click continue on Tell us about additional members page")
    public void clickSaveAndContinue(){tellUsAboutAdditionalMemberPage.clickSaveAndContinue();}
}
