package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.CancellationRequestPageCoCo;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;


public class CancellationRequestPageCoCoSteps {
    CancellationRequestPageCoCo cancellationRequestPageCoCo = new CancellationRequestPageCoCo(WebDriverManager.getDriver());


    @Then("I click Go Back on medical plan Cancellation Page CoCo")
    public void clickGoBackbtnCoCo() {
        cancellationRequestPageCoCo.clickGoBackbtnCoCo();
    }

    @Then("I click continue on Cancellation Request page CoCo")
    public void i_click_continue_on_Cancellation_Request_page(){
        cancellationRequestPageCoCo.clickContinuebtnCoCo();
    }


    @Then("I cancel the active plan detail CoCo")
    public void i_cancel_the_active_plan_detail(){
        cancellationRequestPageCoCo.cancelActivePlanCoCo();
    }

    @Then("I affirm and cancel the active plan CoCo")
    public void cancelPlan(){
        cancellationRequestPageCoCo.cancelPlanCoCo();
    }

    @Then("I click Okay on Thank you popup CoCo")
    public void okaybtn(){
        cancellationRequestPageCoCo.okaybtn();
    }



}
