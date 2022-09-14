class Solution {
    private static final List<Point> DELTAS = List.of(
        new Point(1, 0, 0),
        new Point(0, 1, 0),
        new Point(-1, 0, 0),
        new Point(0, -1, 0)
    );
        
    public int[][] updateMatrix(int[][] mat) {
        int[][] dists = initializeDistMatrix(mat);
        Deque<Point> q = new ArrayDeque<>();
        for (int y = 0; y < mat.length; ++y) {
            for (int x = 0; x < mat[y].length; ++x) {
                if (mat[y][x] == 0) {
                    q.add(new Point(x, y, 0));
                }
            }
        }
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (dists[p.y()][p.x()] != -1) {
                continue;
            }
            dists[p.y()][p.x()] = p.dist();
            for (Point d : DELTAS) {
                Point n = new Point(p.x() + d.x(), p.y() + d.y(), p.dist() + 1);
                if (n.x() >= 0 && n.x() < mat[0].length && n.y() >= 0 && n.y() < mat.length) {
                    q.add(n);
                }
            }
        }
        return dists;
    }
    
    private int[][] initializeDistMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        for (int y = 0; y < mat.length; ++y) {
            for (int x = 0; x < mat[0].length; ++x) {
                result[y][x] = -1;
            }
        }
        return result;
    }
    
    private record Point(int x, int y, int dist) {
    }
}
