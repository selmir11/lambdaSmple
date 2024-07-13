package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TellUsAboutAdditionalMemberPage {

    private BasicActions basicActions;
    public TellUsAboutAdditionalMemberPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    @FindBy(css = "c4PageHeader")
    WebElement txtheader;

    @FindBy(id = "firstName")
    WebElement txtfirstName;

    @FindBy(id = "middleName")
    WebElement txtmiddleName;

    @FindBy(id = "lastName")
    WebElement txtlastName;

    @FindBy(id = "nameSuffix")
    WebElement selectSuffix;

    @FindBy(id = "dateOfBirth")
    WebElement txtdateOfBirth;

    @FindBy(id = "genderFemale")
    WebElement rdobtngenderFemale;
    @FindBy(id = "isPregnantFalse")
    WebElement IsPersonPregnentNo;
    @FindBy(id = "isPregnantTrue")
    WebElement IsPersonPregnentYes;
    @FindBy(id = "genderMale")
    WebElement rdobtngenderMale;

    @FindBy(id = "memberRelationship0")
    WebElement selectRelationship;
    @FindBy(id = "memberRelationship1")
    WebElement selectRelationship1;
    @FindBy(id = "memberRelationship2")
    WebElement selectRelationship2;
    @FindBy(id = "memberRelationship3")
    WebElement selectRelationship3;

    @FindBy(css = "#memberRelationship1 > option:nth-child(2)")
    WebElement selectBrother;

    @FindBy(css = "#memberRelationship1 > option:nth-child(3)")
    WebElement selectCousin;

    @FindBy(xpath = "#memberRelationship1 > option:nth-child(4)")
    WebElement selectFather;

    @FindBy(css = "#memberRelationship1 > option:nth-child(5)")
    WebElement selectGrandfather;

    @FindBy(css = "#memberRelationship1 > option:nth-child(6)")
    WebElement selectGrandson;

    @FindBy(css = "#memberRelationship1 > option:nth-child(7)")
    WebElement selectHalfBrother;

    @FindBy(css= "#memberRelationship1 > option:nth-child(8)")
    WebElement selectSpouse;

    @FindBy(css = "#memberRelationship1 > option:nth-child(9)")
    WebElement selectInLaw;

    @FindBy(css = "#memberRelationship1 > option:nth-child(10)")
    WebElement selectNephew;

    @FindBy(css = "#memberRelationship1 > option:nth-child(11)")
    WebElement selectPartner;

    @FindBy(css = "#memberRelationship1 > option:nth-child(12)")
    WebElement selectStepBrother;

    @FindBy(css = "#memberRelationship1 > option:nth-child(13)")
    WebElement selectStepFather;

    @FindBy(css = "#memberRelationship1 > option:nth-child(14)")
    WebElement selectSon;

    @FindBy(css = "#memberRelationship1 > option:nth-child(15)")
    WebElement selectStepSon;

    @FindBy(css = "#memberRelationship1 > option:nth-child(16)")
    WebElement selectUncle;

    @FindBy(css = "#memberRelationship1 > option:nth-child(17)")
    WebElement selectUnrelated;

    @FindBy(css = "#memberRelationship1 > option:nth-child(18)")
    WebElement selectOther;

    @FindBy(id = "coverageYes")
    WebElement rdobtnIsMemberApplingYes;

    @FindBy(id = "coverageNo")
    WebElement rdobtnIsMemberApplyingNo;

    @FindBy(id = "ssn")
    WebElement txtSSN;

    @FindBy(id = "continueButton")
    WebElement btnsaveAndContinue;

    public static String getUniqueString(int length) {
        return RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz");
    }

    public void enterMemberDetails(String DOB){
        String frstName = getUniqueString(20);
        String mdlName = getUniqueString(8);
        String lastName = getUniqueString(13);
        basicActions.waitForElementToBePresent(txtheader,1);
        basicActions.waitForElementToBePresent(txtfirstName,30);
        txtfirstName.sendKeys(frstName);
        txtmiddleName.sendKeys(mdlName);
        txtlastName.sendKeys(lastName);
        txtdateOfBirth.sendKeys(DOB);
        txtSSN.sendKeys("653035280");
        List<MemberDetails> memberList = SharedData.getMembers();
        int memberCount =0;
        if (memberList == null) {
            memberList = new ArrayList<>();
        }else{
            memberCount = memberList.size();
        }
        memberCount++;
        MemberDetails member = new MemberDetails();
        member.setFirstName(frstName);
        member.setLastName(lastName);
        member.setMiddleName(mdlName);
        member.setDob(DOB);
        member.setSignature(frstName+" "+lastName);
        member.setFullName(frstName+" "+mdlName.charAt(0)+". "+lastName);
        member.setDependentCountTag("member"+memberCount);
        memberList.add(member);

        SharedData.setMembers(memberList);
    }

    public void selectSex(String Sex){
        switch(Sex){
            case "Female":
                rdobtngenderFemale.click();
                break;
            case "Male":
                rdobtngenderMale.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + Sex);
        }
    }
    public void selectIsPersonPregnant(String pregnant){
        switch(pregnant){
            case "Yes":
                IsPersonPregnentYes.click();
                break;
            case "No":
                IsPersonPregnentNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + pregnant);
        }
    }
      public void setSelectRelationship(String Relation){
        basicActions.waitForElementToBePresent(selectRelationship, 15);
        Select dropdown = new Select(selectRelationship);
        dropdown.selectByVisibleText(Relation);
        List<MemberDetails> memberList = SharedData.getMembers();
        memberList.get(memberList.size()-1).setRelation_to_subscriber(Relation);
    }

    public void setSelectRelationship1(String Relation){
        basicActions.waitForElementToBePresent(selectRelationship1, 15);

        Select dropdown = new Select(selectRelationship1);
        dropdown.selectByVisibleText(Relation);
    }
    public void setSelectRelationship2(String Relation){
        basicActions.waitForElementToBePresent(selectRelationship2, 15);

        Select dropdown = new Select(selectRelationship2);
        dropdown.selectByVisibleText(Relation);
    }
    public void setSelectRelationship3(String Relation) {
        basicActions.waitForElementToBePresent(selectRelationship3, 15);

        Select dropdown = new Select(selectRelationship3);
        dropdown.selectByVisibleText(Relation);
    }

    public void isMemberApplyingForInsurance(String Applying){
        switch(Applying){
            case "Yes":
                rdobtnIsMemberApplingYes.click();
                break;
            case "No":
                rdobtnIsMemberApplyingNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + Applying);
        }
    }

    public void clickSaveAndContinue(){btnsaveAndContinue.click();}

    public void memberDetailswithAge(int Age){
        LocalDate currentDate = LocalDate.now();
        LocalDate DOBCalculate = currentDate.minusYears(Age);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String actualdob=dateFormat.format(DOBCalculate);
        enterMemberDetails(actualdob);
    }
    public void Newbornwithcurrentdatelessthanfivedays(int Days) {
        LocalDate currentDate = LocalDate.now();
        LocalDate DOBCalculate = currentDate.minusDays(Days);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String actualdob = dateFormat.format(DOBCalculate);
        enterMemberDetails(actualdob);
    }


}


