package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TellUsAboutYourselfPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

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

    @FindBy(id = "isPregnantFalse" )
    WebElement rdobtnPregnantNo;

    @FindBy(css = "isPregnantTrue")
    WebElement rdobtnPregnantYes;

    @FindBy(css = "div:nth-child(5) p")
    WebElement hdrSsaError;

    

    public void userPregnantQuestion(String Pregnant) {
        switch (Pregnant){
            case "No":
                rdobtnPregnantNo.click();
                break;
            case "Yes":
                rdobtnPregnantYes.click();
                break;
            default:
                throw new IllegalArgumentException("Invalide option: " + Pregnant);

        }

    }
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

    public void iUpdateSSN(String newSsn){
        basicActions.waitForElementToBePresent(ssn, 20);
        MemberDetails subscriber = SharedData.getPrimaryMember();
        String oldSsn = subscriber.getSsn();
        System.out.println("Old ssn: " + oldSsn);
        subscriber.setOldSsn(oldSsn);
        ssn.clear();
        ssn.sendKeys(newSsn);
        subscriber.setSsn(newSsn);
        System.out.println("ssn updated");
        subscriber.setHasIncorrectEntities(true);
        subscriber.setIncorrectEntityTypeQualifier("1");
        subscriber.setIncorrectIdCodeQualifier("34");
        subscriber.setIncorrectIdCode(oldSsn);
        subscriber.setIncorrectEntityIdCode("70");
        subscriber.setIncorrect_first_name(subscriber.getFirstName());
        subscriber.setIncorrect_middle_name(subscriber.getMiddleName());
        subscriber.setIncorrect_last_name(subscriber.getLastName());
        SharedData.setPrimaryMember(subscriber);
    }

   public void updateFullName(String namePrefix){
        List<MemberDetails> membersList = basicActions.getAllMem();
        for(MemberDetails member: membersList){
            if(member.getFirstName().contains(namePrefix)){
                String oldFirstName = member.getFirstName();
                String oldMiddleName = member.getMiddleName()!=null ? member.getMiddleName() : "";
                String oldLastName = member.getLastName();
                member.setHasIncorrectEntities(true);

                String newFirstName = namePrefix+basicActions.getUniqueString(8);
                String newMiddleName = "Test";
                String newLastName = "update"+ member.getLastName();

                member.setIncorrectEntityTypeQualifier("1");
                member.setIncorrectIdCodeQualifier("34");
                member.setIncorrectEntityIdCode("70");
                member.setIncorrect_first_name(oldFirstName);
                member.setIncorrect_middle_name(oldMiddleName);
                member.setIncorrect_last_name(oldLastName);

                member.setFirstName(newFirstName);
                member.setMiddleName(newMiddleName);
                member.setLastName(newLastName);
                member.setSignature(newFirstName+" "+newLastName);
                member.setFullName(newFirstName+" "+newMiddleName.toUpperCase().charAt(0)+". "+newLastName);
                member.setCompleteFullName(newFirstName+" "+newMiddleName+" "+newLastName);

                basicActions.waitForElementToBePresent(txtFirstName, 50);
                txtFirstName.clear();
                txtFirstName.sendKeys(newFirstName);
                txtMiddleName.clear();
                txtMiddleName.sendKeys(newMiddleName);
                txtLastName.clear();
                txtLastName.sendKeys(newLastName);
            }
        }
    }
    public void updateName(){
        MemberDetails subscriber = new MemberDetails();
        basicActions.waitForElementToBePresent(txtFirstName, 50);
        txtFirstName.clear();
        String newFirstName = "PrimaryAmend";
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

    public void validateSsaError(){
        basicActions.waitForElementToBePresent(hdrSsaError, 20);
        softAssert.assertEquals(hdrSsaError.getText(), "Make sure the name and the Social Security number you entered match your Social Security card and try again.");
        softAssert.assertAll();
    }

}
