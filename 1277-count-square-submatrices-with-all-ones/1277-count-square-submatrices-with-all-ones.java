class Solution {
    public int countSquares(int[][] matrix) {
        int[][] onesRight = new int[matrix.length][matrix[0].length];
        for (int y = 0; y < matrix.length; ++y) {
            int acc = 0;
            for (int x = matrix[0].length - 1; x >= 0; --x) {
                if (matrix[y][x] == 0) {
                    acc = 0;
                } else {
                    acc++;
                }
                onesRight[y][x] = acc;
            }
        }
        int result = 0;
        for (int y = 0; y < matrix.length; ++y) {
            for (int x = 0; x < matrix[0].length; ++x) {
                int max = Integer.MAX_VALUE;
                for (int side = 0; y + side < matrix.length; ++side) {
                    max = Math.min(max, onesRight[y + side][x]);
                    if (side + 1 > max) {
                        break;
                    }
                    result++;
                }
            }
        }
        return result;
    }
}