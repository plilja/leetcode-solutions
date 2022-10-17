class Solution {
    private static int MIDNIGHT = toMinutesSinceMidnight("24:00");
    
    public int findMinDifference(List<String> timePoints) {
        List<Integer> times = timePoints.stream()
            .map(t -> toMinutesSinceMidnight(t))
            .sorted((a, b) -> a - b)
            .collect(Collectors.toList());
        int result = diff(times.get(0), times.get(times.size() - 1));
        for (int i = 0; i < times.size() - 1; ++i) {
            result = Math.min(result, diff(times.get(i), times.get(i + 1)));
        }
        return result;
    }
    
    private int diff(int minutesSinceMidnight1, int minutesSinceMidnight2) {
        if (minutesSinceMidnight2 < minutesSinceMidnight1) {
            return diff(minutesSinceMidnight2, minutesSinceMidnight1);
        }
        int result1 = minutesSinceMidnight2 - minutesSinceMidnight1;
        int result2 = minutesSinceMidnight1 + (MIDNIGHT - minutesSinceMidnight2);
        return Math.min(result1, result2);
    }
    
    private static int toMinutesSinceMidnight(String time) {
        String[] args = time.split(":");
        return 60 * Integer.parseInt(args[0]) + Integer.parseInt(args[1]);
    }
}
