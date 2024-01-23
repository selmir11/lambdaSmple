package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.TellUsAboutYourself_LR;
import io.cucumber.java.en.*;

public class TellUsAboutYourselfSteps_LR {
    TellUsAboutYourself_LR tellUs = new TellUsAboutYourself_LR();

    @And("I enter details on tell us about yourself page and continue")
    public void additionaldetailsOfYourself(){
        tellUs.chooseMale();
        tellUs.chooseApplyYes();
        tellUs.saveAndContinue();

    }
}
