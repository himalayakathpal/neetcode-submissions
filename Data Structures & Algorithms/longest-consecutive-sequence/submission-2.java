class Solution {
    public int longestConsecutive(int[] nums) {
        int maxCount = 0;
        Set<Integer> mp = new HashSet<>();
        for (int i =0 ; i<nums.length; i++) {
            mp.add(nums[i]);
        }

        for (int i =0 ; i<nums.length; i++) {
            int temp = 0;
            int tempN = nums[i];
            if (!mp.contains(tempN-1)) {
                while(mp.contains(tempN)) {
                temp++;
                mp.remove(tempN);
                tempN++;
                }
            }
            maxCount = Math.max(maxCount, temp);

        }

        return maxCount;

    }
}
