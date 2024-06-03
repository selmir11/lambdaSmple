package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MedicalCompareCoCoPage { private BasicActions basicActions;

    public MedicalCompareCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions( webDriver );
        PageFactory.initElements( basicActions.getDriver(), this );
    }

    @FindBy(id = "SHP-MedicalComparePlans-GoBacktoPlans")
    public WebElement medicalCompareGoBack;

      public void  clickMedicalCompareGoBack() {
    basicActions.waitForElementToBeClickable(medicalCompareGoBack, 20);
        medicalCompareGoBack.click();}



}
