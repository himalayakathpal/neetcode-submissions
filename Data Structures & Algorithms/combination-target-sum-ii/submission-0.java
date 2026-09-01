class Solution {
    public void combinationSumHelper(int[] nums, int i, List<Integer> tempList, List<List<Integer>> result, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }        
        if (target<0 || i >= nums.length) return;
        int j = i+1;
        while (j<nums.length && nums[j] == nums[i]) j++;
        combinationSumHelper(nums,j, tempList, result, target);
        tempList.add(nums[i]);
        combinationSumHelper(nums,i+1, tempList, result,target-nums[i]);
        tempList.remove(tempList.size()-1);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates,0, new ArrayList<>(), result,target);
        return result;
    }
}
