package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class StartShoppingPage {
    private BasicActions basicActions;

    public StartShoppingPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(xpath = "//*[text() = 'Continue']")
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
    @FindBy(xpath = "//div[contains(text(),\"Next, you'll review your plan options and pick an \")]")
    WebElement nextYouWillReviewText;
    @FindBy(xpath = "//*[contains(text(),\"Not ready to shop?\")]")
    WebElement notReady;

    public void clickNo(){
        btnNo.click();
    }
    public void clickYes(){
        btnYes.click();
    }
    public void clickBtnSaveNExit(){
        saveAndExitButton.click();
    }
    public void clickContinue(){
        btnContinue.click();
    }
    public void verifyTextOnTobaccoPage(){
        String header  = headerText.getText();
        System.out.println(header);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(headerText.getText(), "It's almost time to start shopping for a health insurance plan!");
        softAssert.assertEquals(secondLineText.getText(), "First, we need to ask you about tobacco usage.");
        softAssert.assertEquals(btnNo.getText(), "No");
        softAssert.assertEquals(btnYes.getText(), "Yes");
        softAssert.assertEquals(saveAndExitButton.getText(), "Save and Exit");
        softAssert.assertEquals(btnContinue.getText(), "Continue");
        softAssert.assertEquals(nextYouWillReviewText.getText(), "Next, you'll review your plan options and pick an insurance plan that fits your needs.");
        softAssert.assertEquals(notReady.getText(), "Not ready to shop? Now's a good time to save your progress.");
        softAssert.assertAll();

    }
}
