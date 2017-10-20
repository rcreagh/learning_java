import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TopDownMergeSort {
    private static Comparable[] aux;
    
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
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
    
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {a[k] = aux[j++];}
            else if (j > hi) {a[k] = aux[i++];}
            else if (less(aux[i], aux[j])) {a[k] = aux[i++];}
            else {a[k] = aux[j++];}
        }
    }

    public static void sort(Comparable[] a) {
        // Public sort to create copy only once.
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }
    
    private static void sort(Comparable[] a, int lo, int hi) {
        // Private sort, called by public sort, which also calls itself
        // recursively.
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }
    
    // Creating a test client for TopDownMergeSort.
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
