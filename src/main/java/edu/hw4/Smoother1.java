package edu.hw4;

import java.util.Arrays;

/**
 * A class that smooths a range of values by averaging them.
 */
public class Smoother1 implements Smoother {
    /**
     * Smooth the values in the range.
     * The original array is not modified.
     * The smoothing is done by averaging the values in the range.
     * The value at index i is replaced by the average of the values from
     * start index of the range to index i.
     * The first value in the range is not changed.
     *
     * @param a    the array to smooth
     * @param from the start of the range
     * @param to   the end of the range
     * @return the array with the values in the range smoothed
     */
    @Override
    public Double[] inRange(final Double[] a, final int from, final int to) {
        // Check for invalid range
        if (from < 0 || to > a.length) {
            throw new InvalidRangeException(from, to, a.length);
        }

        // Copy the array
        final Double[] result = Arrays.copyOf(a, a.length);
        // The first value in the range is not changed
        double t = result[0];
        // Smooth the values in the range
        for (int i = from + 1; i < to; i++) {
            // Add the value at index i to the previous sum
            result[i] += t;
            // Save the sum in the value at index i
            t = result[i];
            // Divide the sum by the number of elements
            result[i] /= (i - from + 1);
        }

        return result;
    }
}
