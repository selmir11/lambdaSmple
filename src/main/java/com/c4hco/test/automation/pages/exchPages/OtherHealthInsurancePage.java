package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OtherHealthInsurancePage {
    private BasicActions basicActions;
    public OtherHealthInsurancePage(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(id = "noneOfThese")
    WebElement chkbxNoneOfThese;

    @FindBy(css = "#otherHealthInsurance .input-checkbox")
    List<WebElement> insuranceOptionsCheckBox;

    @FindBy(name = "saveAndContinue")
    WebElement saveAndContinueBtn;

    public void selectInsuranceOption(String insuranceOption){
        switch(insuranceOption){
            case "None of these":
                insuranceOptionsCheckBox.get(11).click();
                break;

        }
        saveAndContinueBtn.click();
    }
}
