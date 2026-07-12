class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0;i<n;i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0 ;i<edges.length;i++) {
            adjList.get(edges[i][1]).add(edges[i][0]);
            adjList.get(edges[i][0]).add(edges[i][1]);
        }
        int count = 0;
        int[] visited = new int[n];
        
        for (int i=0;i<n;i++) { 
            if (visited[i] == 0) {
                dfs(visited,i, adjList,-1);
                count++;
            } 
        }
        return count;
    }
    private void dfs (int[] visited, int i, List<List<Integer>> adjList, int parent) {
        visited[i] = 1;
        for (int k = 0;k<adjList.get(i).size();k++) {
            if (adjList.get(i).get(k) == parent) continue;
            if (visited[adjList.get(i).get(k)] == 0) dfs(visited, adjList.get(i).get(k), adjList, i);
        }
    }
}
