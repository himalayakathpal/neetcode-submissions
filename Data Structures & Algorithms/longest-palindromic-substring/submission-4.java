class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int startIndex = -1;
        int maxLength = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i =n-1 ;i>=0;i--) {
            for (int j=i;j<n;j++) {
                if ((j-i<=2 || dp[i+1][j-1]) && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (j-i+1 > maxLength) {
                        startIndex = i;
                        maxLength = j-i+1;
                    }
                } 
            }
        }
        return s.substring(startIndex, startIndex+maxLength);
    }
}
