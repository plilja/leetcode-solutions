class Solution {
    public int minSideJumps(int[] obstacles) {
        int inf = obstacles.length + 1;
        int[][] dp = new int[obstacles.length][4];
        for (int i = 0; i < obstacles.length; ++i) {
            for (int lane = 1; lane <= 3; ++lane) {
                dp[i][lane] = inf;
            }
        }
        dp[obstacles.length - 1][1] = 0;
        dp[obstacles.length - 1][2] = 0;
        dp[obstacles.length - 1][3] = 0;
        for (int i = obstacles.length - 2; i >= 0; --i) {
            for (int lane = 1; lane <= 3; ++lane) {
                if (obstacles[i] != lane) {
                    if (obstacles[i + 1] == lane) {
                        for (int lane2 = 1; lane2 <= 3; ++lane2) {
                            if (lane != lane2 && obstacles[i] != lane2) {
                                dp[i][lane] = Math.min(dp[i][lane], dp[i + 1][lane2] + 1);
                            }
                        }
                    } else {
                        dp[i][lane] = dp[i + 1][lane];
                    }
                }
            }
        }
        return dp[0][2];
    }
}