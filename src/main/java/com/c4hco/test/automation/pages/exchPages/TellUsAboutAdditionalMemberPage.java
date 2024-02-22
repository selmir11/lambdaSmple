package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TellUsAboutAdditionalMemberPage {

    private BasicActions basicActions;
    public TellUsAboutAdditionalMemberPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

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
        String frstName = getUniqueString(8);
        String mdlName = getUniqueString(8);
        String lastName = getUniqueString(12);

        txtfirstName.sendKeys(frstName);
        txtmiddleName.sendKeys(mdlName);
        txtlastName.sendKeys(lastName);

        txtdateOfBirth.sendKeys(DOB);
        txtSSN.sendKeys("653035280");
    }

    public void selectSex(String Sex){
        switch(Sex){
            case "Female":
                rdobtngenderFemale.click();
                break;
            case "Male":
                rdobtngenderMale.click();
                break;
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
        }
    }
    public void setSelectRelationship(String Relation){
        basicActions.waitForElementToBePresent(selectRelationship, 15);

        Select dropdown = new Select(selectRelationship);
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
        }
    }

    public void clickSaveAndContinue(){btnsaveAndContinue.click();}

}
