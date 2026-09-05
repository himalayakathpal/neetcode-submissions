class Solution {
    private boolean isValid(int[] col,int[] leftDia, int[] rightDia, int i, int j) {
        return col[j] ==0 && leftDia[i-j+col.length] == 0 && rightDia[i+j] ==0;
    }
    private void placeNQueens(int r, int n, List<StringBuilder> temp, List<List<String>> result, int[] col,int[] leftDia, int[] rightDia) {
        if (r == n) {
            List<String> cloneList = new ArrayList<>();
            for (StringBuilder cb : temp) {
                cloneList.add(new String(cb));
            }
            result.add(cloneList);
            return;
        }

        
        for (int j=0;j<n;j++) {
            if(isValid(col,leftDia, rightDia,r, j)) {
                temp.get(r).setCharAt(j,'Q');
                col[j] =1 ;
                leftDia[r-j+n] = 1;
                rightDia[r+j] = 1;
                placeNQueens(r+1,n,temp,result,col,leftDia, rightDia);
                temp.get(r).setCharAt(j,'.');
                col[j] =0 ;
                leftDia[r-j+n] = 0;
                rightDia[r+j] = 0;            }
        }
        
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<StringBuilder> temp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[] col = new int[n];
        int[] leftDia = new int[2*n];
        int[] rightDia = new int[2*n];
        for (int i=0;i<n;i++) {
            sb.append('.');
        }
        temp.add(sb);
        for (int i=0;i<n-1;i++) {
            temp.add(new StringBuilder(sb));
        }
        placeNQueens(0, n, temp, result, col, leftDia, rightDia);
        return result;
    }
}
