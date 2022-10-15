class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        int i = 1;
        while (i * i <= n) {
            int perfectSquare = i * i;
            for (int j = perfectSquare; j <= n; ++j) {
                dp[j] = Math.min(dp[j], dp[j - perfectSquare] + 1);
            }
            i++;
        }
        return dp[n];
    }
}