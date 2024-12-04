package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.Optional;

public class MedicalComparePage {
    private BasicActions basicActions;

    SoftAssert softAssert = new SoftAssert();
    private Optional<Integer> optionalInt;

    public MedicalComparePage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(id = "MedicalComparePlans-GoBackToPlans")
    WebElement goBackCompare;

    @FindBy(xpath = "//a[@id = 'SHP-MedicalComparePlans-DownloadSummaryOfThisPage']")
    WebElement pdfCompareSummary;

    @FindBy(id = "MedicalPlanCompare_InNetworkTab")
    WebElement inNetwork1;

    @FindBy(id = "MedicalPlanCompare_OutOfNetworkTab")
    WebElement outNetwork;

    @FindBy(xpath = "//div[@class = 'disclaimer body-text-2']")
    WebElement disclaimerCompare;

    @FindBy(xpath = "//div[@class = 'pt-5 header-2']")
    WebElement header;

    @FindBy(id = "ngb-accordion-item-0-toggle")
    WebElement inOneHeader;

    @FindBy(id = "ngb-accordion-item-1-toggle")
    WebElement inTwoHeader;

    @FindBy(id = "ngb-accordion-item-2-toggle")
    WebElement inThreeHeader;

    @FindBy(id = "ngb-accordion-item-3-toggle")
    WebElement inFourHeader;

    @FindBy(id = "ngb-accordion-item-4-toggle")
    WebElement inFiveHeader;

    @FindBy(id = "ngb-accordion-item-5-toggle")
    WebElement inSixHeader;

    @FindBy(id = "ngb-accordion-item-6-toggle")
    WebElement inSevenHeader;

    @FindBy(id = "ngb-accordion-item-7-toggle")
    WebElement inEightHeader;

    @FindBy(id = "ngb-accordion-item-8-toggle")
    WebElement inNineHeader;

    @FindBy(id = "ngb-accordion-item-9-toggle")
    WebElement inTenHeader;

    @FindBy(id = "ngb-accordion-item-10-toggle")
    WebElement inElevenHeader;

    @FindBy(id = "ngb-accordion-item-11-toggle")
    WebElement inTwelveHeader;

    @FindBy(id = "ngb-accordion-item-12-toggle")
    WebElement inThirteenHeader;

    @FindBy(id = "ngb-accordion-item-13-toggle")
    WebElement outOneHeader;

    @FindBy(id = "ngb-accordion-item-14-toggle")
    WebElement outTwoHeader;

    @FindBy(id = "ngb-accordion-item-15-toggle")
    WebElement outThreeHeader;

    @FindBy(id = "ngb-accordion-item-16-toggle")
    WebElement outFourHeader;

    @FindBy(id = "ngb-accordion-item-17-toggle")
    WebElement outFiveHeader;

    @FindBy(id = "ngb-accordion-item-18-toggle")
    WebElement outSixHeader;

    @FindBy(id = "ngb-accordion-item-19-toggle")
    WebElement outSevenHeader;

    @FindBy(id = "ngb-accordion-item-20-toggle")
    WebElement outEightHeader;

    @FindBy(id = "ngb-accordion-item-21-toggle")
    WebElement outNineHeader;

    @FindBy(id = "ngb-accordion-item-22-toggle")
    WebElement outTenHeader;

    @FindBy(id = "ngb-accordion-item-23-toggle")
    WebElement outElevenHeader;

    @FindBy(id = "ngb-accordion-item-24-toggle")
    WebElement outTwelveHeader;

    @FindBy(id = "ngb-accordion-item-25-toggle")
    WebElement outThirteenHeader;


    @FindBy(xpath = "//*[contains(text(), 'Plan Details')]")
    WebElement clickPlanDetailLink;

    public void clickPlanDetailLink(){
        basicActions.waitForElementToBePresent(header, 20);
        clickPlanDetailLink.click();
    }

    public void validateInNetworkTextHeaders() {
        basicActions.waitForElementToBePresent(header, 10);
        softAssert.assertEquals(header.getText(), "Highlights");
        softAssert.assertEquals(inOneHeader.getText(), "Monthly Premium");
        softAssert.assertEquals(inTwoHeader.getText(), "General Details");
        softAssert.assertEquals(inThreeHeader.getText(), "Provider Office Visits");
        softAssert.assertEquals(inFourHeader.getText(), "Prescription Drugs");
        softAssert.assertEquals(inFiveHeader.getText(), "Facilities");
        softAssert.assertEquals(inSixHeader.getText(), "Maternity");
        softAssert.assertEquals(inSevenHeader.getText(), "Emergency Care");
        softAssert.assertEquals(inEightHeader.getText(), "Mental Health Benefits");
        softAssert.assertEquals(inNineHeader.getText(), "Testing");
        softAssert.assertEquals(inTenHeader.getText(), "Medical Devices");
        softAssert.assertEquals(inElevenHeader.getText(), "Habilitative and Rehabilitative Services");
        softAssert.assertEquals(inTwelveHeader.getText(), "Home Care & Hospice");
        softAssert.assertEquals(inThirteenHeader.getText(), "Additional EHB Benefits");
        softAssert.assertAll();
        }

    public void validateOutNetworkTextHeaders() {
        basicActions.waitForElementToBePresent(header, 10);
        softAssert.assertEquals(header.getText(), "Highlights");
        softAssert.assertEquals(outOneHeader.getText(), "Monthly Premium");//id='ngb-accordion-item-0-toggle'
        softAssert.assertEquals(outTwoHeader.getText(), "General Details");
        softAssert.assertEquals(outThreeHeader.getText(), "Provider Office Visits");
        softAssert.assertEquals(outFourHeader.getText(), "Prescription Drugs");
        softAssert.assertEquals(outFiveHeader.getText(), "Facilities");
        softAssert.assertEquals(outSixHeader.getText(), "Maternity");
        softAssert.assertEquals(outSevenHeader.getText(), "Emergency Care");
        softAssert.assertEquals(outEightHeader.getText(), "Mental Health Benefits");
        softAssert.assertEquals(outNineHeader.getText(), "Testing");
        softAssert.assertEquals(outTenHeader.getText(), "Medical Devices");
        softAssert.assertEquals(outElevenHeader.getText(), "Habilitative and Rehabilitative Services");
        softAssert.assertEquals(outTwelveHeader.getText(), "Home Care & Hospice");
        softAssert.assertEquals(outThirteenHeader.getText(), "Additional EHB Benefits");
        softAssert.assertAll();
    }


    public void clickPDFSummary(){
        basicActions.waitForElementToBePresent( pdfCompareSummary,15);
        pdfCompareSummary.isEnabled();
    }

    public void clickGoBackCompare(){
        basicActions.waitForElementToDisappear( spinner,30 );
        basicActions.waitForElementToBePresent( goBackCompare,15 );
        basicActions.scrollToElement( goBackCompare );
        goBackCompare.click();
    }

    public void clickInNetworkLink(){
        basicActions.waitForElementToBePresent( inNetwork1,15 );
        inNetwork1.click();
    }

    public void clickOutNetworkLink(){
        basicActions.waitForElementToBePresent( outNetwork, 15 );
        outNetwork.click();
    }

    public void validateDisclaimerCompare(){
        basicActions.waitForElementToBePresent( disclaimerCompare,15 );
        disclaimerCompare.isDisplayed();
    }


}
