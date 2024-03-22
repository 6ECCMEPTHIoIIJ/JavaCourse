package edu.hw4;

import java.util.Arrays;

/**
 * A duplicator of elements.
 *
 * @param <T> the type of elements
 */
public class Duplicator<T extends Comparable<T>>
    implements Ranged<T, T[]> {
    /**
     * The Counter object used to count the target elements.
     */
    private final Counter<T> counter;
    /**
     * The target element.
     */
    private final T target;

    /**
     * Create a duplicator.
     *
     * @param newTarget the target element
     */
    public Duplicator(final T newTarget) {
        counter = new Counter<>(newTarget);
        target = newTarget;
    }

    /**
     * Duplicate the target elements in the range.
     * Order of elements should be preserved.
     * Original array should not be modified.
     * Duplicated elements should be placed right after the original element.
     *
     * @param a    the array
     * @param from the start index (inclusive)
     * @param to   the end index (exclusive)
     * @return the array with the target elements duplicated.
     *     Size of the array should be increased by the number
     *     of target elements in the range.
     */
    @Override
    public T[] inRange(final T[] a, final int from, final int to) {
        // Check for invalid ranges
        if (from < 0 || to > a.length) {
            throw new InvalidRangeException(from, to, a.length);
        }

        // Count the number of target elements in the range
        final int shift = counter.inRange(a, from, to);
        // Copy the array with the new size
        // increased by the number of duplicated elements
        final T[] result = Arrays.copyOf(a, a.length + shift);
        // Duplicate the target elements in the range
        for (int i = from, j = from; i < to; i++) {
            // Copy the element
            result[j++] = a[i];
            if (a[i].compareTo(target) == 0) {
                result[j++] = a[i];
            }
        }

        // Copy the remaining elements that are not in the range
        System.arraycopy(a, to, result, to + shift, a.length - to);
        return result;
    }
}
