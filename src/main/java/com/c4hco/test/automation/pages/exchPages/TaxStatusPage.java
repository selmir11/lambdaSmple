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

    @FindBy(css = "#filingReturnGroup input")
    List<WebElement> fileFedIncomeTaxRadioBtn;

    @FindBy(id = "claimedAsDependentNo")
    WebElement claimAsDependentNoRadioBtn;

    @FindBy(id = "claimedAsDependentYes")
    WebElement claimAsDependentYesRadioBtn;

    @FindBy(id = "claimDependentsNo")
    WebElement claimDependentNoRadioBtn;

    @FindBy(id = "preSubmitButton")
    WebElement saveAndContinueBtn;

    @FindBy(id = "selectedClaimedByMemberId1")
    WebElement lblheadOfHousehold;

    public void claimAsDependent(String claimAsDependentOption){
        switch(claimAsDependentOption){
            case "Yes":
                basicActions.waitForElementToBeClickable(claimAsDependentYesRadioBtn, 10);
                claimAsDependentYesRadioBtn.click();
                break;
            case "No":
                basicActions.waitForElementToBeClickable(claimAsDependentNoRadioBtn, 10);
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

    public void whoWillClaimDependent(){
        //Determine best path to parameterize - current solution is a work around.
        ////input[@name = 'selectedClaimedByMemberId']/..//label//span[text()='bqrgpfrv mnrgamlw']
        lblheadOfHousehold.click();
    }

    public void selectSaveAndContinue(){
        saveAndContinueBtn.click();
    }

}
