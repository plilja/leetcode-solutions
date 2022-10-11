class Solution {
    private static final int MOD = 1000000007;
    
    private static final int a = 0;
    private static final int e = 1;
    private static final int i = 2;
    private static final int o = 3;
    private static final int u = 4;
    
    public int countVowelPermutation(int n) {
        long[][] dp = new long[2][5];
        dp[0][a] = 1;
        dp[0][e] = 1;
        dp[0][i] = 1;
        dp[0][o] = 1;
        dp[0][u] = 1;
        for (int j = 1; j < n; ++j) {
            dp[j % 2][a] = 0;
            dp[j % 2][e] = 0;
            dp[j % 2][i] = 0;
            dp[j % 2][o] = 0;
            dp[j % 2][u] = 0;
            
            // rule 1
            dp[j % 2][e] += dp[(j - 1) % 2][a];
            
            // rule 2
            dp[j % 2][a] += dp[(j - 1) % 2][e];
            dp[j % 2][i] += dp[(j - 1) % 2][e];
            
            // rule 3
            dp[j % 2][a] += dp[(j - 1) % 2][i];
            dp[j % 2][e] += dp[(j - 1) % 2][i];
            dp[j % 2][o] += dp[(j - 1) % 2][i];
            dp[j % 2][u] += dp[(j - 1) % 2][i];
            
            // rule 4
            dp[j % 2][i] += dp[(j - 1) % 2][o];
            dp[j % 2][u] += dp[(j - 1) % 2][o];
            
            // rule 5
            dp[j % 2][a] += dp[(j - 1) % 2][u];
            
            for (int k = 0; k < 5; ++k) {
                dp[j % 2][k] %= MOD;
            }
        }
        long result = 0;
        for (int j = 0; j < 5; ++j) {
            result += dp[(n - 1) % 2][j];
            result %= MOD;
        }
        return (int) result;
    }
}