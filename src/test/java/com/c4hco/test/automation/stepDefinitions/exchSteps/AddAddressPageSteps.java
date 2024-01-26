package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.AddAddressPage;
import io.cucumber.java.en.*;

public class AddAddressPageSteps {
    AddAddressPage addAddressPage = new AddAddressPage();

     @Then("I enter Additional details and click continue on add address page")
    public void additionalDetails() {
         addAddressPage.mailingAddress();
         addAddressPage.selectCounty();
         addAddressPage.coloradoResidentYes();
         addAddressPage.tribeNo();
         addAddressPage.hardshipExempNo();
         addAddressPage.noDisability();
         addAddressPage.deniedMedicaid();
         addAddressPage.notIncarcerated();
         addAddressPage.saveContinue();
     }
}
