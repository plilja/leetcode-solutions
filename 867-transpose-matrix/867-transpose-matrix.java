/*
1 2 3
4 5 6

1 2 3
4 5 6
*/
class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int y = 0; y < matrix.length; ++y) {
            for (int x = 0; x < matrix[y].length; ++x) {
                result[x][y] = matrix[y][x];
            }
        }
        return result;
    }
}
