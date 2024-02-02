package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.EmploymentInfoPage;
import io.cucumber.java.en.And;

public class EmploymentInfoPageSteps {

    EmploymentInfoPage employmentInfoPage = new EmploymentInfoPage();

    @And("I enter employment details with {string} annual income")
        public void iEnterEmploymentDetails(String Salary){ employmentInfoPage.addEmploymentInfo(Salary);}
}
