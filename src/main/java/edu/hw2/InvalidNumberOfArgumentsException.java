package edu.hw2;

/**
 * Exception thrown when the number of arguments is invalid.
 */
public class InvalidNumberOfArgumentsException
    extends IllegalArgumentException {
    /**
     * Constructs a new InvalidNumberOfArgumentsException
     * with the default message.
     *
     * @param expected the expected number of arguments
     * @param actual   the actual number of arguments
     */
    public InvalidNumberOfArgumentsException(
        final int expected,
        final int actual
    ) {
        super(("Invalid number of arguments. "
                + "Expected %d, but got %d"
            ).formatted(expected, actual)
        );
    }
}
