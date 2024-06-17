package com.c4hco.test.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;
import com.c4hco.test.automation.sftpConfig.SftpUtil;

public class WebDriverManager {
    private static WebDriver driver;

    private WebDriverManager() {
        // private constructor to prevent instantiation
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = initializeDriver();
        }
        return driver;
    }

    private static WebDriver initializeDriver() {
        // Create a map to store the preferences
        Map<String, Object> prefs = new HashMap<>();
        SftpUtil sftpUtil = new SftpUtil();

        String localPath = sftpUtil.getLocalSftpDownloadPath();

        // Set the download directory
        prefs.put("download.default_directory", localPath);

        // Disable the download prompt
        prefs.put("download.prompt_for_download", false);
        prefs.put("profile.default_content_settings.popups", 0);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        return new ChromeDriver(options);
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset the driver instance
        }
    }
}
