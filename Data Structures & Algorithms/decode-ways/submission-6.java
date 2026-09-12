class Solution {
    private boolean isValid(String s, int start, int end) {
        if(s.charAt(start) == '0') return false;
        if (start == end) return true;
        int number = (s.charAt(start)-'0') * 10 + (s.charAt(end)-'0');
        return number<=26;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        for (int i=n-1;i>=0;i--) {
            for (int k = i;k<n && k<i+2;k++) {
                if (!isValid(s, i, k)) continue;
                dp[i]+= dp[k+1];
            }
        }
        return dp[0];
    }
}