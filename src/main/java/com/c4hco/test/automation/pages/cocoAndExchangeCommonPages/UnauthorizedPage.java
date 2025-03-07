package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class UnauthorizedPage {

    @FindBy(xpath = "//lib-unauthorized/h1")
    WebElement unauthorizedTxt;



    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public UnauthorizedPage(WebDriver webDriver) {
    basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
}

    public void verifyUnauthorizedText(String language) {
        basicActions.wait(50);
        basicActions.waitForElementToBePresent(unauthorizedTxt, 60);
        switch (language) {
            case "English":
                softAssert.assertEquals(unauthorizedTxt.getText(), "UNAUTHORIZED");
                softAssert.assertEquals(unauthorizedTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(unauthorizedTxt.getCssValue("font-size"), "36px");
                softAssert.assertEquals(unauthorizedTxt.getCssValue("font-weight"), "700");
                softAssert.assertEquals(unauthorizedTxt.getCssValue("color"), "rgba(43, 49, 60, 1)");
                softAssert.assertEquals(unauthorizedTxt.getCssValue("background"), "rgba(0, 0, 0, 0) none repeat scroll 0% 0% / auto padding-box border-box");
                break;
            case "Spanish":
                softAssert.assertEquals(unauthorizedTxt.getText(), "NO AUTORIZADO");
                softAssert.assertEquals(unauthorizedTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(unauthorizedTxt.getCssValue("font-size"), "36px");
                softAssert.assertEquals(unauthorizedTxt.getCssValue("font-weight"), "700");
                softAssert.assertEquals(unauthorizedTxt.getCssValue("color"), "rgba(43, 49, 60, 1)");
                softAssert.assertEquals(unauthorizedTxt.getCssValue("background"), "rgba(0, 0, 0, 0) none repeat scroll 0% 0% / auto padding-box border-box");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

}
