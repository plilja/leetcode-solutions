class Solution {
    public int maxEvents(int[][] eventsArr) {
        TreeMap<Integer, List<Integer>> startDayToEndDays = new TreeMap<>();
        int maxDay = Integer.MIN_VALUE;
        for (int[] e : eventsArr) {
            startDayToEndDays.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            maxDay = Math.max(maxDay, e[1]);
        }
        PriorityQueue<Integer> coursesStarted = new PriorityQueue<>();
        int day = startDayToEndDays.firstKey() - 1;
        int result = 0;
        while (day <= maxDay) {
            while (!coursesStarted.isEmpty() && coursesStarted.peek() < day) {
                coursesStarted.poll();
            }
            if (coursesStarted.isEmpty()) {
                var entry = startDayToEndDays.ceilingEntry(day);
                if (entry == null) {
                    break;
                }
                day = entry.getKey();
                coursesStarted.addAll(entry.getValue());
            }
            if (coursesStarted.isEmpty()) {
                throw new IllegalStateException();
            }
            coursesStarted.poll();
            result++;
            day++;
            var newEndDays = startDayToEndDays.get(day);
            if (newEndDays != null) {
                coursesStarted.addAll(newEndDays);
            }
        }
        return result;
    }
}