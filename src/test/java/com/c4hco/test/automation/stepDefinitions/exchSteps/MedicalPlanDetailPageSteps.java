package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MedicalDetailPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
    public class MedicalPlanDetailPageSteps {

        MedicalDetailPage medicalDetailPage = new MedicalDetailPage( WebDriverManager.getDriver() );

        @And("I validate the Plan Detail summary pdf link")
        public void clickPDFDetail() {
            medicalDetailPage.clickPDFDetail();
        }

        @And("I validate the Plan Detail Disclaimer text")
        public void validateDisclaimerText() {
            medicalDetailPage.validateDisclaimerDetail();
        }

        @And("I validate the text headers and subheaders for the InNetwork Detail page")
        public void validateTextHeadersInNetwork() {
            medicalDetailPage.validateEnglishTextHeadersInNetwork();
        }

        @And("I click the English Plan Detail OutNetwork Link")
        public void clickOutNetworkLink() {
            medicalDetailPage.clickOutNetworkLink();
        }

        @And("I validate the {string} document upload links for the Medical Detail page")
        public void validateDocumentsUpload(String carrier) {medicalDetailPage.validateDocumentsUpload2(carrier);}

        @And("I validate the text headers and subheaders for the OutNetwork Detail page")
        public void validateTextHeadersOutNetwork() {
            medicalDetailPage.validateEnglishTextHeadersOutNetwork();
        }

        @And("I click the English Plan Detail InNetwork Link")
        public void clickInNetworkLink() {
            medicalDetailPage.clickInNetworkLink();
        }

        @And("I click Go Back on the Plan Detail page")
        public void clickGoBackDetail() {
            medicalDetailPage.clickGoBackDetail();
        }

        @And("I click the Remove this Plan button")
        public void clickRemovePlan() {
            medicalDetailPage.clickRemovePlan();
        }

        @And("I click the Select this Plan button")
        public void clickSelectPlan() {
            medicalDetailPage.clickSelectPlan();
        }

        @And("I validate the Spanish Plan Detail summary pdf link")
        public void clickSpanishPDFDetail() {
            medicalDetailPage.clickSpanishPDFDetail();
        }

        @And("I validate the Spanish Plan Detail Disclaimer text")
        public void validateSpanishDisclaimerText() {
            medicalDetailPage.validateSpanishDisclaimerText();
        }

        @And("I validate the Spanish plan documents")
        public void validateSpanishPlanDocuments() {
            medicalDetailPage.validateSpanishPlanDocuments();
        }

        @And("I validate the Spanish text headers and subheaders for the OutNetwork Detail page")
        public void validateSpanishTextHeadersOutNetwork() {
            medicalDetailPage.validateSpanishTextHeadersOutNetwork();
        }

        @And("I validate the Spanish text headers and subheaders for the InNetwork Detail page")
        public void validateSpanishTextHeadersInNetwork() {
            medicalDetailPage.validateSpanishTextHeadersInNetwork();
        }

        @And("I click the Spanish Select this Plan button")
        public void clickSpanishSelectPlan() {
            medicalDetailPage.clickSpanishSelectPlan();
        }

        @And("I click Spanish Go Back on the Plan Detail page")
        public void clickSpanishGoBackDetail() { medicalDetailPage.clickSpanishGoBackDetail(); }

        @And("I click the Spanish Plan Detail InNetwork Link")
        public void clickSpanishInNetworkLink() { medicalDetailPage.clickSpanishInNetworkLink();}

        @And("I click the Spanish Plan Detail OutNetwork Link")
        public void clickSpanishOutNetworkLink() { medicalDetailPage.clickSpanishOutNetworkLink();}

        @And("I validate the document links for the Network Detail page")
        public void validateDocumentsNetworkLink() { medicalDetailPage.validateDocumentsNetworkLink();}


    }

