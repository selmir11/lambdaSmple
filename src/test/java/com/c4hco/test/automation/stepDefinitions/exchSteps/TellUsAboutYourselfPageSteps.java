package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.TellUsAboutYourselfPage;
import io.cucumber.java.en.*;

public class TellUsAboutYourselfPageSteps {
    TellUsAboutYourselfPage tellUsAboutYourselfPage = new TellUsAboutYourselfPage();

    @And("I enter details on tell us about yourself page and continue")
    public void additionaldetailsOfYourself(){
        tellUsAboutYourselfPage.chooseMale();
        tellUsAboutYourselfPage.chooseApplyYes();
        tellUsAboutYourselfPage.saveAndContinue();

    }
    @Then("I enter details and I'm not applying for insurance on tell us about yourself page and continue")
    public void provideDetailsOfYourselfNotApplyingForInsurance() {
        tellUsAboutYourselfPage.chooseMale();
        tellUsAboutYourselfPage.chooseApplyNo();
        tellUsAboutYourselfPage.saveAndContinue();
    }
}
