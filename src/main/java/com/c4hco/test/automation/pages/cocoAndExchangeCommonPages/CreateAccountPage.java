package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.PolicyMember;
import com.c4hco.test.automation.utils.SharedData;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

public class CreateAccountPage {
    SoftAssert softAssert = new SoftAssert();

    @FindBy(css = "app-create-account a em")
    WebElement helpIcon;

    @FindBy(css = ".drawer-contents .drawer-body .drawer-text-content p")
    List<WebElement> helpDrawerText;

    @FindBy(xpath="//a[contains(@class, 'btn')]")
    WebElement closeHelpIcon;

    @FindBy(xpath = "//p[contains(text(),'Connect for Health Colorado es el mercado oficial ')]")
     WebElement helpDrawerTextSP;

    @FindBy(xpath = "//em[@class='fas fa-question-circle']")
     WebElement helpDrawerButton;

    @FindBy(css = ".boot-input-group .help-label")
    WebElement helpLabel;

    @FindBy(id = "fn")
     WebElement firstName;

    @FindBy(id = "ln")
     WebElement lastName;

    @FindBy(id = "email")
     WebElement email;

    @FindBy(id = "phone")
     WebElement phoneNumber;

    @FindBy(id = "password")
     WebElement password;

    @FindBy(id = "confirm-password")
     WebElement confirmPassword;

    @FindBy(xpath = "//*[@for='English']")
     WebElement preferredLanguageButtonEnglish;

    @FindBy(id = "primaryUser-input")
     WebElement primaryUserCheckbox;

    @FindBy(id = "cocoUser-input")
     WebElement cocoTermsOfUseCheckbox;

    @FindBy(id = "exchUser-input")
     WebElement exchangeTermsOfUseCheckbox;

    @FindBy(id = "submit-button")
     WebElement submitButton;

    private BasicActions basicActions;
    public CreateAccountPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickHelpIcon(){
        softAssert.assertTrue(basicActions.waitForElementToBePresent(helpIcon, 20));
        basicActions.waitForElementToBeClickable(helpIcon, 20);
        helpIcon.click();
        basicActions.waitForElementToDisappear(helpIcon, 10);
    }

    public void closeHelpIcon(){
       softAssert.assertTrue(basicActions.waitForElementToBePresent(closeHelpIcon, 20));
        basicActions.waitForElementToBePresent(closeHelpIcon, 20);
        basicActions.waitForElementToBeClickable(closeHelpIcon, 20);
        closeHelpIcon.click();
        basicActions.waitForElementToBePresent(helpLabel, 30);
    }

    public void clickHelpIconButton(){
        basicActions.waitForElementToBeClickable(helpDrawerButton,1000);
        helpDrawerButton.click();
    }

    public static String getUniqueString(int length){
        return RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz");
    }

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
        SharedData.setAppType(appType);
        addDetails();
        switch(appType){
            case "coco":
                cocoTermsOfUseCheckbox.click();
                break;
            case "exchange":
                exchangeTermsOfUseCheckbox.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + appType);

        }
        submitButton.click();
    }

    public void initializeData(){
        PolicyMember subscriber = new PolicyMember();
        subscriber.setFirstName(getUniqueString(8)+"TestMember");
        subscriber.setLastName(getUniqueString(8)+"Test");
        subscriber.setEmailId("AutomationUser."+subscriber.getLastName()+"@test.com");
        subscriber.setPhoneNumber((String) generatePhoneNumber());
        SharedData.setSubscriber(subscriber);
    }

    public void addDetails(){
        initializeData();
        PolicyMember subscriber = SharedData.getSubscriber();
        firstName.sendKeys(subscriber.getFirstName());
        lastName.sendKeys(subscriber.getLastName());
        email.sendKeys(subscriber.getEmailId());
        phoneNumber.sendKeys(subscriber.getPhoneNumber());
        password.sendKeys(subscriber.getPassword());
        confirmPassword.sendKeys(subscriber.getPassword());
        subscriber.setSignature(subscriber.getFirstName()+" "+subscriber.getLastName());
        preferredLanguageButtonEnglish.click();
        primaryUserCheckbox.click();
        SharedData.setSubscriber(subscriber);
    }

    public void validateHelpText(String language){
        switch(language) {
        case "English":
            validateHelpVerbiage();
            break;
        case "Spanish":
            validateHelpVerbiageSP();
            break;
        default:
            throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    // ############################## VALIDATION METHODS #########################

    public void validateHelpVerbiage(){
        basicActions.waitForElementToBePresent(helpDrawerText.get(0), 30);
        softAssert.assertEquals(helpDrawerText.get(0).getText(), "Connect for Health Colorado and Colorado Connect are committed to protecting your privacy and will keep the information you provide private as required by law.");
        softAssert.assertEquals(helpDrawerText.get(1).getText(), "Connect for Health Colorado");
        softAssert.assertEquals(helpDrawerText.get(3).getText(), "Customers who apply through Connect for Health Colorado may be subject to eligibility verification, including information matching with state and federal partners. Personal information, including information about immigration status, cannot be used for immigration enforcement.");
        softAssert.assertEquals(helpDrawerText.get(4).getText(), "Colorado Connect");
        softAssert.assertEquals(helpDrawerText.get(5).getText(), "Colorado Connect was created by Connect for Health Colorado to help more Coloradans enroll in health insurance. Starting in 2023, people who are undocumented can access health insurance through Colorado Connect. Financial help is also available for those who qualify. Personal information of customers who choose to share information only with Colorado Connect is stored separately from Connect for Health Colorado. Your personal information is not shared with federal partners for any purpose and cannot be used for immigration enforcement.");
        softAssert.assertAll();
    }

    public void validateHelpVerbiageSP() {
        basicActions.waitForElementToBePresent(helpDrawerTextSP, 60);
        softAssert.assertEquals(helpDrawerTextSP.getText(),"Connect for Health Colorado es el mercado oficial de seguros de salud de Colorado. Desde 2013, Connect for Health ha estado ayudando a individuos, familias, y peque\u00f1as empresas a comparar planes, solicitar ayuda financiera y adquirir seguros de salud.");
        softAssert.assertAll();
    }





}
