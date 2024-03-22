package edu.hw4;

import java.util.Comparator;

/**
 * A class that sorts the elements in a range by creating an array of indices.
 *
 * @param <T> the type of the elements
 */
public class SortedIndexed<T extends Comparable<T>>
    implements Ranged<T, int[]> {
    /**
     * The Comparator to use.
     */
    private final Comparator<T> cmp;

    /**
     * Create a SortedIndexed object.
     *
     * @param newCmp the Comparator to use
     */
    public SortedIndexed(final Comparator<T> newCmp) {
        cmp = newCmp;
    }

    /**
     * Sort the elements in the range.
     * Order is determined by the Comparator.
     * The original array is not modified.
     * The result is an array of indices that
     * can be used to access the sorted elements.
     *
     * @param a    the array to sort
     * @param from the start of the range
     * @param to   the end of the range
     * @return the sorted elements in the range
     */
    @Override
    public int[] inRange(final T[] a, final int from, final int to) {
        // Check for invalid range
        if (from < 0 || to > a.length) {
            throw new InvalidRangeException(from, to, a.length);
        }

        // Allocate space for the array of indices
        final int[] result = new int[a.length];
        // Array of booleans to keep track of already sorted elements
        final boolean[] used = new boolean[to - from];
        // Sort the elements in the range
        for (int i = from; i < to; i++) {
            // Find first unused element
            int bestIndex = from;
            while (used[bestIndex]) {
                bestIndex++;
            }
            // Find the best element
            for (int j = from; j < to; j++) {
                // The best element is the one with the lowest unused value
                if (!used[j] && cmp.compare(a[j], a[bestIndex]) < 0) {
                    bestIndex = j;
                }
            }
            // Mark the best element as used
            used[bestIndex] = true;
            // Save the index of the best element
            result[i] = bestIndex;
        }

        return result;
    }
}
