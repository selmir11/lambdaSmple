package com.c4hco.test.automation.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.Set;

public class ApplicationProperties {

    private final Properties configProp = new Properties();
    URL url = this.getClass().getClassLoader().getResource("application.properties");
    String path = url.getPath();

    //Private constructor to restrict new instances
    private ApplicationProperties() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("application.properties");
        try {
            configProp.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ApplicationProperties getInstance() {
        return LazyHolder.INSTANCE;
    }

    public String getProperty(String key) {
        return configProp.getProperty(key);
    }

    public Set<String> getAllPropertyNames() {
        return configProp.stringPropertyNames();
    }

    public boolean containsKey(String key) {
        return configProp.containsKey(key);
    }

    public void setProperty(String key, String value) {
        configProp.setProperty(key, value);
    }

    public void updateValue(String key, String value) {
        try {
            setProperty(key, value);
            saveProperties(configProp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveProperties(Properties configProp) throws IOException {
        FileOutputStream fileReader = new FileOutputStream(new File(path));
        configProp.store(fileReader, null);
        fileReader.close();
//        System.out.println("After saving properties:" + configProp);
    }

    public void clear() {
        configProp.clear();
    }

    //Bill Pugh Solution for singleton pattern
    private static class LazyHolder {
        private static final ApplicationProperties INSTANCE = new ApplicationProperties();
    }
}