package com.c4hco.test.automation.utils;

public class Utils {

    public Utils(){
    }

    public String getBaseLoginUrl(String env){
        String baseUrl = "";
        switch(env){
            case "qa-login":
                baseUrl = Constants.QA_LOGIN;
                break;

            case "qa-broker":
                baseUrl = Constants.QA_BROKER;
                break;

            case "qa-admin":
                baseUrl = Constants.QA_ADMIN;
                break;

            case "staging-login":
                baseUrl = Constants.STAGING_LOGIN;
                break;

            case "staging-broker":
                baseUrl = Constants.STAGING_BROKER;
                break;

            case "staging-admin":
                baseUrl = Constants.STAGING_ADMIN;
                break;
        }
        return baseUrl;
    }
}
