package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.AddAddressPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

public class AddAddressPageSteps {
    AddAddressPage addAddressPage = new AddAddressPage(WebDriverManager.getDriver());

     //Handles the 'What is your residential address?' question.
     //Accepts 'Household' for first radio button or 'New' for the second.
     @Then("I select {string} for Residential Address")
    public void memberResidentialAddress(String Address){addAddressPage.selectResidentialAddress(Address);}

    @And("I enter the new residential address details")
    public void addNewResidentialAddress(List<Map<String, String>> addressDetails){
         addAddressPage.addNewResidentialAddress(addressDetails);}

    @And("I enter a new residential address with city {string} state {string} zip {string} and county {string}")
    public void addResidentialAddressDetails(String city, String state, String zipcode, String county){addAddressPage.newResidentialAddress(city, state, zipcode, county);}

    @Then("I enter member with address line1 {string} in city {string} in state {string} with zipcode {string} and county {string}")
    public void mailingAddress(String addrLine1,String city,String state,String zipcode,String county){
        addAddressPage.specificMailingAddress(addrLine1, city, state, zipcode,county);}

    @Then("I enter generic mailing address details")
    public void addMailingAddressDetails(){addAddressPage.mailingAddress();}

    @Then("I enter a new member address with city {string} state {string} zip {string} and county {string}")
    public void addMailingAddressDetails(String city, String state, String zipcode, String county){addAddressPage.newMailingAddress(city, state, zipcode, county);}

    @Then("I select {string} for CO Resident option")
    public void isMemberCOResident(String YNResident){addAddressPage.isColoradoResident(YNResident);}

    @Then("I select {string} for Federally Recognized Tribe option")
    public void isMemberPartOfTribe(String YNTribe){addAddressPage.isFederallyRecognizedTribe(YNTribe);}

    @Then("I select {string} for Hardship Exemption option")
    public void isMemberHardshipExempt(String YNExempt){addAddressPage.isMemberHardshipExempt(YNExempt);}

    @Then("I select {string} for Disability option")
    public void isMemberDisabled(String YNDisabled){addAddressPage.isMemberDisabled(YNDisabled);}

    @Then("I select {string} to the recently denied medicaid question")
    public void hasMemberBeenDeniedRecently(String YNDenied){addAddressPage.hasUserBeenDeniedMedicaid(YNDenied);}

    @Then("I select {string} for Incarceration option")
    public void isMemberIncarcerated(String YNIncacerated){addAddressPage.isUserIncarcerated(YNIncacerated);}

    @Then("I select {string} for Fulltime Student option")
    public void isMemberStudent(String YNStudent){addAddressPage.isMemberStudent(YNStudent);}

    @Then("I select {string} for Foster care in state of Colorado")
    public void isMemberInFosterCare(String YNFosterCare){
         addAddressPage.isUserInFosterCare(YNFosterCare);
    }

    @Then("I click continue on the Add Address page")
    public void clickContinue(){addAddressPage.saveContinue();}

    @Then("I add the tribe details")
    public void Addtribedetails(){addAddressPage.Addtribedetails();}

    @Then("I select {string} specific Address")
    public  void selectspecificaddress(String SpecificAddress){addAddressPage.specificaddress(SpecificAddress); }

}

