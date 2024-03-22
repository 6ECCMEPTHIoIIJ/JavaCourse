package edu.hw4;

import java.util.Comparator;

/**
 * A class that finds the index of the best and worst elements in a range.
 *
 * @param <T> the type of the elements
 */
public class BestWorstIndex<T extends Comparable<T>>
    implements Ranged<T, BestWorstIndexPair> {
    /**
     * The Comparator to use.
     */
    private final Comparator<T> cmp;

    /**
     * Create a BestWorstIndex object.
     *
     * @param newCmp the Comparator to use
     */
    public BestWorstIndex(final Comparator<T> newCmp) {
        cmp = newCmp;
    }

    /**
     * Find the index of the best and worst elements in the range.
     * The "best" and "worst" elements are determined by the Comparator.
     *
     * @param a    the array to search
     * @param from the start of the range
     * @param to   the end of the range
     * @return the index of the best and worst elements in the range
     * @see BestWorstIndexPair
     */
    @Override
    public BestWorstIndexPair inRange(
        final T[] a,
        final int from,
        final int to
    ) {
        // Check for invalid ranges
        if (from < 0 || to > a.length || from > to) {
            throw new InvalidRangeException(from, to, a.length);
        }

        // If the range is empty, return an invalid pair
        if (from == to) {
            return BestWorstIndexPair.invalid();
        }

        // Find the index of the best and worst elements
        int bestIndex = from;
        int worstIndex = from;
        for (int i = from + 1; i < to; i++) {
            // The best element is the one with the highest value
            // The worst element is the one with the lowest value
            if (cmp.compare(a[i], a[bestIndex]) > 0) {
                bestIndex = i;
            } else if (cmp.compare(a[i], a[worstIndex]) < 0) {
                worstIndex = i;
            }
        }
        return BestWorstIndexPair.of(bestIndex, worstIndex);
    }
}
