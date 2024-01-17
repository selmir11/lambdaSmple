package com.c4hco.test.automation.utils;

public class EnvironmentProperties {

    private static PropertyFile propertyFile;
    public EnvironmentProperties(){
        propertyFile = new PropertyFile(ApplicationProperties.getInstance().getProperty("env"));
    }

    public String getBaseLoginUrl(){
        return propertyFile.getProperty("login_url");
    }
}
