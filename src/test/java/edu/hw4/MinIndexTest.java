package edu.hw4;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

class MinIndexTest extends Assertions {
    private static final Integer[] EMPTY = new Integer[0];
    private static final Integer[] ORDERED =
        new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private static final Integer[] REVERSED =
        new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    private static final Integer[] MIXED =
        new Integer[] {3, 2, 1, 4, 5, 8, 7, 10, 6, 9};

    private static final Integer[] WITH_DUPLICATES =
        new Integer[] {1, 2, 3, 4, 5, 5, 3, 3, 4, 2, 5};

    private static final MinIndex<Integer> M = new MinIndex<>();

    @org.junit.jupiter.api.Test
    void testEmpty() {
        assertEquals(-1, M.all(EMPTY));
    }

    @org.junit.jupiter.api.Test
    void testOrdered() {
        assertEquals(0, M.all(ORDERED));
    }

    @org.junit.jupiter.api.Test
    void testReversed() {
        assertEquals(9, M.all(REVERSED));
    }

    @org.junit.jupiter.api.Test
    void testMixed() {
        assertEquals(2, M.all(MIXED));
    }

    @org.junit.jupiter.api.Test
    void testWithDuplicates() {
        assertEquals(0, M.all(WITH_DUPLICATES));
    }
}
