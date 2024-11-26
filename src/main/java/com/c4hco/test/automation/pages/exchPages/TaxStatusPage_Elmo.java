package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaxStatusPage_Elmo {
    private BasicActions basicActions;
    public TaxStatusPage_Elmo(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".container .header-1")
    WebElement existingTaxStatusHeader;

    @FindBy(id = "ELIG-taxStatus-claimedAsDependent-yesButton")
    WebElement claimedAsDependentYes;

    @FindBy(id = "ELIG-taxStatus-claimedAsDependent-noButton")
    WebElement claimedAsDependentNo;

    @FindBy(id = "ELIG-taxStatus-willFile-yesButton")
    WebElement willFileTaxReturnYes;

    @FindBy(id = "ELIG-taxStatus-willFile-noButton")
    WebElement willFileTaxReturnNo;

    @FindBy(id = "ELIG-taxStatus-nav-SaveAndContinue")
    WebElement saveAndContinueBtn;

    public void selectClaimedAsDependent(String claimedAsDependent){
        switch (claimedAsDependent) {
            case "Yes":
                basicActions.waitForElementToBeClickable(claimedAsDependentYes, 20);
                basicActions.click(claimedAsDependentYes);
                break;
            case "No":
                basicActions.waitForElementToBeClickable(claimedAsDependentNo, 20);
                basicActions.click(claimedAsDependentNo);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + claimedAsDependent);
        }
    }

    public void selectWillFileTaxReturn(String willFile){
        switch (willFile) {
            case "Yes":
                basicActions.waitForElementToBeClickable(willFileTaxReturnYes, 20);
                basicActions.click(willFileTaxReturnYes);
                break;
            case "No":
                basicActions.waitForElementToBeClickable(willFileTaxReturnNo, 20);
                basicActions.click(willFileTaxReturnNo);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + willFile);
        }
    }

    public void clickSaveAndContinue(){
        basicActions.waitForElementToBePresentWithRetries(existingTaxStatusHeader, 40);
        basicActions.waitForElementToBeClickableWithRetries(saveAndContinueBtn, 20);
        basicActions.scrollToElement(saveAndContinueBtn);
        saveAndContinueBtn.click();
    }
}
