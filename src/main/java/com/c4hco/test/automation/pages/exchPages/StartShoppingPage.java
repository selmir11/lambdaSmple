package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class StartShoppingPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();


    public StartShoppingPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "SHP-StartShop-Continue")
    WebElement btnContinue;

    @FindBy(xpath = "//*[@class='button-text-selected']")
   List<WebElement> btnNo;

    @FindBy(xpath = "//*[@class='button-text-unselected']")
    List<WebElement> btnYes;

    @FindBy(xpath = "//*[text()='Save and Exit']")
    WebElement saveAndExitButton;

    @FindBy(xpath = "//*[@class='header-1 center']")
    WebElement headerText;
    @FindBy(xpath = "//*[@class='body-text-1 center']")
    List<WebElement> bodyText;

    public void iSelectTobaccoUsage(String option) {
        switch (option) {
            case "Yes":
                basicActions.waitForElementToBeClickable(btnYes.get(1),10);
                btnYes.get(1).click();
                break;
            case "No":
                basicActions.waitForElementToBeClickable(btnNo.get(1),10);
                btnNo.get(1).click();
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
        softAssert.assertEquals(bodyText.get(1), "First, we need to ask you about tobacco usage.");
        softAssert.assertEquals(btnNo.get(1), "No");
        softAssert.assertEquals(btnYes.get(1), "Yes");
        softAssert.assertEquals(saveAndExitButton.getText(), "Save and Exit");
        softAssert.assertEquals(btnContinue.getText(), "Continue");
        softAssert.assertEquals(bodyText.get(3), "Next, you'll set up your shopping groups.");
        softAssert.assertEquals(bodyText.get(4), "Not ready to shop? Now's a good time to save your progress.");
        softAssert.assertAll();
    }
}
