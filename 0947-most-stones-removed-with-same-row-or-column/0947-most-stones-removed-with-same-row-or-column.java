class Solution {
    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < stones.length; ++i) {
            int x1 = stones[i][0];
            int y1 = stones[i][1];
            for (int j = i + 1; j < stones.length; ++j) {
                int x2 = stones[j][0];
                int y2 = stones[j][1];
                if (x1 == x2 || y1 == y2) {
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                    graph.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
                }
            }
        }
        int result = 0;
        boolean[] vis = new boolean[stones.length];
        for (int i = 0; i < stones.length; ++i) {
            if (vis[i]) {
                continue;
            }
            int size = 0;
            Deque<Integer> q = new ArrayDeque<>();
            q.add(i);
            while (!q.isEmpty()) {
                int k = q.poll();
                if (vis[k]) {
                    continue;
                }
                size++;
                vis[k] = true;
                for (int h : graph.getOrDefault(k, List.of())) {
                    if (!vis[h]) {
                        q.add(h);
                    }
                }
            }
            result += size - 1;
        }
        return result;
    }
}