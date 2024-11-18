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

    @FindBy(id = "profile-complete-header")
    WebElement authAssisterOrgPageTitle;

    @FindBy(xpath = "//span[@class='body-text-1 m-auto']")
    WebElement authAssisterOrgInformationalText;

    @FindBy(xpath = "//span[@class='body-text-1 ps-0']")
    WebElement authAssisterSiteIdFieldText;

    @FindBy(id = "site-id")
    WebElement assisterSiteIdSearchBox;

    @FindBy(id= "authorize-button")
    WebElement assisterAuthorizeButton;

    @FindBy(id= "authorize-success-msg")
    WebElement assisterAuthorizationSuccessMessage;

    @FindBy(id= "dashboard-button")
    WebElement assisterGoBackButton;
    @FindBy(id= "assister-button-change")
    WebElement changeAssister;
    @FindBy(id= "container dashboard-card")
    WebElement containerWarning;
    @FindBy(id= "warning-question")
    WebElement containerWarningTitle;
    @FindBy(id= "warning-message")
    WebElement containerWarningText;
    @FindBy(id= "keep-current-btn-id")
    WebElement keepCurrentOrganisationBtn;
    @FindBy(id= "authorize-btn-id")
    WebElement authorizeNewOrganisationBtn;

    public AuthorizeAssisterOrganizationPage(WebDriver webDriver){
        this.basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void validateAuthAssisterOrgPageTitle(String language){
        basicActions.waitForElementToBePresent(authAssisterOrgPageTitle, 10);
        switch (language){
            case "English" :
                softAssert.assertEquals(authAssisterOrgPageTitle.getText(), "Authorize Assister Organization");
                break;
            case "Spanish" :
                softAssert.assertEquals(authAssisterOrgPageTitle.getText(), "Autorizar a la Organizaci\u00F3n de asistencia");
                break;
        }
        softAssert.assertAll();
    }

    public void validateAuthAssisterOrgPageInformationalText(String language){
        basicActions.waitForElementToBePresent(authAssisterOrgInformationalText, 10);
        switch (language){
            case "English" :
                softAssert.assertEquals(authAssisterOrgInformationalText.getText(), "To allow Certified Assisters from an Assister Organization to help you with your account, ask your Assister for their Organization Site ID and click Authorize.");
                break;
            case "Spanish" :
                softAssert.assertEquals(authAssisterOrgInformationalText.getText(), "Para permitirle que un asistente certificado de una Organizaci\u00F3n de asistencia le ayude con su cuenta, p\u00EDdale la identificaci\u00F3n del Sitio de la Organizaci\u00F3n y haga clic en Autorizar.");
                break;
        }
        softAssert.assertAll();
    }

    public void validateAuthAssisterSiteIdFieldTextText(String language){
        basicActions.waitForElementToBePresent(authAssisterSiteIdFieldText, 10);
        switch (language){
            case "English" :
                softAssert.assertEquals(authAssisterSiteIdFieldText.getText(), "Assister Organization Site ID");
                break;
            case "Spanish" :
                softAssert.assertEquals(authAssisterSiteIdFieldText.getText(), "Identificaci\u00F3n del Sitio de la Organizaci\u00F3n de asistencia");
                break;
        }
        softAssert.assertAll();
    }

    public void validateGoBackButton(String language){
        basicActions.waitForElementToBePresent(assisterGoBackButton, 10);
        switch (language){
            case "English" :
                softAssert.assertEquals(assisterGoBackButton.getText(), "Go Back");
                break;
            case "Spanish" :
                softAssert.assertEquals(assisterGoBackButton.getText(), "Volver");
                break;
        }
        softAssert.assertAll();
    }

    public void validateAuthorizeAssisterButton(String language){
        basicActions.waitForElementToBePresent(assisterAuthorizeButton, 10);
        switch (language){
            case "English" :
                softAssert.assertEquals(assisterAuthorizeButton.getText(), "Authorize");
                break;
            case "Spanish" :
                softAssert.assertEquals(assisterAuthorizeButton.getText(), "Autorizar");
                break;
        }
        softAssert.assertAll();
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

    public void clickOnChangeTheExistingAssister() {
        basicActions.waitForElementToBePresent(changeAssister,60);
        changeAssister.click();
    }

    public void validateTheWarningTextToAuthorizeNewOrKeepTheSameAssister() {
        basicActions.waitForElementToBePresent(containerWarning,60);
        basicActions.waitForElementToBePresent(containerWarningTitle,60);
        softAssert.assertEquals(containerWarningTitle.getText(),"Interested in this Assister Organization?");
        softAssert.assertEquals(containerWarningText.getText(),"By selecting Authorize New Organization, your current Assister Organization Blue River Assisters will be deauthorized and Blue River Assisters will be authorized as your new Assister Organization.");
        softAssert.assertEquals(keepCurrentOrganisationBtn.getText(),"Keep Current Organization");
        softAssert.assertEquals(authorizeNewOrganisationBtn.getText(),"Authorize New Organization");
        softAssert.assertTrue(keepCurrentOrganisationBtn.isEnabled());
        softAssert.assertTrue(authorizeNewOrganisationBtn.isEnabled());
        softAssert.assertAll();

    }

    public void clickOnInTheWarningContainerToAuthorizeNewOrKeepTheSameAssister(String btnType) {
        basicActions.waitForElementToBePresent(containerWarning,60);
        basicActions.waitForElementToBePresent(containerWarningTitle,60);
        switch (btnType){
            case "keep Current Organisation" :
                keepCurrentOrganisationBtn.click();
                break;
            case "authorize New Organisation" :
                authorizeNewOrganisationBtn.click();
                break;
        }
    }
}
