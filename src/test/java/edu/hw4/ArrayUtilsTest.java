package edu.hw4;

import edu.hw4.ArrayUtils.MinMax;
import edu.hw4.ArrayUtils.MinMaxIndex;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Optional;

class ArrayUtilsTest extends Assertions {

    @ParameterizedTest
    @MethodSource("edu.hw4.ArrayUtilsTestProvider#provideFindMinIndex")
    void findMinIndex(ArrayUtilsTestProvider.@NotNull FindIndexArg<Double> arg) {
        assertEquals(arg.expected(), ArrayUtils.findMinIndex(arg.array()));
    }

    @ParameterizedTest
    @MethodSource("edu.hw4.ArrayUtilsTestProvider#provideFindMaxIndex")
    void findMaxIndex(ArrayUtilsTestProvider.@NotNull FindIndexArg<Double> arg) {
        assertEquals(arg.expected(), ArrayUtils.findMaxIndex(arg.array()));
    }

    @ParameterizedTest
    @MethodSource("edu.hw4.ArrayUtilsTestProvider#provideFindMinIndex")
    void findMin(ArrayUtilsTestProvider.@NotNull FindIndexArg<Double> arg) {
        Optional<Double> min = ArrayUtils.findMin(arg.array());
        if (arg.expected() == -1) {
            assertTrue(min.isEmpty());
        } else {
            assertTrue(min.isPresent());
            assertEquals(arg.array().get(arg.expected()), min.get());
        }

    }

    @ParameterizedTest
    @MethodSource("edu.hw4.ArrayUtilsTestProvider#provideFindMaxIndex")
    void findMax(ArrayUtilsTestProvider.@NotNull FindIndexArg<Double> arg) {
        Optional<Double> max = ArrayUtils.findMax(arg.array());
        if (arg.expected() == -1) {
            assertTrue(max.isEmpty());
        } else {
            assertTrue(max.isPresent());
            assertEquals(arg.array().get(arg.expected()), max.get());
        }
    }

    @ParameterizedTest
    @MethodSource("edu.hw4.ArrayUtilsTestProvider#provideFindMinMaxIndex")
    void findMinMaxIndex(ArrayUtilsTestProvider.@NotNull FindMinMaxIndexArg<Double> arg) {
        MinMaxIndex minMaxIndex = ArrayUtils.findMinMaxIndex(arg.array());
        assertEquals(arg.expectedMin(), minMaxIndex.min());
        assertEquals(arg.expectedMax(), minMaxIndex.max());
    }

    @ParameterizedTest
    @MethodSource("edu.hw4.ArrayUtilsTestProvider#provideFindMinMaxIndex")
    void findMinMax(ArrayUtilsTestProvider.@NotNull FindMinMaxIndexArg<Double> arg) {
        Optional<MinMax<Double>> minMax = ArrayUtils.findMinMax(arg.array());
        if (arg.expectedMin() == -1) {
            assertTrue(minMax.isEmpty());
        } else {
            assertTrue(minMax.isPresent());
            assertEquals(arg.array().get(arg.expectedMin()), minMax.get().min());
            assertEquals(arg.array().get(arg.expectedMax()), minMax.get().max());
        }
    }

    @ParameterizedTest
    @MethodSource("edu.hw4.ArrayUtilsTestProvider#provideErase")
    void erase(ArrayUtilsTestProvider.@NotNull EraseArg<Double> arg) {
        ArrayUtils.erase(arg.got(), arg.value());
        assertEquals(0, ArrayUtils.compare(arg.expected(), arg.got()));
    }

    @Test
    void eraseUnordered() {
    }

    @Test
    void count() {
    }

    @Test
    void duplicate() {
    }

    @Test
    void selectionSort() {
    }

    @Test
    void insertionSort() {
    }

    @Test
    void bubbleSort() {
    }

    @Test
    void sort() {
    }

    @Test
    void revert() {
    }

    @Test
    void swap() {
    }
}
