package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class StartShoppingPage {
    private BasicActions basicActions;


    public StartShoppingPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "SHP-StartShop-Continue")
    WebElement btnContinue;

    @FindBy(xpath = "//*[text() = 'No']")
    WebElement btnNo;

    @FindBy(xpath = "//*[text() = 'Yes ']")
    WebElement btnYes;

    @FindBy(xpath = "//*[text()='Save and Exit']")
    WebElement saveAndExitButton;

    @FindBy(xpath = "//*[@class='header-1 center']")
    WebElement headerText;

    @FindBy(xpath = "//div[normalize-space()='First, we need to ask you about tobacco usage.']")
    WebElement secondLineText;

    @FindBy(xpath = "//div[contains(text(),\"Next, you'll set up your shopping groups.\")]")
    WebElement nextYouWillReviewText;

    @FindBy(xpath = "//*[contains(text(),\"Not ready to shop?\")]")
    WebElement notReady;

    public void iSelectTobaccoUsage(String option) {
        switch (option) {
            case "Yes":
                basicActions.waitForElementToBeClickable(btnYes,10);
                btnYes.click();
                break;
            case "No":
                basicActions.waitForElementToBeClickable(btnNo,10);
                btnNo.click();
                break;
        }
    }
    public void clickBtnSaveNExit(){
        saveAndExitButton.click();
    }
    public void clickContinue(){
        softAssert.assertTrue(basicActions.waitForElementToBePresent(btnContinue, 20));
        basicActions.waitForElementToBeClickable(btnContinue,10);
        btnContinue.click();
    }

    //-----------------------Validations------------------------//
    public void verifyTextOnTobaccoPage(){ 
        basicActions.waitForElementToBePresent(headerText,10);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(headerText.getText(), "It's almost time to start shopping for a health insurance plan!");
        softAssert.assertEquals(secondLineText.getText(), "First, we need to ask you about tobacco usage.");
        softAssert.assertEquals(btnNo.getText(), "No");
        softAssert.assertEquals(btnYes.getText(), "Yes");
        softAssert.assertEquals(saveAndExitButton.getText(), "Save and Exit");
        softAssert.assertEquals(btnContinue.getText(), "Continue");
        softAssert.assertEquals(nextYouWillReviewText.getText(), "Next, you'll set up your shopping groups.");
        softAssert.assertEquals(notReady.getText(), "Not ready to shop? Now's a good time to save your progress.");
        softAssert.assertAll();
    }
}
