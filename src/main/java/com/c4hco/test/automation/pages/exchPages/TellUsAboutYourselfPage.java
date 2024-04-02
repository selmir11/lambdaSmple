package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TellUsAboutYourselfPage {

    private BasicActions basicActions;

    public TellUsAboutYourselfPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "firstName")
    WebElement txtFirstName;

    @FindBy(id = "middleName")
    WebElement txtMiddleName;

    @FindBy(id = "lastName")
    WebElement txtLastName;

    @FindBy(id = "nameSuffix")
    WebElement selectSuffix;

    @FindBy(id = "genderFemale")
    WebElement rdobtnSexFemale;
    @FindBy(id = "genderMale")
    WebElement rdobtnSexMale;

    @FindBy(id = "coverageYes")
    WebElement rdobtnApplyingYes;
    @FindBy(id = "coverageNo")
    WebElement rdobtnApplyingNo;

    @FindBy(id = "ssn")
    WebElement ssn;
    @FindBy(css = "#addMember #continueButton")
    WebElement btnSaveAndContinue;

    public void userSexQuestion(String Sex) {
        MemberDetails acctHolder = SharedData.getPrimaryMember();
        acctHolder.setGender(Sex);
        SharedData.setPrimaryMember(acctHolder);
        switch (Sex) {
            case "Female":
                rdobtnSexFemale.click();
                break;
            case "Male":
                rdobtnSexMale.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + Sex);
        }
    }

    public void isUserApplyingForHealthInsurance(String YNApplying){
        switch(YNApplying){
            case "Yes":
                rdobtnApplyingYes.click();
                break;
            case "No":
                rdobtnApplyingNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + YNApplying);
        }
    }

    public void saveAndContinue(){
        basicActions.waitForElementToBePresent(btnSaveAndContinue, 20);
        btnSaveAndContinue.click();
    }

    public void iUpdateSSN(){
        basicActions.waitForElementToBePresent(ssn, 20);
        ssn.clear();
        String newSsn = "123456789";
        ssn.sendKeys(newSsn);
        SharedData.getPrimaryMember().setSsn(newSsn);
        System.out.println("ssn updated");
    }

}
