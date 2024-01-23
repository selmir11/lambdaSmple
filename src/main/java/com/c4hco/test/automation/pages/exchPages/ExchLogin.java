package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.RandomDynamicData;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class ExchLogin extends ExCreateAccount{
    @FindBy(xpath = "//*[@formcontrolname='username']")
    WebElement uName;

    @FindBy(xpath = "//*[@formcontrolname='password']")
    WebElement password;

    @FindBy(xpath = "//*[@id='main-sign-in']")
    WebElement btnSignIn;

    @FindBy(xpath = "//*[@class='login-header']")
    WebElement headerText;

    private BasicActions basicActions;
    RandomDynamicData dataInstance = RandomDynamicData.getInstance();
    public ExchLogin(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }
    ExCreateAccount createExAccount = new ExCreateAccount();

    public void validateLoginPage() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue("Did not find Login Page",headerText.getText().contains("Sign in"));

    }
    public void username(){
        uName.click();
        uName.sendKeys(dataInstance.fullEmail);
        System.out.println("Entered user name: "+dataInstance.fullEmail);
    }

    public void enterPwd(){
        password.sendKeys(dataInstance.loginPassword);
        System.out.println("Entered password: "+dataInstance.loginPassword );
    }


    public void signIn() throws InterruptedException {
        sleep(5000);
        btnSignIn.click();
    }
}
