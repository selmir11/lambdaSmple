package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class AccountOverviewPage {

    @FindBy(name = "applyForCurrentYear")
    WebElement btnApplyForCurrentYear;

    @FindBy(xpath = "(//b[.='Click here'])[1]")
    WebElement MyProfileButtonExch;

    @FindBy(css = "h4 .c4PageHeader")
    WebElement txtNextStep;

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public AccountOverviewPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    public void clickApplyForCurrentYear(){
        basicActions.waitForElementToBeClickable(btnApplyForCurrentYear,10);
        btnApplyForCurrentYear.click();
    }


    public void clickMyProfileButtonExch() {
        basicActions.waitForElementToBeClickable(MyProfileButtonExch, 5);
        MyProfileButtonExch.click(); }

    // ================VALIDATION METHODS================//
    public void verifyLanguageText(String language) {
        switch (language) {
            case "English":
                validateNextStepEnglish();
                break;
            case "Spanish":
                validateNextStepSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateNextStepEnglish() {
        basicActions.waitForElementToBePresent(txtNextStep,10);
        softAssert.assertEquals(txtNextStep.getText(), "Next step: Apply for health insurance");
        softAssert.assertAll();
    }

    public void validateNextStepSpanish() {
        basicActions.waitForElementToBePresent(txtNextStep,10);
        softAssert.assertEquals(txtNextStep.getText(), "Paso siguiente: Solicitar seguro de salud");
        softAssert.assertAll();
    }

}
