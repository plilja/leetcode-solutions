class Solution {
    public int minMeetingRooms(int[][] intervals) {
        TreeSet<Integer> timesOfInterest = new TreeSet<>();
        Map<Integer, Integer> meetingsDelta = new HashMap<>();
        for (int[] interval : intervals) {
            timesOfInterest.add(interval[0]);
            timesOfInterest.add(interval[1]);
            meetingsDelta.merge(interval[0], 1, (a, b) -> a + b);
            meetingsDelta.merge(interval[1], -1, (a, b) -> a + b);
        }
        int result = 0;
        int occupiedRooms = 0;
        for (int pointInTime : timesOfInterest) {
            occupiedRooms += meetingsDelta.getOrDefault(pointInTime, 0);
            result = Math.max(result, occupiedRooms);
        }
        return result;
    }
}
