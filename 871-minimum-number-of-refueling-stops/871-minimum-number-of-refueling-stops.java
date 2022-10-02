class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        long[] dp = new long[stations.length + 1];
        dp[0] = startFuel;
        for (int i = 1; i <= stations.length; ++i) {
            int position = stations[i - 1][0];
            int fuel = stations[i - 1][1];
            for (int j = i - 1; j >= 0; --j) {
                if (dp[j] >= position) {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + fuel);
                }
            }
        }
        for (int i = 0; i < dp.length; ++i) {
            if (dp[i] >= target) {
                System.out.println(dp[i]);
                return i;
            }
        }
        return -1;
    }
}