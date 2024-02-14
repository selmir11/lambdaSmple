package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.EmploymentInfoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EmploymentInfoPageSteps {

    EmploymentInfoPage employmentInfoPage = new EmploymentInfoPage();

    @Then("I select the option {string} to employment")
    public void selectEmployment(String Employment){employmentInfoPage.isUserEmployed(Employment);}

    @And("I select the option {string} to self employment")
    public void selectSelfEmployment(String SelfEmployment){employmentInfoPage.isUserSelfEmplyed(SelfEmployment);}

    @And("I enter employment details with {string} income at {string} frequency")
    public void iEnterEmploymentDetails(String Salary, String Frequency){employmentInfoPage.addEmploymentInfo(Salary, Frequency);}

    @And("I select the option {string} to seasonal employment")
    public void selectSeasonalEmployment(String SeasonalEmployment){employmentInfoPage.isUserEmploymentSeasonal(SeasonalEmployment);}

    @And("I select the option {string} to projected income")
    public void selectProjectedIncome(String ProjectedIncome){employmentInfoPage.projectedIncomeQuestion(ProjectedIncome);}

    @And("I click continue on the Employment Info Page")
    public void saveAndContinue(){employmentInfoPage.saveAndContinue();}
}
