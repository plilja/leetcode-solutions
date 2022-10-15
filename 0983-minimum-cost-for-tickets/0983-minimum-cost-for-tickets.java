class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        boolean[] travel = new boolean[366];
        int[] dp = new int[367];
        dp[366] = 0;
        for (int d : days) {
            travel[d] = true;
        }
        for (int i = 365; i >= 1; --i) {
            if (travel[i]) {
                dp[i] = Integer.MAX_VALUE;
                dp[i] = Math.min(dp[i], dp[Math.min(i + 1, 366)] + costs[0]);
                dp[i] = Math.min(dp[i], dp[Math.min(i + 7, 366)] + costs[1]);
                dp[i] = Math.min(dp[i], dp[Math.min(i + 30, 366)] + costs[2]);
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[1];
    }
}