class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] highestRow = new int[grid.length];
        for (int y = 0; y < grid.length; ++y) {
            int highest = 0;
            for (int x = 0; x < grid[0].length; ++x) {
                highest = Math.max(grid[y][x], highest);
            }
            highestRow[y] = highest;
        }
        int[] highestColumn = new int[grid.length];
        for (int x = 0; x < grid[0].length; ++x) {
            int highest = 0;
            for (int y = 0; y < grid.length; ++y) {
                highest = Math.max(grid[y][x], highest);
            }
            highestColumn[x] = highest;
        }
        int result = 0;
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[0].length; ++x) {
                int hr = highestRow[y];
                int hc = highestColumn[x];
                int current = grid[y][x];
                result += Math.min(hr, hc) - current;
            }
        }
        return result;
    }
}