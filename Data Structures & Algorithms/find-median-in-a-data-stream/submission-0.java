class MedianFinder {
    PriorityQueue<Integer> maxQueue;
    PriorityQueue<Integer> minQueue;
    public MedianFinder() {
        maxQueue = new PriorityQueue<>((a,b) -> b-a);
        minQueue = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (minQueue.size() >0 && minQueue.peek()<num) {
            minQueue.offer(num);
            if (minQueue.size() - maxQueue.size()>1) {
                maxQueue.offer(minQueue.poll());
            } 
        }else {
            maxQueue.offer(num);
            if (maxQueue.size()-minQueue.size()>1) {
                minQueue.offer(maxQueue.poll());
            }
        }
        
    }
    
    public double findMedian() {
        int totalSize = maxQueue.size() + minQueue.size();
        if (totalSize%2==0) {
            return (double) (maxQueue.peek() + minQueue.peek())/2;
        } 
        return maxQueue.size() > minQueue.size() ? maxQueue.peek() : minQueue.peek();
    }
}
