class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet ds = new DisjointSet();
        for (int i =0;i<edges.length;i++) {
            int a = ds.findParent(edges[i][0]);
            int b = ds.findParent(edges[i][1]);
            if (a == b) return edges[i];
            else ds.union(a,b);
        }
        return new int[2];
    }
}

class DisjointSet {
    int[] parent;
    DisjointSet() {
        parent = new int[101];
        for (int i =0;i<=100;i++) {
            parent[i] = i;
        }
    }
    public int findParent (int n) {
        while(n != parent[n]) {
            n = parent[n];
        }
        return n;
    }
    public void union (int a, int b) {
        parent[a] = b;
    }

}
