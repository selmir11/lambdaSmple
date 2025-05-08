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
            if(ApplicationProperties.getInstance().getProperty("pdfTesting").equals("yes")) {
                driver.manage().deleteAllCookies();
                driver.get("chrome://settings/clearBrowserData");
                driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
            }
        }
        return driver;
    }

    private static WebDriver initializeDriver() {
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
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
