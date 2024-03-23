package edu.hw4;

import java.util.Arrays;

/**
 * A class that smooths a range of values by averaging them.
 */
public class Smoother3 implements Smoother {
    /**
     * Smooth the values in the range.
     * The original array is modified.
     * The smoothing is done by averaging the values in the range.
     * The value at index i is replaced by the average of the values
     * at index i, i - 1 and i + 1.
     * The first value is replaced by the average of the first two values.
     * The last value replaces by the average of the last two values.
     *
     * @param a    the array to smooth
     * @param from the start of the range
     * @param to   the end of the range
     * @return the original array with the values in the range smoothed
     */
    @Override
    public Double[] inRange(final Double[] a, final int from, final int to) {
        // Check for invalid range
        if (from < 0 || to > a.length) {
            throw new InvalidRangeException(from, to, a.length);
        }

        // Save the first value
        double t = a[from];
        // The first value in the range is replaced by the average
        // of the first two values
        a[from] = (a[from] + a[from + 1]) / 2.0;
        for (int i = from + 1; i < to - 1; i++) {
            // The value at index i is replaced by the average of the near values
            double buf = (a[i + 1] + a[i] + t) / 3.0;
            // Save the value at index i
            t = a[i];
            // Update the value at index i
            a[i] = buf;
        }
        // The last value in the range is replaced by the average
        // of the last two values
        a[to - 1] = (a[to - 1] + t) / 2.0;

        return a;
    }
}
