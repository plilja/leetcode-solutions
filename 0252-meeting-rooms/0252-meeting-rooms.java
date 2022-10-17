class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        for (int i = 0; i < intervals.length; ++i) {
            int[] interval1 = intervals[i];
            for (int j = i + 1; j < intervals.length; ++j) {
                int[] interval2 = intervals[j];
                if (overlaps(interval1, interval2)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean overlaps(int[] interval1, int[] interval2) {
        int x1 = interval1[0];
        int y1 = interval1[1];
        int x2 = interval2[0];
        int y2 = interval2[1];
        if (x1 <= x2 && y1 > x2) {
            return true;
        }
        if (x2 <= x1 && y2 > x1) {
            return true;
        }
        return false;
    }
}
