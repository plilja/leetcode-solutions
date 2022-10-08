class Solution {
    private static List<Point> DELTAS = List.of(
        new Point(1, 0),
        new Point(0, 1),
        new Point(-1, 0),
        new Point(0, -1)
    );
    
    public int uniquePathsIII(int[][] grid) {
        int numEmpty = 0;
        Point start = null;
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[0].length; ++x) {
                if (grid[y][x] == 0 || grid[y][x] == 2) {
                    numEmpty++;
                }
                if (grid[y][x] == 1) {
                    start = new Point(x, y);
                }
            }
        }
        return solve(grid, start, numEmpty, new HashSet<>());
        
    }
    
    public int solve(int[][] grid, Point p, int numEmpty, Set<Point> visited) {
        visited.add(p);
        int result = 0;
        for (Point d : DELTAS) {
            Point n = new Point(p.x() + d.x(), p.y() + d.y());
            if (n.x() >= 0 && n.x() < grid[0].length && n.y() >= 0 && n.y() < grid.length) {
                if (grid[n.y()][n.x()] == 0 && !visited.contains(n)) {
                    result += solve(grid, n, numEmpty - 1, visited);
                }
                if (grid[n.y()][n.x()] == 2 && numEmpty == 1) {
                    result++;
                }
            }
        }
        visited.remove(p);
        return result;
    }
    
    record Point(int x, int y) {
    }
    
}