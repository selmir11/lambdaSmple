package com.c4hco.test.automation.runners;

import com.c4hco.test.automation.utils.ApplicationProperties;
import io.cucumber.tagexpressions.TagExpressionParser;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps",
                "com.c4hco.test.automation.stepDefinitions.cocoSteps",
                "com.c4hco.test.automation.stepDefinitions.exchSteps",
                "com.c4hco.test.automation.stepDefinitions.sftpSteps",
                "com.c4hco.test.automation.stepDefinitions.databaseSteps",
                "com.c4hco.test.automation.stepDefinitions.APISteps",
                "com.c4hco.test.automation.globalhooks.GlobalHooks"
        }
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {

    private int iterationCount;

    TestNGCucumberRunner(){
        String reportFolderPath =getReportPath();
        String tags = ApplicationProperties.getInstance().getProperty("scenario.tags");
        System.setProperty("cucumber.filter.tags", tags);
        // Set the report folder for the HTML and XML reports
        System.setProperty("cucumber.plugin",
                "pretty,html:" + reportFolderPath + "/execution-reports.html,"+"json:"+reportFolderPath+"/cucumber-json.json,"+"testng:" + reportFolderPath + "/execution-reports.xml");
        iterationCount = Integer.parseInt(ApplicationProperties.getInstance().getProperty("iteration.count"));
    }

    @DataProvider
    @Override
    public Object[][] scenarios() {
        // Get scenarios from the parent method
        Object[][] scenarios = super.scenarios();

        // Fetch dynamic tags from application properties
        String dynamicTags = ApplicationProperties.getInstance().getProperty("scenario.tags");
        // Print the dynamic tags for debugging
        System.out.println("Dynamic Tags: " + dynamicTags);
        // Filter scenarios based on dynamic tags
        List<Object[]> filteredScenarios = new ArrayList<>();
        if (dynamicTags != null && !dynamicTags.isEmpty()) {
            System.out.println("Filtering scenarios based on tags...");
            filteredScenarios = Arrays.stream(scenarios)
                    .filter(scenario -> {
                        PickleWrapper pickleWrapper = (PickleWrapper) scenario[0];
                        boolean matches = TagExpressionParser.parse(dynamicTags)
                                .evaluate(pickleWrapper.getPickle().getTags());
                        // Print which scenarios are filtered
                        System.out.println("Scenario: " + pickleWrapper.getPickle().getName() +
                                " - Matches: " + matches);
                        return matches;
                    })
                    .toList();
        } else {
            System.out.println("No dynamic tags provided. Returning all scenarios.");
            filteredScenarios.addAll(Arrays.asList(scenarios));
        }

        // Duplicate filtered scenarios to run multiple times
        List<Object[]> scenariosToReturn = new ArrayList<>();
        for (Object[] scenario : filteredScenarios) {
            for (int i = 0; i < iterationCount; i++) {
                scenariosToReturn.add(scenario); // Add the same scenario multiple times
            }
        }
        // Print filtered scenarios count
        System.out.println("Total Iteration Count : " + scenariosToReturn.size());
        return scenariosToReturn.toArray(new Object[0][]);
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