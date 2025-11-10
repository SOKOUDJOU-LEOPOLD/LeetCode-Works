import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        // Sort the intervals by their start time
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);

        List<int[]> results = new ArrayList<>();
        results.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = results.get(results.size() - 1);
            int[] current = intervals[i];

            if (current[0] <= last[1]) {
                // Merge intervals
                last[1] = Math.max(last[1], current[1]);
            } else {
                results.add(current);
            }
        }

        // Convert the list back to a 2D array
        return results.toArray(new int[0][0]); // the toArray method should take a multidimensional array with size 0
    }
}