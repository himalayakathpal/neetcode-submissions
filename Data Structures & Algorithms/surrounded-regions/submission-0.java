class Solution {
    private static int[][] options = {{0,1},{0,-1},{1,0},{-1,0}};
    private void dfs(int i, int j, char[][] board) {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] == '#' || board[i][j] == 'X') {
            return;
        }
        board[i][j] = '#';
        for (int[] option: options) {
            int newx = option[0] + i;
            int newy = option[1] + j;
            dfs(newx,newy, board);
        }
    }
    public void solve(char[][] board) {
        for (int i = 0;i<board.length;i++) {
            for (int j = 0;j<board[0].length;j++) {
                if ((i ==0 || i== board.length-1 || j ==0 || j== board[0].length-1) && board[i][j] == 'O') {
                    dfs(i,j,board);
                }
            }
        } 
        for (int i = 0;i<board.length;i++) {
            for (int j = 0;j<board[0].length;j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        } 

    }
}
