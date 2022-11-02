class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] mat = new int[rowSum.length][colSum.length];
        if (rowSum.length <= colSum.length) {
            for (int y = 0; y < rowSum.length; ++y) {
                int v = rowSum[y];
                for (int x = 0; x < colSum.length && v > 0; ++x) {
                    mat[y][x] = Math.min(v, colSum[x]);
                    colSum[x] -= mat[y][x];
                    v -= mat[y][x];
                }
            }
        } else {
            for (int x = 0; x < colSum.length; ++x) {
                int v = colSum[x];
                for (int y = 0; y < rowSum.length && v > 0; ++y) {
                    mat[y][x] = Math.min(v, rowSum[y]);
                    rowSum[y] -= mat[y][x];
                    v -= mat[y][x];
                }
            }
        }
        return mat;
    }
}