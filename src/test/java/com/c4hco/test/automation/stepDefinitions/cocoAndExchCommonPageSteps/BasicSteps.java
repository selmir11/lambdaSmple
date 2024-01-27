package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.utils.BasicActions;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class BasicSteps {
    BasicActions basicActions = new BasicActions();

    @And("I validate I am on the {string} page")
    public void iValidatePage(String page){
        String pageUrl= " ";
        switch(page){
            case "Login":
                System.out.println("pageUrl 4===="+pageUrl);
                pageUrl = "/login-portal/login";
                System.out.println("pageUrl 5===="+pageUrl);
                break;
            case "Account Overview":
                System.out.println("pageUrl 1===="+pageUrl);
                 pageUrl = "nes/accountOverview";
                System.out.println("pageUrl 2===="+pageUrl);

                break;
        }
        System.out.println("pageUrl 3===="+pageUrl);
        Assert.assertTrue("expected page::"+ pageUrl+"::did not load", basicActions.getUrlWithWait(pageUrl, 10).contains(pageUrl));
       // return pageUrl;
    }
}
