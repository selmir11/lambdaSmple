package com.c4hco.test.automation.stepDefinitions.APISteps;

import com.c4hco.test.automation.pages.API.APTCCalculator;
import io.cucumber.java.en.When;

public class APTCCalculatorSteps {

    APTCCalculator aptcCalculator = new APTCCalculator();
    @When("I send an APTCCalculator Request with Magi {string}, Zip {string}, Fips {string}, FPL {string}, DOB {string} and expect APTC {string} and Contribution Amount {string}")
    public void testAPTCRequest(String magi, String zipCode, String fipsCode, String fpl, String dateOfBirth, String expectedAPTC, String contribution){aptcCalculator.SendAPTCRequest(magi, zipCode, fipsCode, fpl, dateOfBirth, expectedAPTC, contribution);}
}
