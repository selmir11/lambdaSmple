package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;


public class MyDocumentsPage {
     @FindBy(xpath = "//h2[@class='header-1 my-documents']")
    WebElement myDocumentsTitle;

    @FindBy(xpath = "//div[@class='documents-notices-title header-2']")
    WebElement myDocumentsSubTitle;

    @FindBy(xpath = "//p[contains(text(),'You do not have any Documents or Letters at this t')]")
    WebElement documentsInfoMessage;






// =================VALIDATION STEPS==============//

    public void verifyPageText(String language){
        SoftAssert softAssert = new SoftAssert();
        switch (language) {
            case "English":
                softAssert.assertEquals(myDocumentsTitle.getText(),"My Documents and Letters");
                softAssert.assertEquals(myDocumentsSubTitle.getText(),"Past Documents and Letters");
                softAssert.assertEquals(documentsInfoMessage.getText(),"You do not have any Documents or Letters at this time");
                break;
            case "Spanish":
                softAssert.assertEquals(myDocumentsTitle.getText(),"Mis Documentos y Cartas");
                softAssert.assertEquals(myDocumentsSubTitle.getText(),"Documentos y Cartas Anteriores");
                softAssert.assertEquals(documentsInfoMessage.getText(),"No tiene documentos ni cartas en este momento");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }







}
