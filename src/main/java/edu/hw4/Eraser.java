package edu.hw4;

import java.util.Arrays;

/**
 * A class that erases elements in a range.
 *
 * @param <T> the type of elements in the array
 */
public class Eraser<T extends Comparable<T>>
    implements Ranged<T, T[]> {
    /**
     * The counter to use.
     */
    private final Counter<T> counter;
    /**
     * The target element.
     */
    private final T target;

    /**
     * Create an eraser.
     *
     * @param newTarget the target element
     */
    public Eraser(final T newTarget) {
        counter = new Counter<>(newTarget);
        target = newTarget;
    }

    /**
     * Erase the target elements in the range.
     * Order of elements should be preserved.
     * Original array should not be modified.
     * Erased elements should be removed from the array.
     *
     * @param a    the array
     * @param from the start index (inclusive)
     * @param to   the end index (exclusive)
     * @return the array with the target elements erased.
     *     Size of the array should be decreased by the number.
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
        // decreased by the number of erased elements
        final T[] result = Arrays.copyOf(a, a.length - shift);
        // Erase the target elements in the range
        for (int i = from, j = from; i < to; i++) {
            // Erase the element
            if (a[i].compareTo(target) != 0) {
                result[j++] = a[i];
            }
        }

        // Copy the remaining elements that are not in the range
        System.arraycopy(a, to, result, to - shift, a.length - to);
        return result;
    }
}
