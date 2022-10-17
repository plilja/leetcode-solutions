class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int xStart = start[1];
        int yStart = start[0];
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        PriorityQueue<Point> q = new PriorityQueue<>((a, b) -> a.dist() - b.dist());
        q.add(new Point(xStart, yStart, 0));
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (visited[p.y()][p.x()]) {
                continue;
            }
            visited[p.y()][p.x()] = true;
            if (p.x() == destination[1] && p.y() == destination[0]) {
                return p.dist();
            }
            Point left = rollBall(p, -1, 0, maze);
            Point right = rollBall(p, 1, 0, maze);
            Point up = rollBall(p, 0, -1, maze);
            Point down = rollBall(p, 0, 1, maze);
            q.add(left);
            q.add(right);
            q.add(up);
            q.add(down);
        }
        return -1;
    }
    
    private Point rollBall(Point p, int dx, int dy, int[][] maze) {
        int x = p.x();
        int y = p.y();
        while (x + dx >= 0 && 
               x + dx < maze[0].length && 
               y + dy >= 0 && 
               y + dy < maze.length &&
               maze[y + dy][x + dx] == 0) {
            x += dx;
            y += dy;
        }
        int dist = p.dist() + Math.abs(p.x() - x) + Math.abs(p.y() - y);
        return new Point(x, y, dist);
    }
    
    private record Point(int x, int y, int dist) {
    }
}