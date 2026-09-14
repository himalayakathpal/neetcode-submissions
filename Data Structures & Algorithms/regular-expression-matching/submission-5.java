class Solution {
    public boolean isMatchHelper(String s, String p, int si, int pi, Boolean[][] dp) {
        if (pi == p.length()) return si == s.length();
        if (dp[si][pi] != null) return dp[si][pi];
        boolean match = si<s.length() && (p.charAt(pi) == '.' || p.charAt(pi) == s.charAt(si));
        if (pi< p.length()-1 && p.charAt(pi+1)  == '*' ) {
            if (!match){
                dp[si][pi] = isMatchHelper(s,p,si,pi+2, dp);
                return dp[si][pi];
            } 
            dp[si][pi] = isMatchHelper(s,p,si,pi+2, dp) || isMatchHelper(s,p,si+1,pi, dp);
            return dp[si][pi];
        } 
        dp[si][pi] =  match && isMatchHelper(s,p,si+1,pi+1, dp);
        return dp[si][pi];
    }
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[m][n] = true;
        for (int i=m;i>=0;i--) {
            for (int j=n-1;j>=0;j--) {
                boolean match = i<m && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i));
                if (j< p.length()-1 && p.charAt(j+1)  == '*' ) {
                    if (!match){
                        dp[i][j] = dp[i][j+2];
                    } else {
                        dp[i][j] = dp[i][j+2] || dp[i+1][j];
                    }
                } else dp[i][j] =  match && dp[i+1][j+1];                   
            }
        }
        return dp[0][0];
    }
}
