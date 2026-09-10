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
        while (n!=parent[n]) {
            n = parent[n];
        }
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
                result[0] = edge[0];
                result[1] = edge[1];
                break;
            } 
            ds.unionByRank (edge[0], edge[1]);
        }
        return result;
    }
}
