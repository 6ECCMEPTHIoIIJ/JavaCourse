package edu.hw4;

import java.util.Comparator;
import java.util.Optional;

/**
 * A class that finds the minimum element in a range.
 *
 * @param <T> the type of the elements
 */
public class Min<T extends Comparable<T>>
    implements Ranged<T, Optional<T>> {
    /**
     * The Best object to use.
     * @see Best
     */
    private final Best<T> best = new Best<T>(Comparator.reverseOrder());

    /**
     * Find the minimum element in the range.
     *
     * @param a    the array to search
     * @param from the start of the range
     * @param to   the end of the range
     * @return the minimum element in the range
     */
    @Override
    public Optional<T> inRange(final T[] a, final int from, final int to) {
        return best.inRange(a, from, to);
    }
}
