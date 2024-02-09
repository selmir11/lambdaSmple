package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.ToolBarPage;
import io.cucumber.java.en.*;

public class ToolBarPageSteps {
    ToolBarPage toolBarPage = new ToolBarPage();

    @Then("I click on sign out button to exit the application")
    public void signOutAction(){
        toolBarPage.signOut();
    }
}
