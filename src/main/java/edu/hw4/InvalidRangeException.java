package edu.hw4;

/**
 * An exception thrown when a range is invalid.
 */
public class InvalidRangeException extends IllegalArgumentException {
    /**
     * Create an InvalidRangeException.
     *
     * @param from   the start of the range
     * @param to     the end of the range
     * @param length the length of the array
     */
    public InvalidRangeException(
        final int from,
        final int to,
        final int length
    ) {
        super("Invalid range [" + from + ", " + to + ") for array of length " +
            length);
    }
}
