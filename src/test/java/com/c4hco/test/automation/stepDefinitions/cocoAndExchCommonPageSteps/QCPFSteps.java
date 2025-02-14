package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.QCPFPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class QCPFSteps {
    QCPFPage qcpfPage = new QCPFPage(WebDriverManager.getDriver());
    @Then("I click get started on QCPF Page")
    public void iClickGetStartedOnQCPFPage() {
        qcpfPage.clickGetStartedOnQCPFPage();
    }

    @Then("I enter basic information Name {string} sex {string} DOB {string} in QCPF page")
    public void iEnterBasicInformationNameSexDOBInQCPFPage(String name, String sex, String dob) {
        qcpfPage.enterBasicInformationNameSexDOBInQCPFPage(name, sex, dob);
    }

    @And("I enter location and coverage zipCode {string} county {string} in QCPF page")
    public void iEnterLocationAndCoverageZipCodeCountyInQCPFPage(String zipCode, String county) {
        qcpfPage.enterLocationAndCoverageZipCodeCountyInQCPFPage(zipCode, county);
    }

    @Then("I click {string} for financial help question in QCPF page")
    public void iClickForFinancialHelpQuestionInQCPFPage(String financialOptions) {
        qcpfPage.clickForFinancialHelpQuestionInQCPFPage(financialOptions);
    }

    @And("I click continue button in QCPF page")
    public void iClickContinueButtonInQCPFPage() {
        qcpfPage.clickContinueButtonInQCPFPage();
    }

    @And("I click this looks right button in QCPF page")
    public void iClickThisLooksRightButtonInQCPFPage() {
        qcpfPage.clickThisLooksRightButtonInQCPFPage();
    }

    @Then("I click ok got it button in QCPF page")
    public void iClickOkGotItButtonInQCPFPage() {
        qcpfPage.clickOkGotItButtonInQCPFPage();
    }

    @Then("I click view plan button in QCPF page")
    public void iClickViewPlanButtonInQCPFPage() {
        qcpfPage.clickViewPlanButtonInQCPFPage();
    }

    @Then("I click choose plan button in QCPF page")
    public void iClickChoosePlanButtonInQCPFPage() {
        qcpfPage.clickChoosePlanButtonInQCPFPage();
    }
    @Then("I click start over button in QCPF page")
    public void iClickStartOverButtonInQCPFPage() {
        qcpfPage.clickStartOverButtonInQCPFPage();
    }

    @And("I validate the total number {string} of plans displayed and for Plan Anthem Blue Cross & Blue Shield {string}, Kaiser Permanente {string}, Denver Health Medical Plan {string}, Cigna {string}, Rocky Mountain Health Plans {string}, Select Health {string}")
    public void iValidateTheTotalNumberOfPlansDisplayedAndForPlanAnthemBlueCrossBlueShieldKaiserPermanenteDenverHealthMedicalPlanCignaRockyMountainHealthPlansSelectHealth(String plansNumber, String Anthem, String Kaiser, String DenverHealth, String Cigna, String RockyMountain, String Select) {
        qcpfPage.validateTheTotalNumberOfPlansDisplayedAndPlanDetails(plansNumber,Anthem,Kaiser, DenverHealth,Cigna,RockyMountain, Select);
    }

    @And("I validate the total number {string} of plans displayed by county")
    public void iValidateTheTotalNumberOfPlansDisplayedByCounty(String totalPlanNumber) {
        qcpfPage.validateTheTotalNumberOfPlansDisplayedByCounty(totalPlanNumber);
    }

    @And("I validate the total number {string} of plans displayed and for Plan Anthem Blue Cross & Blue Shield {string}, Kaiser Permanente {string}, Denver Health Medical Plan {string}, Cigna {string}, Rocky Mountain Health Plans {string}")
    public void iValidateTheTotalNumberOfPlansDisplayedAndForPlanAnthemBlueCrossBlueShieldKaiserPermanenteDenverHealthMedicalPlanCignaRockyMountainHealthPlans(String plansNumber, String Anthem, String Kaiser, String DenverHealth, String Cigna, String RockyMountain) {
        qcpfPage.validateTheTotalNrOfPlansDisplayedForCountiesWith5Plans(plansNumber,Anthem,Kaiser, DenverHealth,Cigna,RockyMountain);
    }
}
