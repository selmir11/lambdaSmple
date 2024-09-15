package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ApplicationResultsCoCoPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public ApplicationResultsCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "ELIG-MemberPlanInfo-SaveAndContinue")
    public WebElement continueButton;

    @FindBy(id = "ELIG-NoApplication-BackToWelcomePage")
    public WebElement backToWelcomeButton;

    @FindBy(css = ".container .header-1")
    WebElement applicationResultsHeader;

    @FindBy(xpath = "//div[contains(text(), \"Here's what your household qualifies for\")]")
    WebElement hereIsWhatYourHouseholdQualifiesHeader;

    @FindBy(css = ".body-text-2")
    List<WebElement> doNotQualifyForHealthPlanText;

    @FindBy(css = ".body-text-1")
    WebElement submitNewApplicationText;
    @FindBy(css = "div.plan-name.eligible")
    WebElement eligiblePlanSESOff;

    public void backToWelcomeButton() {
        basicActions.waitForElementToBeClickable(backToWelcomeButton, 5);
        backToWelcomeButton.click();
    }

    public void continueWithApplication()  {
        basicActions.waitForElementToBeClickable(continueButton, 20);
        continueButton.click();
    }

    public void verifyHeader(String language)  {
        switch (language) {
            case "English":
                basicActions.waitForElementToBePresent(applicationResultsHeader,20);
                softAssert.assertEquals(applicationResultsHeader.getText(), "Application results");
                softAssert.assertAll();
                break;
            case "Spanish":
                basicActions.waitForElementToBePresent(applicationResultsHeader,20);
                softAssert.assertEquals(applicationResultsHeader.getText(), "Resultados de la solicitud");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyTextNotQualifyForPlanOnAppResultsPage(){
        basicActions.waitForElementToBePresent(hereIsWhatYourHouseholdQualifiesHeader,10);
        softAssert.assertEquals(hereIsWhatYourHouseholdQualifiesHeader.getText(), "Here's what your household qualifies for");
        softAssert.assertEquals(doNotQualifyForHealthPlanText.get(0).getText(), "Based on the information listed in your application, you do not qualify for a health plan at this time.");
        softAssert.assertEquals(doNotQualifyForHealthPlanText.get(1).getText(), "You must live in Colorado");
        softAssert.assertEquals(submitNewApplicationText.getText(), "If your situation changes you can submit a new application to re-apply and newly qualify.");
        softAssert.assertAll();
    }
    public void verifyEligibleplans(String ses){
        basicActions.waitForElementToBePresent(hereIsWhatYourHouseholdQualifiesHeader,10);
        if(ses.equals("off")) {
            softAssert.assertEquals(eligiblePlanSESOff.getText(), "Health insurance plans through Colorado Connect");
        }
        softAssert.assertAll();
        }
}
