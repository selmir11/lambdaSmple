package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.AdditinalInfoForYourself_LR;
import io.cucumber.java.en.*;

public class AdditinalInfoForYourselfSteps_LR {
    AdditinalInfoForYourself_LR additinalInfo = new AdditinalInfoForYourself_LR();

     @Then("I enter Additional details and click continue")
    public void additionalDetails() throws InterruptedException {
         additinalInfo.mailingAddress();
         additinalInfo.selectCounty();
         additinalInfo.coloradoResidentYes();
         additinalInfo.tribeNo();
         additinalInfo.hardshipExempNo();
         additinalInfo.noDisability();
         additinalInfo.deniedMedicaid();
         additinalInfo.notIncarcerated();
         additinalInfo.saveContinue();

     }
}
