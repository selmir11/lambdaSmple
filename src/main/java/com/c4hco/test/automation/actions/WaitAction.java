package com.c4hco.test.automation.actions;

import com.c4hco.test.automation.utils.Log;
import com.c4hco.test.automation.utils.WebDriverManager;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Action implementation for waiting
 * Used for various wait methods, like waiting for an element to be present, clickable, or to disappear
 * If no element is given, it will just do a hard wait for the given ms
 *
 * On failures, it will attempt up to {@link AbstractAction#attempts} times.
 */
@Getter
@Setter
@SuperBuilder
public class WaitAction extends AbstractAction {
    /**
     * Boolean value for whether this action should wait for an element to be present
     * REQUIRES A NON-NULL ELEMENT
     */
    @Builder.Default
    private boolean present = false;
    /**
     * Boolean value for whether this action should wait for an element to be clickable
     * REQUIRES A NON-NULL ELEMENT
     */
    @Builder.Default
    private boolean clickable = false;
    /**
     * Boolean value for whether this action should wait for an element to disappear
     * REQUIRES A NON-NULL ELEMENT
     */
    @Builder.Default
    private boolean disappear = false;
    /**
     * Milliseconds to sleep for
     */
    private int milliseconds;
    /**
     * Target element for the wait. If target element is null, this action will just do a hard wait for the given milliseconds
     */
    private WebElement element;

    /**
     * Waits for the element status to match the given checks.
     * Will check each status added in a present->clickable->disappear order.
     * If the target element is null, it will do a hard sleep for the given milliseconds
     * @return True if all waits succeed, false if any fail
     */
    @Override
    public boolean run() {
        if (present) {
            if (!waitForElementToBePresent()) {
                return false;
            }
        }
        if (clickable) {
            if (!waitForElementToBeClickable()) {
                return false;
            }
        }
        if(disappear){
            if(!waitForElementToDisappear()){
                return false;
            }
        }
        if (element == null) {
            try {
                Thread.sleep(milliseconds);
            } catch (InterruptedException e) {
                return false;
            }
        }
        return true;
    }

    /**
     * Waits for an element to be present with a given number of attempts
     * @return True if element becomes present within the given time and attempts, else False.
     */
    private boolean waitForElementToBePresent() {
        for (int i = 0; i < attempts; i++) {
            try {
                new WebDriverWait(WebDriverManager.getDriver(), Duration.ofMillis(milliseconds)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.visibilityOf(element));
                return true;
            } catch (TimeoutException ignore) {
            }
        }
        Log.info("Element is not present");
        return false;
    }

    /**
     * Waits for an element to be clickable with a given number of attempts
     * @return True if element becomes clickable within the given time and attempts, else False
     */
    private boolean waitForElementToBeClickable() {
        for (int i = 0; i < attempts; i++) {
            try {
                new WebDriverWait(WebDriverManager.getDriver(), Duration.ofMillis(milliseconds)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.elementToBeClickable(element));
                return true;
            } catch (TimeoutException ignore) {
            }
        }
        Log.info("Element is not clickable");
        return false;
    }

    /**
     * Waits for an element to disappear with a given number of attempts
     * @return True if element disappears within the given time and attempts, else False
     */
    private boolean waitForElementToDisappear() {
        for(int i = 0; i < attempts; i++) {
            try {
                new WebDriverWait(WebDriverManager.getDriver(),
                        Duration.ofSeconds(milliseconds)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.invisibilityOf(element));
                return true;
            } catch (TimeoutException ignore) {
                Log.info("Element is still visible after the wait");
            }
        }
        return false;
    }

    /**
     * Wait for a given element to be present. Defaults to a single attempt.
     *
     * @param element Element to check present status
     * @param seconds number of seconds to wait
     * @return see {@link WaitAction#run()}
     */
    public static boolean waitForPresent(WebElement element, int seconds) {
        return WaitAction.builder().element(element).milliseconds(seconds * 1000).present(true).build().run();
    }

    /**
     * Wait for a given element to be clickable. Defaults to a single attempt.
     *
     * @param element Element to check clickable status
     * @param seconds number of seconds to wait
     * @return see {@link WaitAction#run()}
     */
    public static boolean waitForClickable(WebElement element, int seconds) {
        return WaitAction.builder().element(element).milliseconds(seconds * 1000).clickable(true).build().run();
    }

    /**
     * Wait for a given element to disappear. Defaults to a single attempt.
     *
     * @param element Element to check status
     * @param seconds number of seconds to wait
     * @return see {@link WaitAction#run()}
     */
    public static boolean waitForDisappear(WebElement element, int seconds) {
        return WaitAction.builder().element(element).milliseconds(seconds * 1000).disappear(true).build().run();
    }

    /**
     * Waits for a given number of milliseconds. This is just a hard sleep with no conditions.
     *
     * @param milliseconds milliseconds to sleep for
     * @return see {@link WaitAction#run()}
     */
    public static boolean wait(int milliseconds){
        return WaitAction.builder().milliseconds(milliseconds).build().run();
    }
}
