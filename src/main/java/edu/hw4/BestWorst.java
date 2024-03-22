package edu.hw4;

import java.util.Comparator;
import java.util.Optional;

/**
 * A class that finds the best and worst elements in a range.
 *
 * @param <T> the type of elements in the array
 */
public class BestWorst<T extends Comparable<T>>
    implements Ranged<T, Optional<BestWorstPair<T>>> {
    /**
     * The BestWorstIndex object to use.
     */
    private final BestWorstIndex<T> bestWorstIndex;

    /**
     * Constructs a BestWorst object.
     *
     * @param newCmp the Comparator to use
     * @see BestWorstIndex
     */
    public BestWorst(final Comparator<T> newCmp) {
        bestWorstIndex = new BestWorstIndex<>(newCmp);
    }

    /**
     * Returns the best and worst elements in the range.
     * Criteria for "best" and "worst" are determined by the Comparator used.
     *
     * @param a    the array to search
     * @param from the start index (inclusive)
     * @param to   the end index (exclusive)
     * @return the best and worst elements in the range
     * @see BestWorstPair
     */
    @Override
    public Optional<BestWorstPair<T>> inRange(
        final T[] a,
        final int from,
        final int to
    ) {
        final BestWorstIndexPair pair =
            bestWorstIndex.inRange(a, from, to);
        return pair.isValid() ? Optional.of(BestWorstPair.of(
            a[pair.bestIndex()],
            a[pair.worstIndex()]
        )) : Optional.empty();
    }
}
