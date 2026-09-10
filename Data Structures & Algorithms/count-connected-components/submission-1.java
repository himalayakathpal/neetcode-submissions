class Solution {
    private void dfs(int i, boolean[] visited,List<List<Integer>> adj) {
        if (visited[i]) return;
        visited[i] = true;
        for (int nei : adj.get(i)) {
            dfs(nei, visited, adj);
        }
    }
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0;i<n;i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[1]).add(edge[0]);
            adjList.get(edge[0]).add(edge[1]);
        }
        for (int i = 0;i<n;i++) {
            if (!visited[i]) {
                dfs(i,visited, adjList);
                count++;
            }
        }       
        return count;
    }
}
