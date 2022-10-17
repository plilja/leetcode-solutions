class Solution {
    private static final int[] DX = new int[]{
        1,
        0,
        -1,
        0
    };
    private static final int[] DY = new int[]{
        0,
        1,
        0,
        -1
    };
    record Point(int x, int y) {}
    
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][];
        for (int y = 0; y < m; ++y) {
            visited[y] = new boolean[n];
        }
        
        int result = 0;
        for (int y = 0; y < m; ++y) {
            for (int x = 0; x < n; ++x) {
                if (grid[y][x] == '1' && !visited[y][x]) {
                    result++;
                    Deque<Point> q = new ArrayDeque<>();
                    q.add(new Point(x, y));
                    while(!q.isEmpty()) {
                        Point p = q.poll();
                        if (visited[p.y()][p.x()]) {
                            continue;
                        }
                        visited[p.y()][p.x()] = true;
                        for (int i = 0; i < DX.length; ++i) {
                            int dx = DX[i];
                            int dy = DY[i];
                            Point p2 = new Point(p.x() + dx, p.y() + dy);
                            if (p2.y() >= 0 && p2.y() < m && 
                                p2.x() >= 0 && p2.x() < n &&
                                grid[p2.y()][p2.x()] == '1') {
                                q.add(p2);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    
}
