class DisjointSet {
    int[] rank;
    int[] parent;
    int size;
    DisjointSet(int n) {
        size = n;
        parent = new int[size];
        rank = new int[size];
        for (int i=0;i<size;i++) {
            parent[i] = i;
        }
    }
    public int findParent(int n) {
        if (n == parent[n]) return n;
        parent[n] = findParent(parent[n]);
        return parent[n];
    }
    public void unionByRank(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);
        if (rank[parentA] >= rank[parentB]) {
            rank[parentA]++;
            parent[parentB] = parentA;
        } else {
            rank[parentB]++;
            parent[parentA] = parentB;
        }
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] result = new int[2];
        DisjointSet ds = new DisjointSet(edges.length+1);
        for (int[] edge: edges) {
            if (ds.findParent(edge[0]) == ds.findParent(edge[1])) {
                return new int[] {edge[0],edge[1]};
            } 
            ds.unionByRank (edge[0], edge[1]);
        }
        return result;
    }
}
