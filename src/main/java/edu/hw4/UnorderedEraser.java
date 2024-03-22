package edu.hw4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * A class that removes unordered elements in a range.
 *
 * @param <T> the type of the elements
 */
public class UnorderedEraser<T extends Comparable<T>>
    implements Ranged<T, T[]> {

    /**
     * The Comparator to use.
     */
    private final Comparator<T> cmp;

    /**
     * Create an UnorderedEraser object.
     *
     * @param newCmp the Comparator to use
     */
    public UnorderedEraser(final Comparator<T> newCmp) {
        cmp = newCmp;
    }

    /**
     * Remove the unordered elements in the range.
     * The original array is not modified.
     * The result is an array with the unordered elements removed.
     * The order of the remaining elements is preserved.
     *
     * @param a    the array to remove elements from
     * @param from the start of the range
     * @param to   the end of the range
     * @return the elements in the range with unordered elements removed
     */
    @Override
    public T[] inRange(final T[] a, final int from, final int to) {
        // Check for invalid range
        if (from < 0 || to > a.length) {
            throw new InvalidRangeException(from, to, a.length);
        }

        // Count the number of unordered elements
        int shift = 0;
        for (int i = from + 1; i < to; i++) {
            if (cmp.compare(a[i], a[i - 1 - shift]) < 0) {
                shift++;
            }
        }

        // Copy the array
        // size of the array is reduced by the number of unordered elements
        final T[] result = Arrays.copyOf(a, a.length - shift);
        for (int i = from + 1, j = from + 1; j < to - shift; i++) {
            // Copy the element if it is ordered
            if (cmp.compare(a[i], a[i - 1]) >= 0) {
                result[j++] = a[i];
            }
        }
        // Copy the remaining elements after the range
        System.arraycopy(a, to, result, to - shift, a.length - to);

        return result;
    }
}
