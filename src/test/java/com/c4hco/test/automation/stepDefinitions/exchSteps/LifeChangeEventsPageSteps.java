package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.LifeChangeEventsPage;
import io.cucumber.java.en.And;

public class LifeChangeEventsPageSteps {

    LifeChangeEventsPage lcePage = new LifeChangeEventsPage();

    @And("I report {string} and click continue")
    public void iClickQLCEOption(String QLCEType){
        switch(QLCEType){
            case "Birth":
                lcePage.birthLCE();
                break;

        }
        lcePage.clickContinue();
    }

//    @And("I report a QLCE - birth and click continue")
//    public void checkReportBirthLCE(){
//        lce.birthLCE();
//        lce.clickContinue();
//        System.out.println("Checked birth LCE");
//    }
 /*
    public void checkPregnancy(){
        lce.pregnancyLCE();
        lce.clickContinue();
    }
    public void checkMarriedDivorce(){
        lce.marriageLCE();
        lce.clickContinue();
    }
    public void checkLossCoverage(){
        lce.lossOfCoverageLCE();
        lce.clickContinue();
    }
    public void checkImmigration(){
        lce.immigrationLCE();
        lce.clickContinue();
    }
    public void checkAlaskanNative(){
        lce.alaskaNativeLCE();
        lce.clickContinue();
    }
    public void checkMovedToCO(){
        lce.movedToCOLCE();
        lce.clickContinue();
    }
    public void checkIncarceration(){
        lce.incarcerationStatus();
        lce.clickContinue();
    }
    public void checkOther(){
        lce.other();
        lce.clickContinue();
    }
    public void checkNone(){
        lce.none();
        lce.clickContinue();
    }

  */

}
