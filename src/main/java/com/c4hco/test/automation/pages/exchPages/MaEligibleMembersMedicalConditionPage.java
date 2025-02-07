package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MaEligibleMembersMedicalConditionPage {

    private BasicActions basicActions;
    public MaEligibleMembersMedicalConditionPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(id = "isAnyoneMACriteriaYes")
    WebElement rdoYes;

    @FindBy(id = "isAnyoneMACriteriaNo")
    WebElement rdoNo;

    @FindBy(id = "continueButton")
    WebElement btnSaveAndContinue;

    @FindBy(id = "criteriaApplicableMemberList0.applicableMember1")
    WebElement checkBoxMember1;

    public void answerDisability(String nextOption){
        basicActions.waitForElementToBePresent(rdoYes, 20);
        switch(nextOption) {
            case "Yes":
                rdoYes.click();
                break;
            case "No":
                rdoNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + nextOption);
        }
        btnSaveAndContinue.click();
    }
    public void answerDisabilityOnly(String nextOption){
        basicActions.waitForElementToBePresent(rdoYes, 20);
        switch(nextOption) {
            case "Yes":
                rdoYes.click();
                break;
            case "No":
                rdoNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + nextOption);
        }

    }

    public void iContinue(){
        basicActions.waitForElementToBePresentWithRetries( btnSaveAndContinue,20 );
        basicActions.click( btnSaveAndContinue );

    }

    public void iClickMember(){
        basicActions.waitForElementToBePresentWithRetries( checkBoxMember1,20 );
        basicActions.click( checkBoxMember1 );

    }
}
