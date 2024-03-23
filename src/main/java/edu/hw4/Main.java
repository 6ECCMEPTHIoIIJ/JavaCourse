package edu.hw4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Test your code here
        Smoother smoother = new Smoother1();
        Double[] a = {1.0, 2.0, 3.0, 4.0, 5.0};
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(smoother.all(a)));
        }

        smoother = new Smoother2();
        a = new Double[]{1.0, 2.0, 3.0, 4.0, 5.0};
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(smoother.all(a)));
        }

        smoother = new Smoother3();
        a = new Double[]{1.0, 2.0, 3.0, 4.0, 5.0};
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(smoother.all(a)));
        }
    }
}
