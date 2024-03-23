package edu.hw4;

import org.junit.jupiter.api.Assertions;

class SplittedIndicesTest extends Assertions {
    private static final Integer[] EMPTY = new Integer[0];
    private static final Integer[] ORDERED =
        new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private static final Integer[] REVERSED =
        new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    private static final Integer[] MIXED =
        new Integer[] {3, 2, 1, 4, 5, 8, 7, 10, 6, 9};

    private static final Integer[] WITH_DUPLICATES =
        new Integer[] {1, 2, 3, 4, 5, 5, 3, 3, 4, 2, 5};

    private static final SplittedIndices<Integer> S =
        new SplittedIndices<>(integer -> integer % 2 == 0);

    @org.junit.jupiter.api.Test
    void testEmpty() {
        Pair<Integer[], Integer[]> got = S.all(EMPTY);
        assertArrayEquals(new Integer[0], got.first());
        assertArrayEquals(new Integer[0], got.second());
    }

    @org.junit.jupiter.api.Test
    void testOrdered() {
        Pair<Integer[], Integer[]> got = S.all(ORDERED);
        assertArrayEquals(new Integer[] {1, 3, 5, 7, 9}, got.first());
        assertArrayEquals(new Integer[] {2, 4, 6, 8, 10}, got.second());
    }

    @org.junit.jupiter.api.Test
    void testReversed() {
        Pair<Integer[], Integer[]> got = S.all(REVERSED);
        assertArrayEquals(new Integer[] {10, 8, 6, 4, 2}, got.first());
        assertArrayEquals(new Integer[] {9, 7, 5, 3, 1}, got.second());
    }

    @org.junit.jupiter.api.Test
    void testMixed() {
        Pair<Integer[], Integer[]> got = S.all(MIXED);
        assertArrayEquals(new Integer[] {3, 1, 5, 7, 6}, got.first());
        assertArrayEquals(new Integer[] {2, 4, 8, 10, 9}, got.second());
    }

    @org.junit.jupiter.api.Test
    void testWithDuplicates() {
        Pair<Integer[], Integer[]> got = S.all(WITH_DUPLICATES);
        assertArrayEquals(new Integer[] {1, 3, 5, 3, 4, 5}, got.first());
        assertArrayEquals(new Integer[] {2, 4, 5, 3, 2}, got.second());
    }
}
