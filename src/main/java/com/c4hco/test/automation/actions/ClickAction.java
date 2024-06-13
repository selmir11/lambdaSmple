package com.c4hco.test.automation.actions;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

/**
 * Action implementation for clicks.
 * Fields available to disable certain waits.
 * Requires an element to be passed in.
 * Any fields not passed in to the builder are defaulted to their default values in the class.
 *
 * Example usages:
 * ClickAction.builder()
 * .waitForPresent(false)
 * .waitForClickable(false)
 * .scrollTo(false)
 * .element(WebDriverManager.getDriver().findElement(By.id(id)))
 * .attempts(3)
 * .build().run();
 */
@Getter
@Setter
@SuperBuilder
public class ClickAction extends AbstractAction{
    /**
     * Boolean value on whether to use a {@link WaitAction} to do waitForPresent checks
     * Timeout is set to 10 seconds.
     * It will also use the {@link AbstractAction#attempts} field for this wait
     */
    @Builder.Default
    private boolean waitForPresent = true;
    /**
     * Boolean value for whether to use a {@link WaitAction} to do waitForClickable checks
     * Timeout is set to 5 seconds.
     * It will also use the {@link AbstractAction#attempts} field for this wait
     */
    @Builder.Default
    private boolean waitForClickable = true;
    /**
     * Boolean value for whether to run a {@link ScrollAction} to scroll to the element
     * It will also use the {@link AbstractAction#attempts} field for this scroll
     */
    @Builder.Default
    private boolean scrollTo = true;
    /**
     * WebElement to click
     */
    @NonNull
    private WebElement element;

    /**
     * Runs a click action based on the fields given.
     * @return True if it clicks successfully. False if it fails to scroll/wait. Throws {@link RuntimeException} if it fails to click after scrolling/waiting
     */
    @Override
    public boolean run() {
        //grab static instance of BasicActions
        BasicActions actions = BasicActions.getInstance();
        Exception thrown = null;
        if(scrollTo) {
            //attempt to scroll to element. If it fails, return false.
            if(!ScrollAction.builder().element(element).attempts(attempts).build().run()){
                return false;
            }
        }
        if(waitForPresent) {
            //attempt to wait for the element to be present. Throws an exception if this fails.
            if(!WaitAction.builder()
                    .attempts(attempts)
                    .present(waitForPresent)
                    .element(element)
                    .milliseconds(10_000)
                    .build().run()){
                throw new RuntimeException("Failed to wait for element to be present");
            }
        }
        if(waitForClickable) {
            //wait for the element to be clickable.
            //no exception here, some elements that are 'clickable' are not being determined as
            //clickable by selenium. This is an attempt but has no impact if failed.
            WaitAction.builder()
                    .attempts(attempts)
                    .clickable(waitForClickable)
                    .element(element)
                    .milliseconds(5_000)
                    .build().run();
        }
        //attempt to click the element
        for(int i = 0; i < attempts; i++) {
            try {
                Wait<WebDriver> wait = new FluentWait<>(actions.getDriver())
                        .withTimeout(Duration.ofSeconds(5))
                        .pollingEvery(Duration.ofMillis(100))
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.visibilityOf(element));
                element.click();
                return true;
            }catch(Exception e){
                //on exception being thrown, wait for 1 second and if available, retry.
                actions.wait(1000);
                thrown = e;
            }
        }
        //if it fails to click the element, throw an exception (existing behavior)
        throw new RuntimeException(thrown);
    }

    /* HELPER METHODS */

    /**
     * Builds a {@link ClickAction} for the given web element.
     * @param element element to click. Must not be null.
     * @return See {@link ClickAction#run()}
     */
    public static boolean click(WebElement element){
        return ClickAction.builder().element(element).build().run();
    }

    /**
     * Repeatedly calls {@link ClickAction#click(WebElement)} for each of the given elements.
     * @param elements Elements to click, in order.
     * @return True if all element clicks succeed, else false.
     */
    public static boolean click(WebElement...elements){
        for(WebElement element : elements){
            if(!click(element)){
                return false;
            }
        }
        return true;
    }

    /**
     * Finds a web element based on an ID given and calls {@link ClickAction#click(WebElement)} with it
     * @param id ID of the element to click
     * @return see {@link ClickAction#click(WebElement)}
     */
    public static boolean clickById(String id){
        return click(WebDriverManager.getDriver().findElement(By.id(id)));
    }

    /**
     * Finds a web element based on an xpath given and calls {@link ClickAction#click(WebElement)} with it.
     * @param xpath XPath of the element to click
     * @return see {@link ClickAction#click(WebElement)}
     */
    public static boolean clickByXpath(String xpath){
        return click(WebDriverManager.getDriver().findElement(By.xpath(xpath)));
    }
}
