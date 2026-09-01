class Solution {
    public void subsetsHelper(int[] nums, int i, List<Integer> tempList, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        subsetsHelper(nums,i+1, tempList, result);
        tempList.add(nums[i]);
        subsetsHelper(nums,i+1, tempList, result);
        tempList.remove(tempList.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsetsHelper(nums,0, new ArrayList<>(), result);
        return result;
    }
}
