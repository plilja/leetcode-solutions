class Solution {
    private static List<Point> DELTAS = List.of(
        new Point(1, 0, 0),
        new Point(0, 1, 0),
        new Point(-1, 0, 0),
        new Point(0, -1, 0)
    );
        
    public int swimInWater(int[][] grid) {
        int[][] results = new int[grid.length][grid[0].length];
        for (int y = 0; y < grid.length; ++y) {
            Arrays.fill(results[y], Integer.MAX_VALUE);
        }
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> {
            return a.elevation - b.elevation;
        });
        pq.add(new Point(0, 0, grid[0][0]));
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (results[p.y][p.x] <= p.elevation) {
                continue;
            }
            results[p.y][p.x] = p.elevation;
            for (Point d : DELTAS) {
                int x2 = p.x + d.x;
                int y2 = p.y + d.y;
                if (x2 < 0 || x2 >= grid[0].length) {
                    continue;
                }
                if (y2 < 0 || y2 >= grid.length) {
                    continue;
                }
                int elevation = Math.max(p.elevation, grid[y2][x2]);
                Point n = new Point(x2, y2, elevation);
                pq.add(n);
            }
        }
        return results[grid.length - 1][grid[0].length - 1];
    }
    
    private record Point(int x, int y, int elevation) {
    }
}