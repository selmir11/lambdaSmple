package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.WhoAreYouPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class WhoAreYouPageSteps {
    WhoAreYouPage whoAreYouPage = new WhoAreYouPage(WebDriverManager.getDriver());

    @Then("I select {string} from the who are you question")
    public void checkWhoAreYouBox(String whoAreYouOption){
        whoAreYouPage.checkWhoAreYouOption(whoAreYouOption);
    }

    //include that you are clicking on Continue button in the step below
    @And("I am a member with City {string} in State {string} with dob {string} in county {string} with zipcode {string}")
    public void enterSpecificMemberDetails(String City, String State, String dateOfBirth, String county, String zipcode) {whoAreYouPage.specificMemberDetails(City, State, zipcode, county, dateOfBirth);}

    @And("I am a member with SSN {string} City {string} in State {string} with dob {string} in county {string} with zipcode {string}")
    public void enterSpecificMemberSsnDetails(String ssn, String City, String State, String dateOfBirth, String county, String zipcode) {whoAreYouPage.specificMemberSsnDetails(ssn, City, State, zipcode, county, dateOfBirth);}

    @Then("I click back button on Who Are You Page")
    public void iClickOnBackButton(){
        whoAreYouPage.clickBackButton();
    }

}
