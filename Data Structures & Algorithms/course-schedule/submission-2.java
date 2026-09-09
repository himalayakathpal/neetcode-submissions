public class Solution {
    private boolean dfs(int i, boolean[] visited,List<List<Integer>> adj) {
        if (visited[i]) return false;
        visited[i] = true;
        for (int nei : adj.get(i)) {
            if (!dfs(nei, visited, adj))return false;
        }
        adj.set(i, new ArrayList<>());
        visited[i] = false;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visited, adj)) {
                return false;
            }
        }
        return true;
    }
}