class Solution {
    private static int[][] options = {{0,1},{0,-1},{1,0},{-1,0}};
    private static int maxArea = 0;
    private int dfs(int i, int j, int[][] board, boolean[][] visited) {
        visited[i][j] = true;
        int count = 1;
        for (int[] option: options) {
            int newx = option[0] + i;
            int newy = option[1] + j;
            if (newx>=0 && newx<board.length && newy>=0 && newy<board[0].length && !visited[newx][newy] && board[newx][newy] ==1) {
                count+=dfs(newx,newy, board, visited);
            }
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j] == 1 && !visited[i][j]){
                    int count = dfs(i, j, grid, visited);
                    maxArea = Math.max(maxArea, count);
                }
            }
        }
        return maxArea;
    }
}
