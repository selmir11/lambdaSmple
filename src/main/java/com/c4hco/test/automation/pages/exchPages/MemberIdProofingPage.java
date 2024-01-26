package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MemberIdProofingPage {

    private BasicActions basicActions;

    public MemberIdProofingPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(xpath = "//div/input[@id='answer11']")
    WebElement employerName;
    @FindBy(xpath = "//div/input[@id='answer21']")
    WebElement homeAddress;
    @FindBy(xpath = "//div/input[@id='answer31']")
    WebElement carLoanBank;
    @FindBy(xpath = "//input[@value='Save and Continue']")
    WebElement saveContinue;

    public void selectFirstOptionToAll(){
        // update the names of the locators to reflect they all are first available options
        employerName.click();
        homeAddress.click();
        carLoanBank.click();
        saveContinue.click();
    }

//    public void selectEmployerName(){
//        employerName.click();
//    }
//    public void selectHomeAddress(){
//        homeAddress.click();
//    }
//    public void selectBank(){
//        carLoanBank.click();
//    }
//    public void clickSaveContinue(){
//        saveContinue.click();
//    }

}
