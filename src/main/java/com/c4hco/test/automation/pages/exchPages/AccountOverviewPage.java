package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.ExpectedCalculatedDates;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.ScenarioDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccountOverviewPage {

    @FindBy(css=".fas.fa-spinner.fa-spin")
    WebElement spinner;

    @FindBy(css = "li.vertical-ruler")
    WebElement userNameExchLink;

    @FindBy(xpath = "//*[@id='submit-curr-yr-3' or @id='submit-curr-yr-1' or @id='submit-curr-yr-6']")
    WebElement btnApplyForCurrentYear;  //Locator for both QA and Staging

    @FindBy(css = "#submit[name='applyForNextYear']")
    WebElement btnApplyForNextYear;

    @FindBy(css = ".linkButton")
    List<WebElement> clickHereLinks; // profile, eligibility, documents, plans

    @FindBy(css = "h4 .c4PageHeader")
    WebElement txtNextStep;

    @FindBy(id = "submit-curr-yr-4")
    WebElement makeChangesButton;

    @FindBy(css = ".c4PageHeader-large")
    WebElement header;

    @FindBy(css = ".table-bordered td b")
    List<WebElement> planInformationTable;

    @FindBy(css = ".table-bordered tr:nth-child(1) td:nth-child(2) span b")
    List<WebElement> medicalMemberNames;
    @FindBy(css = "option[selected='selected']")
    WebElement planYearOnWelcomeBackPage;

    @FindBy(xpath = "(//h1/span)[2]")
    WebElement txtUserName;

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public AccountOverviewPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickuserNameExchLink() {
        basicActions.waitForElementToBeClickable(userNameExchLink, 15);
        userNameExchLink.click();
    }

    public void clickApplyForCurrentYear(){
        basicActions.waitForElementToDisappear( spinner, 30 );
        basicActions.waitForElementToBePresent(header, 30);
        WebElement applyForYr;

        if(SharedData.getIsOpenEnrollment().equals("yes")){
             applyForYr = btnApplyForNextYear;
        } else{
            applyForYr = btnApplyForCurrentYear;
        }
        basicActions.waitForElementToBePresent(applyForYr, 40);
        String year = applyForYr.getText().replace("Apply for ", "");
        SharedData.setPlanYear(year);
        applyForYr.click();
    }

    public void clickHereLinks(String clickHereOption){
        basicActions.waitForElementListToBePresent(clickHereLinks, 10);
        switch(clickHereOption){
            case "My Profile":
                clickHereLinks.get(0).click();
                break;
            case "My Eligibility":
                clickHereLinks.get(1).click();
                break;
            case "My Documents":
                clickHereLinks.get(2).click();
                break;
            case "My Plans":
                clickHereLinks.get(3).click();
                break;
            default: throw new IllegalArgumentException("Entered Invalid option for clickHere link: " + clickHereOption);
        }

    }

    public void iClickOnMakeChanges(){
        basicActions.waitForElementToDisappear( spinner,20 );
        basicActions.waitForElementToBePresent(header, 30);
        basicActions.click(makeChangesButton);
    }


    // ================VALIDATION METHODS================//
    public void verifyLanguageText(String language) {
        switch (language) {
            case "English":
                validateNextStepEnglish();
                break;
            case "Spanish":
                validateNextStepSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateNextStepEnglish() {
        basicActions.waitForElementToBePresent(txtNextStep,10);
        softAssert.assertEquals(txtNextStep.getText(), "Next step: Apply for health insurance");
        softAssert.assertAll();
    }

    public void validateNextStepSpanish() {
        basicActions.waitForElementToBePresent(txtNextStep,10);
        softAssert.assertEquals(txtNextStep.getText(), "Paso siguiente: Solicitar seguro de salud");
        softAssert.assertAll();
    }

    public void verifyMemberNames() {
        MemberDetails primaryMember = SharedData.getPrimaryMember();
        List<String> expectedMemberNames = new ArrayList<>();
        List<String> actualMemberNames = new ArrayList<>();
        expectedMemberNames.add(primaryMember.getSignature());
        actualMemberNames.add(medicalMemberNames.get(0).getText());
        List<MemberDetails> memberDetailsList = SharedData.getMembers();

        if(memberDetailsList !=null) {
            for (int i = 0; i < memberDetailsList.size(); i++) {
                MemberDetails member = SharedData.getMembers().get(i);
                expectedMemberNames.add(member.getFirstName()+" "+member.getLastName());
                actualMemberNames.add(planInformationTable.get(i+2).getText());
            }
        }
        softAssert.assertTrue(actualMemberNames.containsAll(expectedMemberNames) && expectedMemberNames.containsAll(actualMemberNames) && actualMemberNames.size()==expectedMemberNames.size());
        softAssert.assertAll();
    }

    public void verifyPlanInfo() {
        MemberDetails primaryMember = SharedData.getPrimaryMember();
        softAssert.assertEquals(planYearOnWelcomeBackPage.getText(), SharedData.getPlanYear(),"Plan Year does not match");
        int totalDependents = Integer.parseInt(SharedData.getScenarioDetails().getDependents());
        // only the locator for the plan details change but the value will stay same for the entire group. Hence, comparing with primary member.
        softAssert.assertEquals(planInformationTable.get(totalDependents+2).getText(), primaryMember.getMedicalPlan(), "Primary Medical Plan Name does not match");

        softAssert.assertEquals(planInformationTable.get(totalDependents+3).getText(), "$" + primaryMember.getMedicalPremiumAmt(), "Primary Medical premium amount does not match");
        softAssert.assertEquals(planInformationTable.get(totalDependents+4).getText(), "$"+primaryMember.getMedicalAptcAmt(), "Medical APTC amount did not match");
        //Dental
        softAssert.assertEquals(planInformationTable.get(totalDependents+totalDependents+7).getText(), primaryMember.getDentalPlan(), "Primary Dental Plan Name does not match");
        softAssert.assertEquals(planInformationTable.get(totalDependents+totalDependents+8).getText(), "$"+basicActions.doubleAmountFormat(primaryMember.getDentalPremiumAmt()), "Primary Dental Premium amount does not match");
        softAssert.assertEquals(planInformationTable.get(totalDependents+totalDependents+9).getText(), primaryMember.getDentalAptcAmt(), "Dental APTC amount on account overview page mismatch");
        softAssert.assertAll();
    }

    public void setScenarioDetails(List<Map<String, String>> expectedResult) {
        String noOfGroups = expectedResult.get(0).get("totalGroups");
        String totalMembers = expectedResult.get(0).get("totalMembers");
        String totalSubscribers = expectedResult.get(0).get("total_subscribers");
        String totalDependents = expectedResult.get(0).get("total_dependents");
        String totalEnrollees = expectedResult.get(0).get("total_enrollees");
        ScenarioDetails scenarioDetails = new ScenarioDetails();
        scenarioDetails.setTotalGroups(Integer.parseInt(noOfGroups));
        scenarioDetails.setTotalMembers(Integer.parseInt(totalMembers));
        scenarioDetails.setSubscribers(totalSubscribers);
        scenarioDetails.setDependents(totalDependents);
        scenarioDetails.setEnrollees(totalEnrollees);
        SharedData.setScenarioDetails(scenarioDetails);
   }

    public void setDates(List<Map<String, String>> expectedResult) {
        // These details are same for medical and dental. If dental plan has different values, then we should rely on a different step.
        MemberDetails subscriber = SharedData.getPrimaryMember();
        ExpectedCalculatedDates expectedCalculatedDates = new ExpectedCalculatedDates();

        String policyStartDate = basicActions.getDateBasedOnRequirement(expectedResult.get(0).get("PolicyStartDate"));
        String policyEndDate = basicActions.getDateBasedOnRequirement(expectedResult.get(0).get("PolicyEndDate"));
        String coverageStartDate = basicActions.getDateBasedOnRequirement(expectedResult.get(0).get("CoverageStartDate"));
        String coverageEndDate = basicActions.getDateBasedOnRequirement(expectedResult.get(0).get("CoverageEndDate"));
        String financialStartDate = basicActions.getDateBasedOnRequirement(expectedResult.get(0).get("FinancialStartDate"));
        String financialEndDate = basicActions.getDateBasedOnRequirement(expectedResult.get(0).get("FinancialEndDate"));
        String planStartDate =  basicActions.changeDateFormat(policyStartDate, "yyyy-MM-dd", "MM/dd/yyyy");
        String planEndDate = basicActions.changeDateFormat(policyEndDate, "yyyy-MM-dd", "MM/dd/yyyy");

        expectedCalculatedDates.setPolicyStartDate(policyStartDate);
        expectedCalculatedDates.setPolicyEndDate(policyEndDate);
        expectedCalculatedDates.setCoverageStartDate(coverageStartDate);
        expectedCalculatedDates.setCoverageEndDate(coverageEndDate);
        expectedCalculatedDates.setFinancialStartDate(financialStartDate);
        expectedCalculatedDates.setFinancialEndDate(financialEndDate);

        subscriber.setPlanStartDate(planStartDate);
        subscriber.setPlanEndDate(planEndDate);

        SharedData.setExpectedCalculatedDates(expectedCalculatedDates);
        SharedData.setPrimaryMember(subscriber);

    }


    public void validateFirstMemberName(String memberName){
    basicActions.waitForElementToBePresent(txtUserName,20);
    softAssert.assertTrue(txtUserName.getText().contains(memberName));
    softAssert.assertAll();
    System.out.println(SharedData.getPrimaryMember().getCompleteFullName());
    }

}
