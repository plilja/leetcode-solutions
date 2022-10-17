class Solution {
    private static final List<Point> DELTAS = List.of(
        new Point(1, 0),
        new Point(0, 1),
        new Point(-1, 0),
        new Point(0, -1)
    );
    
    public int getFood(char[][] grid) {
        Deque<Point> q = new ArrayDeque<>();
        int[][] dists = new int[grid.length][grid[0].length];
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[y].length; ++x) {
                dists[y][x] = -1;
                if (grid[y][x] == '*') {
                    q.add(new Point(x, y));
                    dists[y][x] = 0;
                }
            }
        }
        while (!q.isEmpty()) {
            Point p = q.poll();
            int dist = dists[p.y()][p.x()];
            for (Point d : DELTAS) {
                Point n = new Point(p.x() + d.x(), p.y() + d.y());
                if (n.x() >= 0 && n.x < grid[0].length && n.y() >= 0 && n.y() < grid.length) {
                    char c = grid[n.y()][n.x()];
                    if (c == '#') {
                        return dist + 1;
                    }
                    if (c == 'O' && dists[n.y()][n.x()] == -1) {
                        dists[n.y()][n.x()] = dist + 1;
                        q.add(n);
                    }
                    
                }
            }
            
        }
        return -1;
    }
    
    record Point(int x, int y) {
    }
}
