package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class LoginPage {

    @FindBy(id = "create-account-link")
    WebElement createAccountLink;

    @FindBy(css = "app-create-account a em")
    WebElement helpIcon;

    @FindBy(css = ".drawer-contents .drawer-body .drawer-text-content p")
    List<WebElement> helpDrawerText;


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

    public void clickHelpIcon(){
        // login-portal page
        helpIcon.click();
    }

    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line

    public void validateHelpVerbiage(){
        // there are total 6 paragraphs here
        // work on the apostrophe
        String text = "Connect for Health Colorado is Colorado’s official health insurance marketplace. Since 2013, Connect for Health Colorado has been helping individuals, families and small employers compare plans, apply for financial help and buy health insurance.";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(helpDrawerText.get(0).getText(), "Connect for Health Colorado and Colorado Connect are committed to protecting your privacy and will keep the information you provide private as required by law.");
        softAssert.assertEquals(helpDrawerText.get(1).getText(), "Connect for Health Colorado");
        softAssert.assertEquals(helpDrawerText.get(2).getText(), text);
        softAssert.assertEquals(helpDrawerText.get(3).getText(), "Customers who apply through Connect for Health Colorado may be subject to eligibility verification, including information matching with state and federal partners. Personal information, including information about immigration status, cannot be used for immigration enforcement.");
        softAssert.assertEquals(helpDrawerText.get(4).getText(), "Colorado Connect");
        softAssert.assertEquals(helpDrawerText.get(5).getText(), "Colorado Connect was created by Connect for Health Colorado to help more Coloradans enroll in health insurance. Starting in 2023, people who are undocumented can access health insurance through Colorado Connect. Financial help is also available for those who qualify. Personal information of customers who choose to share information only with Colorado Connect is stored separately from Connect for Health Colorado. Your personal information is not shared with federal partners for any purpose and cannot be used for immigration enforcement.");
        softAssert.assertAll();
    }
}
