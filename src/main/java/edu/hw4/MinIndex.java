package edu.hw4;

import java.util.Comparator;

/**
 * A class that finds index of the minimum element in a range.
 *
 * @param <T> the type of the elements
 */
public class MinIndex<T extends Comparable<T>>
    implements Ranged<T, Integer> {
    /**
     * The BestIndex object to use.
     *
     * @see BestIndex
     */
    private final BestIndex<T> bestIndex =
        new BestIndex<T>(Comparator.reverseOrder());

    /**
     * Find the index of the minimum element in the range.
     *
     * @param a    the array to search
     * @param from the start of the range
     * @param to   the end of the range
     * @return the index of the minimum element in the range
     */
    @Override
    public Integer inRange(final T[] a, final int from, final int to) {
        return bestIndex.inRange(a, from, to);
    }
}
