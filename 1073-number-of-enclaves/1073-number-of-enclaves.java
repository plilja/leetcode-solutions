import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution {
    private static final int[] DX = new int[]{1, 0, -1, 0};
    private static final int[] DY = new int[]{0, 1, 0, -1};

    record Point(int x, int y) {
    }

    public int numEnclaves(int[][] grid) {
        int result = 0;
        Set<Point> visited = new HashSet<>();
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[y].length; x++) {
                Point start = new Point(x, y);
                if (grid[y][x] == 0 || visited.contains(start)) {
                    continue;
                }
                Deque<Point> q = new ArrayDeque<>();
                q.add(start);
                boolean border = false;
                int cellsVisited = 0;
                while (!q.isEmpty()) {
                    Point p = q.poll();
                    if (visited.contains(p) || grid[p.y()][p.x()] == 0) {
                        continue;
                    }
                    cellsVisited++;
                    visited.add(p);
                    for (int i = 0; i < 4; i++) {
                        int dx = DX[i];
                        int dy = DY[i];
                        if (p.x() + dx < 0
                                || p.x() + dx >= grid[0].length
                                || p.y() + dy < 0
                                || p.y() + dy >= grid.length) {
                            border = true;
                        } else {
                            q.add(new Point(p.x() + dx, p.y() + dy));
                        }
                    }
                }
                if (!border) {
                    result += cellsVisited;
                }

            }
        }
        return result;
    }
}