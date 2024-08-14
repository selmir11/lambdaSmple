package com.c4hco.test.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

import java.nio.file.Paths;

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
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();

        if(ApplicationProperties.getInstance().getProperty("pdfTesting").equals("yes")){
            // Create a map to store the preferences
            Map<String, Object> prefs = new HashMap<>();
            // Disable the download prompt
            prefs.put("download.prompt_for_download", false);
            prefs.put("profile.default_content_settings.popups", 0);
            ChromeOptions options = new ChromeOptions();

            BasicActions basicActions = new BasicActions();
            String localPath = basicActions.getNoticesDownloadPath();
            String absolutePath = Paths.get(localPath).toAbsolutePath().toString();

            // Set the download directory
            prefs.put("download.default_directory", absolutePath);
            prefs.put("savefile.default_directory", absolutePath);

            // Disable the download prompt
            prefs.put("plugins.plugins_disabled", new String[] {"Chrome PDF Viewer"});
            prefs.put("download.prompt_for_download", false);
            prefs.put("profile.default_content_settings.popups", 0);
            prefs.put("download.directory_upgrade", true);
            prefs.put("safebrowsing.enabled", true);
            prefs.put("download.extensions_to_open", "application/xml");

            options.addArguments("--start-maximized");
            options.addArguments("--safebrowsing-disable-download-protection");
            options.setExperimentalOption("prefs", prefs);
            driver.manage().deleteAllCookies();
            driver.get("chrome://settings/clearBrowserData");
            driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
            return new ChromeDriver(options);
        } else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--incognito");
            return new ChromeDriver(options);
        }

    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset the driver instance
        }
    }
}
