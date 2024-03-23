package edu.hw4;

import java.util.Comparator;
import org.junit.jupiter.api.Assertions;

class UnorderedEraserTest extends Assertions {
    public static final Integer[] EMPTY = new Integer[0];
    public static final Integer[] ORDERED =
        new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static final Integer[] REVERSED =
        new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    public static final Integer[] MIXED =
        new Integer[] {3, 2, 1, 4, 5, 8, 7, 10, 6, 9};

    public static final Integer[] WITH_DUPLICATES =
        new Integer[] {1, 2, 3, 4, 5, 5, 3, 3, 4, 2, 5};

    public static final UnorderedEraser<Integer> S =
        new UnorderedEraser<Integer>(Comparator.naturalOrder());

    @org.junit.jupiter.api.Test
    void testEmpty() {
        assertArrayEquals(new Integer[0], S.all(EMPTY));
    }

    @org.junit.jupiter.api.Test
    void testOrdered() {
        assertArrayEquals(
            new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            S.all(ORDERED)
        );
    }

    @org.junit.jupiter.api.Test
    void testReversed() {
        assertArrayEquals(
            new Integer[] {10},
            S.all(REVERSED)
        );
    }

    @org.junit.jupiter.api.Test
    void testMixed() {
        assertArrayEquals(
            new Integer[] {3, 4, 5, 8, 10},
            S.all(MIXED)
        );
    }


    @org.junit.jupiter.api.Test
    void testWithDuplicates() {
        assertArrayEquals(
            new Integer[] {1, 2, 3, 4, 5, 5, 5},
            S.all(WITH_DUPLICATES)
        );
    }

}
