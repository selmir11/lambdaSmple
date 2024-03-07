package com.c4hco.test.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Utils {
    private String env = ApplicationProperties.getInstance().getProperty("env");
    private BasicActions basicActions;

    public Utils(WebDriver webDriver){
        this.basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public String getBaseLoginUrl(String appType){
        String baseUrl = "";
        switch(appType){
            case "login":
                baseUrl = Constants.PROTOCOL+env+Constants.LOGIN;
                break;
            case "broker":
                baseUrl = Constants.PROTOCOL+env+Constants.BROKER;
                break;

            case "admin":
                baseUrl = Constants.PROTOCOL+env+Constants.ADMIN;
                break;
        }
        return baseUrl;
    }
}
