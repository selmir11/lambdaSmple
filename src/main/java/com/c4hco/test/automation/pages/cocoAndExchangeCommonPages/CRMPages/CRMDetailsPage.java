package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class CRMDetailsPage {

    @FindBy(xpath = "//input[@aria-label = 'Address 2: Street 1']")
    WebElement txtAddress1Input;

    @FindBy(xpath = "//input[@aria-label = 'Address 2: City']")
    WebElement txtCityInput;

    @FindBy(xpath = "//input[@aria-label = 'Address 2: State/Province']")
    WebElement txtStateInput;

    @FindBy(xpath = "//input[@aria-label = 'Address 2: ZIP/Postal Code']")
    WebElement txtZipCodeInput;

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public CRMDetailsPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void verifyDetailsData(){
        basicActions.waitForElementToBePresent(txtAddress1Input,50);
        softAssert.assertEquals(txtAddress1Input.getAttribute("title"), SharedData.getPrimaryMember().getMailingAddress().getAddressLine1());
        softAssert.assertEquals(txtCityInput.getAttribute("title"), SharedData.getPrimaryMember().getMailingAddress().getAddressCity());
        softAssert.assertEquals(txtStateInput.getAttribute("title"), SharedData.getPrimaryMember().getMailingAddress().getAddressState());
        softAssert.assertEquals(txtZipCodeInput.getAttribute("title"), SharedData.getPrimaryMember().getMailingAddress().getAddressZipcode());
        softAssert.assertAll();
    }


}
