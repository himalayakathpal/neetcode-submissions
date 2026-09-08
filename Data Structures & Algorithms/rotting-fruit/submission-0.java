class QueueElement {
    int i;
    int j;
    int dist;
    QueueElement(int x, int y, int d) {
        i = x;
        j = y;
        dist = d;
    }
}
class Solution {
    public static int[][] options = {{0,1},{0,-1},{1,0},{-1,0}};
    public int orangesRotting(int[][] grid) {
        int minTime = 0;
        Queue<QueueElement> q = new LinkedList<>();
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j] == 2) q.offer(new QueueElement(i,j, 0));
            }
        }
        while (!q.isEmpty()) {
            QueueElement temp = q.poll();
            for (int i=0;i<4;i++) {
                int nextI = temp.i+options[i][0];
                int nextJ =  temp.j+options[i][1];
                if (nextI>=0 && nextI<grid.length && nextJ>=0 && nextJ<grid[0].length && grid[nextI][nextJ] == 1) {
                    grid[nextI][nextJ] = 2;
                    q.offer(new QueueElement(nextI, nextJ, temp.dist+1));
                    minTime = Math.max(minTime, temp.dist+1);
                }
            }
        }

        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return minTime;
    }
}
