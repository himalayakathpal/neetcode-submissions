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
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        return isMatchHelper(s,p,0,0, dp);
    }
}
