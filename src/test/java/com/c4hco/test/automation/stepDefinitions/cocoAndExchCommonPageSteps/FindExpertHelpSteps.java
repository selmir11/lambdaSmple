package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.FindExpertHelpPage;
import io.cucumber.java.en.*;

public class FindExpertHelpSteps {
        FindExpertHelpPage findExpertHelpPage = new FindExpertHelpPage();
        @Then("I verify Find Expert Help header Text in {string}")
        public void IVerifyFindExpertHelpHeaderTextIn(String Language) {
                findExpertHelpPage.verifyHeaderPage(Language);
        }

        @Then("I verify Find Expert Help page title Text in {string}")
        public void i_verify_find_expert_help_page_title_text_in(String Language) {
                findExpertHelpPage.verifyTitlePage(Language);
        }

        @Then("I verify Find Expert Help page Text in {string}")
        public void IVerifyFindExpertHelpPageTextIn (String Language) {
                findExpertHelpPage.verifyPageText(Language);
        }

        @Then("I verify Find Expert Help buttons in {string}")
        public void i_verify_find_expert_help_buttons_in(String Language) {
                 findExpertHelpPage.verifyButtontext(Language);
        }
}
