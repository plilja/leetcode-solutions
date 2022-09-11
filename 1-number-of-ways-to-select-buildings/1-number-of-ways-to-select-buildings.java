class Solution {
    public long numberOfWays(String s) {
        long[][][] dp = new long[2][3][2];
        for (int i = s.length() - 1; i >= 0; --i) {
            int building = (int) (s.charAt(i) - '0');
            for (int j = 0; j < 3; ++j) {
                dp[i % 2][j][0] = dp[(i + 1) % 2][j][0];
                dp[i % 2][j][1] = dp[(i + 1) % 2][j][1];
            }
            dp[i % 2][0][building] += 1;
            dp[i % 2][1][building] += dp[(i + 1) % 2][0][(building + 1) % 2];
            dp[i % 2][2][building] += dp[(i + 1) % 2][1][(building + 1) % 2];
        }
        return dp[0][2][0] + dp[0][2][1];
    }
}
