package edu.hw4;

import java.util.Comparator;

public class BellSorted<T extends Comparable<T>> implements Ranged<T, T[]> {

    private final Sorted<T> sorted;

    public BellSorted(final Comparator<T> newCmp) {
        sorted = new Sorted<>(newCmp);
    }

    /**
     * Sort the elements in the range.
     * Order is determined by the Comparator.
     * The original array is modified.
     * The minimum element is placed at the start of the range,
     * The second minimum element is placed at the end of the range,
     * The third minimum element is placed at the
     * second element of the range,
     * The fourth minimum element is placed at the
     * second last element of the range,
     * and so on.
     *
     * @param a    the array to sort
     * @param from the start of the range
     * @param to   the end of the range
     * @return the original array with the elements in the range sorted
     */
    @Override
    public T[] inRange(final T[] a, final int from, final int to) {
        // Check for invalid range
        if (from < 0 || to > a.length) {
            throw new InvalidRangeException(from, to, a.length);
        }

        sorted.inRange(a, from, to);
        for (int i = from + 1, k = 1; i < to - 1; i++, k++) {
            for (int j = i; j < to - k; j++) {
                ArrayUtils.swap(a, j, j + 1);
            }
        }

        return a;

    }
}
