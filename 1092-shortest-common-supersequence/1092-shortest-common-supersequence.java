class Solution {
    private static final int DONE = -1;
    private static final int ADVANCE_BOTH = 1;
    private static final int ADVANCE_FIRST = 2;
    private static final int ADVANCE_SECOND = 3;
    
    public String shortestCommonSupersequence(String str1, String str2) {
        Integer[][] dp = new Integer[str1.length() + 1][str2.length() + 1];
        int[][] trail = new int[str1.length() + 1][str2.length() + 1];
        solve(str1, str2, 0, 0, dp, trail);
        int i = 0;
        int j = 0;
        StringBuilder result = new StringBuilder();
        while (i < str1.length() || j < str2.length()) {
            int v = trail[i][j];
            //System.out.println(i + " " + j + " " + v);
            if (v == ADVANCE_BOTH) {
                result.append(str1.charAt(i));
                i++;
                j++;
            } else if (v == ADVANCE_FIRST) {
                result.append(str1.charAt(i));
                i++;
            } else if (v == ADVANCE_SECOND) {
                result.append(str2.charAt(j));
                j++;
            } else {
                break;
            } 
        }
        return result.toString();
    }
    
    private int solve(String str1, String str2, int i, int j, Integer[][] dp, int[][] trail) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        //System.out.println("visit " + i + " " + j);
        if (i == str1.length() && j == str2.length()) {
            dp[i][j] = 0;
            trail[i][j] = DONE;
            return 0;
        }
        if (i == str1.length()) {
            int result = solve(str1, str2, i, j + 1, dp, trail) + 1;
            dp[i][j] = result;
            trail[i][j] = ADVANCE_SECOND;
            return result;
        }
        if (j == str2.length()) {
            int result = solve(str1, str2, i + 1, j, dp, trail) + 1;
            dp[i][j] = result;
            trail[i][j] = ADVANCE_FIRST;
            return result;
        }
        char c1 = str1.charAt(i);
        char c2 = str2.charAt(j);
        if (c1 == c2) {
            int result = 1 + solve(str1, str2, i + 1, j + 1, dp, trail);
            dp[i][j] = result;
            trail[i][j] = ADVANCE_BOTH;
            return result;
        } else {
            int sub1 = 1 + solve(str1, str2, i + 1, j, dp, trail);
            int sub2 = 1 + solve(str1, str2, i, j + 1, dp, trail);
            if (sub1 < sub2) {
                dp[i][j] = sub1;
                trail[i][j] = ADVANCE_FIRST;
                return sub1;
            } else {
                dp[i][j] = sub2;
                trail[i][j] = ADVANCE_SECOND;
                return sub2;
            }
        }
    }
}