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
    @And("I am a member with dob {string} in county {string} with zipcode {string}")
    public void enterSpecificMemberDetails(String dateOfBirth, String county, String zipcode){whoAreYouPage.specificMemberDetails(zipcode, county, dateOfBirth);}

    @Then("I update SSN number to new SSN number")
    public void updateSSN(){
        // TO DO: Modify this method and step - separate continue
        // Check if continue buttons are same always or it changes the button - continue, save and continue
        whoAreYouPage.iUpdateSSN();
        whoAreYouPage.iClickContinueAfterSSNUpdate();
    }

    @And("I am a member with City {string} in State {string} with dob {string} in county {string} with zipcode {string}")
    public void enterSpecificMemberDetailsCityAndState(String City, String State, String dateOfBirth, String county, String zipcode){whoAreYouPage.specificMemberDetailsWithCityAndState(City, State, zipcode, county, dateOfBirth);}
}
