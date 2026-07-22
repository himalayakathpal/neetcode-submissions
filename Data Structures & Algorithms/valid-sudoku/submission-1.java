class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i=0;i<9;i++) {
            int[] count = new int[10];
            for (int j=0;j<9;j++) {
                if (board[i][j] == '.') continue;
                if (count[board[i][j]-'0']>0) return false;
                count[board[i][j]-'0']++;
            }
        }

        for (int i=0;i<9;i++) {
            int[] count = new int[10];
            for (int j=0;j<9;j++) {
                                if (board[j][i] == '.') continue;
                if (count[board[j][i]-'0']>0) return false;
                                count[board[j][i]-'0']++;

            }
        }

        int boxNumber = 0;
        while(boxNumber<=8) {
            int[] count = new int[10];
            for (int i=0;i<3;i++) {
                for (int j=0;j<3;j++) {
                    int row = i+ (boxNumber/3) * 3;
                    int col = j+ (boxNumber%3) * 3;
                    if (board[row][col] == '.') continue;
                    if (count[board[row][col]-'0']>0) return false;
                    count[board[row][col]-'0']++;

                }
            }
            boxNumber++;
        }
        return true;
    }
}
