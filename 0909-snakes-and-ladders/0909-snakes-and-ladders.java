class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;
        Deque<QueueItem> q = new ArrayDeque<>();
        var points = makePoints(n);
        int[] dists1 = new int[n * n + 1];
        int[] dists2 = new int[n * n + 1];
        Arrays.fill(dists1, Integer.MAX_VALUE);
        Arrays.fill(dists2, Integer.MAX_VALUE);
        q.add(new QueueItem(1, false, 0));
        while (!q.isEmpty()) {
            var item = q.poll();
            int curr = item.curr();
            int dist = item.dist;
            if (item.cameFromJump) {
                if (dists2[curr] <= dist) {
                    continue;
                }
                dists2[curr] = dist;
            } else {
                if (dists1[curr] <= dist) {
                    continue;
                }
                dists1[curr] = dist;
            }
            Point p = points.get(curr);
            if (!item.cameFromJump && board[p.y][p.x] != -1) {
                int next = board[p.y][p.x];
                q.add(new QueueItem(next, true, dist));
            } else {
                for (int next = curr + 1; next <= Math.min(curr + 6, target); ++next) {
                    q.add(new QueueItem(next, false, dist + 1));
                }
            }
        }
        if (dists1[target] == Integer.MAX_VALUE && dists2[target] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return Math.min(dists1[target], dists2[target]);
        }
    }
    
    private Map<Integer, Point> makePoints(int n) {
        Map<Integer, Point> result = new HashMap<>();
        int x = 0;
        int y = n - 1;
        int dx = 1;
        for (int curr = 1; curr <= n*n; ++curr) {
            result.put(curr, new Point(x, y));
            if (curr % n == 0) {
                dx = dx * -1;
                y--;
            } else {
                x += dx;
            }
        }
        return result;
    }
    
    private record Point(int x, int y) {}
    
    private record QueueItem(int curr, boolean cameFromJump, int dist) {}
}