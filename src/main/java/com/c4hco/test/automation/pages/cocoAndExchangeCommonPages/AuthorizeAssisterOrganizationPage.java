package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class AuthorizeAssisterOrganizationPage {
    SoftAssert softAssert = new SoftAssert();
    private BasicActions basicActions;

    @FindBy(id = "site-id")
    WebElement assisterSiteIdSearchBox;

    @FindBy(id= "authorize-button")
    WebElement assisterAuthorizeButton;

    @FindBy(id= "authorize-success-msg")
    WebElement assisterAuthorizationSuccessMessage;

    @FindBy(id= "dashboard-button")
    WebElement assisterGoBackButton;

    public AuthorizeAssisterOrganizationPage(WebDriver webDriver){
        this.basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void authorizeAssisterSiteID(String stgSiteID, String qaSiteID){
        basicActions.waitForElementToBePresent(assisterSiteIdSearchBox, 10);

        if(SharedData.getEnv().equals("staging")){
            assisterSiteIdSearchBox.sendKeys(stgSiteID);
        } else{
            assisterSiteIdSearchBox.sendKeys(qaSiteID);
        }
        assisterAuthorizeButton.click();
    }

    public void validateAuthorizationSuccessText(){
        basicActions.waitForElementToBePresent(assisterAuthorizationSuccessMessage, 10);

        softAssert.assertEquals(assisterAuthorizationSuccessMessage.getText(), "Assister Organization is successfully Authorized");
        softAssert.assertAll();
    }

    public void clickAssisterGoBack(){
        basicActions.waitForElementToBePresent(assisterGoBackButton, 10);
        assisterGoBackButton.click();
    }
}
