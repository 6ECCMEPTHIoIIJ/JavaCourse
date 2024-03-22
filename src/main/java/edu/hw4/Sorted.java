package edu.hw4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * A class that sorts the elements in a range.
 *
 * @param <T> the type of the elements
 */
public class Sorted<T extends Comparable<T>>
    implements Ranged<T, T[]> {

    /**
     * The Comparator to use.
     */
    private final Comparator<T> cmp;

    /**
     * Create a Sorted object.
     *
     * @param newCmp the Comparator to use
     */
    public Sorted(final Comparator<T> newCmp) {
        cmp = newCmp;
    }

    /**
     * Sort the elements in the range.
     * Order is determined by the Comparator.
     * The original array is not modified.
     *
     * @param a    the array to sort
     * @param from the start of the range
     * @param to   the end of the range
     * @return the sorted elements in the range
     */
    @Override
    public T[] inRange(final T[] a, final int from, final int to) {
        // Check for invalid range
        if (from < 0 || to > a.length) {
            throw new InvalidRangeException(from, to, a.length);
        }

        // Copy the array
        final T[] result = Arrays.copyOf(a, a.length);
        // Sort the elements in the range
        Arrays.sort(result, from, to, cmp);

        return result;
    }
}
