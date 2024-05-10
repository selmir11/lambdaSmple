package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class AddInfoForAdditionalMemberCoCoPage {

    private BasicActions basicActions;

    public AddInfoForAdditionalMemberCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
}
