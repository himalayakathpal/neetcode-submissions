class Solution {
    public int longestConsecutive(int[] nums) {
        int maxi = 0;
        Map<Integer, Boolean> mp = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            mp.put(nums[i], false);
        }
        for (int i=0;i<nums.length;i++) {
            if(!mp.containsKey(nums[i]-1)) mp.put(nums[i], true); 
        }   
        for (int i=0;i<nums.length;i++) {
            if (mp.get(nums[i])) {
                int start = nums[i];
                int count = 1;
                while (mp.containsKey(start+1)) {
                    count++;
                    start++;
                }
                maxi = Math.max(maxi, count);
            }
        } 

        return maxi;

    }
}
