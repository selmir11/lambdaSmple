package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.RandomDynamicData;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExCreateAccount {
    @FindBy(xpath = "//input[@id='fn']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='ln']")
    WebElement lastName;

    @FindBy(xpath = "//*[@id='email']")
    WebElement email;

    @FindBy(xpath = "//*[@id='phone']")
    WebElement phone;

    @FindBy(xpath = "//*[@id='password']")
    WebElement password;

    @FindBy(xpath = "//*[@id='confirm-password']")
    WebElement confirmPassword;

    @FindBy(xpath = "//label[contains(text(), 'English')]")
    WebElement btnEnglish;

    @FindBy(xpath = "//*[contains(text(), 'I am the primary user/account holder')]")
    WebElement chkPrimaryAccountHolder;

    @FindBy(xpath = "//*[@id='exchUser-input']")
    WebElement exchangeUserConsent;

    @FindBy(xpath = "//*[@id='submit-button']")
    WebElement btnSubmit;


    private BasicActions basicActions;
    public ExCreateAccount(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    RandomDynamicData dataInstance = RandomDynamicData.getInstance();


//    public void createExAccount(){
//        System.out.println("Entering account details");
//        firstName.clear();
//        firstName.sendKeys(dataInstance.fname);
//        System.out.println("First Name: "+dataInstance.fname);
//        lastName.clear();
//        lastName.sendKeys(dataInstance.lname);
//        System.out.println("Last Name: "+dataInstance.lname);
//        email.clear();
//        email.sendKeys(dataInstance.fullEmail);
//        System.out.println("Email: "+ dataInstance.fullEmail);
//        phone.clear();
//        phone.sendKeys("723-333-2130");
//        password.clear();
//        password.sendKeys(dataInstance.loginPassword);
//        System.out.println("Password: "+dataInstance.loginPassword);
//        confirmPassword.clear();
//        confirmPassword.sendKeys(dataInstance.loginPassword);
//        System.out.println("Confirm Password: "+dataInstance.loginPassword);
//        btnEnglish.click();
//        chkPrimaryAccountHolder.click();
//        exchangeUserConsent.click();
//    }

    public void submit() throws InterruptedException {

        btnSubmit.click();
        Thread.sleep(5000);

        System.out.println("Clicked Submit button");
    }












}
