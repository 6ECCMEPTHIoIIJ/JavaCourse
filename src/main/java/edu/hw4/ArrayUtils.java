package edu.hw4;

import java.util.Comparator;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

public final class ArrayUtils {
    public static <T> void reverse(
        final T @NotNull [] arr
    ) {
        for (int i = 0; i < arr.length / 2; i++) {
            swap(arr, i, arr.length - 1 - i);
        }
    }

    public static <T extends Comparable<T>> int minIndex(
        final T @NotNull [] arr,
        final @NotNull Comparator<T> comparator
    ) {
        if (arr.length == 0) {
            return -1;
        }

        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (comparator.compare(arr[i], arr[minIndex]) < 0) {
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static <T extends Comparable<T>> int minIndex(
        final T @NotNull [] arr
    ) {
        return minIndex(arr, Comparator.naturalOrder());
    }

    public static <T extends Comparable<T>> int maxIndex(
        final T @NotNull [] arr,
        final @NotNull Comparator<T> comparator
    ) {
        if (arr.length == 0) {
            return -1;
        }

        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (comparator.compare(arr[i], arr[maxIndex]) > 0) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public static <T extends Comparable<T>> int maxIndex(
        final T @NotNull [] arr
    ) {
        return maxIndex(arr, Comparator.naturalOrder());
    }

    public static <T extends Comparable<T>> @NotNull MinMaxIndex minMaxIndex(
        final T @NotNull [] arr,
        final @NotNull Comparator<T> comparator
    ) {
        if (arr.length == 0) {
            return MinMaxIndex.invalid();
        }

        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            final int cmp = comparator.compare(arr[i], arr[minIndex]);
            if (cmp < 0) {
                minIndex = i;
            } else if (cmp > 0) {
                maxIndex = i;
            }
        }

        return new MinMaxIndex(minIndex, maxIndex);
    }

    public static <T extends Comparable<T>> @NotNull MinMaxIndex minMaxIndex(
        final T @NotNull [] arr
    ) {
        return minMaxIndex(arr, Comparator.naturalOrder());
    }

    public static <T extends Comparable<T>> Optional<T> min(
        final T @NotNull [] arr,
        final @NotNull Comparator<T> comparator
    ) {
        int minIndex = minIndex(arr, comparator);
        return minIndex == -1
            ? Optional.empty()
            : Optional.of(arr[minIndex]);
    }

    public static <T extends Comparable<T>> Optional<T> min(
        final T @NotNull [] arr
    ) {
        return min(arr, Comparator.naturalOrder());
    }

    public static <T extends Comparable<T>> Optional<T> max(
        final T @NotNull [] arr,
        final @NotNull Comparator<T> comparator
    ) {
        int maxIndex = maxIndex(arr, comparator);
        return maxIndex == -1
            ? Optional.empty()
            : Optional.of(arr[maxIndex]);
    }

    public static <T extends Comparable<T>> Optional<T> max(
        final T @NotNull [] arr
    ) {
        return max(arr, Comparator.naturalOrder());
    }

    public static <T extends Comparable<T>> Optional<MinMax<T>> minMax(
        final T @NotNull [] arr,
        final @NotNull Comparator<T> comparator
    ) {
        final MinMaxIndex minMaxIndex = minMaxIndex(arr, comparator);
        return minMaxIndex.minIndex() == -1
            ? Optional.empty()
            : Optional.of(new MinMax<>(
            arr[minMaxIndex.minIndex()],
            arr[minMaxIndex.maxIndex()]
        ));
    }

    public static <T extends Comparable<T>> Optional<MinMax<T>> minMax(
        final T @NotNull [] arr
    ) {
        return minMax(arr, Comparator.naturalOrder());
    }

    public static <T> void swap(
        final T @NotNull [] arr,
        final int i, final int j
    ) {
        final T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public record MinMax<T extends Comparable<T>>(T min, T max) {
        public static <T extends Comparable<T>> @NotNull Optional<MinMax<T>> find(
            final T @NotNull [] arr,
            final @NotNull Comparator<T> comparator
        ) {
            return minMax(arr, comparator);
        }

        public static <T extends Comparable<T>> @NotNull Optional<MinMax<T>> find(
            final T @NotNull [] arr
        ) {
            return minMax(arr);
        }
    }

    public record MinMaxIndex(int minIndex, int maxIndex) {
        public static MinMaxIndex invalid() {
            return new MinMaxIndex(-1, -1);
        }

        public static <T extends Comparable<T>> @NotNull MinMaxIndex find(
            final T @NotNull [] arr,
            final @NotNull Comparator<T> comparator
        ) {
            return minMaxIndex(arr, comparator);
        }

        public static <T extends Comparable<T>> @NotNull MinMaxIndex find(
            final T @NotNull [] arr
        ) {
            return minMaxIndex(arr);
        }
    }
}
