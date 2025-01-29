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
        basicActions.waitForElementToBePresent(unauthorizedTxt, 60);
        String[] parts = language.split(":");
        String lang = parts[0];
        String pageType = (parts.length > 1) ? parts[1] : "";
        String color = getColorForPageType(pageType);
        switch (lang) {
            case "English":
                softAssert.assertEquals(unauthorizedTxt.getText(), "UNAUTHORIZED");
                softAssert.assertEquals(unauthorizedTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(unauthorizedTxt.getCssValue("font-size"), "40px");
                softAssert.assertEquals(unauthorizedTxt.getCssValue("font-weight"), "500");
                softAssert.assertEquals(unauthorizedTxt.getCssValue("color"), color);
                softAssert.assertEquals(unauthorizedTxt.getCssValue("background"), "rgba(0, 0, 0, 0) none repeat scroll 0% 0% / auto padding-box border-box");
                break;
            case "Spanish":
                softAssert.assertEquals(unauthorizedTxt.getText(), "NO AUTORIZADO");
                softAssert.assertEquals(unauthorizedTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(unauthorizedTxt.getCssValue("font-size"), "40px");
                softAssert.assertEquals(unauthorizedTxt.getCssValue("font-weight"), "500");
                softAssert.assertEquals(unauthorizedTxt.getCssValue("color"), color);
                softAssert.assertEquals(unauthorizedTxt.getCssValue("background"), "rgba(0, 0, 0, 0) none repeat scroll 0% 0% / auto padding-box border-box");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + lang);
        }
        softAssert.assertAll();
    }

    private String getColorForPageType(String pageType) {
        if ("Income".equals(pageType)) {
            return "rgba(33, 37, 41, 1)";
        } else {
            return "rgba(77, 77, 79, 1)";
        }
    }

}
