class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = strs.length - 1; i >= 0; --i) {
            int zeroes = countCharsMatching(strs[i], '0');
            int ones = countCharsMatching(strs[i], '1');
            for (int k = m; k >= zeroes; --k) {
                for (int h = n; h >= ones; --h) {
                    dp[k][h] = Math.max(dp[k][h], dp[k - zeroes][h - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int countCharsMatching(String s, char c) {
        int result = 0;
        for (int j = 0; j < s.length(); ++j) {
            if (c == s.charAt(j)) {
                result++;
            }
        }
        return result;
    }
}
