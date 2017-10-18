// This program implements insertion sort, a naive sorting method with O(n^2)
// runtime in the worst case. This algorithm performs better if the data is
// already almost sorted.

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class InsertionSort {
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
    	    for (int i = 1; i < n; i++) {
    	    	    for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
    	    	    	    exchange(a, j, j - 1);
    	    	    }
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
