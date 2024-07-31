package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.TellUsAboutAdditionalMemberPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class TellUsAboutAdditionalMembersPageSteps {

    TellUsAboutAdditionalMemberPage tellUsAboutAdditionalMemberPage = new TellUsAboutAdditionalMemberPage(WebDriverManager.getDriver());


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

    @And("I select {string} as relationship one option")
    public void selectRelationship1(String Relationship1){tellUsAboutAdditionalMemberPage.setSelectRelationship1(Relationship1);}
    @And("I select {string} as relationship two option")
    public void selectRelationship2(String Relationship2){tellUsAboutAdditionalMemberPage.setSelectRelationship2(Relationship2);}
    @And("I select {string} as relationship three option")
    public void selectRelationship3(String Relationship3){tellUsAboutAdditionalMemberPage.setSelectRelationship3(Relationship3);}

    @And("I select {string} as relationship four option")
    public void selectRelationship4(String Relationship4){tellUsAboutAdditionalMemberPage.setSelectRelationship4(Relationship4);}

    @And("I select {string} to Is Member Applying")
    public void isMemberApplying(String isApplying){tellUsAboutAdditionalMemberPage.isMemberApplyingForInsurance(isApplying);}

    @And("I click continue on Tell us about additional members page")
    public void clickSaveAndContinue(){tellUsAboutAdditionalMemberPage.clickSaveAndContinue();}

    @Then("I enter member details with age as {int}")
    public void iEnterMemberDetailsAge(int Age){tellUsAboutAdditionalMemberPage.memberDetailswithAge(Age);}


    @Then("I enter new born with minus {int} days as DOB")
    public void iEnterMemberDOBwithminusfive(int Days){tellUsAboutAdditionalMemberPage.Newbornwithcurrentdatelessthanfivedays(Days);}

    @Then("I enter details on tell us about additional members of your household exch page and continue with {string}, {string}, {string} and applying {string}")
    public void EnterspecificAdditionalMemberDetailsExch(String Name, String DOB, String gender, String applying, List<String> Relations) {
        tellUsAboutAdditionalMemberPage.specificAdditionalMemberDetailsExch(Name, DOB, gender, Relations, applying);
    }

}
