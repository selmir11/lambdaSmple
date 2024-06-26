package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.WhoAreYouPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class WhoAreYouPageSteps {
    WhoAreYouPage whoAreYouPage = new WhoAreYouPage(WebDriverManager.getDriver());

    @Then("I select {string} from the who are you question")
    public void checkWhoAreYouBox(String whoAreYouOption) {
        whoAreYouPage.checkWhoAreYouOption(whoAreYouOption);
    }

    //include that you are clicking on Continue button in the step below
    @And("I am a member with City {string} in State {string} with dob {string} in county {string} with zipcode {string}")
    public void enterSpecificMemberDetails(String City, String State, String dateOfBirth, String county, String zipcode) {
        whoAreYouPage.enterSpecificMemberDetailsAndContinue(City, State, zipcode, county, dateOfBirth);
    }

    @And("I enter details with city {string}, state {string}, dob {string}, county {string} and zipcode {string}")
    public void enterMemberDetails(String City, String State, String dateOfBirth, String county, String zipcode) {
        whoAreYouPage.enterSpecificMemberDetails(City, State, zipcode, county, dateOfBirth);
    }

    @Then("I click the who are you save and continue button")
    public void saveAndContinue(){
        whoAreYouPage.saveAndContinue();
    }

}
