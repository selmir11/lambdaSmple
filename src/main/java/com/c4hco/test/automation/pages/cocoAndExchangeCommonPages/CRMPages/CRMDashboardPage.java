package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMDashboardPage {

    @FindBy(xpath = "//a[@aria-label='C4HCO CS Hub']")
    WebElement lblCRMDashHeaderText;

    @FindBy(id = "GlobalSearchBox")
    WebElement txtCRMDashSearchBox;

    private BasicActions basicActions;

    public CRMDashboardPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void CRMDashboardSearchUserEmailandOpenFirst(){
        basicActions.wait(10000);

        basicActions.waitForElementToBePresentWithRetries(txtCRMDashSearchBox, 30);
        txtCRMDashSearchBox.sendKeys(SharedData.getPrimaryMember().getEmailId(), Keys.RETURN);
    }
}
