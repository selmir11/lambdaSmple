package com.c4hco.test.automation.utils;

import com.c4hco.test.automation.Dto.SharedData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Utils {
    private String env = ApplicationProperties.getInstance().getProperty("env");
    private BasicActions basicActions;

    public Utils(WebDriver webDriver){
        this.basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
        SharedData.setEnv(env);
        SharedData.setDbName(getdbName());
    }

    public String getBaseLoginUrl(String portalType){
        String baseUrl = "";
        switch(portalType){
            case "login":
                baseUrl = Constants.PROTOCOL+env+Constants.LOGIN;
                break;
            case "broker":
                baseUrl = Constants.PROTOCOL+env+Constants.BROKER;
                break;
            case "admin":
                baseUrl = Constants.PROTOCOL+env+Constants.ADMIN;
                break;
            case "assistNet":
                baseUrl = Constants.PROTOCOL+env+Constants.ASSISTER;
                break;
           default: throw new IllegalArgumentException("Invalid option: " + portalType);
        }
        return baseUrl;
    }

    public String getdbName(){
        String dbName;
        if(env.equals("qa")){
            dbName = env+"_"+"exch";
        } else {
            dbName = "exch";
        }
        return dbName;
    }
}
