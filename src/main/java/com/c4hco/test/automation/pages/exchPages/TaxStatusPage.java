package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class TaxStatusPage {
    private BasicActions basicActions;
    public TaxStatusPage(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(id = "claimedAsDependentYes")
    WebElement rdobtnYesClaimedDependent;

    @FindBy(id = "claimedAsDependentNo")
    WebElement rdobtnNoClaimedDependent;

    @FindBy(id = "fileTaxReturnYes")
    WebElement rdobtnYesFileReturn;

    @FindBy(id = "fileTaxReturnNo")
    WebElement rdobtnNoFileReturn;

    @FindBy(id = "filingStatus")
    WebElement selectFilingStatus;

    @FindBy(id = "exceptionalCircumstances1")
    WebElement rdobtnExceptionalCircumstances;

    @FindBy(id = "claimDependentsYes")
    WebElement rdobtnYesClaimDependents;

    @FindBy(id = "claimDependentsNo")
    WebElement rdobtnNoClaimDependent;

    @FindBy(id = "preSubmitButton")
    WebElement btnContinue;

    public void notClaimedNoDependents(String FilingStatus){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(basicActions.waitForElementToBeClickable(rdobtnNoClaimedDependent, 60));

        rdobtnNoClaimedDependent.click();
        rdobtnYesFileReturn.click();

        Select dropdown = new Select(selectFilingStatus);
        dropdown.selectByVisibleText(FilingStatus);

        rdobtnNoClaimDependent.click();
        btnContinue.click();
    }
}
