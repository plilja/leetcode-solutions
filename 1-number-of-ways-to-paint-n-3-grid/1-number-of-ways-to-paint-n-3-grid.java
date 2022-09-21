class Solution {
    private static long MOD = 1000000007L;
    
    public int numOfWays(int n) {
        /*
        xyz => 4  (6 in total)    xyx 2     xyz 2
        xyx => 5  (6 in total)    xyx 3     xyz 2
        */
        // dp[i][0] == num solutions i rows, last row is xyx
        // dp[i][1] == num solutions i rows, last row is xyz
        long[][] dp = new long[n][2];
        dp[0][0] = 6;
        dp[0][1] = 6;
        for (int i = 1; i < n; ++i) {
            dp[i][0] = 3 * dp[i - 1][0] + 2 * dp[i - 1][1];
            dp[i][0] %= MOD;
            dp[i][1] = 2 * dp[i - 1][0] + 2 * dp[i - 1][1];
            dp[i][1] %= MOD;
        }
        return (int) ((dp[n - 1][0] + dp[n - 1][1]) % MOD);
    }
}
