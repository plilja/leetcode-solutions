class Solution {
    
    record Point(
        int x,
        int y
    ) {
    }
    record QueueItem(
        int cost,
        Point point
    ) {
    }
    
    private static List<Point> DELTAS = List.of(
        new Point(1, 0),
        new Point(0, 1),
        new Point(-1, 0),
        new Point(0, -1)
    );
    
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<QueueItem> queue = new PriorityQueue<>((a, b) -> a.cost() - b.cost());
        queue.add(new QueueItem(0, new Point(0, 0)));
        int[][] costs = new int[heights.length][];
        for (int y = 0; y < heights.length; ++y) {
            costs[y] = new int[heights[y].length];
            for (int x = 0; x < heights[y].length; ++x) {
                costs[y][x] = -1;
            }
        }
        while (!queue.isEmpty()) {
            var item = queue.poll();
            var p = item.point();
            if (costs[p.y()][p.x()] != -1) {
                if (costs[p.y()][p.x()] > item.cost()) {
                    throw new IllegalStateException("Smaller cost visited later in queue");
                }
                continue;
            }
            costs[p.y()][p.x()] = item.cost();
            
            for (var d : DELTAS) {
                var n = new Point(p.x() + d.x(), p.y() + d.y());
                if (n.y() >= 0 && n.y() < heights.length && 
                   n.x() >= 0 && n.x() < heights[0].length) {
                    int heightDiff = Math.abs(heights[p.y()][p.x()] - heights[n.y()][n.x()]);
                    queue.add(new QueueItem(Math.max(item.cost(), heightDiff), n));
                }
            }
        }
        return costs[heights.length - 1][heights[0].length - 1];
    }
}
