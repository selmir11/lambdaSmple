package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AccountOverviewPage {

    @FindBy(css = "li.vertical-ruler")
    WebElement userNameExchLink;

    @FindBy(name = "applyForCurrentYear")
    WebElement btnApplyForCurrentYear;

    @FindBy(css = ".linkButton")
    List<WebElement> clickHereLinks; // profile, eligibility, documents, plans

    @FindBy(css = "h4 .c4PageHeader")
    WebElement txtNextStep;

    @FindBy(id = "submit-curr-yr-6")
    WebElement makeChangesButton;

    @FindBy(css = ".c4PageHeader-large")
    WebElement header;


    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public AccountOverviewPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickuserNameExchLink() {
        basicActions.waitForElementToBeClickable(userNameExchLink, 15);
        userNameExchLink.click();
    }

    public void clickApplyForCurrentYear(){
        basicActions.waitForElementToBePresent(header, 50);
        basicActions.waitForElementToBeClickable(btnApplyForCurrentYear,10);
        btnApplyForCurrentYear.click();
    }

    public void clickHereLinks(String clickHereOption){
        basicActions.waitForElementListToBePresent(clickHereLinks, 10);
        switch(clickHereOption){
            case "My Profile":
                clickHereLinks.get(0).click();
                break;
            case "My Eligibility":
                clickHereLinks.get(1).click();
                break;
            case "My Documents":
                clickHereLinks.get(2).click();
                break;
            case "My Plans":
                clickHereLinks.get(3).click();
                break;
            default: throw new IllegalArgumentException("Entered Invalid option for clickHere link: " + clickHereOption);
        }

    }

    public void iClickOnMakeChanges(){
        basicActions.waitForElementToBePresent(header, 10);
        basicActions.click(makeChangesButton);
    }


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
