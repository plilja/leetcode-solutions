class Solution {
    private static final List<Point> DELTAS = List.of(
        new Point(1, 0),
        new Point(0, 1),
        new Point(-1, 0),
        new Point(0, -1)
    );
    
    public int numDistinctIslands(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        Set<Set<Point>> islands = new HashSet<>();
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[0].length; ++x) {
                if (grid[y][x] == 0 || vis[y][x]) {
                    continue;
                }
                Set<Point> island = new HashSet<>();
                Deque<Point> q = new ArrayDeque<>();
                q.add(new Point(x, y));
                while (!q.isEmpty()) {
                    Point p = q.poll();
                    if (vis[p.y][p.x]) {
                        continue;
                    }
                    vis[p.y][p.x] = true;
                    island.add(new Point(p.x - x, p.y - y));
                    for (Point d : DELTAS) {
                        Point n = new Point(p.x + d.x, p.y + d.y);
                        if (n.x < 0 || n.x >= grid[0].length) {
                            continue;
                        }
                        if (n.y < 0 || n.y >= grid.length) {
                            continue;
                        }
                        if (grid[n.y][n.x] == 1 && !vis[n.y][n.x]) {
                            q.add(n);
                        }
                    }
                }
                islands.add(island);
            }
        }
        return islands.size();
    }
    
    private record Point(int x, int y) {
    }
}