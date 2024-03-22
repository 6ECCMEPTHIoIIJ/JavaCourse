package edu.hw4;

import java.util.Comparator;
import java.util.Optional;

/**
 * A class that finds the best element in a range.
 * The "best" element is determined by a Comparator.
 *
 * @param <T> the type of elements in the array
 */
public class Best<T extends Comparable<T>>
    implements Ranged<T, Optional<T>> {

    /**
     * The BestIndex object used to find the best element.
     */
    private final BestIndex<T> bestIndex;

    /**
     * Constructs a Best object with the given Comparator.
     *
     * @param newCmp the Comparator to use
     * @see BestIndex
     */
    public Best(final Comparator<T> newCmp) {
        bestIndex = new BestIndex<>(newCmp);
    }

    /**
     * Returns the best element in the given range.
     * Criteria for "best" is determined by the Comparator used to.
     *
     * @param a    the array
     * @param from the start index (inclusive)
     * @param to   the end index (exclusive)
     * @return the best element in the given range.
     *     If the range is empty, returns an empty Optional.
     */
    @Override
    public Optional<T> inRange(final T[] a, final int from, final int to) {
        final int bestIndex = this.bestIndex.inRange(a, from, to);
        return bestIndex == -1 ? Optional.empty() :
            Optional.of(a[bestIndex]);
    }
}
