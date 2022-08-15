class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> managerToSubordinates = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int m = manager[i];
            managerToSubordinates.computeIfAbsent(m, k -> new ArrayList<>()).add(i);
        }
        Map<Integer, Integer> informedAt = new HashMap<>();
        Deque<Integer> q = new ArrayDeque<>();
        q.add(headID);
        informedAt.put(headID, 0);
        while (!q.isEmpty()) {
            int employeeId = q.poll();
            int time = informedAt.get(employeeId) + informTime[employeeId];
            for (int subordinate : managerToSubordinates.getOrDefault(employeeId, List.of())) {
                informedAt.put(subordinate, time);
                q.add(subordinate);
            }
        }
        int result = 0;
        for (int t : informedAt.values()) {
            result = Math.max(t, result);
        }
        return result;
    }
}
