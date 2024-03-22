package edu.hw4;

public class ArrayUtils {
    public static <T> void swap(final T[] a, final int i, final int j) {
        if (i == j) {
            return;
        }

        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
