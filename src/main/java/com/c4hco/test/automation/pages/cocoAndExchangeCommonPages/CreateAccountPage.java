package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

public class CreateAccountPage {
    @FindBy(css = "app-create-account a em")
    WebElement helpIcon;

    @FindBy(css = ".drawer-contents .drawer-body .drawer-text-content p")
    private  List<WebElement> helpDrawerText;

    @FindBy(xpath = "//label[@class='help-label ng-tns-c2-0']")
    private WebElement helpIconSP;

    @FindBy(xpath="//a[contains(@class, 'btn')]")
    WebElement closeHelpIcon;

    @FindBy(xpath = "//p[contains(text(),'Connect for Health Colorado es el mercado oficial ')]")
    private WebElement helpDrawerTextSP;

    @FindBy(xpath = "//em[@class='fas fa-question-circle']")
    private WebElement helpDrawerButton;

    @FindBy(xpath = "//div[13]/div[1]/em")
    private WebElement helpDrawerButtonSP;

    @FindBy(id = "fn")
    private WebElement firstName;

    @FindBy(id = "ln")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "phone")
    private WebElement phoneNumber;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "confirm-password")
    private WebElement confirmPassword;

    @FindBy(xpath = "//*[@for='English']")
    private WebElement preferredLanguageButtonEnglish;

    @FindBy(id = "primaryUser-input")
    private WebElement primaryUserCheckbox;

    @FindBy(id = "cocoUser-input")
    private WebElement cocoTermsOfUseCheckbox;

    @FindBy(xpath = "//*[@id='exchUser-input']")
    private WebElement exchangeTermsOfUseCheckbox;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    private BasicActions basicActions;
    public CreateAccountPage(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    public void clickHelpIcon(){
        basicActions.waitForElementToBeClickable(helpIcon, 5);
        helpIcon.click();
    }

    public void closeHelpIcon(){
        basicActions.waitForElementToBeClickable(closeHelpIcon, 60);
        closeHelpIcon.click();
    }

    public void clickHelpIconButton(){
        basicActions.waitForElementToBeClickable(helpDrawerButton,1000);
        helpDrawerButton.click();
    }

    public static String getUniqueString(int length){
        return RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz");
    }

    public static String frstName = getUniqueString(8);
    public static String lstName = getUniqueString(8);
    public static String Initials = String.valueOf(frstName.charAt(1)+lstName.charAt(1));
    public static String emailId = lstName + Initials + "@test.com";
    public static String phnNumber = (String) generatePhoneNumber();
    public static String pswrd = "ALaska12!";

    public static CharSequence generatePhoneNumber(){
        Random rand = new Random();
        int num1 = (rand.nextInt(7)+1)*100;
        int num2 = rand.nextInt(743);
        int num3 = rand.nextInt(10000);
        DecimalFormat df3 = new DecimalFormat("000");
        DecimalFormat df4 = new DecimalFormat("0000");
        String phoneNumber = df3.format(num1) + "-" + df3.format(num2) + "-" + df4.format(num3);
        return phoneNumber;
    }

    public void createGeneralAccount(String appType){
        // Creates the primary user/Account holder
        switch(appType){
            case "coco":
                addDetails();
                cocoTermsOfUseCheckbox.click();
                submitButton.click();
                break;
            case "exchange":
                addDetails();
                exchangeTermsOfUseCheckbox.click();
                submitButton.click();
        }

    }

    public void addDetails(){
        firstName.sendKeys(frstName);
        lastName.sendKeys(lstName);
        email.sendKeys(emailId);
        phoneNumber.sendKeys(phnNumber);
        password.sendKeys(pswrd);
        confirmPassword.sendKeys(pswrd);
        preferredLanguageButtonEnglish.click();
        primaryUserCheckbox.click();
    }
    public void validateHelpText(String Language){
     switch(Language) {
        case "English":
            validateHelpVerbiage();
            break;
        case "Spanish":
            validateHelpVerbiageSP();
            break;
        default:
            System.out.println("The wrong language option has been selected");
        }
    }

    // ############################## VALIDATION METHODS #########################

    public void validateHelpVerbiage(){
        basicActions.waitForElementToBePresent(helpDrawerText.get(0), 30);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(helpDrawerText.get(0).getText(), "Connect for Health Colorado and Colorado Connect are committed to protecting your privacy and will keep the information you provide private as required by law.");
        softAssert.assertEquals(helpDrawerText.get(1).getText(), "Connect for Health Colorado");
        softAssert.assertEquals(helpDrawerText.get(3).getText(), "Customers who apply through Connect for Health Colorado may be subject to eligibility verification, including information matching with state and federal partners. Personal information, including information about immigration status, cannot be used for immigration enforcement.");
        softAssert.assertEquals(helpDrawerText.get(4).getText(), "Colorado Connect");
        softAssert.assertEquals(helpDrawerText.get(5).getText(), "Colorado Connect was created by Connect for Health Colorado to help more Coloradans enroll in health insurance. Starting in 2023, people who are undocumented can access health insurance through Colorado Connect. Financial help is also available for those who qualify. Personal information of customers who choose to share information only with Colorado Connect is stored separately from Connect for Health Colorado. Your personal information is not shared with federal partners for any purpose and cannot be used for immigration enforcement.");
        softAssert.assertAll();
    }

    public void validateHelpVerbiageSP() {
        basicActions.waitForElementToBePresent(helpDrawerTextSP, 60);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(helpDrawerTextSP.getText().contains("Connect for Health Colorado es el mercado oficial de seguros de salud de Colorado"));

    }





}
