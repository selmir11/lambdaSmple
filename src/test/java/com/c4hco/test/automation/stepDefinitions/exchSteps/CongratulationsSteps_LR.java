package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.Congratulations_LR;
import io.cucumber.java.en.*;

public class CongratulationsSteps_LR {
    Congratulations_LR congrats = new Congratulations_LR();

    @And("I continue on Congratulations page")
    public void ClickContinue(){
        congrats.saveContinue();
    }
}
