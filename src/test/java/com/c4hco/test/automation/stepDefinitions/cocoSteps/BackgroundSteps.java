package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.LoginPage;
import io.cucumber.java8.En;
import com.c4hco.test.automation.dbUtils.DataProviderDb_qa_coco;

public class BackgroundSteps implements En {

    public BackgroundSteps(){
        LoginPage loginPage = new LoginPage();
        DataProviderDb_qa_coco dbDataProviderForQaCoco = new DataProviderDb_qa_coco();

        When("I open the login page on the login portal", () -> {
            loginPage.openPage();
        });

        Given("I connect to the ob834_detail table", ()->{
            // move this step around - To DO
            dbDataProviderForQaCoco.getDataFromob834_detail();
        });

    }
}
