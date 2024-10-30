package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Optional;

public class MedicalPlanDetailCoCoPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public MedicalPlanDetailCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(id = "MedicalCarrierDetails-OutOfNetwork")
    public WebElement selectOutofNetworkLink;

    @FindBy(xpath = "//div[@id='MedicalCarrierDetails-InNetworkTier1-panel'] //button")
    public List<WebElement> drpDwnPlanDetails;

    @FindBy(id = "MedicalCarrierDetails-InNetworkTier1")
    public WebElement selectInNetworkTier1Link;

    @FindBy(css = "#MedicalCarrierDetails-GoBacktoPlans")
    public WebElement medicalCompareGoBack;

    @FindBy(css = "span.float-start")
    public List<WebElement> planPremiumDetails;

    @FindBy(id = "MedicalCarrierDetails-PreferredDrugList")
    public WebElement preferredDrugList;

    @FindBy(id = "MedicalCarrierDetails-ProviderNetwork")
    public WebElement providerNetwork;

    public void verifyTextMedicalplancmpr(List<String> planDetails) {
        basicActions.waitForElementToDisappear(spinner,20);
        softAssert.assertEquals(planPremiumDetails.get(0).getText(), planDetails.get(0));
        softAssert.assertEquals(planPremiumDetails.get(1).getText(), planDetails.get(1));
        softAssert.assertEquals(selectInNetworkTier1Link.getText(), planDetails.get(2));
        softAssert.assertEquals(selectOutofNetworkLink.getText(), planDetails.get(3));
        softAssert.assertEquals(drpDwnPlanDetails.get(0).getText(), planDetails.get(4));
        softAssert.assertEquals(drpDwnPlanDetails.get(1).getText(), planDetails.get(5));
        softAssert.assertEquals(drpDwnPlanDetails.get(2).getText(), planDetails.get(6));
        softAssert.assertEquals(drpDwnPlanDetails.get(3).getText(), planDetails.get(7));
        softAssert.assertEquals(drpDwnPlanDetails.get(4).getText(), planDetails.get(8));
        softAssert.assertEquals(drpDwnPlanDetails.get(5).getText(), planDetails.get(9));
        softAssert.assertEquals(drpDwnPlanDetails.get(6).getText(), planDetails.get(10));
        softAssert.assertEquals(drpDwnPlanDetails.get(7).getText(), planDetails.get(11));
        softAssert.assertEquals(drpDwnPlanDetails.get(8).getText(), planDetails.get(12));
        softAssert.assertEquals(drpDwnPlanDetails.get(9).getText(), planDetails.get(13));
        softAssert.assertEquals(drpDwnPlanDetails.get(10).getText(), planDetails.get(14));
        softAssert.assertEquals(drpDwnPlanDetails.get(11).getText(), planDetails.get(15));
        softAssert.assertEquals(preferredDrugList.getText(), planDetails.get(16));
        softAssert.assertEquals(providerNetwork.getText(), planDetails.get(17));
        softAssert.assertEquals(medicalCompareGoBack.getText(), planDetails.get(18));
        softAssert.assertAll();
    }

    public void verifyDropdownMedicalplancmpr(List<String> planDetails) {
        basicActions.waitForElementToDisappear(spinner,20);
        for(int i=0;i<planDetails.size();i++){
            WebElement dropdownCtrol=basicActions.getDriver().findElement(By.xpath("//button[contains(text(),'"+planDetails.get(i)+"')]"));
            softAssert.assertTrue(dropdownCtrol.isEnabled());
            softAssert.assertAll();
            dropdownCtrol.click();
        }
    }

    public void  clickMedicalDetailGoBack() {
        basicActions.waitForElementToDisappear( spinner,40 );
        basicActions.waitForElementToBePresent(medicalCompareGoBack, 40);
        basicActions.scrollToElement( medicalCompareGoBack );
        medicalCompareGoBack.click();}


}
