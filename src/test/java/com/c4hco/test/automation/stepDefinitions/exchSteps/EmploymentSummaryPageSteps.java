package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.EmploymentSummaryPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmploymentSummaryPageSteps {
    EmploymentSummaryPage employmentSummaryPage = new EmploymentSummaryPage(WebDriverManager.getDriver());

    @Then("I click continue on the Employment Summary Page")
        public void iClickContinueEmpSummary(){employmentSummaryPage.clickContinue();}

    @Then("I click Edit on Income Summary row {int}")
        public void iClickEditIncomeLink(int Index){
        employmentSummaryPage.clickEditIncome(Index);}

    @Then("I click on Add job or self-employment on the Employment Summary Page")
    public void iSelectAddJob(){employmentSummaryPage.clickAddJob();}

    @Then("I click on Remove job {string} entered for Primary on the Employment Summary Page")
    public void iSelectRemoveJob(String DeleteJob){employmentSummaryPage.clickRemoveJob(DeleteJob);}

    @And("I select {string} icon on the Employment Summary Page")
    public void iSelectHelpIcon(String labelIcon){employmentSummaryPage.clickHelpIcon(labelIcon);}

    @Then("I click on {string} link in Help Drawer on the Employment Summary page")
    public void iClickHelpDrawerContactUs(String lnkName){employmentSummaryPage.clickHelpContactUsNavigation(lnkName);}








    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the Employment Summary page in {string}")
    public void iVerifyTextOnEmploymentSummaryPage(String language){employmentSummaryPage.verifyHeadersEmploymentSummaryPage(language);}

    @Then("I validate Employment Summary help drawer verbiage in {string}")
    public void iValidateHelp(String language){employmentSummaryPage.validateHelpVerbiage(language);}

    @Then("I validate Employment Summary text in {string}")
    public void ivalidateTextEmploymentSummaryPage(String language){employmentSummaryPage.validateTextEmploymentSummaryPage(language);}

    @Then("I validate Employment Summary bold text in Employment Summary Page")
    public void ivalidateBoldTextEmploymentSummaryPage(){employmentSummaryPage.validateBoldTextEmploymentSummaryPage();}

    @When("I click on Go Back button in employment summary page")
    public void iClickOnGoBackButtonInEmploymentSummaryPage() {
        employmentSummaryPage.clickOnGoBack();
    }
}
