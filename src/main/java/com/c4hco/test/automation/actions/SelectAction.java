package com.c4hco.test.automation.actions;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.openqa.selenium.WebElement;

/**
 * Click implementation for selectable actions.
 * This is separated to be able to verify against selection status of the element.
 */
@Getter
@Setter
@SuperBuilder
public class SelectAction extends ClickAction {
    @Builder.Default
    private boolean targetSelectedStatus = true;

    /**
     * Attempts to run a click action on an element, verifying against the selection status of the element.
     * If the element is already selected and {@link SelectAction#targetSelectedStatus} is true, method will not run and return True
     *
     * @return True if element selection status matches the target selection status, see {@link ClickAction#run()} for other info
     */
    @Override
    public boolean run() {
        if(getElement().isSelected() == targetSelectedStatus){
            return true;
        }
        return super.run() && getElement().isSelected() == targetSelectedStatus;
    }

    /**
     * see {@link SelectAction#select(WebElement, boolean)} with a target status of true
     */
    public static boolean select(WebElement element){
        return select(element, true);
    }

    /**
     * Calls select on a given element
     * @param element web element to select
     * @param targetStatus true/false value for the target selection status of the element
     * @return see {@link SelectAction#run()} with given target selected status
     */
    public static boolean select(WebElement element, boolean targetStatus){
        return SelectAction.builder().targetSelectedStatus(targetStatus).element(element).build().run();
    }
}
