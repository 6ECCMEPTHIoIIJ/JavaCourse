package edu.hw3;

public abstract class IntegralElement
    implements Expression {
    protected int n;

    public IntegralElement(final int lowerBound) {
        n = lowerBound;
    }

    final void next() {
        n++;
    }
}
