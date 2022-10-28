class Solution {
    
    public int minimumMoves(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        return solve(arr, 0, arr.length - 1, dp);
    }
    
    private int solve(int[] arr, int from, int to, int[][] dp) {
        if (from == to) {
            return 1;
        }
        if (from > to) {
            return 0;
        }
        if (dp[from][to] != 0) {
            return dp[from][to];
        }
        int result = 1 + solve(arr, from + 1, to, dp);
        if (arr[from] == arr[from + 1]) {
            result = Math.min(result, solve(arr, from + 2, to, dp) + 1);
        }
        for (int j = from + 2; j <= to; ++j) {
            if (arr[from] == arr[j]) {
                int sub1 = solve(arr, from + 1, j - 1, dp);
                int sub2 = solve(arr, j + 1, to, dp);
                result = Math.min(result, sub1 + sub2);
            }
        }
        dp[from][to] = result;
        return result;
    }
}