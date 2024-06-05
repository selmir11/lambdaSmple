package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.MedicalDentalCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MedicalDentalCoCoPageSteps {
    MedicalDentalCoCoPage medicalDentalCoCoPage = new MedicalDentalCoCoPage(WebDriverManager.getDriver());

    @And("I click Continue button on the Medical Dental Page CoCo")
    public void iClickContinueOnOwnButton() {
        medicalDentalCoCoPage.clickContinueButton();
    }

   }
