package edu.hw4;

import java.util.function.Predicate;

/**
 * A class to count the number of elements that satisfy the predicate.
 *
 * @param <T> the type of elements
 */
public class Count<T>
    implements Ranged<T, Integer> {
    /**
     * Predicate to use.
     */
    private final Predicate<T> predicate;

    /**
     * Create a counter which counts the number of elements equal to the target.
     *
     * @param newTarget the target element
     */
    public Count(final T newTarget) {
        predicate = t -> t.equals(newTarget);
    }

    /**
     * Create a counter which counts
     * the number of elements that satisfy the predicate.
     *
     * @param newPredicate the predicate to use
     */
    public Count(final Predicate<T> newPredicate) {
        predicate = newPredicate;
    }

    /**
     * Count the number of elements that satisfy the predicate in the range.
     *
     * @param a    the array
     * @param from the start index (inclusive)
     * @param to   the end index (exclusive)
     * @return the number of elements equal to the target
     */
    @Override
    public Integer inRange(final T[] a, final int from, final int to) {
        // Check for invalid ranges
        if (from < 0 || to > a.length) {
            throw new InvalidRangeException(from, to, a.length);
        }

        // Count the number of elements satisfying the predicate
        int count = 0;
        for (int i = from; i < to; i++) {
            if (predicate.test(a[i])) {
                count++;
            }
        }

        return count;
    }
}
