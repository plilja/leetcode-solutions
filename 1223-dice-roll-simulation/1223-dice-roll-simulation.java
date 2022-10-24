class Solution {
    private static final int MOD = 1000000007;
    
    public int dieSimulator(int n, int[] rollMax) {
        long[][][] dp = new long[n + 1][6][16];
        for (int i = 0; i < 6; ++i) {
            dp[n][i][0] = 1;
        }
        for (int m = n - 1; m >= 0; --m) {
            for (int i = 0; i < 6; ++i) {
                for (int roll = 1; roll <= rollMax[i]; ++roll) {
                    dp[m][i][roll] = dp[m + 1][i][roll - 1];
                }
                for (int j = 0; j < 6; ++j) {
                    if (i != j) {
                        for (int roll = 1; roll <= rollMax[j]; ++roll) {
                            dp[m][i][1] += dp[m + 1][j][roll];
                            dp[m][i][1] %= MOD;
                        }
                    }
                }
            }
        }
        long result = 0;
        for (int i = 0; i < 6; ++i) {
            for (int roll = 0; roll <= rollMax[i]; ++roll) {
                result += dp[0][i][roll];
                result %= MOD;
            }
        }
        return (int) result;
    }
}