class Solution {
    private static final List<Point> MOVES = List.of(
            new Point(1, -2),
            new Point(2, -1),
            new Point(2, 1),
            new Point(1, 2),
            new Point(-1, 2),
            new Point(-2, 1),
            new Point(-2, -1),
            new Point(-1, -2)
    );

    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Deque<Point> q = new ArrayDeque<>();
        Deque<Integer> dists = new ArrayDeque<>();
        Set<Point> vis = new HashSet<>();
        q.add(new Point(0, 0));
        dists.add(0);
        while (true) {
            Point p = q.poll();
            int dist = dists.poll();
            if (p.x < -2 || p.x > x + 2 || p.y < -2 || p.y > y + 2) {
                continue;
            }
            if (vis.contains(p)) {
                continue;
            }
            vis.add(p);
            if (p.x == x && p.y == y) {
                return dist;
            }
            for (Point m : MOVES) {
                var p2 = new Point(p.x + m.x, p.y + m.y);
                q.add(p2);
                dists.add(dist + 1);
            }
        }
    }
    
    private record Point(int x, int y) {
    }
}