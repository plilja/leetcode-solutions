class Solution {
    private static final long MOD = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) {
            return 0;
        }
        long[][][] answers = new long[maxMove][m][n];
        answers[0][startRow][startColumn] = 1;
        for (int moves = 1; moves < maxMove; moves++) {
            for (int y = 0; y < m; y++) {
                for (int x = 0; x < n; x++) {
                    if (y - 1 >= 0) {
                        answers[moves][y][x] += answers[moves - 1][y - 1][x];
                    }
                    if (y + 1 < m) {
                        answers[moves][y][x] += answers[moves - 1][y + 1][x];
                    }
                    if (x - 1 >= 0) {
                        answers[moves][y][x] += answers[moves - 1][y][x - 1];
                    }
                    if (x + 1 < n) {
                        answers[moves][y][x] += answers[moves - 1][y][x + 1];
                    }
                    answers[moves][y][x] %= MOD;
                }
            }
        }
        long result = 0;
        for (int moves = 0; moves < maxMove; moves++) {
            for (int y = 0; y < m; y++) {
                result += answers[moves][y][0];
                result += answers[moves][y][n - 1];
                result %= MOD;
            }
            for (int x = 0; x < n; x++) {
                // Intentionally double counting corners such as answers[move][0][0]
                // since we can go out of bounds both up and left
                result += answers[moves][0][x];
                result += answers[moves][m - 1][x];
                result %= MOD;
            }
        }
        return (int) result;
    }
}

