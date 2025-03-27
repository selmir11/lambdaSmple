package com.c4hco.test.automation.globalhooks;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GlobalHooks {

    private WebDriver driver;

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("Before Scenario!");
        SharedData.reset();
        driver = WebDriverManager.getDriver();  // Ensure driver is initialized
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed() && SharedData.getScreenshots().equals("yes")) {
            screenshot(scenario);
        }
        if (SharedData.getGlobalHooksAfter().equals("yes"))  {
        WebDriverManager.closeDriver();
        }

        System.out.println("After Scenario!");
    }

    private void screenshot(Scenario scenario) {
        if (driver != null) {
            Date now = new Date();
            String dateFolder = new SimpleDateFormat("yyyy-MM-dd").format(now);
            String hourFolder = new SimpleDateFormat("HH").format(now);

            Path outputDirectory = Paths.get("target/screenshots", dateFolder, hourFolder);

            try {
                Files.createDirectories(outputDirectory);
            } catch (IOException e) {
                System.out.println("[ERROR] Failed to create screenshot folder: " + e.getMessage());
                return;
            }

            String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
            String timestamp = new SimpleDateFormat("mm").format(now);
            String screenshotFileName = scenarioName + "_" + timestamp + ".png";

            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = outputDirectory.resolve(screenshotFileName).toString();

            try {
                FileUtils.copyFile(screenshotFile, new File(screenshotPath));
                System.out.println("[INFO] Screenshot saved at: " + screenshotPath);
            } catch (IOException e) {
                System.out.println("[ERROR] Failed to save screenshot: " + e.getMessage());
            }
        }
    }

}
