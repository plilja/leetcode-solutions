class Solution {
    public int stoneGameV(int[] stoneValues) {
        int[] prefixSum = new int[stoneValues.length];
        int acc = 0;
        for (int i = 0; i < stoneValues.length; ++i) {
            acc += stoneValues[i];
            prefixSum[i] = acc;
        }
        int[][] dp = new int[stoneValues.length][stoneValues.length];
        for (int range = 1; range < stoneValues.length; ++range) {
            for (int i = 0; i + range < stoneValues.length; ++i) {
                for (int j = 0; j < range; ++j) {
                    int left = sumRange(prefixSum, i, i + j);
                    int right = sumRange(prefixSum, i + j + 1, i + range);
                    int splitSolution;
                    if (left == right) {
                        splitSolution = left + Math.max(dp[i][j], dp[i + j + 1][i + range]);
                    } else if (left < right) {
                        splitSolution = left + dp[i][i + j];
                    } else {
                        splitSolution = right + dp[i + j + 1][i + range];
                    }
                    dp[i][i + range] = Math.max(dp[i][i + range], splitSolution);
                }
            }
        }
        return dp[0][stoneValues.length - 1];
    }

    private int sumRange(int[] prefixSum, int left, int right) {
        int result = prefixSum[right];
        if (left > 0) {
            result -= prefixSum[left - 1];
        }
        return result;
    }
}