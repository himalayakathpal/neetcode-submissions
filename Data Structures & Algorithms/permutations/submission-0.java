class Solution {
    private void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    public void permuteHelper(int[] nums, int i, List<List<Integer>> result) { 
        if (i == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;  
        }
        for (int j = i;j<nums.length;j++) {
            swap(nums,i,j);
            permuteHelper(nums, i+1, result);
            swap(nums,i,j);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums,0, result);
        return result;    }
}
