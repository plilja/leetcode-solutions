class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int y = 0; y < grid.length; ++y) {
            if (y > 0) {
                dp[y][0] = dp[y - 1][0] + grid[y][0];
            } else {
                dp[0][0] = grid[0][0];
            }
            for (int x = 1; x < grid[0].length; ++x) {
                dp[y][x] = dp[y][x - 1] + grid[y][x];
                if (y > 0) {
                    dp[y][x] = Math.min(dp[y][x], dp[y - 1][x] + grid[y][x]);
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}