package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationResultsPage {

    @FindBy(id = "month-pay")
    WebElement lblAPTCValue;

    @FindBy(xpath = "//*[@name='redirectToShoppingPortal']")
    WebElement continueBtn;
    private BasicActions basicActions;

    public ApplicationResultsPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }


    public void clickBtnContinue(){
        continueBtn.click();
    }

    public void validateAPTC(String expectedAPTC){
        basicActions.waitForElementToBePresent(lblAPTCValue, 15);
        String APTC = lblAPTCValue.getText();
        Assert.assertTrue("Incorrected APTC Amount! Expected "+expectedAPTC+" but "+APTC+" displayed.", APTC.contains(expectedAPTC));
    }
}
