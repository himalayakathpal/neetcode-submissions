class Solution {
    private static int[][] options = {{0,1},{0,-1},{-1,0},{1,0}};
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] gridTime = new int[m][n];
        for (int i = 0;i<m;i++) {
            Arrays.fill(gridTime[i],-1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{grid[0][0],0,0});

        while (pq.size()>0) {
            int[] curr = pq.poll();
            if (gridTime[curr[1]][curr[2]] != -1) continue;
            gridTime[curr[1]][curr[2]] = curr[0];
            for (int[] option: options) {
                int destX = option[0] + curr[1];
                int destY = option[1] + curr[2];
                if (destX <0 || destX>=m || destY<0 || destY>=n ||gridTime[destX][destY] != -1) continue;
                int time = Math.max(curr[0], grid[destX][destY]);
                pq.offer(new int[] {time, destX, destY});
            } 
        }

        return gridTime[m-1][n-1];
    }
}
