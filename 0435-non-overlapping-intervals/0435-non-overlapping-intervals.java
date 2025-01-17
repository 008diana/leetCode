class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort by end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        int count = 0;
        int prevEnd = Integer.MIN_VALUE;
        
        for (int[] interval : intervals) {
            if (interval[0] >= prevEnd) {
                // No overlap, update prevEnd
                prevEnd = interval[1];
            } else {
                // Overlap found, need to remove this interval
                count++;
            }
        }
        
        return count;
    }
}