class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : flights) {
            adj.get(time[0]).add(new int[] {time[1], time[2]});
        }
   
        int[] minTime = new int[n];
        for (int i = 0; i < n; i++) {
            minTime[i] = Integer.MAX_VALUE;
        }
       
        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{0,src});
        minTime[src] = 0;
        int stops = 0;

        while (pq.size()>0 && stops<= k) {
            int edgesCount = pq.size();
            while (edgesCount>0) {
                int[] curr = pq.poll();
                for (int[] edge: adj.get(curr[1])) {
                    int dest = edge[0];
                    int time = edge[1];
                    if (time+curr[0] < minTime[dest]) {
                        pq.offer(new int[] {time+curr[0], dest});
                        minTime[dest] = time+curr[0];
                    }
                } 
                edgesCount--;
            }
            stops++;
        }
        return minTime[dst] == Integer.MAX_VALUE? -1 : minTime[dst];
    }
}
