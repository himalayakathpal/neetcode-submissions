class Solution {
    private void dfs(int k,  List<List<Integer[]>> adj, int[] minTime, int timeTillNow) {
        for (Integer[] edge: adj.get(k)) {
            int dest = edge[0];
            int time = edge[1];
            if (minTime[dest]>time+timeTillNow) {
                minTime[dest] = time+timeTillNow;
                dfs(dest, adj, minTime, timeTillNow+ time);
            }
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Integer[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : times) {
            adj.get(time[0]).add(new Integer[] {time[1], time[2]});
        }

        for (int i = 0; i <= n; i++) {
            Collections.sort(adj.get(i), (a, b) -> a[1] - b[1]);
        }
        int[] minTime = new int[n+1];
        for (int i = 0; i <= n; i++) {
            minTime[i] = Integer.MAX_VALUE;
        }
        minTime[k] = 0;

        dfs(k, adj, minTime,0);
        int result = -1;
        for (int i = 1; i <= n; i++) {
            if (minTime[i] == Integer.MAX_VALUE) return -1;
            result = Math.max(result, minTime[i]);
        }
        return result;
    }
}
