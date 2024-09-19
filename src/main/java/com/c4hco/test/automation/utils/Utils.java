package com.c4hco.test.automation.utils;

import com.c4hco.test.automation.Dto.SharedData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Utils {
    private String env = ApplicationProperties.getInstance().getProperty("env");
    private String isLrEnv = ApplicationProperties.getInstance().getProperty("isLrEnv");
    private String isOpenEnrollment = ApplicationProperties.getInstance().getProperty("isOpenEnrollment");
    private String ses = ApplicationProperties.getInstance().getProperty("ses");
    private BasicActions basicActions;

    public Utils(WebDriver webDriver){
        this.basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
        SharedData.setEnv(env);
        SharedData.setDbName(getdbName());
        SharedData.setIsOpenEnrollment(isOpenEnrollment);
        SharedData.setSes(ses);
    }

    public String getBaseLoginUrl(String portalType){
        String baseUrl = "";
        String lrPath = isLrEnv.equals("yes") ? "/lr/" : "";
        switch(portalType){
            case "login":
                baseUrl = Constants.PROTOCOL+env+Constants.host+lrPath+Constants.LOGIN;
                break;
            case "broker":
                baseUrl = Constants.PROTOCOL+env+Constants.host+lrPath+Constants.BROKER;
                break;
            case "admin":
                baseUrl = Constants.PROTOCOL+env+Constants.host+lrPath+Constants.ADMIN;
                break;
            case "assistNet":
                baseUrl = Constants.PROTOCOL+env+Constants.host+lrPath+Constants.ASSISTER;
                break;
           default: throw new IllegalArgumentException("Invalid option: " + portalType);
        }
        return baseUrl;
    }

    public String getdbName(){
        return env.equals("qa") ? env + "_exch" : "exch";
    }
}
