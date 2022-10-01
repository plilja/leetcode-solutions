class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;
        for (int x = 0; x < matrix[0].length && !firstRowHasZero; ++x) {
            firstRowHasZero = matrix[0][x] == 0;
        }
        for (int y = 0; y < matrix.length && !firstColumnHasZero; ++y) {
            firstColumnHasZero = matrix[y][0] == 0;
        }
        for (int y = 1; y < matrix.length; ++y) {
            for (int x = 1; x < matrix[0].length; ++x) {
                if (matrix[y][x] == 0) {
                    matrix[y][0] = 0;
                    matrix[0][x] = 0;
                }
            }
        }
        for (int y = 1; y < matrix.length; ++y) {
            if (matrix[y][0] == 0) {
                for (int x = 1; x < matrix[0].length; ++x) {
                    matrix[y][x] = 0;
                }
            }
        }
        for (int x = 1; x < matrix[0].length; ++x) {
            if (matrix[0][x] == 0) {
                for (int y = 1; y < matrix.length; ++y) {
                    matrix[y][x] = 0;
                }
            }
        }
        if (firstRowHasZero) {
            for (int x = 0; x < matrix[0].length; ++x) {
                matrix[0][x] = 0;
            }
        }
        if (firstColumnHasZero) {
            for (int y = 0; y < matrix.length; ++y) {
                matrix[y][0] = 0;
            }
        }
        
    }
}