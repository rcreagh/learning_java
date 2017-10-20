// This program implements ShellSort, a naive sorting method with
// O(n^2) runtime in the worst case. Uses insertion sort. Takes advantage of
// the fact that the closer a dataset is to being sorted, the faster insertion
// sort is. The final value of h is 1, which is the same as insertion sort.

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ShellSort {
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
    	    int h = 1;
    	    while (h < n/3) {h = h * 3 + 1;}
    	    while (h >= 1) {
    	    	    for (int i = h; i < n; i++) {
    	    	        for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
    	    	    	        exchange(a, j, j - h);
    	    	        }
    	    	    }
    	    	    h = h/3;
    	    }
    }
    // Creating a test client for ShellSort.
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
