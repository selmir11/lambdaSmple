package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeclarationsAndSignaturePage {
    private BasicActions basicActions;

    public DeclarationsAndSignaturePage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".container h1")
    WebElement hdrDeclarations;

    @FindBy(name = "continue")
    WebElement submitContinue;

    @FindBy(id = "holdon-content")
    WebElement holdOnEllipsis;

    public void enterSignature(int index){
        basicActions.waitForElementToBePresent(hdrDeclarations,20);
        basicActions.waitForElementToBePresent(submitContinue,20);
        String namePath = "(//div/label/b[1])["+index+"]";
        String signature = basicActions.getDriver().findElement(By.xpath(namePath)).getText();

        index = index-1;

        String signBoxPath = "signeeList"+index+".signature";
        WebElement signatureBox =  basicActions.getDriver().findElement(By.id(signBoxPath));
        signatureBox.click();
        signatureBox.sendKeys(signature);
    }

    public void submitApplication()  {
        basicActions.waitForElementToBePresent(submitContinue, 30);
        submitContinue.click();
    }

    public void waitForHoldOnContentToDisappear(){
    basicActions.waitForElementToDisappear(holdOnEllipsis, 120);
    }
}
