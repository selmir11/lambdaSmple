package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindExpertHelpPage {
    BasicActions basicActions;

    public FindExpertHelpPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    @FindBy(css = "#contineOwn-button")
    WebElement continueOnMyOwnButton;

    @FindBy(id = "broker-button")
    WebElement findABrokerBtn;
    @FindBy(id="findBroker-brokerName-agency-license-input")
    WebElement searchBrokerNameBar;
    @FindBy(id="findBroker-searchBroker-btn")
    WebElement searchForBrokerBtn;
    @FindBy(id="person-name")
    WebElement nameOfBrokerFound;
    @FindBy(css=".fa-chevron-down")
    WebElement brokerMoreDetailsDrpDown;
    @FindBy(id="agency-manage-account-button")
    WebElement authorizeBtn;
    @FindBy(id="terms-checkbox-input")
    WebElement brokertermsCheckBox;
    @FindBy(css=".primary-action-button .ng-star-inserted")
    WebElement authorizeBrokerButton;
    public void clickFindABrokerBtn(){
        basicActions.waitForElementToBeClickable(findABrokerBtn,10);
        findABrokerBtn.click();
    }
    public void findBrokerByName(String brokerName){
        basicActions.waitForElementToBeClickable(searchBrokerNameBar,10);
        searchBrokerNameBar.sendKeys(brokerName);
        basicActions.waitForElementToBeClickable(searchForBrokerBtn,10);
        searchForBrokerBtn.click();
        basicActions.waitForElementToBePresent(nameOfBrokerFound,10);
        brokerMoreDetailsDrpDown.click();
        basicActions.waitForElementToBeClickable(authorizeBtn,10);
        authorizeBtn.click();
        brokertermsCheckBox.click();
        authorizeBrokerButton.click();
    }

    public void clickContinueOnMyOwnButton() {
        basicActions.waitForElementToBeClickable(continueOnMyOwnButton,60);
        continueOnMyOwnButton.click();

    }

    @FindBy(id = "BP-Findexperthelpnearyou-Back")
    private WebElement backButton;

    public void clickBackButton() {
        basicActions.waitForElementToBeClickable(backButton, 5);
        backButton.click();
    }
}
