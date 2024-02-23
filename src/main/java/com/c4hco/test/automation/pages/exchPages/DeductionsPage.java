package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DeductionsPage {
    private BasicActions basicActions;
    public DeductionsPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "app-deductions .additional-income-row button")
    List<WebElement> addtlDeductionOptionsCheckbox;

    @FindBy(id = "Deductions-SaveAndContinue")
    WebElement saveAndContinueBtn;

    public void selectAddtlDeductionOption(String addtlDeductionOption){
        switch(addtlDeductionOption){
            case "None of these":
                addtlDeductionOptionsCheckbox.get(10).click();
                break;
        }
        saveAndContinueBtn.click();
    }
}
