package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.CitizenshipandImmigration_LR;
import io.cucumber.java.en.*;

public class CitizenshipandImmigrationSteps_LR {

    CitizenshipandImmigration_LR citizenship = new CitizenshipandImmigration_LR();

    @And("I enter citizenship details and click continue")
    public void citizenshipPage(){
        citizenship.citizen();
        citizenship.naturalized();
        citizenship.save();
    }
}
