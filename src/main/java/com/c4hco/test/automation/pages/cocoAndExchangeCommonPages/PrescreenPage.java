package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class PrescreenPage {

    SoftAssert softAssert= new SoftAssert();
    @FindBy(css = ".linkText1")
    WebElement createMyAccount;
    @FindBy(xpath= "//header/div[2]//nav/ul/li[3]/a")
    WebElement signIn;
    @FindBy(css= ".btn.btn-c4primary")
    WebElement helpMeUnderstandWhatIQualifyForBtn;

    private BasicActions basicActions;
    public PrescreenPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickCreateAccountLink(){
        createMyAccount.click();
    }

    public void verifySignInDisplayed() {
        basicActions.waitForElementToBePresent(signIn,10);
        softAssert.assertEquals(signIn.getText(),"Sign In");
        softAssert.assertAll();
    }

    public void clickOnHelpMeUnderstandWhatIQualifyFor() {
        helpMeUnderstandWhatIQualifyForBtn.click();
    }

    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line


}
