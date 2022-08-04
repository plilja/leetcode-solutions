class Solution {
    
    public boolean removeOnes(int[][] grid) {
        for (int y = 1; y < grid.length; ++y) {
            if (grid[0][0] == grid[y][0]) {
                boolean rowEqual = true;
                for (int x = 1; x < grid[y].length && rowEqual; ++x) {
                    rowEqual = grid[0][x] == grid[y][x];
                }
                if (!rowEqual) {
                    return false;
                }
            } else {
                boolean rowFlippedEqual = true;
                for (int x = 1; x < grid[y].length && rowFlippedEqual; ++x) {
                    rowFlippedEqual = grid[0][x] != grid[y][x];
                }
                if (!rowFlippedEqual) {
                    return false;
                }
            }
        }
        for (int x = 1; x < grid[0].length; ++x) {
            if (grid[0][0] == grid[0][x]) {
                boolean colEqual = true;
                for (int y = 1; y < grid.length && colEqual; ++y) {
                    colEqual = grid[y][0] == grid[y][x];
                }
                if (!colEqual) {
                    return false;
                }
            } else {
                boolean colFlippedEqual = true;
                for (int y = 1; y < grid.length && colFlippedEqual; ++y) {
                    colFlippedEqual = grid[y][0] != grid[y][x];
                }
                if (!colFlippedEqual) {
                    return false;
                }
            }
        }
        return true;
        
    }
}
