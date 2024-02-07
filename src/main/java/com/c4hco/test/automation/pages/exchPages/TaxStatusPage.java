package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TaxStatusPage {
    private BasicActions basicActions;
    public TaxStatusPage(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(id = "filingStatus")
    WebElement selectFilingStatus;

    @FindBy(id = "exceptionalCircumstances1")
    WebElement rdobtnExceptionalCircumstances;

    @FindBy(css = "#ClaimedAsDependentGroup .claimedAsDependent")
    List<WebElement> claimAsDependentRadioBtn;

    @FindBy(css = "#filingReturnGroup input")
    List<WebElement> fileFedIncomeTaxRadioBtn;

    @FindBy(css = "#ClaimDependentsQGroup input")
    List<WebElement> claimDependentsRadioBtn;

    @FindBy(id = "claimedAsDependentNo")
    WebElement claimAsDependentNoRadioBtn;

    @FindBy(id = "claimDependentsNo")
    WebElement claimDependentNoRadioBtn;


    @FindBy(id = "preSubmitButton")
    WebElement saveAndContinueBtn;

    public void claimAsDependent(String claimAsDependentOption){
        switch(claimAsDependentOption){
            case "No":
                basicActions.waitForElementToBeClickable(claimAsDependentNoRadioBtn, 30);
                claimAsDependentNoRadioBtn.click();
                break;
        }
    }

    public void fileFedIncomeTaxReturn(String fileFedIncomeTaxReturnOption){
        switch(fileFedIncomeTaxReturnOption){
            case "Yes":
                fileFedIncomeTaxRadioBtn.get(0).click();
                break;
        }
    }

    public void selectTaxFilingOption(String taxFilingOption){
        Select dropdown = new Select(selectFilingStatus);
        dropdown.selectByVisibleText(taxFilingOption);
    }

    public void selectDependentsOption(String dependentsOption){
        switch (dependentsOption){
            case "No":
                claimDependentNoRadioBtn.click();
                break;
        }
    }

    public void selectSaveAndContinue(){
        saveAndContinueBtn.click();
    }

//
//    public void notClaimedNoDependents(String FilingStatus){
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertTrue(basicActions.waitForElementToBeClickable(rdobtnNoClaimedDependent, 60));
//
//        rdobtnNoClaimedDependent.click();
//        rdobtnYesFileReturn.click();
//
//
//
//        rdobtnNoClaimDependent.click();
//        btnContinue.click();
//    }
}
