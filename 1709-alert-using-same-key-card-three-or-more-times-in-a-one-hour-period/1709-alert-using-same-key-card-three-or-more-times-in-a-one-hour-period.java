class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, TreeSet<Integer>> nameToTimes = new HashMap<>();
        for (int i = 0; i < keyName.length; ++i) {
            String name = keyName[i];
            String time = keyTime[i];
            int minute = toMinute(time);
            TreeSet<Integer> times = nameToTimes.computeIfAbsent(name, k -> new TreeSet<>());
            times.add(minute);
        }
        Set<String> alerts = new TreeSet<>();
        for (var entry : nameToTimes.entrySet()) {
            if (entry.getValue().size() >= 3) {
                Deque<Integer> q = new ArrayDeque<>();
                for (int time : entry.getValue()) {
                    while (!q.isEmpty() && time - q.peekFirst() > 60) {
                        q.pollFirst();
                    }
                    q.add(time);
                    if (q.size() >= 3) {
                        alerts.add(entry.getKey());
                    }
                }
            }
        }
        return new ArrayList<>(alerts);
    }

    private int toMinute(String time) {
        String[] args = time.split(":");
        return 60 * Integer.parseInt(args[0]) + Integer.parseInt(args[1]);
    }
}
