package edu.hw4;

/**
 * A pair of indices.
 */
public record BestWorstIndexPair(int bestIndex, int worstIndex) {

    /**
     * Create a pair.
     *
     * @param bestIndex  the best index
     * @param worstIndex the worst index
     * @return the pair
     */
    public static BestWorstIndexPair of(
        final int bestIndex,
        final int worstIndex
    ) {
        return new BestWorstIndexPair(bestIndex, worstIndex);
    }

    /**
     * Create an invalid pair.
     * Invalid indices are represented by -1.
     *
     * @return an invalid pair
     */
    public static BestWorstIndexPair invalid() {
        return new BestWorstIndexPair(-1, -1);
    }

    /**
     * Check if the pair is valid.
     * A pair is valid if both indices are non-negative.
     *
     * @return true if the pair is valid, false otherwise
     */
    public boolean isValid() {
        return bestIndex >= 0 && worstIndex >= 0;
    }
}
