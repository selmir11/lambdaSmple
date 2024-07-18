package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class CongratulationsCoCoPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public CongratulationsCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "SOL-WhatsNext-Okay")
    WebElement saveAndContinueBtn;

    @FindBy(id = "SOL-WhatsNext-WhatsNextHeader")
    WebElement header;

    @FindBy(id = "SOL-WhatsNext-EmailNotificationCOCO")
    WebElement emailNotification;
    @FindBy(id = "SOL-WhatsNext-Email")
    WebElement emailOnFile;
    @FindBy(id = "SOL-WhatsNext-IssuerContact")
    WebElement issuerContact;
    @FindBy(id = "SOL-WhatsNext-WhatsNextInformationCOCO")
    WebElement whatsNextInfo;

    public void clickSaveContinueCongratsCoCo(){
        basicActions.waitForElementToBeClickable( saveAndContinueBtn, 60);
        saveAndContinueBtn.click();
    }

    public void validatePageText(){
        basicActions.waitForElementToBePresent(header, 15);
        softAssert.assertEquals(header.getText(), "Congratulations, you’ve selected a plan and we sent it to your insurance company! ", "header text did not match");
        softAssert.assertEquals(emailOnFile.getText(), SharedData.getPrimaryMember().getEmailId(), "email id did not match");
        softAssert.assertEquals(emailNotification.getText(), " Thank you for choosing a plan for 2024 through Colorado Connect! We sent a confirmation to your email address on file:  ", "email notification text did not match");
        softAssert.assertEquals(issuerContact.getText(), "It takes 3-10 business days for your insurance company to receive and process your information. After that time, you can contact your insurance company directly to make or confirm your initial payment and to set up ongoing payments.", "issuer contact text did not match");
        softAssert.assertEquals(whatsNextInfo.getText(), " Check out the Welcome page for your insurance company’s contact information and plan details.", "whats next information text did not match");
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Go to Welcome Page", "text on the button did not match");
        softAssert.assertAll();
    }

}
