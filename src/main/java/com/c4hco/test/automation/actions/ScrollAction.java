package com.c4hco.test.automation.actions;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * Action implementation for scrolling to an element.
 * Executes javascript to scroll to an element
 * Example usage, see {@link ScrollAction#scrollToElement(WebElement, int)}
 * Default attempts count is 1, see {@link AbstractAction#attempts}
 *
 */
@Getter
@Setter
@SuperBuilder
public class ScrollAction extends AbstractAction {
    /**
     * Web element to scroll to
     */
    private WebElement element;

    /**
     * Attempts to scroll to the given element using javascript
     * @return True if javascript runs successfully, throws {@link RuntimeException} if all attempts fail.
     */
    @Override
    public boolean run() {
        Exception thrown = null;
        for(int i = 0; i < attempts; i++){
            try{
                ((JavascriptExecutor) WebDriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
                return true;
            }catch(Exception e){
                thrown = e;
                BasicActions.getInstance().wait(1000);
            }
        }
        throw new RuntimeException(thrown);
    }

    /**
     * See {@link ScrollAction#scrollToElement(WebElement, int)} with an attempt count of 1
     */
    public static boolean scrollToElement(WebElement element){
        return scrollToElement(element, 1);
    }

    /**
     * Scrolls to a given element, on failure it will run as many times as attempts is given.
     * @param element web element to scroll to
     * @param attempts number of attempts to scroll before failure
     * @return See {@link ScrollAction#run()}
     */
    public static boolean scrollToElement(WebElement element, int attempts){
        return ScrollAction.builder().element(element).attempts(attempts).build().run();
    }
}
