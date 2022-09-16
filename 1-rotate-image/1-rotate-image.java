class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int middle = matrix.length / 2;
        for (int y = 0; y < middle; ++y) {
            for (int x = y; x < n - y - 1; ++x) {
                int tl = matrix[y][x];
                int bl = matrix[n - x - 1][y];
                int br = matrix[n - y - 1][n - x - 1];
                int tr = matrix[x][n - y - 1];
                matrix[y][x] = bl;
                matrix[n - x - 1][y] = br;
                matrix[n - y - 1][n - x - 1] = tr;
                matrix[x][n - y - 1] = tl;
            }
        }
    }
}
