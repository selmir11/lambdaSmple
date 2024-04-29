package com.c4hco.test.automation.runners;

import com.c4hco.test.automation.utils.ApplicationProperties;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps",
                "com.c4hco.test.automation.stepDefinitions.cocoSteps",
                "com.c4hco.test.automation.stepDefinitions.exchSteps",
                "com.c4hco.test.automation.stepDefinitions.sftpSteps",
                "com.c4hco.test.automation.stepDefinitions.databaseSteps",
                "com.c4hco.test.automation.stepDefinitions.APISteps",
                "com.c4hco.test.automation.globalhooks"
                }
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {

    TestNGCucumberRunner(){
        String reportFolderPath =getReportPath();
        String tags = ApplicationProperties.getInstance().getProperty("scenario.tags");
        System.setProperty("cucumber.filter.tags", tags);
        // Set the report folder for the HTML and XML reports
        System.setProperty("cucumber.plugin",
                "pretty,html:" + reportFolderPath + "/execution-reports.html,testng:" + reportFolderPath + "/execution-reports.xml");
    }

    private String getReportPath(){
        String timestamp = new SimpleDateFormat("MMddyyyy-HHmmss").format(new Date());
        String reportFolderPath = "target/cucumber-reports/ExecutionReport-" + timestamp;
        // Create the timestamped folder
        File reportFolder = new File(reportFolderPath);
        if (!reportFolder.exists()) {
            boolean folderCreated = reportFolder.mkdirs();
            if (!folderCreated) {
                System.out.println("Failed to create the report folder.");
            }
        }
        return reportFolderPath;
    }
}