class Solution {
    public void combinationSumHelper(int[] nums, int i, List<Integer> tempList, List<List<Integer>> result, int target) {
        if (target<0 || i == nums.length) return;
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        combinationSumHelper(nums,i+1, tempList, result, target);
        tempList.add(nums[i]);
        combinationSumHelper(nums,i, tempList, result,target-nums[i]);
        tempList.remove(tempList.size()-1);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(nums,0, new ArrayList<>(), result,target);
        return result;
    }
}
