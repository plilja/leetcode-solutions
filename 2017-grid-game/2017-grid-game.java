class Solution {
    public long gridGame(int[][] grid) {
        long row1sum = 0;
        long row2sum = 0;
        for (int i = 0; i < grid[0].length; ++i) {
            row1sum += grid[0][i];
            row2sum += grid[1][i];
        }
        long result = Long.MAX_VALUE;
        long row1acc = row1sum;
        long row2acc = 0;
        for (int i = 0; i < grid[0].length; ++i) {
            row1acc -= grid[0][i];
            if (i > 0) {
                row2acc += grid[1][i - 1];
            }
            result = Math.min(result, Math.max(row1acc, row2acc));
        }
        return result;
    }
}