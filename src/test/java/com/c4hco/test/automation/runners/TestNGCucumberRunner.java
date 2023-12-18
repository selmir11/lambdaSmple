package com.c4hco.test.automation.runners;

import com.c4hco.test.automation.utils.ApplicationProperties;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/Features",
        glue = {"org.c4hco.stepDefinitions.cocoSteps","org.c4hco.stepDefinitions.cocoSteps","org.c4hco.globalhooks"},
        plugin = {"pretty", "html:target/execution-reports.html", "testng:target/execution-reports.xml"}
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {

    TestNGCucumberRunner(){
        String tags = ApplicationProperties.getInstance().getProperty("scenario.tags");
        System.setProperty("cucumber.filter.tags", tags);
    }
}