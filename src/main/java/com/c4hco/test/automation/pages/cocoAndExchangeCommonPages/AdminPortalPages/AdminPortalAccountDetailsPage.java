package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AdminPortalAccountDetailsPage {

    public BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public AdminPortalAccountDetailsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".account-detail-row div")
    List<WebElement> accDetailsLabelAndValues;

    @FindBy(xpath = "//*[contains(@class, 'dashboardHeader1') and contains(text(), 'Primary Account Holder:')]")
    WebElement headerText;

    public void validatePrimaryMemDetails(){
        basicActions.waitForElementListToBePresent(accDetailsLabelAndValues, 10);
        MemberDetails primaryMem = SharedData.getPrimaryMember();
        validateHeaderDetails(primaryMem);
        softAssert.assertEquals(accDetailsLabelAndValues.get(1).getText(), primaryMem.getCompleteFullName(), "name did not match");
        softAssert.assertEquals(accDetailsLabelAndValues.get(11).getText(), basicActions.changeDateFormat(primaryMem.getDob(), "MMddyyyy", "MM/dd/yyyy"), "DOB did not match!");
        softAssert.assertAll();
    }

    private void validateHeaderDetails(MemberDetails primaryMem){
        basicActions.waitForElementToBePresent(headerText, 10);
        softAssert.assertEquals(headerText.getText(), "Primary Account Holder: "+primaryMem.getSignature(), "Primary person's name from header did not match");
    }

}
