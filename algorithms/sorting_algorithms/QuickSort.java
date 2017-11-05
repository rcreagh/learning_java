// This program implements quick sort, which sorts in O(nlog(n)) runtime.

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class QuickSort {
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    public static void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
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
        // StdRandom.shuffle(a); Haven't got this installed, giving up for the sake
        // of my sanity. Of course, this is essential to have this algorithm run
        // efficiently in the event that the array is already sorted or nearly sorted.
        sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }
    private static int partition(Comparable a[], int lo, int hi) {
        int i = lo;
        int j = hi + 1; // hi + 1 as we will be decrementing j before evaluating.
     // Choose the first item in the array as the partitioning item.
        Comparable v = a[lo];
        while (true) {
            // Start at the 2nd item and keep going left (to the 3rd item, 4th item
            // etc.) until you find an item that is bigger than v.
            while (less(a[++i], v)) {
                // If this item is in the position 'hi', we have reached the end of
                // the array, so we break. Otherwise, we move on and scan from
                // right to left (the next while loop).
                if (i == hi) {break;}
            }
            // Start at the last item and keep going right (to the 2nd last item, 
            // 3rd last item etc.) until you find an item that is smaller than v.
            while (less(v, a[--j])) {
                if (j == lo) {break;}
            }
            // Now that we have found an item bigger than v and one smaller than v,
            // we swap them unless the larger item is actually already to the right
            // of the smaller one. In that case, we've scanned all items, so we break.
            if (i >= j) {break;}
            exchange(a, i, j);
        }
        // Finally, we swap the partitioning item (v) and the final value of j (the
        // item furthest to the right that is smaller than v, so that everything to
        // the left of v is smaller than v, and everything to the right of it is
        //larger than it.
        exchange(a, lo, j);
        // Return the index of where we moved the partitioning item to, so that our
        // algorithm knows which two subarrays to partition next.
        return j;
    }
    // Creating a test client for QuickSort.
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