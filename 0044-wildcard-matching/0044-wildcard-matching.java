class Solution {
    Boolean[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String s, String p, int i, int j) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (j == p.length()) {
            return i == s.length();
        }
        boolean result = false;
        char cp = p.charAt(j);
        if (i == s.length()) {
            result = cp == '*' && isMatch(s, p, i, j + 1);
        } else {
            char cs = s.charAt(i);
            if (cp == '?' || cp == cs) {
                result = isMatch(s, p, i + 1, j + 1);
            }
            if (cp == '*') {
                for (int i2 = i; i2 <= s.length() && !result; ++i2) {
                    result = isMatch(s, p, i2, j + 1);
                }
            }
        }
        dp[i][j] = result;
        return result;
    }
}
