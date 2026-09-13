class Solution {
    public int minDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for (int i=m;i>=0;i--){
            for (int j=n;j>=0;j--) {
                if (j == n) {
                    dp[i][j] = m-i;
                    continue;
                }
                if (i == m) {
                    dp[i][j] = n-j;
                    continue;
                }

                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i+1][j+1])) +1;
                }
            }
        }

        return dp[0][0];        
    }
}
