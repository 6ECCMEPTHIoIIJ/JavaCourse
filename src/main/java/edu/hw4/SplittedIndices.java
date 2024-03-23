package edu.hw4;

import java.lang.reflect.Array;
import java.util.function.Predicate;

/**
 * A class that splits a range of values based on the indices.
 *
 * @param <T> the type of the elements
 */
public class SplittedIndices<T>
    implements Splitted<T> {
    /**
     * Predicate to use.
     */
    private final Predicate<Integer> predicate;

    /**
     * Create a SplittedIndices object.
     *
     * @param newPredicate the predicate to use
     */
    public SplittedIndices(final Predicate<Integer> newPredicate) {
        predicate = newPredicate;
    }

    /**
     * Split the elements in the range based on the predicate.
     * The original array is not modified.
     *
     * @param a    the array
     * @param from the start index (inclusive)
     * @param to   the end index (exclusive)
     * @return a Pair of arrays where the first array contains the elements
     *         satisfying the predicate and the second array contains the rest
     */
    @Override
    public Pair<T[], T[]> inRange(final T[] a, final int from, final int to) {
        // Check for invalid ranges
        if (from < 0 || to > a.length) {
            throw new InvalidRangeException(from, to, a.length);
        }

        // Count the number of elements satisfying the predicate
        int count = 0;
        for (int i = from; i < to; i++) {
            if (predicate.test(i)) {
                count++;
            }
        }

        // Create arrays to hold the elements
        @SuppressWarnings("unchecked") final T[] first =
            (T[]) Array.newInstance(a.getClass().getComponentType(), count);
        @SuppressWarnings("unchecked") final T[] second =
            (T[]) Array.newInstance(
                a.getClass().getComponentType(),
                to - from - count
            );

        // Split the elements
        for (int i = from, j = 0, k = 0; i < to; i++) {
            if (predicate.test(i)) {
                first[j++] = a[i];
            } else {
                second[k++] = a[i];
            }
        }

        return Pair.of(first, second);
    }
}
