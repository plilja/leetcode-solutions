class Solution {
    private static final List<Point> DELTAS = List.of(
        new Point(1, 0),
        new Point(0, 1),
        new Point(-1, 0),
        new Point(0, -1)
    );
    
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[y].length; ++x) {
                if (grid[y][x] == 0 || visited[y][x]) {
                    continue;
                }
                Deque<Point> q = new ArrayDeque<>();
                q.add(new Point(x, y));
                int island = 0;
                while (!q.isEmpty()) {
                    Point p = q.poll();
                    if (visited[p.y()][p.x()] || grid[p.y()][p.x()] == 0) {
                        continue;
                    }
                    island++;
                    visited[p.y()][p.x()] = true;
                    for (Point d : DELTAS) {
                        Point n = new Point(p.x() + d.x(), p.y() + d.y());
                        if (n.y() >= 0 && n.y() < grid.length && n.x() >= 0 && n.x() < grid[0].length) {
                            q.add(n);
                        }
                    }
                }
                result = Math.max(result, island);
            }
        }
        return result;
    }
    
    record Point(int x, int y) {}
}
