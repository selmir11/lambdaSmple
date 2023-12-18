package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "create-account-link")
    WebElement createAccountLink;

    private BasicActions basicActions;
    public LoginPage(){
          this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void openPage(){
        basicActions.getDriver().get("https://qa-aws.connectforhealthco.com/login-portal");
    }

    public void clickCreateAccount(){
        System.out.println("click create account");
       createAccountLink.click();
    }
}
