class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0;i<k;i++) {
            while(q.size()>0 && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
        }
        int index = 0;
        int start = 0;
        result[index] = nums[q.getFirst()];
        index++;
        for (int i = k;i<n;i++) {
            if (start == q.getFirst()) q.removeFirst();
            start++;
            while(q.size()>0 && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
            result[index] = nums[q.getFirst()];
            index++;
        }
        return result;
    }
}
