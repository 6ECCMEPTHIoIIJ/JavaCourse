package edu.hw2;

/**
 * Exception thrown when no system expression`s condition is valid.
 */
public class NoValidExpressionConditionException
    extends IllegalStateException {
    /**
     * Constructs a new NoValidExpressionConditionException
     * with the default message.
     */
    public NoValidExpressionConditionException() {
        super("No system expression`s condition is valid");
    }
}
