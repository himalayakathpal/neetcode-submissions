class Solution {
    public int jump(int[] nums) {
        int l = 0;
        int r = 0;

        int jumps = 0;

        while (r<nums.length-1) {
            int farthest= r;
            for (int i=l;i<=r;i++) {
                farthest = Math.max(farthest, i+nums[i]);
            }
            jumps++;
            l = r+1;
            r = farthest; 
        }


        return jumps;

    }
}
