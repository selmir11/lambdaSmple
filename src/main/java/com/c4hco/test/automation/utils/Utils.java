package com.c4hco.test.automation.utils;

public class Utils {
    private String env = ApplicationProperties.getInstance().getProperty("env");

    public Utils(){
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
