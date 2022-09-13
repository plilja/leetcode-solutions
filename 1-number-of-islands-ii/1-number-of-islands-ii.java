class Solution {
    private static List<Point> DELTAS = List.of(
        new Point(1, 0),
        new Point(0, 1),
        new Point(-1, 0),
        new Point(0, -1)
    );
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] grid = new int[m][n];
        List<Integer> result = new ArrayList<>();
        int numIslands = 0;
        int nextIsland = 1;
        for (int[] position : positions) {
            Point p = new Point(position[1], position[0]);
            if (grid[p.y()][p.x()] > 0) {
                result.add(numIslands);
                continue;
            }
            int neighbourLand = 0;
            Set<Integer> neighbourIslands = new HashSet<>();
            for (Point neigh : getNeighbourLand(grid, p)) {
                neighbourIslands.add(grid[neigh.y()][neigh.x()]);
            }
            if (neighbourIslands.isEmpty()) {
                grid[p.y()][p.x()] = nextIsland;
                nextIsland++;
                numIslands++;
                result.add(numIslands);
            } else if (neighbourIslands.size() == 1) {
                grid[p.y()][p.x()] = neighbourIslands.iterator().next();
                result.add(numIslands);
            } else {
                numIslands = numIslands - neighbourIslands.size() + 1;
                Deque<Point> q = new ArrayDeque<>();
                q.add(p);
                while (!q.isEmpty()) {
                    Point front = q.poll();
                    if (grid[front.y()][front.x()] == nextIsland) {
                        continue;
                    }
                    grid[front.y()][front.x()] = nextIsland;
                    for (Point neigh : getNeighbourLand(grid, front)) {
                        q.add(neigh);
                    }
                }
                nextIsland++;
                result.add(numIslands);
            }
        }
        return result;
    }
    
    private List<Point> getNeighbourLand(int[][] grid, Point p) {
        int m = grid.length;
        int n = grid[0].length;
        List<Point> result = new ArrayList<>();
        for (Point d : DELTAS) {
            Point neigh = new Point(p.x() + d.x(), p.y() + d.y());
            if (neigh.x() >= 0 && neigh.x() < n && neigh.y() >= 0 && neigh.y() < m) {
                if (grid[neigh.y()][neigh.x()] > 0) {
                    result.add(neigh);
                }
            }
        }
        return result;
    }
    
    private record Point(int x, int y) {
    }
}
