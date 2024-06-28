package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Optional;

public class MedicalComparePage {
    private BasicActions basicActions;
    private Optional<Integer> optionalInt;

    public MedicalComparePage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "SHP-MedicalComparePlans-GoBacktoPlans")
    WebElement goBackCompare;

    @FindBy(id = "SHP-MedicalComparePlans-DownloadSummaryOfThisPage")
    WebElement pdfCompareSummary;

    @FindBy(id = "SHP-MedicalComparePlans-InNetworkTier1")
    WebElement inNetwork1;

    @FindBy(id = "SHP-MedicalComparePlans-OutOfNetwork")
    WebElement outNetwork;

    @FindBy(xpath = "//div[class = 'disclaimer body-text-2'")
    WebElement disclaimerCompare;

    public void clickPDFSummary(){
        basicActions.waitForElementToBeClickable( pdfCompareSummary,15);
        pdfCompareSummary.click();
    }

    public void clickGoBackCompare(){
        basicActions.waitForElementToBeClickable( goBackCompare,15 );
        goBackCompare.click();
    }

    public void clickInNetworkLink(){
        basicActions.waitForElementToBeClickable( inNetwork1,15 );
        inNetwork1.click();
    }

    public void clickOutNetworkLink(){
        basicActions.waitForElementToBeClickable( outNetwork, 15 );
        outNetwork.click();
    }

    public void validateDisclaimerCompare(){
        basicActions.waitForElementToBePresent( disclaimerCompare,15 );
        disclaimerCompare.isDisplayed();
    }


}
