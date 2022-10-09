class Solution {
    public int deleteString(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            int[] kmpArray = createKmpArray(s, i);
            dp[i] = 1;
            for (int j = 1; i + 2 * j <= s.length(); ++j) {
                if (kmpArray[2 * j - 1] == j - 1) {
                    dp[i] = Math.max(dp[i], dp[i + j] + 1);
                }
            }
        }
        return dp[0];
    }

    private int[] createKmpArray(String s, int from) {
        int[] result = new int[s.length() - from];
        Arrays.fill(result, -1);
        int i = 1;
        int j = 0;
        while (i + from < s.length()) {
            if (s.charAt(i + from) == s.charAt(j + from)) {
                result[i] = j;
                j++;
                i++;
            } else if (j > 0) {
                j = result[j - 1] + 1;
            } else {
                i++;
            }
        }
        return result;
    }
}
