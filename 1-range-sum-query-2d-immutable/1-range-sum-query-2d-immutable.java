class NumMatrix {
    private final int[][] matrixSums;

    public NumMatrix(int[][] matrix) {
        matrixSums = new int[matrix.length][matrix[0].length];
        for (int y = 0; y < matrix.length; ++y) {
            int rowAcc = 0;
            for (int x = 0; x < matrix[y].length; ++x) {
                rowAcc += matrix[y][x];
                matrixSums[y][x] = rowAcc;
                if (y > 0) {
                    matrixSums[y][x] += matrixSums[y - 1][x];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = matrixSums[row2][col2];
        if (col1 > 0) {
            result -= matrixSums[row2][col1 - 1];
        }
        if (row1 > 0) {
            result -= matrixSums[row1 - 1][col2];
        }
        if (row1 > 0 && col1 > 0) {
            result += matrixSums[row1 - 1][col1 - 1];
        }
        return result;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
