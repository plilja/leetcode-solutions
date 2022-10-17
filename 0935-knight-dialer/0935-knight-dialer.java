class Solution {
    private static final int MOD = 1000000007;
    
    private static Map<Integer, List<Integer>> MOVES = Map.of(
        0, List.of(4, 6),
        1, List.of(6, 8),
        2, List.of(7, 9),
        3, List.of(4, 8),
        4, List.of(0, 3, 9),
        5, List.of(),
        6, List.of(0, 1, 7),
        7, List.of(2, 6),
        8, List.of(1, 3),
        9, List.of(2, 4)
    );
    
    public int knightDialer(int n) {
        // dp[i][j] = num phone numbers with i button presses, initially knight is at j
        long[][] dp = new long[n + 1][10];
        
        for (int j = 0; j < 10; ++j) {
            dp[0][j] = 1;
        }
        
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < 10; ++j) {
                for (int prev : MOVES.get(j)) {
                    dp[i][j] += dp[i - 1][prev];
                    dp[i][j] %= MOD;
                }
            }
        }
        long result = 0;
        for (int j = 0; j < 10; ++j) {
            result += dp[n - 1][j];
            result %= MOD;
        }
        return (int)result;
    }
}
