class Solution {
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        // dp[i][j] == min distance to cover houses 0 -> i using j mailboxes
        int[][] dp = new int[houses.length + 1][k + 1];
        for (int i = 0; i < houses.length; ++i) {
            dp[i][1] = costOneMailbox(houses, 0, i);
            for (int j = 2; j <= k; ++j) {
                if (j >= i + 1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i - 1][j - 1]; // put last mailbox on house i
                for (int m = 1; m <= i; ++m) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - m][j - 1] + costOneMailbox(houses, i - m + 1, i));
                }
            }
        }
        return dp[houses.length - 1][k];
    }

    private int costOneMailbox(int[] houses, int from, int to) {
        int middle = from + (to - from) / 2;
        int cost = 0;
        for (int i = from; i <= to; ++i) {
            cost += Math.abs(houses[middle] - houses[i]);
        }
        return cost;
    }
}