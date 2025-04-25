package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class PaymentPortalCoCoPage {
    SoftAssert softAssert = new SoftAssert();
    private BasicActions basicActions;

    public PaymentPortalCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "c4-type-header-lg")
    WebElement hdr_AllDone;

    @FindBy(xpath = "//*[@id='SOL-PayNow-AllDone-Indv' or @id='SOL-PayNow-AllDone-Obo']")
    WebElement allDoneBtn;

    @FindBy(id="SOL-PayNow-AllDone-Obo")
    WebElement allDoneOboBtn;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(xpath = "//div[@class= 'payment-option-disabled ng-star-inserted']")
    WebElement CoordinatePayment;
    @FindBy(css="div.username")
    WebElement submittedByEmail;

    public void clickAllDoneCoCo(){
        basicActions.waitForElementToDisappear(spinner, 15);
        basicActions.waitForElementToBePresent(hdr_AllDone, 15);
        basicActions.waitForElementToBePresent(allDoneBtn, 30);
        basicActions.scrollToElement(allDoneBtn);
        getSubmittedByEmail();
        allDoneBtn.click();
    }
    public void getSubmittedByEmail(){
        String email =submittedByEmail.getText();
        List<MemberDetails> eligMembersList = basicActions.getAllMedicalEligibleMemInfo();
        for(MemberDetails member: eligMembersList) {
            member.setSubmittedBy(email);
        }
    }

    public void clickAllDoneOboCoCo(){
        basicActions.waitForElementToDisappear(spinner, 15);
        basicActions.waitForElementToBePresent(allDoneOboBtn, 30);
        basicActions.scrollToElement(allDoneOboBtn);
        allDoneOboBtn.click();
    }
    public void verifyDisabledTextonPaymentPageCoCO() {
       basicActions.waitForElementToBePresent(CoordinatePayment, 10);
       softAssert.assertEquals(CoordinatePayment.getText(), "Your insurance company will contact you within 10 business days to coordinate payment.");
       softAssert.assertAll();
    }
}

