package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.ApplicationProperties;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class CRMDashboardPage {

    @FindBy(id = "GlobalSearchBox")
    WebElement txtCRMDashSearchBox;

    private BasicActions basicActions;

    public CRMDashboardPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void CRMDashboardSearchUserEmailandOpenFirst(){
        basicActions.wait(5000);
        basicActions.waitForElementToBePresentWithRetries(txtCRMDashSearchBox, 60);
        txtCRMDashSearchBox.sendKeys(SharedData.getPrimaryMember().getEmailId());
        basicActions.wait(1000);
        txtCRMDashSearchBox.sendKeys(Keys.RETURN);

    }
}
