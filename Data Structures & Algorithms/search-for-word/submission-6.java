class Solution {
    private static int[][] option = {{0,1},{0,-1},{1,0},{-1,0}};
    private boolean existHelper(char[][] board, int x, int y, String word, int ind) {
        if (ind >= word.length()) return true;
        char temp = board[x][y];
        board[x][y] = '#';
        for (int i=0;i<4;i++) {
            int newX = x + option[i][0];
            int newY = y + option[i][1];
            if (newX>=0 && newY>=0 && newX<board.length && newY<board[0].length && board[newX][newY] == word.charAt(ind) && board[newX][newY] != '#' && existHelper(board,newX,newY, word, ind+1)) return true;
        }
        board[x][y] = temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        for (int i=0;i<board.length;i++) {
            for (int j = 0;j<board[0].length;j++) {
                if (board[i][j] == word.charAt(0) &&
                existHelper(board,i,j,word, 1)) return true;
            }
        }
        return false;
    }
}
