class Solution {
    public int numSimilarGroups(String[] strs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < strs.length; ++i) {
            for (int j = i + 1; j < strs.length; ++j) {
                if (areSimilar(strs[i], strs[j])) {
                    graph.computeIfAbsent(i, k -> new HashSet<>()).add(j);
                    graph.computeIfAbsent(j, k -> new HashSet<>()).add(i);
                }
            }
        }
        Set<Integer> visited = new HashSet<>();
        int groups = 0;
        for (int i = 0; i < strs.length; ++i) {
            if (visited.contains(i)) {
                continue;
            }
            groups++;
            Deque<Integer> q = new ArrayDeque<>();
            q.add(i);
            while (!q.isEmpty()) {
                int j = q.poll();
                if (visited.contains(j)) {
                    continue;
                }
                visited.add(j);
                for (int n : graph.getOrDefault(j, Set.of())) {
                    q.add(n);
                }
            }
        }
        return groups;
    }
    
    private boolean areSimilar(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff <= 2;
    }
}