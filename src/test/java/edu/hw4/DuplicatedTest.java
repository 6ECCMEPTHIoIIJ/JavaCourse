package edu.hw4;

import org.junit.jupiter.api.Assertions;

class DuplicatedTest extends Assertions {
    private static final Integer[] EMPTY = new Integer[0];
    private static final Integer[] ORDERED =
        new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private static final Integer[] REVERSED =
        new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    private static final Integer[] MIXED =
        new Integer[] {3, 2, 1, 4, 5, 8, 7, 10, 6, 9};

    private static final Integer[] WITH_DUPLICATES =
        new Integer[] {1, 2, 3, 4, 5, 5, 3, 3, 4, 2, 5};

    private static final Duplicated<Integer> D =
        new Duplicated<>(3);

    @org.junit.jupiter.api.Test
    void testEmpty() {
        assertArrayEquals(new Integer[0], D.all(EMPTY));
    }

    @org.junit.jupiter.api.Test
    void testOrdered() {
        assertArrayEquals(new Integer[] {
            1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10
        }, D.all(ORDERED));
    }

    @org.junit.jupiter.api.Test
    void testReversed() {
        assertArrayEquals(new Integer[] {
            10, 9, 8, 7, 6, 5, 4, 3, 3, 2, 1
        }, D.all(REVERSED));
    }

    @org.junit.jupiter.api.Test
    void testMixed() {
        assertArrayEquals(new Integer[] {
            3, 3, 2, 1, 4, 5, 8, 7, 10, 6, 9
        }, D.all(MIXED));
    }

    @org.junit.jupiter.api.Test
    void testWithDuplicates() {
        assertArrayEquals(new Integer[] {
            1, 2, 3, 3, 4, 5, 5, 3, 3, 3, 3, 4, 2, 5
        }, D.all(WITH_DUPLICATES));
    }
}
