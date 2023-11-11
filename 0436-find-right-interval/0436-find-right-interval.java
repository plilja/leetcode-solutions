class Solution {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> ts = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            ts.put(intervals[i][0], i);
        }
        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            var nextEntry = ts.ceilingEntry(intervals[i][1]);
            if (nextEntry != null) {
                result[i] = nextEntry.getValue();
            } else {
                result[i] = -1;
            }
        }
        return result;
    }
}
