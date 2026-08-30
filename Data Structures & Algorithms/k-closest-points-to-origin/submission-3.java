class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (b[0]*b[0] + b[1]*b[1]) -(a[0]*a[0] + a[1]*a[1]));
        int n = points.length;
        for (int i = 0;i<n;i++) {
            pq.offer(points[i]);
            if (pq.size()>k) pq.poll();
        }

        int[][] result = new int[k][2];
        int i=0;
        while (pq.size()>0) {
            result[i++] = pq.poll();
        }
        return result;

    }
}
