package heapanddisjointset;

public class DisjointSet {
    int n;
    int[] p;
    int[] r;
    int count;
    public DisjointSet(int n) {
        this.n = n;
        p = new int[n];
        r = new int[n];
        this.count = n;
        for(int i=0;i<n;i++) {
            p[i] = i;
            r[i] = 1;
        }
    }
    public int find(int a) {
        if(p[a] != a) {
            int root =  find(p[a]);
            p[a] = root; //Path compression
            return root;
        }
        return a;
    }
    public void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if(ra != rb) {
            count--;
            //p[ra] = rb;
            if(r[ra] > r[rb]) {
                p[rb] = ra;
            }
            else if(r[ra] < r[rb]) {
                p[ra] = rb;
            }
            else {
                p[ra] = rb;
                r[rb]++;
            }
        }
    }
}
