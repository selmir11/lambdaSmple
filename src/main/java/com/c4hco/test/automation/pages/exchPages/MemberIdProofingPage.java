package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MemberIdProofingPage {

    private BasicActions basicActions;

    public MemberIdProofingPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(xpath = "//div/input[@id='answer11']")
    WebElement firstOptionInEmployerName;
    @FindBy(xpath = "//div/input[@id='answer21']")
    WebElement firstOptionInHomeAddress;
    @FindBy(xpath = "//div/input[@id='answer31']")
    WebElement firstOptionInCarLoanBank;
    @FindBy(id = "submitButton")
    WebElement saveContinue;

    public void selectFirstOptionToAll(){
        firstOptionInEmployerName.click();
        firstOptionInHomeAddress.click();
        firstOptionInCarLoanBank.click();
        saveContinue.click();
    }

}
