class Solution {
    public int countNegatives(int[][] grid) {
        int result = 0;
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[0].length; ++x) {
                if (grid[y][x] < 0) {
                    result++;
                }
            }
        }
        return result;
    }
}