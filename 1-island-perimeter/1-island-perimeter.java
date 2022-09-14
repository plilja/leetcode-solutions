class Solution {
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[y].length; ++x) {
                if (grid[y][x] == 1) {
                    if (x == 0 || grid[y][x - 1] == 0) {
                        result++; // water to the left
                    }
                    if (x == grid[y].length - 1 || grid[y][x + 1] == 0) {
                        result++; // water to the right
                    }
                    if (y == 0 || grid[y - 1][x] == 0) {
                        result++; // water top of
                    }
                    if (y == grid.length - 1 || grid[y + 1][x] == 0) {
                        result++; // water bottom of
                    }
                }
            }
        }
        return result;
    }
}
