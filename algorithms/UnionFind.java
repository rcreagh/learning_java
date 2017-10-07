// This program implements union find.
// Must know the total number of nodes.
// NOTE: This is WIP.
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class UnionFind {
    private int[] id;
    private int[] size;
    private int count;
    
    public UnionFind(int n){
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {id[i] = i;}
        size = new int[n];
        for (int i = 0; i < n; i++) {size[i] = 1;}
    }
    public int count() {return count;}

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while(id[p] != p) {p = id[p];}
            return p;
    }
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {return;}
        else {
            if (size[i] < size[j]) {
                id[i] = j;
                size[j] += size[i];
            }
            else {
                id[j] = i;
                size[i] += size[j];
            }
            count --;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        // Test for union find.
        // Test takes a file of integers, where the first integer is the
        // total number of nodes in the graph. The rest of the integers are
        // pairs of nodes, which represent arcs in the graph.
        Scanner scanner = new Scanner(new File(args[0]));
        int n = scanner.nextInt();
        UnionFind uf = new UnionFind(n);
        while (scanner.hasNextInt()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            uf.union(p, q);
        }
        System.out.println("Number of connected components: " + uf.count());
    }
}
