class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length];
        for (int y = matrix.length - 1; y >= 0; --y) {
            for (int x = 0; x < matrix[0].length; ++x) {
                int value = matrix[y][x];
                dp[y][x] = dp[y + 1][x] + value;
                if (x - 1 >= 0) {
                    dp[y][x] = Math.min(dp[y][x], dp[y + 1][x - 1] + value);
                }
                if (x + 1 < matrix[0].length) {
                    dp[y][x] = Math.min(dp[y][x], dp[y + 1][x + 1] + value);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int x = 0; x < matrix[0].length; ++x) {
            result = Math.min(result, dp[0][x]);
        }
        return result;
    }
}
