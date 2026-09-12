class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : times) {
            adj.get(time[0]).add(new int[] {time[1], time[2]});
        }
   
        int[] minTime = new int[n+1];
        for (int i = 0; i <= n; i++) {
            minTime[i] = Integer.MAX_VALUE;
        }
       
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{0,k});
        minTime[k] = 0;

        while (pq.size()>0) {
            int[] curr = pq.poll();
            for (int[] edge: adj.get(curr[1])) {
                int dest = edge[0];
                int time = edge[1];
                if (time+curr[0] < minTime[dest]) {
                    pq.offer(new int[] {time+curr[0], dest});
                    minTime[dest] = time+curr[0];
                }
            } 
        }
       
        int result = -1;
        for (int i = 1; i <= n; i++) {
            if (minTime[i] == Integer.MAX_VALUE) return -1;
            result = Math.max(result, minTime[i]);
        }
        return result;
    }
}
