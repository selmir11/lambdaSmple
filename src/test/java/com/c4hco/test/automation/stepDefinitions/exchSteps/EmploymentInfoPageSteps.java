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

    @And("I select the option {string} to seasonal employment")
    public void selectSeasonalEmployment(String SeasonalEmployment){employmentInfoPage.isUserEmploymentSeasonal(SeasonalEmployment);}

    @And("I select the option {string} to projected income")
    public void selectProjectedIncome(String ProjectedIncome){employmentInfoPage.projectedIncomeQuestion(ProjectedIncome);}

    @And("I click continue on the Employment Info Page")
    public void saveAndContinue(){employmentInfoPage.saveAndContinue();}

    @And("I maximize the help drawer on the Employment Info Page")
    public void iMaximizeHelpDrawer(){employmentInfoPage.maximizeHeldDrawer();}

    @Then("I validate help drawer header verbiage in {string}")
    public void iValidateHelpHeader(String languageSelection){employmentInfoPage.validateHelpHeaderVerbiage(languageSelection);}

    @Then("I validate general help drawer body verbiage in {string}")
    public void iValidateGeneralHelpBodyEng(String language){employmentInfoPage.validateGeneralHelpBodyVerbiage(language);}

    @Then("I validate help drawer footer verbiage in {string}")
    public void iValidateHelpFooter(String languageSelection){employmentInfoPage.validateHelpFooterVerbiage(languageSelection);}

    @And("I click Contact Us link in help drawer footer")
    public void iClickHelpContactUsLink(){employmentInfoPage.clickHelpContactUsNavigation();}
}
