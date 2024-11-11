package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMDashboardPage {

    @FindBy(id = "GlobalSearchBox")
    WebElement txtCRMDashSearchBox;

    @FindBy(css = "#navigateBackButtontab-id-0 > span")
    WebElement btnGoBack;

    @FindBy(css = "#mectrl_headerPicture")
    WebElement btnHdrPic;

    @FindBy(css = "#mectrl_body_signOut")
    WebElement lnkSignOut;

    @FindBy(css = ".table-cell.tile-menu.tile-menu-float img")
    WebElement btnThreeDots;

    @FindBy(id = "forgetLink")
    WebElement btnForget;

    private BasicActions basicActions;

    public CRMDashboardPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void CRMDashboardSearchUserEmailandOpenFirst(){
        basicActions.wait(10000);
        basicActions.waitForElementToBePresentWithRetries(txtCRMDashSearchBox, 60);
        txtCRMDashSearchBox.sendKeys(SharedData.getPrimaryMember().getEmailId());
        basicActions.wait(3000);
        txtCRMDashSearchBox.sendKeys(Keys.RETURN);

    }

    public void clickGoBack(){
        basicActions.waitForElementToBePresentWithRetries(btnGoBack, 60);
        btnGoBack.click();
    }

    public void signOutOfCrm(){
        basicActions.waitForElementToBePresentWithRetries(btnHdrPic, 60);
        btnHdrPic.click();
        basicActions.waitForElementToBePresentWithRetries(lnkSignOut, 60);
        lnkSignOut.click();
        basicActions.wait(3000);
        basicActions.waitForElementToBePresentWithRetries(btnThreeDots, 60);
        btnThreeDots.click();
        basicActions.waitForElementToBePresentWithRetries(btnForget, 60);
        btnForget.click();
    }
}
