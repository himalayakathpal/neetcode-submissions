class Solution {
    private static int[][] options = {{0,1},{0,-1},{1,0},{-1,0}};
    private void dfs(int i, int j, char[][] board, boolean[][] visited) {
        visited[i][j] = true;
        for (int[] option: options) {
            int newx = option[0] + i;
            int newy = option[1] + j;
            if (newx>=0 && newx<board.length && newy>=0 && newy<board[0].length && !visited[newx][newy] && board[newx][newy] =='1') {
                dfs(newx,newy, board, visited);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j] == '1' && !visited[i][j]){
                    dfs(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }
}
