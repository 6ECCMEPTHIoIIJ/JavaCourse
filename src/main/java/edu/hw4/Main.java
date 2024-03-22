package edu.hw4;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Test your code here
        Ranged<Integer, Integer[]> applier = new Reversed<>();
        System.out.println(Arrays.toString(
            applier.all(new Integer[] {1, 2, 3, 4, 5})));
        applier = new Sorted<Integer>(Comparator.naturalOrder());
        System.out.println(Arrays.toString(
            applier.all(new Integer[] {5, 3, 4, 1, 2})));
        applier = new Sorted<Integer>(Comparator.reverseOrder());
        System.out.println(Arrays.toString(
            applier.inRange(new Integer[] {1, 2, 3, 4, 5}, 1, 4)));
        applier = new Eraser<>(3);
        System.out.println(Arrays.toString(
            applier.inRange(new Integer[] {1, 2, 3, 7, 3, 3, 4, 5}, 3, 5)));
        applier = new Duplicator<>(3);
        System.out.println(Arrays.toString(
            applier.inRange(new Integer[] {1, 2, 3, 7, 3, 3, 4, 5}, 3, 5)));
        applier = new UnorderedEraser<Integer>(Comparator.naturalOrder());
        System.out.println(Arrays.toString(
            applier.all(new Integer[] {1, 2, 3, 7, 3, 3, 4, 5})));
        Ranged<Integer, int[]> sorter =
            new SortedIndexed<Integer>(Comparator.naturalOrder());
        System.out.println(Arrays.toString(
            sorter.all(new Integer[] {1, 2, 3, 7, 3, 3, 4, 5})));
        Smoother smoother = new Smoother1();
        System.out.println(Arrays.toString(
            smoother.all(new Double[] {1.0, 3.0, 3.0, 4.0, 5.0})));
        smoother = new Smoother2();
        System.out.println(Arrays.toString(
            smoother.all(new Double[] {1.0, 3.0, 3.0, 4.0, 5.0})));
        smoother = new Smoother3();
        System.out.println(Arrays.toString(
            smoother.all(new Double[] {1.0, 2.0, 3.0, 4.0, 5.0})));
    }
}
