class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a,b) -> (b[0]*b[0] + b[1]*b[1]) -(a[0]*a[0] + a[1]*a[1]));
        int n = points.length;
        for (int i = 0;i<n;i++) {
            pq.offer(new Integer[] {points[i][0],points[i][1]});
            if (pq.size()>k) pq.poll();
        }

        int[][] result = new int[k][2];
        int i=0;
        while (pq.size()>0) {
            Integer[] temp = pq.poll();
            result[i][0] = temp[0];
            result[i][1] = temp[1];
            i++;
        }
        return result;

    }
}
