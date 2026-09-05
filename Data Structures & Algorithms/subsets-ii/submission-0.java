class Solution {
    private void subsetsHelper(int[] nums, int ind, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));
        for (int i=ind;i<nums.length;i++) {
            if (i>ind && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            subsetsHelper(nums,i+1, temp, result);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsHelper(nums,0, new ArrayList<>(), result);
        return result;       
    }
}
