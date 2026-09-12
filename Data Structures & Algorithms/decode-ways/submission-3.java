class Solution {
    private boolean isValid(String s, int start, int end) {
        String subs = s.substring(start, end+1);
        if(subs.charAt(0) == '0') return false;
        int number = Integer.parseInt(subs);
        if (number<1 || number>26) return false;
        return true;
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