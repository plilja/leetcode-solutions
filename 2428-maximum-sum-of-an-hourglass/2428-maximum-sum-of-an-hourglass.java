class Solution {
    public int maxSum(int[][] grid) {
        int result = Integer.MIN_VALUE;
        for (int y = 0; y < grid.length - 2; ++y) {
            for (int x = 0; x < grid[0].length - 2; ++x) {
                int hourglass = 0;
                hourglass += grid[y][x] + grid[y][x + 1] + grid[y][x + 2];
                hourglass += grid[y + 1][x + 1];
                hourglass += grid[y + 2][x] + grid[y + 2][x + 1] + grid[y + 2][x + 2];
                result = Math.max(result, hourglass);
            }
        }
        return result;
    }
}