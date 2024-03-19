package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.database.dbDataProvider.DataProviderDb_qa_coco;
import io.cucumber.java.en.Given;

public class BackgroundSteps {
        DataProviderDb_qa_coco dbDataProviderForQaCoco = new DataProviderDb_qa_coco();

        @Given("I connect to the ob834_detail table")
                public void iGetDataFromOb834DetailTable() {
            dbDataProviderForQaCoco.getDataFromob834_detail();
        };
}
