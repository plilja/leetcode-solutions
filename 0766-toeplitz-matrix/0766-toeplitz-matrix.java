class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int xStart = 0; xStart < matrix[0].length; ++xStart) {
            int x = xStart;
            int y = 0;
            while (x < matrix[0].length && y < matrix.length) {
                if (matrix[0][xStart] != matrix[y][x]) {
                    return false;
                }
                x++;
                y++;
            }
        }
        for (int yStart = 1; yStart < matrix.length; ++yStart) {
            int x = 0;
            int y = yStart;
            while (x < matrix[0].length && y < matrix.length) {
                if (matrix[yStart][0] != matrix[y][x]) {
                    return false;
                }
                x++;
                y++;
            }
        }
        return true;
    }
}