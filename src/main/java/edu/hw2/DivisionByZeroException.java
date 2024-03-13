package edu.hw2;

/**
 * Exception thrown when division by zero is attempted.
 */
public class DivisionByZeroException extends IllegalArgumentException {
    /**
     * Constructs a new DivisionByZeroException with the default message.
     */
    public DivisionByZeroException() {
        super("Division by zero");
    }
}
