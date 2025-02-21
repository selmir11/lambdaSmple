package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.math.BigDecimal;
import java.util.List;

public class ApplicationHistoryPage {

    @FindBy(id = "month-pay")
    WebElement lblAPTCValue;
    @FindBy(xpath = "//button[@name= 'viewResults']")
    WebElement viewResultsAndShop;
    @FindBy(id = "price-background")
    WebElement aptcSection;
    @FindBy(css = "table tbody  #align-right")
    List<WebElement> applicationSummary;
    @FindBy(css=".self-attestation-title")
    WebElement mvrPopUp;
    @FindBy(css= ".no-self-attestation-btn")
    WebElement noBtnMvrPopUp;
    @FindBy(css = ".verify-myinfo-btn")
    WebElement yesBtnMvrPopUp;
    @FindBy(xpath = "//button[text()='Back to Welcome Page']")
    WebElement goBackToWelcomePage;
    @FindBy(css = "div.not-qualified-div")
    WebElement taxHouseholdNotQualify;

    @FindBy(xpath = "//div[@id='current-app']/h1")
    List<WebElement> currentApplication ;


    private BasicActions basicActions;

    public ApplicationHistoryPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickViewResults(){
        setApplicationId();
        if(mvrPopUp.isDisplayed()){
            noBtnMvrPopUp.click();
        }
        basicActions.waitForElementToBeClickable(viewResultsAndShop, 10);
        basicActions.clickElementWithRetries(viewResultsAndShop, 10);
    }

    private void setApplicationId(){
        basicActions.waitForElementListToBePresent(applicationSummary, 10);
        String applicationid = applicationSummary.get(0).getText();
        SharedData.getPrimaryMember().setApplication_id(applicationid);
        System.out.println("Application Id : "+ applicationid);
    }

    public void setUpdatedPremiums(){
        basicActions.waitForElementToBePresent(lblAPTCValue, 10);
        MemberDetails subscriber = SharedData.getPrimaryMember();
        String medAPTCAmt = lblAPTCValue.getText().replace("$", "").replace("/mo", "");
        subscriber.setMedicalAptcAmt(medAPTCAmt);

        String totalMedPremiumAfterReduction =  String.format("%.2f",Float.parseFloat(SharedData.getPrimaryMember().getMedicalPremiumAmt()) - Float.parseFloat(SharedData.getPrimaryMember().getMedicalAptcAmt()));
        subscriber.setTotalMedAmtAfterReduction(totalMedPremiumAfterReduction);

        BigDecimal bigDecimalmedPremiumMinusAPTC = new BigDecimal(totalMedPremiumAfterReduction);
        BigDecimal bigDecimalmedAPTCAmt = new BigDecimal(medAPTCAmt);

        BigDecimal totalMedicalPremium = bigDecimalmedPremiumMinusAPTC.add( bigDecimalmedAPTCAmt );
        subscriber.setMedicalPremiumAmt( String.valueOf( totalMedicalPremium ) );
    }

    public void validateAPTC(String expectedAPTC){
        basicActions.waitForElementToBePresent(lblAPTCValue, 30);
        String APTC = lblAPTCValue.getText();
        Assert.assertTrue(APTC.contains(expectedAPTC),"Incorrected APTC Amount! Expected "+expectedAPTC+" but "+APTC+" displayed.");
    }

    public void validateTextOnPage(String Text){
        basicActions.waitForElementToBePresent(lblAPTCValue, 15);

        basicActions.waitForElementToBePresent(basicActions.getDriver().findElement(By.xpath("//*[text()='"+Text+"']")), 15);
    }

    public void backToWelcomePage(){
        goBackToWelcomePage.click();
    }

    public void validateTextDoesNotExistOnPage(String Text){
        basicActions.waitForElementToBePresent(viewResultsAndShop, 15);
        Assert.assertEquals(0, basicActions.getDriver().findElements(By.xpath("//*[text()='"+Text+"']")).size());
    }

    public void validateAptcSectionDoesntExist(){
        basicActions.waitForElementToBePresent(viewResultsAndShop, 10);
        Assert.assertFalse(basicActions.isElementDisplayed(aptcSection, 3));
    }

    public void clickVerifyMyInfoText(String popUpOption){
        switch (popUpOption){
            case "Verify My Information":
                basicActions.waitForElementToBePresent(yesBtnMvrPopUp,10);
                yesBtnMvrPopUp.click();
                break;
            case "No":
                basicActions.waitForElementToBePresent(noBtnMvrPopUp,10);
                noBtnMvrPopUp.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + popUpOption);
        }
    }
    public void validateMemberEligibilityForMA() {
    Assert.assertEquals(taxHouseholdNotQualify.getText(), "Based on the information listed in your application, you do not qualify for a health plan at this time.");
    }

    public void validatetextWithNoPolicy(String text) {
        basicActions.waitForElementListToBePresent(currentApplication, 40);
        System.out.println(currentApplication.get(0).getText());
        Assert.assertEquals(currentApplication.get(0).getText(), text , text + "Not Found");

    }
}
