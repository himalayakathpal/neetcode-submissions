class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        //int[] dp = new int[n+1];
        int two = 0;
        int one = cost[n-1];
        for (int i = n-2;i>=0;i--) {
            int temp = cost[i] + Math.min(one, two);
            two = one;
            one = temp;
        }
        return Math.min(one, two);  
    }
}
