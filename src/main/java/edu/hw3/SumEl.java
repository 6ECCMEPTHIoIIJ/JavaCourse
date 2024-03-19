package edu.hw3;

public record SumEl(double x, int n) {
    /**
     * Factory method to create a new instance of SumEl.
     *
     * @param x the x value
     * @param n the n value
     * @return a new instance of SumEl
     */
    public static SumEl of(final double x, final int n) {
        return new SumEl(x, n);
    }
}
