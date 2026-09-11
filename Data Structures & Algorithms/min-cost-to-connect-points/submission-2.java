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
    public boolean unionByRank(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);
        if (parentA == parentB) return false;
        if (rank[parentA] >= rank[parentB]) {
            rank[parentA]++;
            parent[parentB] = parentA;
        } else {
            rank[parentB]++;
            parent[parentA] = parentB;
        }
        return true;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        DisjointSet ds = new DisjointSet(points.length);
        int count = 0;
        int result = 0;
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        List<int[]> edges = new ArrayList<>();
        for (int i = 0;i<points.length;i++) {
            for (int j = i+1;j<points.length;j++) {
                int dist = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]); 
                edges.add(new int[] {i,j, dist});
            }
        }
        Collections.sort(edges, (a,b) -> Integer.compare(a[2], b[2]));
        for (int[] edge: edges) {
            if (ds.unionByRank(edge[0],edge[1])) {
                result+=edge[2];
                count++;
            } 
        }
        return result;
    }
}
