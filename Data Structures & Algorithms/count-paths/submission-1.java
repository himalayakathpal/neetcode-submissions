class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        int[] curr = new int[n];
        for (int i=m-1;i>=0;i--) {
            for (int j=n-1;j>=0;j--) {
                if (i == m-1 && j == n-1) {
                    curr[j] = 1;
                    continue;
                }
                if (i == m-1) {
                    curr[j] = curr[j+1];
                    continue;
                }
                if (j == n-1) {
                    curr[j] = prev[j];
                    continue;                    
                }
                curr[j] = curr[j+1] + prev[j];
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[0];
    }
}
