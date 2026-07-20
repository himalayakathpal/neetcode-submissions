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

        int rowStart = 0;
        while(rowStart<=6) {
            int colStart = 0;
            while(colStart<=6){
                int[] count = new int[10];
                for (int i=rowStart;i<rowStart+3;i++) {
                    for (int j=colStart;j<colStart+3;j++) {
                                        if (board[i][j] == '.') continue;
                        if (count[board[i][j]-'0']>0) return false;
                                        count[board[i][j]-'0']++;

                    }
                }
                colStart+=3;
            }
            rowStart+=3;
        }
        return true;
    }
}
