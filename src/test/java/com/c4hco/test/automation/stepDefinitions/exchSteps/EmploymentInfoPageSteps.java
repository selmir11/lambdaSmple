package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.EmploymentInfoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EmploymentInfoPageSteps {

    EmploymentInfoPage employmentInfoPage = new EmploymentInfoPage(WebDriverManager.getDriver());

    @Then("I select the option {string} to employment")
    public void selectEmployment(String Employment){employmentInfoPage.isUserEmployed(Employment);}

    @And("I select the option {string} to self employment")
    public void selectSelfEmployment(String SelfEmployment){employmentInfoPage.isUserSelfEmplyed(SelfEmployment);}

    @And("I enter employment details with {string} income at {string} frequency")
    public void iEnterEmploymentDetails(String Salary, String Frequency){employmentInfoPage.addEmploymentInfo(Salary, Frequency);}
    @Then("I enter company details with addressline1 as {string} and city as {string} and state as {string} and zipcode as {string} and income {string} at frequency {string}")
    public void ienterCompanyDetails(String addressline1,String city,String state,String zipcode,String income,String frequency){
        employmentInfoPage.genericEmploymentInfo(addressline1, city, state, zipcode, income, frequency);
    }

    @And( "I edit the income level to {string}")
    public void iEnterEmploymentIncome(String Salary){employmentInfoPage.enterEmploymentIncome(Salary);}

    @And("I select the option {string} to seasonal employment")
    public void selectSeasonalEmployment(String SeasonalEmployment){employmentInfoPage.isUserEmploymentSeasonal(SeasonalEmployment);}

    @And("I select the option {string} to projected income")
    public void selectProjectedIncome(String ProjectedIncome){employmentInfoPage.projectedIncomeQuestion(ProjectedIncome);}

    @And("I click continue on the Employment Info Page")
    public void saveAndContinue(){employmentInfoPage.saveAndContinue();}

    @And("I select {string} icon on the Employment Info Page")
    public void iSelectGeneralHelpIcon(String labelIcon){employmentInfoPage.clickHelpIcon(labelIcon);}

    @Then("I validate help drawer header verbiage in {string}")
    public void iValidateHelpHeader(String languageSelection){employmentInfoPage.validateHelpHeaderVerbiage(languageSelection);}

    @Then("I validate general help drawer body verbiage in {string}")
    public void iValidateGeneralHelpBody(String languageOption){employmentInfoPage.validateGeneralHelpBodyVerbiage(languageOption);}

    @Then("I validate help drawer footer verbiage in {string}")
    public void iValidateHelpFooter(String languageSelection){employmentInfoPage.validateHelpFooterVerbiage(languageSelection);}

    @And("I click Contact Us link in help drawer footer")
    public void iClickHelpContactUsLink(){employmentInfoPage.clickHelpContactUsNavigation();}

    @Then("I validate job question verbiage in {string}")
    public void iValidateJobQsHelpVerbiage(String languageSelection){employmentInfoPage.validateJobQuestionsHelpVerbiage(languageSelection);};

    @Then("I validate Employment Info Page header in {string}")
    public void iValidateHeaderOnEmploymentInfo(String languageSelection){employmentInfoPage.validateHeaderOnEmploymentInfo(languageSelection);};

    @Then("I validate Company verbiage in {string}")
    public void iValidateCompanyQsHelpVerbiage(String languageSelection){employmentInfoPage.validateCompanyHelpVerbiage(languageSelection);};

    @Then("I validate Net Income verbiage in {string}")
    public void iValidateNetIncomeQsHelpVerbiage(String languageSelection){employmentInfoPage.validateNetIncomeHelpVerbiage(languageSelection);};

    @Then("I validate Income Change verbiage in {string}")
    public void iValidateIncomeChangeQsHelpVerbiage(String languageSelection){employmentInfoPage.validateIncomeChangeHelpVerbiage(languageSelection);};

    @Then("I select the EditUpdate link for employer {int}")
    public void iClickEditUpdateLink(int index){employmentInfoPage.clickEditUpdateLink(index);}

}
