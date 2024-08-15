package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

public class AccountOverviewPage {

    @FindBy(css=".fas.fa-spinner.fa-spin")
    WebElement spinner;

    @FindBy(css = "li.vertical-ruler")
    WebElement userNameExchLink;

    @FindBy(css = "//*[@id='submit-curr-yr-3' or @id='submit-curr-yr-1']")
    WebElement btnApplyForCurrentYear;  //Locator for both QA and Staging

    @FindBy(css = "#submit[name='applyForNextYear']")
    WebElement btnApplyForNextYear;

    @FindBy(css = ".linkButton")
    List<WebElement> clickHereLinks; // profile, eligibility, documents, plans

    @FindBy(css = "h4 .c4PageHeader")
    WebElement txtNextStep;

    @FindBy(id = "submit-curr-yr-6")
    WebElement makeChangesButton;

    @FindBy(css = ".c4PageHeader-large")
    WebElement header;

    @FindBy(css = ".table-bordered td b")
    List<WebElement> planInformationTable;

    @FindBy(css = ".table-bordered tr:nth-child(1) td:nth-child(2) span b")
    List<WebElement> medicalMemberNames;
    @FindBy(css = "p select option:nth-child(1)")
    WebElement planYearOnWelcomeBackPage;

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
        basicActions.waitForElementToDisappear( spinner, 20 );
        basicActions.waitForElementToBePresent(header, 10);
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
        basicActions.waitForElementToBePresent(header, 10);
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
        softAssert.assertEquals(medicalMemberNames.get(0).getText(), primaryMember.getFirstName() + " " + primaryMember.getLastName(), "Primary member name does not match");
        List<MemberDetails> memberDetailsList = SharedData.getMembers();
        if(memberDetailsList !=null) {
            for (int i = 0; i < memberDetailsList.size(); i++) {
                MemberDetails member = SharedData.getMembers().get(i);
                softAssert.assertEquals(planInformationTable.get(i + 2).getText(), member.getFirstName() + " " + member.getLastName(), "Member name does not match");
            }
        }
        softAssert.assertAll();
    }

    public void verifyPlanInfo() {
        MemberDetails primaryMember = SharedData.getPrimaryMember();
        softAssert.assertEquals(planYearOnWelcomeBackPage.getText(), SharedData.getPlanYear(),"Plan Year does not match");
        List<MemberDetails> memberDetailsList = SharedData.getMembers();
        if(memberDetailsList !=null) {
            int totalMembers = memberDetailsList.size();
            for (int i = 0; i < totalMembers; i++) {
                MemberDetails member = SharedData.getMembers().get(i);
                softAssert.assertEquals(planInformationTable.get(i + 3).getText(), member.getMedicalPlan(), "Members Medical Plan Name does not match");
                softAssert.assertEquals(planInformationTable.get(i + 4).getText(), "$" + member.getMedicalPremiumAmt(), "Members Medical premium amount does not match");
                softAssert.assertEquals(planInformationTable.get(i + 9).getText(), member.getDentalPlan(), "Members Dental Plan Name does not match");
                softAssert.assertEquals(planInformationTable.get(i + 10).getText() + ".00", member.getDentalPremiumAmt(), "Members Dental Premium amount does not match");
            }
        }else{
            softAssert.assertEquals(planInformationTable.get(2).getText(), primaryMember.getMedicalPlan(), "Primary Medical Plan Name does not match");
            softAssert.assertEquals(planInformationTable.get(3).getText(), "$" + primaryMember.getMedicalPremiumAmt(), "Primary Medical premium amount does not match");
            softAssert.assertEquals(planInformationTable.get(7).getText(), primaryMember.getDentalPlan(), "Primary Dental Plan Name does not match");
            softAssert.assertEquals(planInformationTable.get(8).getText()+".00", primaryMember.getDentalPremiumAmt(), "Primary Dental Premium amount does not match");
        }
        softAssert.assertAll();
    }

    public void setScenarioDetails(List<Map<String, String>> expectedResult) {
        String noOfGroups = expectedResult.get(0).get("totalGroups");
        SharedData.setTotalGroups(Integer.parseInt(noOfGroups));
    }

}
