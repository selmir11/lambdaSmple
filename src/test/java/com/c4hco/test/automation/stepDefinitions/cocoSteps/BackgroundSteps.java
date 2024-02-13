package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPage;
import io.cucumber.java.en.*;
import com.c4hco.test.automation.dbUtils.DataProviderDb_qa_coco;

public class BackgroundSteps {
        LoginPage loginPage = new LoginPage();
        DataProviderDb_qa_coco dbDataProviderForQaCoco = new DataProviderDb_qa_coco();

        @Given("I open the login page on the {string} portal")
        public void openPage(String appType){
            loginPage.openPage(appType);
        };

        @Given("I connect to the ob834_detail table")
                public void iGetDataFromOb834DetailTable() {
            dbDataProviderForQaCoco.getDataFromob834_detail();
        };
}
