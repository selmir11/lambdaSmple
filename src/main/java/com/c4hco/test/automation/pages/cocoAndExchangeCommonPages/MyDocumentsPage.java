package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.pages.exchPages.AccountOverviewPage;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class MyDocumentsPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    AccountOverviewPage accountOverviewPage = new AccountOverviewPage(WebDriverManager.getDriver());
    public MyDocumentsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".primary-header-container > h2")
    WebElement myDocumentsTitle;

    @FindBy(css = ".documents-notices-title.header-2")
    WebElement myDocumentsSubTitle;

//    @FindBy(css = ".documents-notices-content-container > div")
    @FindBy(css =".document-notice-name")
    WebElement documentsInfoMessage;

    @FindBy(xpath = "//button[normalize-space()='Go back to Welcome page']")
    WebElement goBackWelcomePage;


    public void ClickLinkMyDocsWelcomePage() {
        basicActions.switchToParentPage("accountOverview");
        accountOverviewPage.clickHereLinks("My Documents");
    }

                //============================VALIDATION STEPS==============//

    public void verifyPageText(String language)
        {
        switch (language) {
            case "English":
                basicActions.waitForElementToBePresent(myDocumentsTitle, 20);
                softAssert.assertEquals(myDocumentsTitle.getText(),"My Documents and Letters");
                softAssert.assertEquals(myDocumentsSubTitle.getText(),"Past Documents and Letters");
                softAssert.assertEquals(documentsInfoMessage.getText(),"You do not have any Documents or Letters at this time");
                softAssert.assertAll();
                break;
            case "Spanish":
                basicActions.waitForElementToBePresent(myDocumentsTitle, 20);
                softAssert.assertEquals(myDocumentsTitle.getText(),"Mis Documentos y Cartas");
                softAssert.assertEquals(myDocumentsSubTitle.getText(),"Documentos y Cartas Anteriores");
                softAssert.assertEquals(documentsInfoMessage.getText(),"No tiene documentos ni cartas en este momento");
                softAssert.assertAll();
                break;
            case "Spanish Headers":
                basicActions.waitForElementToBePresent(myDocumentsTitle, 20);
                softAssert.assertEquals(myDocumentsTitle.getText(),"Mis Documentos y Cartas");
                softAssert.assertEquals(myDocumentsSubTitle.getText(),"Documentos y Cartas Anteriores");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
     }

    public void validateTheNoticeExistInMyDocumentLetterPage(String documentName) {
        basicActions.waitForElementToBePresent(documentsInfoMessage,100);
        basicActions.scrollToElement(documentsInfoMessage);
        softAssert.assertEquals(documentsInfoMessage.getText(),documentName);
        softAssert.assertAll();
    }

    public void goBackToWelcomePage(){
        basicActions.waitForElementToBeClickable(goBackWelcomePage,30);
        basicActions.click(goBackWelcomePage);
    }
}
