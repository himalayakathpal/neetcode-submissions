class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rowArray = new int[board.length];
        int[] colArray = new int[board[0].length];
        int[] boxArray = new int[board.length];

        for (int i=0;i<board.length;i++) {
            for (int j = 0;j<board[0].length;j++) {
                if (board[i][j] == '.') continue;
                int val = board[i][j] - '1';
                if ((rowArray[i] & (1<<val)) >0 ||
                    (colArray[j] & (1<<val)) >0 ||
                    (boxArray[i/3*3+j/3] & (1<<val)) >0) 
                return false;
                rowArray[i] |= 1<<val;
                colArray[j] |= 1<<val;
                boxArray[i/3*3+j/3] |= 1<<val;
            }
        }

        return true;
    }
}
