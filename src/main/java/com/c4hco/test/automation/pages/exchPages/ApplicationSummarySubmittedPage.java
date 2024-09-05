package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class ApplicationSummarySubmittedPage {

    SoftAssert softAssert = new SoftAssert();

    private BasicActions basicActions;

    public ApplicationSummarySubmittedPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements((basicActions.getDriver()),this);
    }

    @FindBy(css = ".desk-button.row #submit")
    WebElement btnViewAppDetails;


    public void clickViewAppDetails(){
        basicActions.waitForElementToBeClickable(btnViewAppDetails,20);
        basicActions.scrollToElement(btnViewAppDetails);
        btnViewAppDetails.click();
    }

}
