package edu.hw4;

import java.lang.reflect.Array;
import java.util.function.Predicate;

public class SplittedValues<T>
    implements Splitted<T> {
    private final Count<T> count;
    private final Predicate<T> predicate;

    public SplittedValues(final Predicate<T> newPredicate) {
        count = new Count<>(newPredicate);
        predicate = newPredicate;
    }

    @Override
    public Pair<T[], T[]> inRange(final T[] a, final int from, final int to) {
        // Check for invalid ranges
        if (from < 0 || to > a.length) {
            throw new InvalidRangeException(from, to, a.length);
        }

        // Count the number of elements satisfying the predicate
        int count = this.count.inRange(a, from, to);
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
            if (predicate.test(a[i])) {
                first[j++] = a[i];
            } else {
                second[k++] = a[i];
            }
        }

        return Pair.of(first, second);
    }
}
