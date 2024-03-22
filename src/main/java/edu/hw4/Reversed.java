package edu.hw4;

import java.util.Arrays;

/**
 * A class that reverses the elements in a range.
 *
 * @param <T> the type of the elements
 */
public class Reversed<T> implements Ranged<T, T[]> {
    /**
     * Reverse the elements in the range.
     * The original array is not modified.
     *
     * @param a    the array to reverse
     * @param from the start of the range
     * @param to   the end of the range
     * @return the array with the elements in the range reversed
     */
    @Override
    public T[] inRange(final T[] a, final int from, final int to) {
        // Check for invalid range
        if (from < 0 || to > a.length) {
            throw new InvalidRangeException(from, to, a.length);
        }

        // Copy the array
        final T[] result = Arrays.copyOf(a, a.length);
        // Reverse the elements in the range
        for (int i = from, j = to - 1; i < j; i++, j--) {
            // Swap the elements at i and a.length - 1 - i
            ArrayUtils.swap(result, i, j);
        }

        return result;
    }
}
