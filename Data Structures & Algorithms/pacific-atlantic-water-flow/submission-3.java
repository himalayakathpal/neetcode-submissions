class Solution {
    private static int[][] options = {{0,1},{0,-1},{1,0},{-1,0}};
    private void dfs(int i, int j, int[][] board, boolean[][] canReach, int prev) {
        if(i<0 || j<0) {
            return;
        }
        if (i>=board.length || j>=board[0].length) {
            return;
        }
        if (canReach[i][j]) return;
        if (board[i][j]<prev) return;
        canReach[i][j] = true;
        for (int[] option: options) {
            int newx = option[0] + i;
            int newy = option[1] + j;
            dfs(newx,newy, board, canReach, board[i][j]);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] canReachPacific = new boolean[heights.length][heights[0].length];
        boolean[][] canReachAtlantic = new boolean[heights.length][heights[0].length];
        for (int j=0;j<heights[0].length;j++) {
            dfs(0, j, heights,canReachPacific, Integer.MIN_VALUE);
            dfs(rows-1, j, heights,canReachAtlantic, Integer.MIN_VALUE);
        }
        for (int j=0;j<heights.length;j++) {
            dfs(j, 0, heights,canReachPacific, Integer.MIN_VALUE);
            dfs(j, cols-1, heights,canReachAtlantic,Integer.MIN_VALUE);
        }
        for (int i = 0;i<rows;i++) {
            for (int j = 0;j<cols;j++) {
                if (canReachPacific[i][j] && canReachPacific[i][j] == canReachAtlantic[i][j]) {
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;        
    }
}
