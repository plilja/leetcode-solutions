class Solution {
    private static final int[] DXS = new int[]{1, 1, 0, -1, -1, -1,  0,  1};
    private static final int[] DYS = new int[]{0, 1, 1,  1,  0, -1, -1, -1};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        Deque<Integer> qx = new ArrayDeque<>();
        Deque<Integer> qy = new ArrayDeque<>();
        Deque<Integer> qd = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        qx.add(0);
        qy.add(0);
        qd.add(1);
        while (!qx.isEmpty()) {
            int x = qx.poll();
            int y = qy.poll();
            int d = qd.poll();
            if (visited[y][x]) {
                continue;
            }
            visited[y][x] = true;
            if (x == grid[0].length - 1 && y == grid.length - 1) {
                return d;
            }
            for (int i = 0; i < DXS.length; ++i) {
                int dx = DXS[i];
                int dy = DYS[i];
                if (x + dx < 0 || x + dx >= grid[0].length) {
                    continue;
                }
                if (y + dy < 0 || y + dy >= grid.length) {
                    continue;
                }
                if (grid[y + dy][x + dx] == 0) {
                    qx.add(x + dx);
                    qy.add(y + dy);
                    qd.add(d + 1);
                }
            }
        }
        return -1;
    }
}