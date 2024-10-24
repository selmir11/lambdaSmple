package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyPoliciesCoCoPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public MyPoliciesCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".current-policy .txt-name")
    List<WebElement> memberNames;  // Gives names of all members - both medical and dental

    @FindBy(css = ".current-policy .current-policy-container")
    List<WebElement> cardsList;

    @FindBy(css = ".current-policy-data .pDate span:nth-child(2)")
    List<WebElement> planStartAndEndDate; // update this locator - split and have one for plan start date and one for plan end date

    @FindBy(css = ".current-policy-container .header-3")
    List<WebElement> planNames; // Both medical and dental plan names for all members

    @FindBy(id = "viewPlanHistoryLink_0")
    WebElement viewPlanHistoryLinkMedical; // To DO:: Update the locators in this file

    @FindBy(id = "viewPlanHistoryLink_1")
    WebElement viewPlanHistoryLinkDental; // Update locator - will only work when we have 1medical, 1dental and 1 memeber

    @FindBy(css = "app-plan-details .container .header-2")
    WebElement planHistoryTitle;

    @FindBy(css = "table .body-text-1")
    List<WebElement> tableRecord; // TO DO:: Check if this works with multiple members and multiple groups

    @FindBy(id="backToCurrentPlanDetailsButton")
    WebElement backToCurPlansBtn;

    @FindBy(xpath = "//span[contains(., 'Monthly Premium')]/following-sibling::span")
    List<WebElement> premiumAmt;

    @FindBy(xpath = "//div[contains(./span, 'Exchange Policy Number:')]/following-sibling::div/span")
    List<WebElement> EAPID; //exchange policy number for both medical and dental

    @FindBy(css=".amount-row span")
    List<WebElement> financialPremiumData; // financial stat date, premium after help

    @FindBy(css = ".current-policy div:nth-child(4) .txt-left span")
    List<WebElement> policyNumSubscriber; // policy num, subscriber, updated On for both medical and dental plans

    @FindBy(id="Cancel 2024 Medical PlansButton")
    WebElement cancelMedicalPlanbtn;

    @FindBy(id="Cancel 2024 Dental Plans Button")
    WebElement cancelDentalPlanbtn;
    @FindBy(css ="table tr:nth-child(2) p")
    List<WebElement> planhistoryNames;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;
    String lastUpdated = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    MemberDetails primaryMember = SharedData.getPrimaryMember();
    Set<String> allMemberNames = new HashSet<>();

    public void VerifyPlanDetails(String memberName,String planName){
        basicActions.waitForElementToDisappear(spinner,30);
        basicActions.waitForElementToBePresent(viewPlanHistoryLinkMedical,10);
        WebElement planDetails = basicActions.getDriver().findElement(By.xpath("//*[contains(text(),'"+memberName+"')]/ancestor::div[@class='current-policy-data']/parent::div  //div[@class='header-3']"));
        basicActions.waitForElementToBeClickable(planDetails,30) ;
        softAssert.assertEquals(planDetails.getText(),planName);
        softAssert.assertAll();
    }
    public void validateEnrolledPlanDetails() {
        // Validating Names
        basicActions.waitForElementListToBePresent(memberNames, 10);
        basicActions.waitForElementListToBePresent(policyNumSubscriber, 10);
        allMemberNames = new HashSet<>(basicActions.getAllMemNames());
        Set<String> namesFromUi = new HashSet<>(Arrays.asList(memberNames.get(0).getText().replace(" and ", ", ").split(", ")));
        softAssert.assertTrue(allMemberNames.equals(namesFromUi));

        softAssert.assertEquals(planStartAndEndDate.get(0).getText(), primaryMember.getPlanStartDate(), "medical plan date did not match");
        softAssert.assertEquals(planStartAndEndDate.get(1).getText(), primaryMember.getPlanEndDate(), "medical plan end date did not match");
        softAssert.assertEquals(planNames.get(0).getText(), primaryMember.getMedicalPlan(), "medical plan name did not match");
        softAssert.assertEquals(premiumAmt.get(0).getText(), "$" + primaryMember.getMedicalPremiumAmt(), "medical premium did not match");
        softAssert.assertTrue(policyNumSubscriber.get(2).getText().equals("Subscriber:"));
        softAssert.assertEquals(policyNumSubscriber.get(3).getText(), primaryMember.getSignature(), "Subscriber Name did not match on medical card");
        softAssert.assertTrue(policyNumSubscriber.get(4).getText().equals("Last Updated On:"));
        softAssert.assertEquals(policyNumSubscriber.get(5).getText(), lastUpdated, "Last Updated Date did not match");

        //Validating Total Premium without SES
        String totalAmtAfterZeroFinancialHelp = primaryMember.getMedicalPremiumAmt();
        String premiumWithoutSes = financialPremiumData.get(5).getText();
        softAssert.assertEquals(premiumWithoutSes, "$"+totalAmtAfterZeroFinancialHelp+"/mo", "Total Premium amount after APTC reduction does not match from UI and DB");
        softAssert.assertAll();
    }

}
