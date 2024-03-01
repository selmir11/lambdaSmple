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

    @FindBy(name = "saveAndContinue")
    WebElement saveAndContinueBtn;

    public void selectInsuranceOption(String insuranceOption){
        switch(insuranceOption){
            case "None of these":
                insuranceOptionsCheckBox.get(11).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + insuranceOption);

        }
        saveAndContinueBtn.click();
    }
}
