class Solution {
    public int leastInterval(char[] tasks, int n) {
      int[] freq = new int[26];
      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
      Queue<int[]> q = new LinkedList<>();
      for (char task: tasks) {
        freq[task-'A']++;
      }  
      
      for (int count: freq) {
        if (count>0) pq.offer(count);
      }


      int time = 0;
      while (!pq.isEmpty() || !q.isEmpty() ){
        time++;
        if (!pq.isEmpty()) {
            int remCount = pq.poll();
            if (remCount>1) {
                q.offer(new int[]{remCount-1, time+n});
            }
        }

        if (!q.isEmpty() && time == q.peek()[1]) {
            pq.offer(q.poll()[0]);
        }
      }

      return time;


    }
}
