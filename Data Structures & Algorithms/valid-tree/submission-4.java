class Solution {
    private boolean dfs(int i, boolean[] visited,List<List<Integer>> adj, int parent) {
        if (visited[i]) return false;
        visited[i] = true;
        for (int nei : adj.get(i)) {
            if (nei!=parent && !dfs(nei, visited, adj, i))return false;
        }
        return true;
    }
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0;i<n;i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[1]).add(edge[0]);
            adjList.get(edge[0]).add(edge[1]);
        }
        if (!dfs(0,visited, adjList,-1)) return false;
        for (boolean isVisited : visited) {
            if (!isVisited) return false;
        }
        return true;

    }
}
