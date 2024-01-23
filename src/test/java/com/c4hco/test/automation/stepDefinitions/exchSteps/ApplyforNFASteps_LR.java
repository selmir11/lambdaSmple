package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.ApplyforNFA_LR;
import io.cucumber.java.en.*;

public class ApplyforNFASteps_LR {
    ApplyforNFA_LR applyNFA = new ApplyforNFA_LR();

    @And("I Apply for no financial help")
    public void clickNoThanks(){
        applyNFA.chooseNoFinancialHelp();
    }
}
