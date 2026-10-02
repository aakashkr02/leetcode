import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int previousEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < previousEnd) {
                // Overlap
                count++;
            } else {
                // No overlap
                previousEnd = intervals[i][1];
            }
        }

        return count;
    }
}