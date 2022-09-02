class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int result = 0;
        for (int i = 0; i < isConnected.length; ++i) {
            if (visited[i]) {
                continue;
            }
            result++;
            Deque<Integer> q = new ArrayDeque<>();
            q.add(i);
            visited[i] = true;
            while (!q.isEmpty()) {
                int n = q.poll();
                for (int j = 0; j < isConnected.length; ++j) {
                    if (isConnected[n][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        q.add(j);
                    }
                }
            }
        }
        return result;
    }
}
