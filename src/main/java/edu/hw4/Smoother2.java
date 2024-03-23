package edu.hw4;

import java.util.Arrays;

/**
 * A class that smooths a range of values by averaging them.
 */
public class Smoother2 implements Smoother {
    /**
     * Smooth the values in the range.
     * The original array is modified.
     * The smoothing is done by averaging the values in the range.
     * The value at index i is replaced by
     * the average of the values at index i and i - 1.
     * The first value in the range is not changed.
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

        // The first value in the range is not changed
        double t = a[from];
        // Smooth the values in the range
        for (int i = from + 1; i < to; i++) {
            // Add the value at index i to the previous value and divide by 2
            double buf = (a[i] + t) / 2;
            // Save the value at index i
            t = a[i];
            // Update the value at index i
            a[i] = buf;
        }

        return a;
    }
}
