class Solution {
    private static List<Point> DELTAS = List.of(
        new Point(1, 0),
        new Point(0, 1),
        new Point(-1, 0),
        new Point(0, -1)
    );
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int origColor = image[sr][sc];
        if (origColor == color) {
            return image;
        }
        Deque<Point> q = new ArrayDeque<>();
        q.add(new Point(sc, sr));
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (image[p.y()][p.x()] != origColor) {
                continue;
            }
            image[p.y()][p.x()] = color;
            for (Point d : DELTAS) {
                Point n = new Point(p.x() + d.x(), p.y() + d.y());
                if (n.x() >= 0 && n.x() < image[0].length && n.y() >= 0 && n.y() < image.length) {
                    q.add(n);
                }
            }
        }
        return image;
    }
    
    record Point(int x, int y) {}
}
