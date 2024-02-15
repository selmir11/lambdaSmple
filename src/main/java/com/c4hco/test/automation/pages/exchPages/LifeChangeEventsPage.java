package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LifeChangeEventsPage {

    private BasicActions basicActions;

    public LifeChangeEventsPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(css = ".input-checkbox")
    List<WebElement> lceInputCheckbox;

    @FindBy(id = "continueButton")
    WebElement saveAndContinueButton;

    public void selectLCE(String lceOption){
        switch(lceOption){
                case "Birth":
                    lceInputCheckbox.get(0).click();
                    break;
                case "Pregnancy":
                    lceInputCheckbox.get(1).click();
                    break;
            case "Marriage":
                lceInputCheckbox.get(2).click();
                break;
            case "LostCoverage":
                lceInputCheckbox.get(3).click();
                break;
                case "MovedToColorado":
                    lceInputCheckbox.get(6).click();
                    break;
            }
        saveAndContinueButton.click();
    }
}
