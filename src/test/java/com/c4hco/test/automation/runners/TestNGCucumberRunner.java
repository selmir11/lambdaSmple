package com.c4hco.test.automation.runners;

import com.c4hco.test.automation.utils.ApplicationProperties;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"com.c4hco.test.automation.stepDefinitions.cocoSteps","com.c4hco.test.automation.stepDefinitions.exchSteps","com.c4hco.test.automation.globalhooks"},
        plugin = {"pretty", "html:target/execution-reports.html", "testng:target/execution-reports.xml"}
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {

    TestNGCucumberRunner(){
        String tags = ApplicationProperties.getInstance().getProperty("scenario.tags");
        System.setProperty("cucumber.filter.tags", tags);
    }
}