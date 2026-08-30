class KthLargest {
    PriorityQueue<Integer> pq;
    int maxSize;
    public KthLargest(int k, int[] nums) {
        // NlogN for insertion of elements Max Heap 
        //NlogK if min Heap
        pq = new PriorityQueue<>();
        maxSize = k;

        for (int i=0;i<nums.length;i++) {
            if (i<k) pq.offer(nums[i]);
            else if (i>=k && nums[i]>pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        // LogN + KLogN
        //LogK + LogK
        if (pq.size() < maxSize) pq.offer(val);
        else if (val>pq.peek()) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}
