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
        Select dropdown = new Select(selectFilingStatus);
        dropdown.selectByVisibleText(taxFilingOption);
    }

    public void selectDependentsOption(String dependentsOption){
        switch (dependentsOption){
            case "No":
                claimDependentNoRadioBtn.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + dependentsOption);
        }
    }

    public void whoWillClaimDependent(String memberId){
        String clalimedDependentOption = "selectedClaimedByMemberId"+memberId;
        basicActions.getDriver().findElement(By.id(clalimedDependentOption)).click();
    }

    public void selectSaveAndContinue(){
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 20);
        saveAndContinueBtn.click();
    }

}
