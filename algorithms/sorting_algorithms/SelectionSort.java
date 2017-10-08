// This program implements selection sort, a naive sorting method with
// O(n^2) runtime.

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class SelectionSort {
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (less(a[i + 1], a[i])) {return false;}
        }
            return true;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {min = j;}
            }
            exchange(a, i, min);
        }
    }
    // Creating a test client for SelectionSort.
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(args[0]));
        Integer[] a = new Integer[15]; // Hacky, just to get working.
        int i = 0;
        while (scanner.hasNextInt()) {
            a[i] = scanner.nextInt();
            i++;
        }
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
