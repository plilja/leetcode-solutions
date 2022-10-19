class Solution {
    private static final List<Point> DELTAS = List.of(
        new Point(1, 0),
        new Point(0, 1),
        new Point(-1, 0),
        new Point(0, -1)
    );
    
    public int shortestBridge(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        Deque<Point> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        for (int y = 0; y < grid.length && q1.isEmpty(); ++y) {
            for (int x = 0; x < grid[y].length && q1.isEmpty(); ++x) {
                if (grid[y][x] == 1) {
                    Deque<Point> q = new ArrayDeque<>();
                    q.add(new Point(x, y));
                    while (!q.isEmpty()) {
                        Point p = q.poll();
                        q1.add(p);
                        q2.add(0);
                        vis[p.y][p.x] = true;
                        for (Point d : DELTAS) {
                            Point n = new Point(p.x + d.x, p.y + d.y);
                            if (n.x < 0 || n.x >= grid[0].length) {
                                continue;
                            }
                            if (n.y < 0 || n.y >= grid.length) {
                                continue;
                            }
                            if (grid[n.y][n.x] == 1 && !vis[n.y][n.x]) {
                                vis[n.y][n.x] = true;
                                q.add(n);
                            }
                        }
                    }
                }
            }
        }
        
        while (!q1.isEmpty()) {
            Point p = q1.poll();
            int dist = q2.poll();
            if (grid[p.y][p.x] == 0 && vis[p.y][p.x]) {
                continue;
            }
            vis[p.y][p.x] = true;
            for (Point d : DELTAS) {
                Point n = new Point(p.x + d.x, p.y + d.y);
                if (n.x < 0 || n.x >= grid[0].length) {
                    continue;
                }
                if (n.y < 0 || n.y >= grid.length) {
                    continue;
                }
                if (grid[n.y][n.x] != 0 && !vis[n.y][n.x]) {
                    return dist;
                }
                if (grid[n.y][n.x] == 0 && !vis[n.y][n.x]) {
                    q1.add(n);
                    q2.add(dist + 1);
                }
            }
        }
        return -1;
    }
    
    private record Point (int x, int y) {
        
    }
}