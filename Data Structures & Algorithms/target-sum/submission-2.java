class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> prev = new HashMap<>();

        prev.put(target,1);
        for (int i = n-1;i>=0;i--) {
            Map<Integer, Integer> curr = new HashMap<>();
            for (Map.Entry<Integer,Integer> entry: prev.entrySet()) {
                int ways = entry.getValue();
                int sum = entry.getKey();
                curr.put(sum+nums[i], curr.getOrDefault(sum+nums[i],0) + ways);
                curr.put(sum-nums[i], curr.getOrDefault(sum-nums[i],0) + ways);
            }
            prev = curr;
        }
        return prev.getOrDefault(0,0);
    }
}
