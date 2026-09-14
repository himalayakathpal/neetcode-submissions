class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        int i=0;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        while(i<intervals.length) {
            while (i == intervals.length-1 || (i<intervals.length-1 && intervals[i][1]<intervals[i+1][0]) ) {
                    result.add(intervals[i]);
                    i++;
            }
            if (i == intervals.length) break;

            int[] newInterval = new int[] {intervals[i][0], intervals[i][1]};
            i++;
            while (i<intervals.length && newInterval[1]>=intervals[i][0]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
            result.add(newInterval);
        }

        
        return result.toArray(new int[result.size()][]);
    }
}
