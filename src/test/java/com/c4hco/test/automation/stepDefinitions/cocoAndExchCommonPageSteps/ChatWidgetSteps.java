package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.ChatWidgetPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class ChatWidgetSteps {

    ChatWidgetPage chatWidgetPage = new ChatWidgetPage(WebDriverManager.getDriver());



    @Then("I validate chat widget is present")
    public void IValidateChatWidgetIsPresent()  {
        chatWidgetPage.validateChatWidgetIsPresent();
    }

    @Then("I open on chat widget")
    public void i_open_on_chat_widget() {
        chatWidgetPage.clickChatWidget();
    }

  @Then("I minimize the chat window")
    public void i_minimize_the_chat_window() {
        chatWidgetPage.minimizeChatWidget();
    }


}
