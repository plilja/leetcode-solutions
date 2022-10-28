class Solution {
    private static final int INF = Integer.MAX_VALUE;
    private static final List<Point> DELTAS = List.of(
        new Point(1, 0, 0),
        new Point(0, 1, 0),
        new Point(-1, 0, 0),
        new Point(0, -1, 0)
    );
    
    public int shortestDistance(int[][] grid) {
        int numBuildings = 0;
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[0].length; ++x) {
                if (grid[y][x] == 1) {
                    numBuildings++;
                }
            }
        }
        int[][] buildingsVisited = new int[grid.length][grid[0].length];
        int[][] costs = new int[grid.length][grid[0].length];
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[0].length; ++x) {
                if (grid[y][x] != 1) {
                    continue;
                }
                Deque<Point> q = new ArrayDeque<>();
                q.add(new Point(x, y, 0));
                boolean[][] visited = new boolean[grid.length][grid[0].length];
                while (!q.isEmpty()) {
                    Point p = q.poll();
                    if (visited[p.y][p.x]) {
                        continue;
                    }
                    visited[p.y][p.x] = true;
                    costs[p.y][p.x] += p.dist;
                    buildingsVisited[p.y][p.x]++;
                    for (Point d : DELTAS) {
                        Point n = new Point(p.x + d.x, p.y + d.y, p.dist + 1);
                        if (n.x < 0 || n.x >= grid[0].length) {
                            continue;
                        }
                        if (n.y < 0 || n.y >= grid.length) {
                            continue;
                        }
                        if (grid[n.y][n.x] == 0 && !visited[n.y][n.x]) {
                            q.add(n);
                        }
                    }
                }
            }
        }
        int result = INF;
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[0].length; ++x) {
                if (grid[y][x] == 0 && buildingsVisited[y][x] == numBuildings) {
                    result = Math.min(result, costs[y][x]);
                }
            }
        }
        if (result == INF) {
            return -1;
        } else {
            return result;
        }
    }
    
    private record Point(int x, int y, int dist) {}
}