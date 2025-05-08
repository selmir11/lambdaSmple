package com.c4hco.test.automation.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Utils {
    private String env = ApplicationProperties.getInstance().getProperty("env");
    private String isLrEnv = ApplicationProperties.getInstance().getProperty("isLrEnv");
    private String isOpenEnrollment = ApplicationProperties.getInstance().getProperty("isOpenEnrollment");
    private String ses = ApplicationProperties.getInstance().getProperty("ses");
    private String dbName = ApplicationProperties.getInstance().getProperty("dbName");

    private BasicActions basicActions;

    public Utils(WebDriver webDriver){
        this.basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public String getBaseLoginUrl(String portalType){
        String baseUrl = "";
        String lrPath = isLrEnv.equals("yes") ? "/lr/" : "";
        switch(portalType){
            case "login":
                baseUrl = Constants.PROTOCOL+env+Constants.host+lrPath+Constants.LOGIN;
                break;
        }
        return baseUrl;
    }


}
