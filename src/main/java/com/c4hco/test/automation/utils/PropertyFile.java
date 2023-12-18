package com.c4hco.test.automation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PropertyFile {
    private final Properties configProp = new Properties();

    public PropertyFile(String fileName) {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(fileName + ".properties");
        try {
            configProp.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
