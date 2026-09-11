class Solution {
    public int minCostConnectPoints(int[][] points) {
        int result = 0;
        int n = points.length;
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        int count =0;
        int next = 0;
        while(count<n) {
            int mini = Integer.MAX_VALUE;
            for (int i=0;i<n;i++) {
                if (!visited[i] && dist[i]<mini) {
                    mini = dist[i];
                    next = i;
                }
            }
            result+= dist[next];
            visited[next] = true;
            for (int i=0;i<n;i++) {
                if (!visited[i]) {
                    int currDist = Math.abs(points[next][0] - points[i][0]) + Math.abs(points[next][1] - points[i][1]); 
                   dist[i] = Math.min(dist[i], currDist);
                }
            }

            count++;
        }
        return result;
    }
}
