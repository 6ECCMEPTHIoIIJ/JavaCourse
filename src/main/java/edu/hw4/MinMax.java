package edu.hw4;

import java.util.Comparator;
import java.util.Optional;

/**
 * A class that finds the minimum and maximum elements in a range.
 *
 * @param <T> the type of the elements
 */
public class MinMax<T extends Comparable<T>>
    implements Ranged<T, Optional<BestWorstPair<T>>> {
    /**
     * The BestWorst object to use.
     *
     * @see BestWorst
     */
    private final BestWorst<T> bestWorst =
        new BestWorst<T>(Comparator.reverseOrder());

    /**
     * Find the minimum and maximum elements in the range.
     *
     * @param a    the array to search
     * @param from the start of the range
     * @param to   the end of the range
     * @return the minimum and maximum elements in the range.
     *     If the range is empty, return an empty Optional.
     */
    @Override
    public Optional<BestWorstPair<T>> inRange(
        final T[] a,
        final int from,
        final int to
    ) {
        return bestWorst.inRange(a, from, to);
    }
}
