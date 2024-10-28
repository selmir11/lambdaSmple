package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMDashboardPage {

    @FindBy(xpath = "//a[@aria-label='C4HCO CS Hub']")
    WebElement lblCRMDashHeaderText;

    @FindBy(id = "GlobalSearchBox")
    WebElement txtCRMDashSearchBox;

    @FindBy(xpath = "//div[2]/div[2]/div[2]//div[2]/div[1]/div[1]/div[1]/div[2]//button[1]/div[1]")
    WebElement btnFirstContactOption;

    private BasicActions basicActions;

    public CRMDashboardPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void CRMDashboardSearchUserEmailandOpenFirst(){
        basicActions.wait(5000);
        basicActions.waitForElementToBePresent(txtCRMDashSearchBox, 30);
        txtCRMDashSearchBox.sendKeys(SharedData.getPrimaryMember().getEmailId());

        basicActions.wait(5000);
        txtCRMDashSearchBox.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
    }
}
