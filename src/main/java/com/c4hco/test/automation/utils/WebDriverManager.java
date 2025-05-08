package com.c4hco.test.automation.utils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


public class WebDriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final String BITBAR_DESKTOP_URL = "https://selmir:LT_9Vaj2XarlU15Tg13mwWRZmEZfLjuqbqaiFwGoyPGx0qNrtp@hub.lambdatest.com/wd/hub";
    private static final String BITBAR_MOBILE_URL = "https://us-west-mobile-hub.bitbar.com/wd/hub";

    private WebDriverManager() {
        // private constructor to prevent instantiation
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(initializeDriver());
            maximizeWindow(driver.get());

            if ("yes".equals(ApplicationProperties.getInstance().getProperty("pdfTesting"))) {
                driver.get().manage().deleteAllCookies();
                driver.get().get("chrome://settings/clearBrowserData");
                driver.get().findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
            }
        }
        return driver.get();
    }

    private static WebDriver initializeDriver() {
        String environment = ApplicationProperties.getInstance().getProperty("driver"); // "Local", "Remote", "Mobile"

        if ("Mobile".equalsIgnoreCase(environment)) {
            return initializeMobileDriver();
        } else {
            return initializeDesktopDriver(environment);
        }
    }
    private static final String hub = "@hub.lambdatest.com/wd/hub";
    private static WebDriver initializeDesktopDriver(String environment) {
        ChromeOptions options = new ChromeOptions();

        if ("Remote".equalsIgnoreCase(environment)) {
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            options.setPlatformName("Windows 10");
            options.setBrowserVersion("dev");
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("username", "selmir");
            ltOptions.put("accessKey", "LT_9Vaj2XarlU15Tg13mwWRZmEZfLjuqbqaiFwGoyPGx0qNrtp");
            ltOptions.put("project", "c4");
            ltOptions.put("selenium_version", "4.0.0");
            ltOptions.put("w3c", true);
            ltOptions.put("tunnel",true);
            ltOptions.put("build","loginTest");
            ltOptions.put("name","login");
            options.setCapability("LT:Options", ltOptions);


        } else {
            // Running Locally
            System.out.println("Running Locally...");
            io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
            options.addArguments("--start-maximized");
        }

        if ("yes".equals(ApplicationProperties.getInstance().getProperty("pdfTesting"))) {
            System.out.println("Configuring browser settings for PDF testing...");
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("download.prompt_for_download", false);
            prefs.put("profile.default_content_settings.popups", 0);

            BasicActions basicActions = new BasicActions();
//            String localPath = basicActions.getNoticesDownloadPath();
//            String absolutePath = Paths.get(localPath).toAbsolutePath().toString();

//            prefs.put("download.default_directory", absolutePath);
//            prefs.put("savefile.default_directory", absolutePath);
            prefs.put("plugins.plugins_disabled", new String[]{"Chrome PDF Viewer"});
            prefs.put("download.directory_upgrade", true);
            prefs.put("safebrowsing.enabled", true);
            prefs.put("download.extensions_to_open", "application/xml");

            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--safebrowsing-disable-download-protection");
        }

        try {
            if ("Remote".equalsIgnoreCase(environment)) {
                String hub = "@hub.lambdatest.com/wd/hub";
                String hubMobile = "@mobile-hub.lambdatest.com/wd/hub";  // to start session for mobile devices
                String remoteUrl = "https://" + "selmir" + ":" + "LT_9Vaj2XarlU15Tg13mwWRZmEZfLjuqbqaiFwGoyPGx0qNrtp" + hub;
                return new RemoteWebDriver(new URL(remoteUrl), options);
            } else {
                return new ChromeDriver(options);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Remote WebDriver URL", e);

        }}

    private static WebDriver initializeMobileDriver() {
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, Object> bitbarOptions = new HashMap<>();

        bitbarOptions.put("apiKey", ApplicationProperties.getInstance().getProperty("BitBarAPI"));
        bitbarOptions.put("device", ApplicationProperties.getInstance().getProperty("device"));
        bitbarOptions.put("findDevice", false);
        bitbarOptions.put("appiumVersion", "2.0");

        capabilities.setCapability("platformName", ApplicationProperties.getInstance().getProperty("PlatformName"));
        capabilities.setCapability("browserName", ApplicationProperties.getInstance().getProperty("BrowserName"));
        capabilities.setCapability("appium:automationName", ApplicationProperties.getInstance().getProperty("AutomationName"));
        capabilities.setCapability("bitbar:options", bitbarOptions);

        try {
            return new RemoteWebDriver(new URL(BITBAR_MOBILE_URL), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Bitbar Mobile Server URL", e);
        }
    }


    private static void maximizeWindow(WebDriver driver) {
        try {
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println("Failed to maximize browser window: " + e.getMessage());
        }
    }

    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }}


}

