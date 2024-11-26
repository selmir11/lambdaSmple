package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CRMSearchResultsPage {

    @FindBy(xpath = "//h1[@title='Search results']")
    WebElement lblSearchHeader;

    @FindBy(id = "GlobalSearchBox")
    WebElement txtCRMDashSearchBox;

    private BasicActions basicActions;

    public CRMSearchResultsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void openResultByName(){
        WebElement linkOpenContact = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'"+ SharedData.getPrimaryMember().getFirstName()+" "+SharedData.getPrimaryMember().getLastName()+"')]"));
        linkOpenContact.click();
    }

    public void handleSearchResultsPage() {
        // This function handles the Search Results page when searching from the dashboard page.
        int retryCount = 100;
        int waitTime = 2;

        WebDriver driver = basicActions.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));

        By contactLinkLocator = By.xpath("//div[contains(text(),'"+ SharedData.getPrimaryMember().getFirstName()+" "+ SharedData.getPrimaryMember().getLastName()+"')]");

        for (int i = 0; i < retryCount; i++) {
            try {
                WebElement linkOpenContact = wait.until(ExpectedConditions.visibilityOfElementLocated(contactLinkLocator));
                if (linkOpenContact.isDisplayed()) {
                    openResultByName();
                    return;
                }
            } catch (Exception e) {
                System.out.println("Retry " + (i + 1) + " failed, attempting search again for "+contactLinkLocator);
                txtCRMDashSearchBox.click();
                txtCRMDashSearchBox.sendKeys(Keys.RETURN);
            }
        }
        System.err.println("Failed to find contact link after " + retryCount + " attempts.");
        throw new RuntimeException("Contact link not found after maximum retries.");
    }

}
