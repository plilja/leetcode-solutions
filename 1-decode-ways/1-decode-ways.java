class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; --i) {
            char c1 = s.charAt(i);
            if (c1 != '0') {
                dp[i] = dp[i + 1]; // encode c1 as a separate number
            }
            if (i + 1 < s.length() && c1 >= '1' && c1 <= '2') {
                char c2 = s.charAt(i + 1);
                if (c1 == '1' || (c2 >= '0' && c2 <= '6')) {
                    dp[i] += dp[i + 2]; // encode c1 + c2 as a number
                }
            }
        }
        return dp[0];
    }
}
