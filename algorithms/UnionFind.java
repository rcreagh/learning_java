// This program implements union find.
// NOTE: This is WIP.

public class UnionFind {
    private int[] id;
    private int[] size;
    private int count;
    
    public UnionFind(int n){
        count = n;
        id = new int[n];
        for(int i = 0; i < n; i++) {id[i] = i;}
        size = new int[n];
        for(int i = 0; i < n;) {size[i] = 1;}
    }
    public int count() {return n;}

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while(id[p] != p) {p = id[p];}
            return p
    }

}
