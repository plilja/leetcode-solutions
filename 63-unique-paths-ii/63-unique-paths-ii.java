class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] numPaths = new int[obstacleGrid.length][obstacleGrid[0].length];
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 0) {
            numPaths[obstacleGrid.length - 1][obstacleGrid[0].length - 1] = 1;
        }
        for (int y = numPaths.length - 1; y >= 0; y--) {
            for (int x = numPaths[0].length - 1; x >= 0; x--) {
                if (obstacleGrid[y][x] == 0) {
                    if (y + 1 < numPaths.length) {
                        numPaths[y][x] += numPaths[y + 1][x];
                    }
                    if (x + 1 < numPaths[0].length) {
                        numPaths[y][x] += numPaths[y][x + 1];
                    }
                }
            }
        }
        return numPaths[0][0];
    }
}

