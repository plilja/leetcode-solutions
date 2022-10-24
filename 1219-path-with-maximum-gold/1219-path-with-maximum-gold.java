class Solution {
    private static final int[] DXS = new int[]{1, 0, -1, 0};
    private static final int[] DYS = new int[]{0, 1, 0, -1};
    
    public int getMaximumGold(int[][] grid) {
        int result = 0;
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[0].length; ++x) {
                if (grid[y][x] != 0) {
                    int gold = dfs(grid, x, y);
                    result = Math.max(result, gold);
                }
            }
        }
        return result;
    }
    
    private int dfs(int[][] grid, int x, int y) {
        int gold = grid[y][x];
        grid[y][x] = 0;
        int result = gold;
        for (int i = 0; i < 4; ++i) {
            int dx = DXS[i];
            int dy = DYS[i];
            int x2 = x + dx;
            int y2 = y + dy;
            if (x2 < 0 || x2 >= grid[0].length) {
                continue;
            }
            if (y2 < 0 || y2 >= grid.length) {
                continue;
            }
            if (grid[y2][x2] > 0) {
                int subsolution = dfs(grid, x2, y2) + gold;
                result = Math.max(result, subsolution);
            }
        }
        grid[y][x] = gold;
        return result;
    }
}