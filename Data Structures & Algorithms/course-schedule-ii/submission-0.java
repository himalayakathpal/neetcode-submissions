class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0;i<numCourses;i++) {
            adjList.add(new ArrayList<>());
        }
        int[] inCount = new int[numCourses];
        for (int[] preReq : prerequisites) {
            adjList.get(preReq[1]).add(preReq[0]);
            inCount[preReq[0]]++;
        }

        for (int i = 0;i<numCourses;i++) {
            if (inCount[i] == 0) q.offer(i);
        }
        int[] result = new int[numCourses];
        int index = 0;

        while (!q.isEmpty()) {
            int temp = q.poll();
            result[index++] = temp;
            for (int node : adjList.get(temp)) {
                inCount[node]--;
                 if (inCount[node] == 0) q.offer(node);
            }
        }
        return index == numCourses? result : new int[0];


    }
}
