package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OtherHealthInsurancePage {
    private BasicActions basicActions;
    public OtherHealthInsurancePage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "#otherHealthInsurance .input-checkbox")
    List<WebElement> insuranceOptionsCheckBox;

    @FindBy(id = "submitButton")
    WebElement goBackButton;

    @FindBy(name = "saveAndContinue")
    WebElement saveAndContinueBtn;

    public void selectInsuranceOption(String insuranceOption){
        switch(insuranceOption){
            case "HealthFirst":
                basicActions.click(insuranceOptionsCheckBox.get(0));
                break;
            case "CHP":
                basicActions.click(insuranceOptionsCheckBox.get(1));
                break;
            case "ESI":
                basicActions.click(insuranceOptionsCheckBox.get(2));
                break;
            case "HRA":
                basicActions.click(insuranceOptionsCheckBox.get(3));
                break;
            case "Medicare":
                basicActions.click(insuranceOptionsCheckBox.get(4));
                break;
            case "VA Healthcare":
                basicActions.click(insuranceOptionsCheckBox.get(5));
                break;
            case "COBRA":
                basicActions.click(insuranceOptionsCheckBox.get(6));
                break;
            case "Retiree Health Plan":
                basicActions.click(insuranceOptionsCheckBox.get(7));
                break;
            case "TRICARE":
                basicActions.click(insuranceOptionsCheckBox.get(8));
                break;
            case "Peace Corps":
                basicActions.click(insuranceOptionsCheckBox.get(9));
                break;
            case "Individual Insurance":
                basicActions.click(insuranceOptionsCheckBox.get(10));
                break;
            case "None of these":
                basicActions.click(insuranceOptionsCheckBox.get(11));
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + insuranceOption);

        }
        saveAndContinueBtn.click();
    }

    public void clickGoBackButton() {
        basicActions.waitForElementToBeClickable(goBackButton, 30);
        goBackButton.click();
    }


    public void clickSaveAndContinue(){
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 20);
        saveAndContinueBtn.click();
    }

    public void selectInsuranceOptionOnly(String insuranceOption){
        basicActions.waitForElementListToBePresent(insuranceOptionsCheckBox, 5);
        switch(insuranceOption){
            case "None of these":
                basicActions.click(insuranceOptionsCheckBox.get(11));
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + insuranceOption);
        }
    }
}
