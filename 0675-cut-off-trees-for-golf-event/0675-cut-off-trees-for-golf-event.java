class Solution {
    private static final List<Point> DELTAS = List.of(
        new Point(1, 0, 0),
        new Point(0, 1, 0),
        new Point(-1, 0, 0),
        new Point(0, -1, 0)
    );
    
    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<Integer> trees = new PriorityQueue<>();
        for (int y = 0; y < forest.size(); ++y) {
            for (int x = 0; x < forest.get(y).size(); ++x) {
                if (forest.get(y).get(x) > 1) {
                    trees.add(forest.get(y).get(x));
                }
            }
        }
        Point currentPosition = new Point(0, 0, 0);
        while (!trees.isEmpty()) {
            boolean[][] vis = new boolean[forest.size()][forest.get(0).size()];
            int tree = trees.poll();
            Deque<Point> q = new ArrayDeque<>();
            q.add(currentPosition);
            boolean reached = false;
            while (!q.isEmpty()) {
                Point p = q.poll();
                if (vis[p.y][p.x]) {
                    continue;
                }
                vis[p.y][p.x] = true;
                if (forest.get(p.y).get(p.x) == tree) {
                    currentPosition = p;
                    forest.get(p.y).set(p.x, 1);
                    reached = true;
                    break;
                }
                for (Point d : DELTAS) {
                    Point n = new Point(p.x + d.x, p.y + d.y, p.dist + 1);
                    if (n.x < 0 || n.x >= forest.get(0).size()) {
                        continue;
                    }
                    if (n.y < 0 || n.y >= forest.size()) {
                        continue;
                    }
                    if (forest.get(n.y).get(n.x) >= 1 && !vis[n.y][n.x]) {
                        q.add(n);
                    }
                }
            }
            if (!reached) {
                return -1;
            }
        }
        return currentPosition.dist;
    }
    
    private record Point(int x, int y, int dist) {
    }
}