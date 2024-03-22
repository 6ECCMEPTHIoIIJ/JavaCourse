package edu.hw4;

/**
 * A pair of elements.
 *
 * @param <T> the type of elements
 */
public record BestWorstPair<T>(T best, T worst) {
    /**
     * Create a pair.
     *
     * @param best  the best element
     * @param worst the worst element
     * @return the pair
     */
    public static <T> BestWorstPair<T> of(final T best, final T worst) {
        return new BestWorstPair<>(best, worst);
    }
}
