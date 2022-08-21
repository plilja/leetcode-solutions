class Solution {
    private static int EMPTY_ROOM = Integer.MAX_VALUE;
    private static int GATE = 0;
    private static int WALL = -1;
    
    private static List<Point> DELTAS = List.of(
        new Point(1, 0),
        new Point(0, 1),
        new Point(-1, 0),
        new Point(0, -1)
    );
    
    public void wallsAndGates(int[][] rooms) {
        Deque<Point> q = new ArrayDeque<>();
        for (int y = 0; y < rooms.length; ++y) {
            for (int x = 0; x < rooms[y].length; ++x) {
                if (rooms[y][x] == GATE) {
                    q.add(new Point(x, y));
                }
            }
        }
        while (!q.isEmpty()) {
            Point p = q.poll();
            int dist = rooms[p.y()][p.x()];
            for (Point d : DELTAS) {
                Point n = new Point(p.x() + d.x(), p.y() + d.y());
                if (n.x() >= 0 && n.x() < rooms[0].length && n.y() >= 0 && n.y() < rooms.length) {
                    if (rooms[n.y()][n.x()] == EMPTY_ROOM) {
                        rooms[n.y()][n.x()] = dist + 1;
                        q.add(n);
                    }
                }
            }
        }
        
    }
    
    private record Point(int x, int y) {}
}
