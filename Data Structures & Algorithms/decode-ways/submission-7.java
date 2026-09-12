class Solution {
    private boolean isValid(String s, int start, int end) {
        if(s.charAt(start) == '0') return false;
        if (start == end) return true;
        int number = (s.charAt(start)-'0') * 10 + (s.charAt(end)-'0');
        return number<=26;
    }
    public int numDecodings(String s) {
        int n = s.length();
        //int[] dp = new int[n+1];
        //dp[n] = 1;
        int one = 1;
        int two = 0;
        for (int i=n-1;i>=0;i--) {
            int temp = 0;
            if (isValid(s, i, i)) temp+= one;
            if (i<n-1 && isValid(s,i,i+1)) temp+= two;
            two = one;
            one = temp;
        }
        return one;
    }
}