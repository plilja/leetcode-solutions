class Solution {
    private static List<Point> DELTAS = List.of(
        new Point(1, 0),
        new Point(0, 1),
        new Point(-1, 0),
        new Point(0, -1)
    );
    
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] timeUntilRotten = new int[m][n];
        Deque<Point> q = new ArrayDeque<>();
        for (int y = 0; y < m; ++y) {
            for (int x = 0; x < n; ++x) {
                if (grid[y][x] == 2) {
                    q.add(new Point(x, y));
                }
            }
        }
        while (!q.isEmpty()) {
            var p = q.poll();
            int time = timeUntilRotten[p.y()][p.x()];
            for (var d : DELTAS) {
                Point e = new Point(p.x() + d.x(), p.y() + d.y());
                if (e.y() >= 0 && e.y() < m && e.x() >= 0 && e.x() < n) {
                    if (grid[e.y()][e.x()] == 1 && timeUntilRotten[e.y()][e.x()] == 0) {
                        timeUntilRotten[e.y()][e.x()] = time + 1;
                        q.add(e);
                    }
                }
            }
        }
        int result = 0;
        for (int y = 0; y < m; ++y) {
            for (int x = 0; x < n; ++x) {
                if (grid[y][x] == 1 && timeUntilRotten[y][x] == 0) {
                    return -1;
                }
                result = Math.max(result, timeUntilRotten[y][x]);
            }
        }
        return result;
    }
    
    private record Point(int x, int y) {}
}
