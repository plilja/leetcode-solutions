class Solution {
    record Interval(int start, int end) implements Comparable<Interval> {
        @Override
        public int compareTo(Interval other) {
            if (start != other.start) {
                return start - other.start;
            } else {
                return end - other.end;
            }
        }
        
    }
    
    public int[][] merge(int[][] intervalsArr) {
        List<Interval> intervals = new ArrayList<>();
        for (int[] interval : intervalsArr) {
            intervals.add(new Interval(interval[0], interval[1]));
        }
        Collections.sort(intervals);
        List<Interval> result = new ArrayList<>();
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); ++i) {
            Interval last = result.get(result.size() - 1);
            Interval interval = intervals.get(i);
            if (overlaps(last, interval)) {
                Interval merged = new Interval(
                    Math.min(last.start(), interval.start()), 
                    Math.max(last.end(), interval.end())
                );
                result.set(result.size() - 1, merged);
            } else {
                result.add(interval);
            }
        }
        return toArray(result);
    }
    
    private boolean overlaps(Interval a, Interval b) {
        if (a.start() <= b.start() && a.end() >= b.start()) {
            return true;
        }
        if (b.start() <= a.start() && b.end() >= a.start()) {
            return true;
        }
        return false;
    }
    
    private int[][] toArray(List<Interval> intervals) {
        int[][] result = new int[intervals.size()][2];
        for (int i = 0; i < intervals.size(); ++i) {
            var interval = intervals.get(i);
            result[i][0] = interval.start();
            result[i][1] = interval.end();
        }
        return result;
    }
    
}
