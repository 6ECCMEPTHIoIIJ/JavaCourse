package edu.hw4;

import org.junit.jupiter.api.Assertions;

class MinMaxIndexTest extends Assertions {
    private static final Integer[] EMPTY = new Integer[0];
    private static final Integer[] ORDERED =
        new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private static final Integer[] REVERSED =
        new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    private static final Integer[] MIXED =
        new Integer[] {3, 2, 1, 4, 5, 8, 7, 10, 6, 9};

    private static final Integer[] WITH_DUPLICATES =
        new Integer[] {1, 2, 3, 4, 5, 5, 3, 3, 4, 2, 5};

    private static final MinMaxIndex<Integer> M = new MinMaxIndex<>();

    @org.junit.jupiter.api.Test
    void testEmpty() {
        assertEquals(BestWorstIndexPair.invalid(), M.all(EMPTY));
    }

    @org.junit.jupiter.api.Test
    void testOrdered() {
        assertEquals(new BestWorstIndexPair(0, 9), M.all(ORDERED));
    }

    @org.junit.jupiter.api.Test
    void testReversed() {
        assertEquals(new BestWorstIndexPair(9, 0), M.all(REVERSED));
    }

    @org.junit.jupiter.api.Test
    void testMixed() {
        assertEquals(new BestWorstIndexPair(2, 7), M.all(MIXED));
    }

    @org.junit.jupiter.api.Test
    void testWithDuplicates() {
        assertEquals(new BestWorstIndexPair(0, 4), M.all(WITH_DUPLICATES));
    }

}
