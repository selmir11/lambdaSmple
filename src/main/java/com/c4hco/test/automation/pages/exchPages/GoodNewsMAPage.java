package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class GoodNewsMAPage {
    SoftAssert softAssert = new SoftAssert();

    private BasicActions basicActions;
    public GoodNewsMAPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(css = "#submitButton")
    List<WebElement> btnSubmit;

    @FindBy(css = "p.c4BodyText1")
    WebElement textMAEligibility;

    public void clickNextOption(String nextOption){
        basicActions.waitForElementListToBePresent(btnSubmit, 20);
        switch(nextOption) {
            case "No Thanks":
                btnSubmit.get(1).click();
                break;
            case "Continue":
                btnSubmit.get(0).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + nextOption);
        }
    }

    public void verifyTextMAEligibility() {
        basicActions.waitForElementToBePresent(btnSubmit.get(0), 20);
        softAssert.assertEquals(textMAEligibility.getText(), "Based on the information you provided, one or more members of your household may qualify for Health First Colorado (Colorado's Medicaid Program) or Child Health Plan Plus (CHP+). We have just a few more questions to see if you qualify.");
        softAssert.assertAll();
    }
}
