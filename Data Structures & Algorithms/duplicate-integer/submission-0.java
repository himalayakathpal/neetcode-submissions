class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> alreadyPresent = new HashSet<>();
        for (int i = 0; i< nums.length;i++) {
            if (alreadyPresent.contains(nums[i])) return true;
            alreadyPresent.add(nums[i]);
        }
        return false;
    }
}