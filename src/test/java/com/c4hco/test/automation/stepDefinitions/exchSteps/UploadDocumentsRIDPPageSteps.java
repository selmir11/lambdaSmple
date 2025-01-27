package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.UploadDocumentsRIDPPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class UploadDocumentsRIDPPageSteps {
    UploadDocumentsRIDPPage  uploadDocumentsRIDPPage = new  UploadDocumentsRIDPPage(WebDriverManager.getDriver());

   @Then("I click on back button of Upload Documents RIDP page")
   public void clickOnBackButton(){
       uploadDocumentsRIDPPage.clickBackButton();
   }

    @Then("I click on upload documents button of Upload Documents RIDP page")
    public void clickOnUploadDocumentsButton(){
        uploadDocumentsRIDPPage.clickUploadDocumentsButton();
    }

}
