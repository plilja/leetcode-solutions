class Solution {
    private static List<Point> DELTAS = List.of(
        new Point(0, 1, 0),
        new Point(0, -1, 0),
        new Point(1, 0, 0),
        new Point(-1, 0, 0)
    );
    
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<Point> bfsQueue = new ArrayDeque<>();
        var startPoint = new Point(0, 0, k);
        bfsQueue.add(startPoint);
        Map<Point, Integer> distance = new HashMap<>();
        distance.put(startPoint, 0);
        while (!bfsQueue.isEmpty()) {
            var point = bfsQueue.poll();
            int pointDistance = distance.get(point);
            for (var delta : DELTAS) {
                int x = point.x() + delta.x();
                int y = point.y() + delta.y();
                boolean yValid = y >= 0 && y < m;
                boolean xValid = x >= 0 && x < n;
                if (yValid && xValid) {
                    boolean hasObstacle = grid[y][x] == 1;
                    var neighbour = new Point(x, y, hasObstacle ? point.k() - 1 : point.k());
                    boolean alreadyVisited = false;
                    for (int i = neighbour.k(); i <= k && !alreadyVisited; ++i) {
                        alreadyVisited = distance.containsKey(new Point(x, y, i));
                    }
                    if (neighbour.k() >= 0 && !alreadyVisited) {
                        bfsQueue.add(neighbour);
                        distance.put(neighbour, pointDistance + 1);
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= k; ++i) {
            var potentialEndPoint = new Point(n -1, m - 1, i);
            result = Math.min(result, distance.getOrDefault(potentialEndPoint, Integer.MAX_VALUE));
        }
        return result != Integer.MAX_VALUE ? result : -1;
    }
    
    record Point(
        int x,
        int y,
        int k
    ) {
    }
}
