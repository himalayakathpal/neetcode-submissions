class Solution {
    public int climbStairs(int n) {
        int prev = 1;
        int prevPrev = 1;
        for (int i = 2;i<=n;i++) {
            int temp = prev+prevPrev;
            prevPrev = prev;
            prev = temp;
        }
        return prev;
    }
}
