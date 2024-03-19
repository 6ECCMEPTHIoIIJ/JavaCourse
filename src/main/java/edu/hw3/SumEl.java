package edu.hw3;

public record SumEl(double x, int n) {
    public static SumEl of(double x, int n) {
        return new SumEl(x, n);
    }
}
