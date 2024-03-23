package edu.hw4;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

class CountTest extends Assertions {
    private static final Integer[] EMPTY = new Integer[0];
    private static final Integer[] ORDERED =
        new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private static final Integer[] REVERSED =
        new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    private static final Integer[] MIXED =
        new Integer[] {3, 2, 1, 4, 5, 8, 7, 10, 6, 9};

    private static final Integer[] WITH_DUPLICATES =
        new Integer[] {1, 2, 3, 4, 5, 5, 3, 3, 4, 2, 5};

    private static final Count<Integer> C =
        new Count<Integer>(i -> i % 2 == 0);

    @org.junit.jupiter.api.Test
    void testEmpty() {
        assertEquals(0, C.all(EMPTY));
    }

    @org.junit.jupiter.api.Test
    void testOrdered() {
        assertEquals(5, C.all(ORDERED));
    }

    @org.junit.jupiter.api.Test
    void testReversed() {
        assertEquals(5, C.all(REVERSED));
    }

    @org.junit.jupiter.api.Test
    void testMixed() {
        assertEquals(5, C.all(MIXED));
    }

    @org.junit.jupiter.api.Test
    void testWithDuplicates() {
        assertEquals(4, C.all(WITH_DUPLICATES));
    }
}
