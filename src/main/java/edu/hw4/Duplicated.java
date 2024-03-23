package edu.hw4;

import java.lang.reflect.Array;

/**
 * A duplicator of elements.
 *
 * @param <T> the type of elements
 */
public class Duplicated<T extends Comparable<T>>
    implements Ranged<T, T[]> {
    /**
     * The Counter object used to count the target elements.
     */
    private final Count<T> count;
    /**
     * The target element.
     */
    private final T target;

    /**
     * Create a duplicator.
     *
     * @param newTarget the target element
     */
    public Duplicated(final T newTarget) {
        count = new Count<>(newTarget);
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
        final int shift = count.inRange(a, from, to);
        // Allocate space for the new array with the duplicated elements
        @SuppressWarnings("unchecked") final T[] result =
            (T[]) Array.newInstance(
                a.getClass().getComponentType(),
                a.length + shift
            );

        // Copy the elements before the range
        System.arraycopy(a, 0, result, 0, from);
        // Duplicate the target elements in the range
        for (int i = from, j = from; i < to; i++) {
            // Copy the element
            result[j++] = a[i];
            if (a[i].compareTo(target) == 0) {
                result[j++] = a[i];
            }
        }

        // Copy the remaining elements after the range
        System.arraycopy(a, to, result, to + shift, a.length - to);
        return result;
    }
}
