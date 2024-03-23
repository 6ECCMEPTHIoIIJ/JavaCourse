package edu.hw4;

import java.lang.reflect.Array;

/**
 * A class that reverses the elements in a range.
 *
 * @param <T> the type of the elements
 */
public class Reversed<T> implements Ranged<T, T[]> {
    /**
     * Reverse the elements in the range.
     * The original array is modified.
     *
     * @param a    the array to reverse
     * @param from the start of the range
     * @param to   the end of the range
     * @return the original array with the elements in the range reversed
     */
    @Override
    public T[] inRange(final T[] a, final int from, final int to) {
        // Check for invalid range
        if (from < 0 || to > a.length) {
            throw new InvalidRangeException(from, to, a.length);
        }

        // Reverse the elements in the range
        for (int i = from, j = to - 1; i < j; i++, j--) {
            // Swap the elements at i and a.length - 1 - i
            ArrayUtils.swap(a, i, j);
        }

        return a;
    }
}
