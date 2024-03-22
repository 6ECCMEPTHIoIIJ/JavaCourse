package edu.hw4;

/**
 * A class to count the number of elements equal to a target element in a range.
 *
 * @param <T> the type of elements
 */
public class Counter<T extends Comparable<T>>
    implements Ranged<T, Integer> {
    /**
     * The target element.
     */
    private final T target;

    /**
     * Create a counter.
     *
     * @param newTarget the target element
     */
    public Counter(final T newTarget) {
        target = newTarget;
    }

    /**
     * Count the number of elements equal to the target in the range.
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

        // Count the number of elements equal to the target
        int count = 0;
        for (int i = from; i < to; i++) {
            if (a[i].compareTo(target) == 0) {
                count++;
            }
        }

        return count;
    }
}
