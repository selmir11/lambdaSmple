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
    AccountOverviewPage accountOverviewPage = new AccountOverviewPage(WebDriverManager.getDriver());
    public MyDocumentsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
        @FindBy(xpath = "//h2[@class='header-1 my-documents']")
    WebElement myDocumentsTitle;

    @FindBy(xpath = "//div[@class='documents-notices-title header-2']")
    WebElement myDocumentsSubTitle;

    @FindBy(xpath = "//p[contains(text(),'You do not have any Documents or Letters at this t')]")
    WebElement documentsInfoMessage;

    public void Click_link_my_docs_on_welcome_page() {
        basicActions.switchToParentPage("accountOverview");
        accountOverviewPage.clickHereLinks("My Documents");
    }




                //============================VALIDATION STEPS==============//

    public void verifyPageText(String language)
        {
        SoftAssert softAssert = new SoftAssert();
        switch (language) {
            case "English":
                softAssert.assertEquals(myDocumentsTitle.getText(),"My Documents and Letters");
                softAssert.assertAll();
                softAssert.assertEquals(myDocumentsSubTitle.getText(),"Past Documents and Letters");
                softAssert.assertAll();
                softAssert.assertEquals(documentsInfoMessage.getText(),"You do not have any Documents or Letters at this time");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(myDocumentsTitle.getText(),"Mis Documentos y Cartas");
                softAssert.assertAll();
                softAssert.assertEquals(myDocumentsSubTitle.getText(),"Documentos y Cartas Anteriores");
                softAssert.assertAll();
                softAssert.assertEquals(documentsInfoMessage.getText(),"No tiene documentos ni cartas en este momento");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
     }
}
