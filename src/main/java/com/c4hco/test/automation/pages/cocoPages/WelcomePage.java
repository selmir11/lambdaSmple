package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

    @FindBy(id = "ELIG-WelcomePage-ApplyForInsurance-2024")
    WebElement applyFor2024Button;

    @FindBy(id = "ELIG-WelcomePage-MyProfile")
    WebElement myProfileButton;

    @FindBy(id = "ELIG-WelcomePage-ApplicationResults")
    WebElement applicationResultsButton;

    @FindBy(id = "ELIG-WelcomePage-MyDocuments")
    WebElement myDocumentsButton;

    private BasicActions basicActions;
    public WelcomePage(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickApply2024CoCo() {
        basicActions.waitForElementToBeClickable(applyFor2024Button, 5);
        applyFor2024Button.click(); }

    public void clickMyProfileButton() {
        basicActions.waitForElementToBeClickable(myProfileButton, 5);
        myProfileButton.click(); }

    public void clickApplicationResultsButton() {
        basicActions.waitForElementToBeClickable(applicationResultsButton, 5);
        applicationResultsButton.click(); }

    public void clickMyDocumentsButton() {
        basicActions.waitForElementToBeClickable(myDocumentsButton, 5);
        myDocumentsButton.click(); }

    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line
}


