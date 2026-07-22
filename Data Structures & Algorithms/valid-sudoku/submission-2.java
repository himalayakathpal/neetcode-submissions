class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>> rowsMap = new HashMap<>();
        Map<Integer,Set<Character>> colsMap = new HashMap<>();
        Map<Integer,Set<Character>> boxesMap = new HashMap<>();
        
        for (int i=0;i<board.length;i++) {
            for (int j = 0;j<board[0].length;j++) {
                if (board[i][j] == '.') continue;
                if (rowsMap.computeIfAbsent(i, k-> new HashSet<>()).contains(board[i][j])
                    || colsMap.computeIfAbsent(j, k-> new HashSet<>()).contains(board[i][j])
                    || boxesMap.computeIfAbsent((i/3)*3+j/3, k-> new HashSet<>()).contains(board[i][j])
                )
                return false;
                rowsMap.get(i).add(board[i][j]);
                colsMap.get(j).add(board[i][j]);
                boxesMap.get((i/3)*3+j/3).add(board[i][j]);
            }
        }

        return true;
    }
}
