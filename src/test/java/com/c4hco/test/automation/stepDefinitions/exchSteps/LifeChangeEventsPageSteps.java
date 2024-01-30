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
            case "Pregnancy":
                lcePage.pregnancyLCE();
                break;
            case "Marriage":
                lcePage.marriageLCE();
                break;
            case "LossOfCoverageLCE":
                lcePage.lossOfCoverageLCE();
                break;
            case "ImmigrationLCE":
                lcePage.immigrationLCE();
                break;
            case "AlaskaNativeLCE":
                lcePage.alaskaNativeLCE();
                break;
            case "MovedToCOLCE":
                lcePage.movedToCOLCE();
                break;
            case "IncarcerationStatus":
                lcePage.incarcerationStatus();
                break;
            case "Other":
                lcePage.other();
                break;
            case "None":
                lcePage.none();
                break;
        }
        lcePage.clickContinue();
    }

}
