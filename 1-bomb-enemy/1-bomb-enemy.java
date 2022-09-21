class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int result = 0;
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[0].length; ++x) {
                if (grid[y][x] != '0') {
                    continue;
                }
                int killed = 0;
                for (int x2 = x + 1; x2 < grid[0].length; ++x2) {
                    char c = grid[y][x2];
                    if (c == 'W') {
                        break;
                    }
                    if (c == 'E') {
                        killed++;
                    }
                }
                for (int x2 = x - 1; x2 >= 0; --x2) {
                    char c = grid[y][x2];
                    if (c == 'W') {
                        break;
                    }
                    if (c == 'E') {
                        killed++;
                    }
                }
                for (int y2 = y + 1; y2 < grid.length; ++y2) {
                    char c = grid[y2][x];
                    if (c == 'W') {
                        break;
                    }
                    if (c == 'E') {
                        killed++;
                    }
                }
                for (int y2 = y - 1; y2 >= 0; --y2) {
                    char c = grid[y2][x];
                    if (c == 'W') {
                        break;
                    }
                    if (c == 'E') {
                        killed++;
                    }
                }
                result = Math.max(result, killed);
            }
        }
        return result;
    }
}
