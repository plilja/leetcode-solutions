class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n][5];
        dp[n - 1][0] = 1;
        dp[n - 1][1] = 1;
        dp[n - 1][2] = 1;
        dp[n - 1][3] = 1;
        dp[n - 1][4] = 1;
        for (int j = n - 2; j >= 0; --j) {
            for (int i = 0; i < 5; ++i) {
                for (int k = i; k < 5; ++k) {
                    dp[j][i] += dp[j + 1][k];
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 5; ++i) {
            result += dp[0][i];
        }
        return result;
    }
}
