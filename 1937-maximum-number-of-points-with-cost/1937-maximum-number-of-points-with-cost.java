class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        
        long[][] bestLeft = makeMatrix(m, n);
        long[][] bestRight = makeMatrix(m, n);
        long[][] best = makeMatrix(m, n);
        
        for (int x = 0; x < n; ++x) {
            bestLeft[m - 1][x] = points[m - 1][x];
            bestRight[m - 1][x] = points[m - 1][x];
            best[m - 1][x] = points[m - 1][x];
        }
        
        for (int y = m - 2; y >= 0; --y) {
            // Right to left sweep
            bestRight[y][n - 1] = best[y + 1][n - 1] + points[y][n - 1];
            for (int x = n - 2; x >= 0; --x) {
                int point = points[y][x];
                int rightPoint = points[y][x + 1];
                bestRight[y][x] = Math.max(
                    best[y + 1][x] + point,
                    bestRight[y][x + 1] - rightPoint + point - 1
                );
            }
            
            // left to right sweep
            bestLeft[y][0] = best[y + 1][0] + points[y][0];
            for (int x = 1; x < n; ++x) {
                int point = points[y][x];
                int leftPoint = points[y][x - 1];
                bestLeft[y][x] = Math.max(
                    best[y + 1][x] + point,
                    bestLeft[y][x - 1] - leftPoint + point - 1
                );
            }
            
            // Sweep for best overall
            for (int x = 0; x < n; ++x) {
                best[y][x] = Math.max(bestLeft[y][x], bestRight[y][x]);
            }
        }
        
        long result = -1;
        for (int x = 0; x < n; ++x) {
            result = Math.max(result, best[0][x]);
        }
        return result;
    }
    
    private long[][] makeMatrix(int m, int n) {
        long[][] result = new long[m][];
        for (int y = 0; y < m; ++y) {
            result[y] = new long[n];
        }
        return result;
    }
}
