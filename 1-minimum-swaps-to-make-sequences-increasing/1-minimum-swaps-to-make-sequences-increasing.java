class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int m = nums1.length;
        // dp[i][0] == min solution from index i to end given that position i is not swapped
        // dp[i][1] == min solution from index i to end given that position i is swapped
        int[][] dp = new int[m][2];
        dp[m - 1][0] = 0;
        dp[m - 1][1] = 1;
        for (int i = m - 2; i >= 0; --i) {
            dp[i][0] = m + 1;
            dp[i][1] = m + 1;
            int a = nums1[i];
            int aNext = nums1[i + 1];
            int b = nums2[i];
            int bNext = nums2[i + 1];
            if (a < aNext && b < bNext) {
                dp[i][0] = dp[i + 1][0];
                dp[i][1] = dp[i + 1][1] + 1;
            }
            if (a < bNext && b < aNext) {
                dp[i][0] = Math.min(dp[i][0], dp[i + 1][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i + 1][0] + 1);
            }
        }
        return Math.min(dp[0][0], dp[0][1]);
    }
}
