package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(css = "#nameSuffix > option")
    List<WebElement> suffixDropdownOptions;

    @FindBy(id = "dateOfBirth")
    WebElement dob;

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
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", btnSaveAndContinue);
        basicActions.waitForElementToDisappear(btnSaveAndContinue, 5);
    }

    public void iUpdateSSN(){
        basicActions.waitForElementToBePresent(ssn, 20);
        ssn.clear();
        String newSsn = "123456789";
        ssn.sendKeys(newSsn);
        SharedData.getPrimaryMember().setSsn(newSsn);
        System.out.println("ssn updated");
    }

    public void updateName(){
        MemberDetails subscriber = new MemberDetails();
        basicActions.waitForElementToBePresent(txtFirstName, 50);
        txtFirstName.clear();
        String newFirstName = "Amend";
        txtFirstName.sendKeys(newFirstName);
        subscriber.setFirstName(newFirstName);
        System.out.println("First Name updated to "+newFirstName);

        txtMiddleName.clear();
        String newMiddleName = "Revise";
        txtMiddleName.sendKeys(newMiddleName);
        subscriber.setMiddleName(newMiddleName);
        subscriber.setMiddleInitial("R.");
        System.out.println("Middle Name updated to "+newMiddleName);

        txtLastName.clear();
        String newLastName = "Improve";
        txtLastName.sendKeys(newLastName);
        subscriber.setLastName(newLastName);
        System.out.println("Last Name updated to "+newLastName);

        String newSuffix = "Sr.";
        selectSuffix.click();
        basicActions.selectValueFromDropdown(selectSuffix, suffixDropdownOptions, newSuffix);
        subscriber.setSuffix(newSuffix);
        System.out.println("Suffix updated to "+newSuffix);

        subscriber.setFullName(subscriber.getFirstName()+" "+subscriber.getMiddleInitial()+" "+subscriber.getLastName()+" "+subscriber.getSuffix());
        subscriber.setSignature(subscriber.getFirstName()+" "+subscriber.getLastName());
        SharedData.setPrimaryMember(subscriber);
    }

    public void updateDOB(String newDob){
        basicActions.waitForElementToBePresent(dob, 20);
        dob.clear();
        dob.sendKeys(newDob);
        SharedData.getPrimaryMember().setDob(newDob);
        System.out.println("dob updated");
    }

}
