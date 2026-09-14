/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<int[]> events  = new ArrayList<>();
        for (Interval i: intervals){
            events.add(new int[]{i.start, 1});
            events.add(new int[]{i.end,-1});
        }
        Collections.sort(events, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int count=0;
        int maxCount= 0;

        for (int[] event : events) {
            count+= event[1];
            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }
}
