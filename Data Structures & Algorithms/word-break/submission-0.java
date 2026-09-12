class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        Set<String> set = new HashSet<>();
        for (String word: wordDict) set.add(word);
        dp[n] = true;
        for (int i = n-1;i>=0;i--) {
            for (int k=i;k<n;k++) {
                if (set.contains(s.substring(i,k+1)) && dp[k+1]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
