package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.dbUtils.PostgresStatementExecutor;
import com.c4hco.test.automation.utils.ApplicationProperties;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.Utils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class AdminPage {
    CreateAccountPage createAccountPage = new CreateAccountPage();
    private BasicActions basicActions;
    private Utils utils = new Utils();
    private PostgresStatementExecutor executor = new PostgresStatementExecutor();
    private String env = ApplicationProperties.getInstance().getProperty("env");
    public AdminPage(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void closeBrowser(){
        basicActions.getDriver().close();
    }

    @FindBy(xpath = "//div[@class='form-btn-group big-screen']//button[@id='create-individual-account']")
    public WebElement createAccountAdmin;

    @FindBy(xpath = "//body//app-root//span[3]")
    public WebElement dropdownArrow;

    @FindBy(xpath = "//div[@id='logout-link']")
    public WebElement logoutAdmin;


    public void validateAdminPage(){
        Assert.assertTrue("url doesn't have preScreen", basicActions.getCurrentUrl().contains("AdminPortal"));
    }

    public void navigateToPreviousPage(){
        basicActions.getDriver().navigate().back();
    }


    public void clickCreateAccount(){
     createAccountPage.waitForVisibility(createAccountAdmin, Duration.ofSeconds(1000));
     createAccountAdmin.click();
    }
}
