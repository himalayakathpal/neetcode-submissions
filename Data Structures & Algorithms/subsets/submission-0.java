class Solution {
    public void subsetsHelper(int[] nums, int i, List<Integer> tempList, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(tempList);
            return;
        }
        subsetsHelper(nums,i+1, tempList, result);
        List<Integer> copy = new ArrayList<>(tempList);
        copy.add(nums[i]);
        subsetsHelper(nums,i+1, copy, result);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsetsHelper(nums,0, new ArrayList<>(), result);
        return result;
    }
}
