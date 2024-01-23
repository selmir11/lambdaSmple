package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeclarationsAndSignature_LR {
    private BasicActions basicActions;

    public DeclarationsAndSignature_LR() {
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



    public void enterSignature(){
        String signature = memberName.getText();
        signatureBox.sendKeys(signature);
        System.out.println("Signature: "+signature);
    }
    public void submitApplication() throws InterruptedException {
        submitContinue.click();
        Thread.sleep(10000);
    }
}
