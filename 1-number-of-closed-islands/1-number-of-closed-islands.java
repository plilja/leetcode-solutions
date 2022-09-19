class Solution {
    private static List<Point> DELTAS = List.of(
        new Point(1, 0),
        new Point(0, 1),
        new Point(-1, 0),
        new Point(0, -1)
    );
    
    public int closedIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[y].length; ++x) {
                if (visited[y][x] || grid[y][x] == 1) {
                    continue;
                }
                boolean surrounded = true;
                Deque<Point> q = new ArrayDeque<>();
                q.add(new Point(x, y));
                while (!q.isEmpty()) {
                    Point p = q.poll();
                    if (visited[p.y()][p.x()]) {
                        continue;
                    }
                    visited[p.y()][p.x()] = true;
                    for (Point d : DELTAS) {
                        Point n = new Point(p.x() + d.x(), p.y() + d.y());
                        if (n.x() >= 0 && n.x() < grid[0].length && n.y() >= 0 && n.y() < grid.length) {
                            int v = grid[n.y()][n.x()];
                            if (v == 0) {
                                q.add(n);
                            }
                        } else {
                            surrounded = false;
                        }
                    }
                }
                if (surrounded) {
                    result++;
                }
            }
        }
        return result;
    }
    
    private record Point(int x, int y) {
        
    }
}
