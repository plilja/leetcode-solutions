class Solution {
    public int longestLine(int[][] mat) {
        int result = 0;
        result = Math.max(result, horizontalSweep(mat));
        result = Math.max(result, verticalSweep(mat));
        result = Math.max(result, downRightSweep(mat));
        result = Math.max(result, downLeftSweep(mat));
        return result;
    }
    
    private int horizontalSweep(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int result = 0;
        for (int y = 0; y < m; ++y) {
            int accumulator = 0;
            for (int x = 0; x < n; ++x) {
                int value = mat[y][x];
                if (value == 1) {
                    accumulator++;
                } else {
                    accumulator = 0;
                }
                result = Math.max(result, accumulator);
            }
        }
        return result;
    }
    
    private int verticalSweep(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int result = 0;
        for (int x = 0; x < n; ++x) {
            int accumulator = 0;
            for (int y = 0; y < m; ++y) {
                int value = mat[y][x];
                if (value == 1) {
                    accumulator++;
                } else {
                    accumulator = 0;
                }
                result = Math.max(result, accumulator);
            }
        }
        return result;
    }
    
    private int downRightSweep(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int result = 0;
        for (int startX = 0; startX < n; ++startX) {
            int maxY = startX == 0 ? m : 1;
            for (int firstY = 0; firstY < maxY; ++firstY) {
                int x = startX;
                int y = firstY;
                int accumulator = 0;
                while (y < m && x < n) {
                    int value = mat[y][x];
                    if (value == 1) {
                        accumulator++;
                    } else {
                        accumulator = 0;
                    }
                    result = Math.max(result, accumulator);
                    x++;
                    y++;
                }
            }
        }
        return result;
    }
    
    private int downLeftSweep(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int result = 0;
        for (int startX = 0; startX < n; ++startX) {
            int maxY = startX == n - 1 ? m : 1;
            for (int firstY = 0; firstY < maxY; ++firstY) {
                int x = startX;
                int y = firstY;
                int accumulator = 0;
                while (y < m && x >= 0) {
                    int value = mat[y][x];
                    if (value == 1) {
                        accumulator++;
                    } else {
                        accumulator = 0;
                    }
                    result = Math.max(result, accumulator);
                    x--;
                    y++;
                }
            }
        }
        return result;
    }
}
