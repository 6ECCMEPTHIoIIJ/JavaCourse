package edu.hw4;

import java.util.Comparator;

/**
 * A class that finds index of the minimum and maximum elements in a range.
 *
 * @param <T> the type of the elements
 */
public class MinMaxIndex<T extends Comparable<T>>
    implements Ranged<T, BestWorstIndexPair> {
    /**
     * The BestWorstIndex object to use.
     *
     * @see BestWorstIndex
     */
    private final BestWorstIndex<T> bestWorstIndex =
        new BestWorstIndex<T>(Comparator.reverseOrder());

    /**
     * Find the index of the minimum and maximum elements in the range.
     *
     * @param a    the array to search
     * @param from the start of the range
     * @param to   the end of the range
     * @return the index of the minimum and maximum elements in the range.
     *     If the range is empty, return an empty Optional.
     */
    @Override
    public BestWorstIndexPair inRange(
        final T[] a,
        final int from,
        final int to
    ) {
        return bestWorstIndex.inRange(a, from, to);
    }
}
