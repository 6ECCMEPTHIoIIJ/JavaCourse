package edu.hw4;

import java.util.Arrays;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

public final class ArrayUtils {
    /**
     * Finds the minimum index of an array slice.
     *
     * @param s   the array slice
     * @param <T> the type of the elements
     * @return the minimum index of the array slice.
     *     If the array slice is empty, returns -1.
     */
    public static <T extends Comparable<T>> int findMinIndex(
        final @NotNull ArraySlice<T> s
    ) {
        if (s.getSize() == 0) {
            return -1;
        }

        int minIndex = 0;
        for (int i = 1; i < s.getSize(); i++) {
            if (s.get(i).compareTo(s.get(minIndex)) < 0) {
                minIndex = i;
            }
        }

        return minIndex;
    }

    /**
     * Finds the maximum index of an array slice.
     *
     * @param s   the array slice
     * @param <T> the type of the elements
     * @return the maximum index of the array slice.
     *     If the array slice is empty, returns -1.
     */
    public static <T extends Comparable<T>> int findMaxIndex(
        final @NotNull ArraySlice<T> s
    ) {
        if (s.getSize() == 0) {
            return -1;
        }

        int maxIndex = 0;
        for (int i = 1; i < s.getSize(); i++) {
            if (s.get(i).compareTo(s.get(maxIndex)) > 0) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    /**
     * Finds the minimum value of an array slice.
     *
     * @param s   the array slice
     * @param <T> the type of the elements
     * @return the minimum value of the array slice.
     *     If the array slice is empty, returns an empty optional.
     */
    public static <T extends Comparable<T>> Optional<T> findMin(
        final @NotNull ArraySlice<T> s
    ) {
        int minIndex = findMinIndex(s);
        return minIndex == -1
            ? Optional.empty()
            : Optional.of(s.get(minIndex));
    }

    /**
     * Finds the maximum value of an array slice.
     *
     * @param s   the array slice
     * @param <T> the type of the elements
     * @return the maximum value of the array slice.
     *     If the array slice is empty, returns an empty optional.
     */
    public static <T extends Comparable<T>> Optional<T> findMax(
        final @NotNull ArraySlice<T> s
    ) {
        int maxIndex = findMaxIndex(s);
        return maxIndex == -1
            ? Optional.empty()
            : Optional.of(s.get(maxIndex));
    }

    /**
     * Finds the minimum and maximum indices of an array slice.
     *
     * @param s   the array slice
     * @param <T> the type of the elements
     * @return the minimum and maximum indices of the array slice.
     *     If the array slice is empty, the minimum and maximum indices are invalid.
     * @see MinMaxIndex
     */
    public static <T extends Comparable<T>> MinMaxIndex findMinMaxIndex(
        final @NotNull ArraySlice<T> s
    ) {
        if (s.getSize() == 0) {
            return MinMaxIndex.invalid();
        }

        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 1; i < s.getSize(); i++) {
            if (s.get(i).compareTo(s.get(minIndex)) < 0) {
                minIndex = i;
            } else if (s.get(i).compareTo(s.get(maxIndex)) > 0) {
                maxIndex = i;
            }
        }

        return new MinMaxIndex(minIndex, maxIndex);
    }

    /**
     * Finds the minimum and maximum value of an array slice.
     *
     * @param s   the array slice
     * @param <T> the type of the elements
     * @return the minimum and maximum value of the array slice.
     *    If the array slice is empty, returns an empty optional.
     * @see MinMax
     */
    public static <T extends Comparable<T>> Optional<MinMax<T>> findMinMax(
        @NotNull ArraySlice<T> s
    ) {
        return MinMax.of(s, findMinMaxIndex(s));
    }

    /**
     * Erases all elements from an array slice that are equal to a value.
     *
     * @param s     the array slice
     * @param value the value to erase
     * @param <T>   the type of the elements
     */
    public static <T extends Comparable<T>> void erase(
        @NotNull ArraySlice<T> s,
        final T value
    ) {
        int shift = 0;
        for (int i = 0; i < s.getSize(); i++) {
            if (s.get(i).compareTo(value) == 0) {
                shift++;
            } else {
                s.set(i - shift, s.get(i));
            }
        }

        s.resize(s.getSize() - shift);
    }

    /**
     * Erases all elements from an array slice that are not in sorted order.
     *
     * @param s   the array slice
     * @param <T> the type of the elements
     */
    public static <T extends Comparable<T>> void eraseUnordered(
        @NotNull ArraySlice<T> s
    ) {
        int shift = 0;
        for (int i = 1; i < s.getSize(); i++) {
            if (s.get(i).compareTo(s.get(i - 1)) < 0) {
                shift++;
            } else {
                s.set(i - shift, s.get(i));
            }
        }

        s.resize(s.getSize() - shift);
    }

    /**
     * Counts the number of occurrences of a value in an array slice.
     *
     * @param s     the array slice
     * @param value the value to count
     * @param <T>   the type of the elements
     * @return the number of occurrences of the value in the array slice
     */
    public static <T extends Comparable<T>> int count(
        final @NotNull ArraySlice<T> s,
        final T value
    ) {
        int count = 0;
        for (int i = 0; i < s.getSize(); i++) {
            if (s.get(i).compareTo(value) == 0) {
                count++;
            }
        }

        return count;
    }

    /**
     * Duplicates a value in an array slice.
     * The duplicated value is inserted after each occurrence of the value.
     * The array slice is resized to accommodate the duplicated values.
     *
     * @param s     the array slice
     * @param value the value to duplicate
     * @param <T>   the type of the elements
     */
    public static <T extends Comparable<T>> void duplicate(
        final @NotNull ArraySlice<T> s,
        final T value
    ) {
        int shift = count(s, value);
        s.resize(s.getSize() + shift);
        boolean needDuplicate = false;
        for (int i = s.getSize() - 1; i >= 0; i--) {
            s.set(i, s.get(i - shift));
            needDuplicate = !needDuplicate && s.get(i).compareTo(value) == 0;
            if (needDuplicate) {
                shift--;
            }
        }
    }

    /**
     * Sorts an array slice using the selection sort algorithm.
     *
     * @param s   the array slice
     * @param <T> the type of the elements
     */
    public static <T extends Comparable<T>> void selectionSort(
        @NotNull ArraySlice<T> s
    ) {
        for (int i = 0; i < s.getSize(); i++) {
            swap(s, i, i + findMinIndex(ArraySlice.ofFrom(s, s.getBegin() + i)));
        }
    }

    /**
     * Sorts an array slice using the insertion sort algorithm.
     *
     * @param s   the array slice
     * @param <T> the type of the elements
     */
    public static <T extends Comparable<T>> void insertionSort(
        @NotNull ArraySlice<T> s
    ) {
        for (int i = 1; i < s.getSize(); i++) {
            int j = i;
            while (j > 0 && s.get(j - 1).compareTo(s.get(j)) > 0) {
                swap(s, j - 1, j);
                j--;
            }
        }
    }

    /**
     * Sorts an array slice using the bubble sort algorithm.
     *
     * @param s   the array slice
     * @param <T> the type of the elements
     */
    public static <T extends Comparable<T>> void bubbleSort(
        @NotNull ArraySlice<T> s
    ) {
        for (int i = 0; i < s.getSize(); i++) {
            for (int j = 0; j < s.getSize() - i - 1; j++) {
                if (s.get(j).compareTo(s.get(j + 1)) > 0) {
                    swap(s, j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts an array slice.
     *
     * @param s   the array slice
     * @param <T> the type of the elements
     */
    public static <T extends Comparable<T>> void sort(
        @NotNull ArraySlice<T> s
    ) {
        Arrays.sort(s.getData(), s.getBegin(), s.getEnd());
    }

    /**
     * Reverts an array slice.
     *
     * @param s   the array slice
     * @param <T> the type of the elements
     */
    public static <T> void revert(
        @NotNull ArraySlice<T> s
    ) {
        for (int i = 0; i < s.getSize() / 2; i++) {
            swap(s, i, s.getSize() - i - 1);
        }
    }

    /**
     * Swaps two elements in an array slice.
     *
     * @param s   the array slice
     * @param i   the index of the first element
     * @param j   the index of the second element
     * @param <T> the type of the elements
     */
    public static <T> void swap(
        @NotNull ArraySlice<T> s,
        final int i,
        final int j
    ) {
        T temp = s.get(i);
        s.set(i, s.get(j));
        s.set(j, temp);
    }

    /**
     * Represents a minimum and maximum value.
     *
     * @param <T> the type of the minimum and maximum value
     */
    public record MinMax<T>(@NotNull T min, @NotNull T max) {
        /**
         * Returns the minimum and maximum value of an array slice.
         *
         * @param s           the array slice
         * @param minMaxIndex the minimum and maximum index
         * @param <T>         the type of the minimum and maximum value
         * @return the minimum and maximum value of the array slice.
         *     If the minimum and maximum index is invalid, returns an empty optional.
         */
        public static <T extends Comparable<T>> Optional<MinMax<T>> of(
            @NotNull ArraySlice<T> s,
            final @NotNull MinMaxIndex minMaxIndex
        ) {
            return minMaxIndex.isInvalid()
                ? Optional.empty()
                : Optional.of(new MinMax<>(
                s.get(minMaxIndex.min),
                s.get(minMaxIndex.max)
            ));
        }
    }

    /**
     * Represents the minimum and maximum indices of an array slice.
     */
    public record MinMaxIndex(int min, int max) {
        /**
         * Returns an invalid minimum and maximum index.
         * Invalid minimum and maximum indices are represented by -1.
         *
         * @return an invalid minimum and maximum index
         */
        public static MinMaxIndex invalid() {
            return new MinMaxIndex(-1, -1);
        }

        /**
         * Returns whether the minimum and maximum indices are invalid.
         *
         * @return true if the minimum and maximum indices are equal to -1, false otherwise
         */
        public boolean isInvalid() {
            return min == -1 && max == -1;
        }
    }
}

