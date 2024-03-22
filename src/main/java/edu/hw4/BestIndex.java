package edu.hw4;

import java.util.Comparator;

/**
 * A class that finds the index of the best element in a range.
 *
 * @param <T> the type of the elements
 */
public class BestIndex<T extends Comparable<T>>
    implements Ranged<T, Integer> {
    /**
     * The Comparator to use.
     */
    private final Comparator<T> cmp;

    /**
     * Create a BestIndex object.
     *
     * @param newCmp the Comparator to use
     */
    public BestIndex(final Comparator<T> newCmp) {
        cmp = newCmp;
    }

    /**
     * Find the index of the best element in the range.
     * The "best" element is determined by the Comparator.
     *
     * @param a    the array to search
     * @param from the start of the range
     * @param to   the end of the range
     * @return the index of the best element in the range
     */
    @Override
    public Integer inRange(final T[] a, final int from, final int to) {
        // Check for invalid ranges
        if (from < 0 || to > a.length || from > to) {
            throw new InvalidRangeException(from, to, a.length);
        }

        // If the range is empty, return -1
        if (from == to) {
            return -1;
        }

        // Find the index of the best element
        int bestIndex = from;
        for (int i = from + 1; i < to; i++) {
            // The best element is the one with the highest value
            if (cmp.compare(a[i], a[bestIndex]) > 0) {
                bestIndex = i;
            }
        }
        return bestIndex;
    }
}
