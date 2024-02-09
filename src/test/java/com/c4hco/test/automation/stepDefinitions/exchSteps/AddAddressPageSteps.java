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

    @Then("I enter Additional details and I'm not Co resident and click continue on add address page")
    public void additionalDetailsNotCoResident() {
        addAddressPage.mailingAddress();
        addAddressPage.selectCounty();
        addAddressPage.coloradoResidentNo();
        addAddressPage.tribeNo();
        addAddressPage.hardshipExempNo();
        addAddressPage.noDisability();
        addAddressPage.deniedMedicaid();
        addAddressPage.notIncarcerated();
        addAddressPage.saveContinue();
    }

    @Then("I enter Additional details for addresses, residency, federal tribe and click continue on add address page")
    public void additionalDetailsForAddressesResidencyTribe() {
        addAddressPage.mailingAddress();
        addAddressPage.selectCounty();
        addAddressPage.coloradoResidentYes();
        addAddressPage.tribeNo();
        addAddressPage.saveContinue();
    }
}
