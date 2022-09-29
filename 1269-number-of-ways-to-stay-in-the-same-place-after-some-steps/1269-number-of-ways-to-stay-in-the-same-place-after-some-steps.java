class Solution {
    private static final int MOD = 1000000007;
    
    public int numWays(int steps, int arrLen) {
        long[][] arr = new long[steps + 1][Math.min(steps, arrLen)];
        arr[0][0] = 1;
        for (int i = 1; i <= steps; ++i) {
            for (int j = 0; j < arr[i].length; ++j) {
                arr[i][j] = arr[i - 1][j];
                if (j > 0) {
                    arr[i][j] += arr[i - 1][j - 1];
                }
                if (j < arr[i].length - 1) {
                    arr[i][j] += arr[i - 1][j + 1];
                }
                arr[i][j] %= MOD;
            }
        }
        return (int) arr[steps][0];
    }
}