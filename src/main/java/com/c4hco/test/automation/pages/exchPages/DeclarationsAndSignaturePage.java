package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class DeclarationsAndSignaturePage {
    private BasicActions basicActions;

    public DeclarationsAndSignaturePage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(xpath = "//div/label/b[1]")
    WebElement memberName;
    @FindBy(xpath = "//*[@id='signeeList0.signature']")
    WebElement signatureBox;

    @FindBy(xpath = "//*[@value='Continue']")
    WebElement submitContinue;

    @FindBy(id = "holdon-content")
    WebElement holdOnEllipsis;



    public void enterSignature(){
        String signature = memberName.getText();
        signatureBox.sendKeys(signature);
    }
    public void submitApplication()  {
        submitContinue.click();
    }

    public void waitForHoldOnContentToDisappear(){
        SoftAssert softAssert = new SoftAssert();
    softAssert.assertTrue(basicActions.waitForElementToDisappear(holdOnEllipsis, 10));
    softAssert.assertAll();
    }
}
