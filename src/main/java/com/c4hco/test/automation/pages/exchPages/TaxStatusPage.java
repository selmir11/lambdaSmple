package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TaxStatusPage {
    private BasicActions basicActions;
    public TaxStatusPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "#filingStatus")
    WebElement selectFilingStatus;

    @FindBy(css = "#filingReturnGroup input")
    List<WebElement> fileFedIncomeTaxRadioBtn;

    @FindBy(id = "selectedSpouseId1")
    WebElement fileTaxesJointlyWithBtn;

    @FindBy(css = "#claimedAsDependentNo")
    WebElement claimAsDependentNoRadioBtn;

    @FindBy(css = "#claimedAsDependentYes")
    WebElement claimAsDependentYesRadioBtn;

    @FindBy(css = "#ClaimDependentsQGroup > div > div > input")
    List <WebElement> claimDependentRadioBtn;

    @FindBy(id = "preSubmitButton")
    WebElement saveAndContinueBtn;

    @FindBy(id = "selectedClaimedByMemberId1")
    WebElement lblheadOfHousehold;

    @FindBy(id = "selectedDependents1")
    WebElement selectedDependents1;

    @FindBy(id = "selectedDependents2")
    WebElement selectedDependents2;

    @FindBy(id = "selectedDependents3")
    WebElement selectedDependents3;

    @FindBy(id  = "selectedDependents4")
    WebElement selectedDependents4;

    public void claimAsDependent(String claimAsDependentOption){
        switch(claimAsDependentOption){
            case "Yes":
                basicActions.waitForElementToBeClickable(claimAsDependentYesRadioBtn, 10);
                claimAsDependentYesRadioBtn.click();
                break;
            case "No":
                basicActions.waitForElementToBeClickable(claimAsDependentNoRadioBtn, 50);
                claimAsDependentNoRadioBtn.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + claimAsDependentOption);
        }
    }

    public void fileFedIncomeTaxReturn(String fileFedIncomeTaxReturnOption){
        switch(fileFedIncomeTaxReturnOption){
            case "Yes":
                fileFedIncomeTaxRadioBtn.get(0).click();
                break;
            case "No":
                fileFedIncomeTaxRadioBtn.get(1).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + fileFedIncomeTaxReturnOption);
        }
    }

    public void selectTaxFilingOption(String taxFilingOption){
        basicActions.scrollToElement( selectFilingStatus );
        basicActions.waitForElementToBeClickable(selectFilingStatus, 20);
        Select dropdown = new Select(selectFilingStatus);
        dropdown.selectByVisibleText(taxFilingOption);
    }

    public void selectFileTaxesJointlyWith(){
        basicActions.waitForElementToBePresent(fileTaxesJointlyWithBtn, 20);
        fileTaxesJointlyWithBtn.click();
    }

    public void selectDependentsOption(String dependentsOption){
        switch (dependentsOption){
            case "No":
                basicActions.waitForElementListToBePresent(claimDependentRadioBtn,20);
                claimDependentRadioBtn.get(1).click();
                break;
            case "Yes":
                basicActions.waitForElementListToBePresent(claimDependentRadioBtn,20);
                claimDependentRadioBtn.get(0).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dependentsOption);
        }
    }

    public void whoWillClaimDependent(String memberId){
        String clalimedDependentOption = "selectedClaimedByMemberId"+memberId;
        basicActions.getDriver().findElement(By.id(clalimedDependentOption)).click();
    }

    public void checkDependentClaimed(String memberId){
        String clalimDependentOption = "selectedDependents"+memberId;
        basicActions.getDriver().findElement(By.id(clalimDependentOption)).click();
    }

    public void iSelectDependent1(){
        basicActions.waitForElementToBePresent(selectedDependents1, 20);
        selectedDependents1.click();
    }
    public void iSelectDependent2(){
        basicActions.waitForElementToBePresent(selectedDependents2, 20);
        selectedDependents2.click();
    }
    public void iSelectDependent3(){
        basicActions.waitForElementToBePresent(selectedDependents3, 20);
        selectedDependents3.click();
    }

    public void iSelectDependent4(){
        basicActions.waitForElementToBePresent(selectedDependents4, 20);
        selectedDependents4.click();
    }

    public void selectSaveAndContinue(){
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 20);
        saveAndContinueBtn.click();
    }

}
