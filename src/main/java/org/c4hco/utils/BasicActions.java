package org.c4hco.utils;


import org.openqa.selenium.WebDriver;

import org.c4hco.selenium.Selenese;

public class BasicActions {
    private WebDriver driver;
    private Selenese selenese = Selenese.getInstance();


    public BasicActions(){
        this.driver = selenese.getDriver();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public static BasicActions getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder{
        private static final BasicActions INSTANCE = new BasicActions();
    }

    public void closeBrowser(){
        if(this.driver!= null){
            this.driver.quit();
        }
    }
}
