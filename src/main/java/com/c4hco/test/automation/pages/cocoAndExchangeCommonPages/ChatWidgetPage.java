package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class ChatWidgetPage {

    private BasicActions basicActions;
    public ChatWidgetPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    @FindBy(id = "oc-lcw-chat-button-title")
    WebElement ChatWidgetTitle;
    @FindBy(tagName = "iframe")
    WebElement ChatWidgetIframe;
    @FindBy(id = "oc-lcw-chat-button-subtitle")
    WebElement ChatWidgetSubtitle;
    @FindBy(id= "lcw-header-minimize-button")
    WebElement minimizeChatWindow;

    public void validateChatWidgetIsPresent()  {
        basicActions.getDriver().switchTo().frame(ChatWidgetIframe);
        basicActions.waitForElementToBePresent(ChatWidgetTitle,20);
        Assert.assertEquals("Let's chat",ChatWidgetTitle.getText());
        basicActions.waitForElementToBePresent(ChatWidgetSubtitle,20);
        Assert.assertEquals("We're Online",ChatWidgetSubtitle.getText());
    }
    public void clickChatWidget(){
        basicActions.waitForElementToBePresent(ChatWidgetTitle,20);
        ChatWidgetTitle.click();
    }
    public void minimizeChatWidget(){
        basicActions.waitForElementToBePresent(minimizeChatWindow,20);
        minimizeChatWindow.click();
    }






}
