class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[s.length()][t.length()] = 1;
        for (int i = s.length() - 1; i >= 0; --i) {
            dp[i][t.length()] = 1;
            for (int j = t.length() - 1; j >= 0; --j) {
                char c1 = s.charAt(i);
                char c2 = t.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
}