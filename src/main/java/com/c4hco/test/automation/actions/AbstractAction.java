package com.c4hco.test.automation.actions;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Represents an abstract action, contains an attempts count field as a base for all actions
 */
@Getter
@Setter
@SuperBuilder
public abstract class AbstractAction {
    /**
     * Number of attempts it will do on the action. If you want it to retry on failures, increase this value
     * Default is 1
     */
    @Builder.Default
    protected int attempts = 1;

    /**
     * Abstract method to implement for running an action
     * @return true if the action succeeded, else false
     */
    public abstract boolean run();
}
