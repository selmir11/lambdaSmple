package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

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
}
