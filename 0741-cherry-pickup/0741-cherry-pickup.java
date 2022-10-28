import java.util.Arrays;

class Solution {
    private static final int SMALL = -10000;

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        Integer[][][] dp = new Integer[n][n][n];
        for (int y = 0; y < n; ++y) {
            for (int i = 0; i < n; ++i) {
                Arrays.fill(dp[y][i], null);
            }
        }
        int ans = solve(grid, n, 0, 0, 0, dp);
        return Math.max(ans, 0);
    }

    private int solve(int[][] grid, int n, int y1, int x1, int x2, Integer[][][] dp) {
        int p1walked = y1 + x1;
        int y2 = p1walked - x2;
        if (x1 < 0 || x2 < 0 || x1 >= n || x2 >= n || y1 >= n || y2 >= n) {
            return SMALL;
        }
        if (grid[y1][x1] == -1 || grid[y2][x2] == -1) {
            return SMALL;
        }
        if (y1 == n - 1 && x1 == n - 1 && y2 == n - 1 && x2 == n - 1) {
            return grid[n - 1][n - 1];
        }
        if (dp[y1][x1][x2] != null) {
            return dp[y1][x1][x2];
        }
        int cherries = grid[y1][x1];
        if (y1 != y2 || x1 != x2) {
            cherries += grid[y2][x2];
        }
        int bothRight = solve(grid, n, y1, x1 + 1, x2 + 1, dp);
        int bothDown = solve(grid, n, y1 + 1, x1, x2, dp);
        int p1DownP2Right = solve(grid, n, y1 + 1, x1, x2 + 1, dp);
        int p1RightP2Down = solve(grid, n, y1, x1 + 1, x2, dp);
        int result = Math.max(Math.max(bothRight, bothDown), Math.max(p1RightP2Down, p1DownP2Right)) + cherries;
        dp[y1][x1][x2] = result;
        return result;
    }
}
