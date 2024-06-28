package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TobaccoUsageCoCoPage {
    SoftAssert softAssert = new SoftAssert();

    @FindBy(css = "#SHP-StartShop-Continue")
    WebElement continueButton;
    private BasicActions basicActions;

    @FindBy(css = ".container .radio-button")
    List<WebElement> btnNoAndYes;

    @FindBy(id = "SHP-StartShop-SaveAndExit")
    WebElement saveAndExitButton;
    @FindBy(css = ".container .header-1")
    WebElement headerText;
    @FindBy(css = ".container .body-text-1")
    List<WebElement> bodyText;

    public TobaccoUsageCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void selectContinueTobacco() {
        basicActions.waitForElementToBeClickableWithRetries(continueButton, 120);
        basicActions.scrollToElement(continueButton);
        continueButton.click();
    }

    public void verifyTextOnTobaccoPage() {
        basicActions.waitForElementToBePresent(headerText, 10);
        softAssert.assertEquals(headerText.getText(), "It's almost time to start shopping for a health insurance plan!");
        softAssert.assertEquals(bodyText.get(1), "First, we need to ask you about tobacco usage.");
        softAssert.assertEquals(bodyText.get(2), "Within the last 6 months, has any member of your household used tobacco products regularly");
        softAssert.assertEquals(btnNoAndYes.get(1), "No");
        softAssert.assertEquals(btnNoAndYes.get(2), "Yes");
        softAssert.assertEquals(saveAndExitButton.getText(), "Save and Exit");
        softAssert.assertEquals(continueButton, "Continue");
        softAssert.assertEquals(bodyText.get(3), "Next, you'll set up your shopping groups.");
        softAssert.assertEquals(bodyText.get(4), "Not ready to shop? Now's a good time to save your progress.");
        softAssert.assertAll();
    }
}
