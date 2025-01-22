package com.c4hco.test.automation.pages.cocoPages;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class AdminPortalCocoUserDashboardPage {

    public BasicActions basicActions;

    public AdminPortalCocoUserDashboardPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(xpath = "//*[contains(text(),'Manage')]")
    List<WebElement> dashboardButtons;

    @FindBy(css = ".container-fluid .reports-container .link-section span:nth-child(1)")
    List<WebElement> reportViewButtons;

    public void clickFromDashboardButtons(String DashboardButtons) {
        basicActions.waitForElementListToBePresent(dashboardButtons, 10);
        dashboardButtons.stream().filter(dashboardButtons -> dashboardButtons.getText().equals(DashboardButtons)).findFirst().ifPresent(WebElement::click);
        basicActions.switchtoactiveTab();
    }

    public void viewReportLinks(String searchText) {
        basicActions.waitForElementListToBePresent(reportViewButtons, 20);
        WebElement viewButton = basicActions.getDriver().findElement(By.xpath("//span[contains(normalize-space(), '" + searchText + "')]//following::span[1]"));
        viewButton.click();
        basicActions.switchtoactiveTab();
    }
}






