class KthLargest {
    PriorityQueue<Integer> pq;
    int maxSize;
    public KthLargest(int k, int[] nums) {
        // NlogN for insertion of elements Max Heap 
        //NlogK if min Heap
        pq = new PriorityQueue<>();
        maxSize = k;

        for (int i=0;i<nums.length;i++) {
            pq.offer(nums[i]);
            if (pq.size() > maxSize) {
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        // LogN + KLogN
        //LogK + LogK
        pq.offer(val);
        if (pq.size()>maxSize) {
            pq.poll();
        }
        return pq.peek();
    }
}
