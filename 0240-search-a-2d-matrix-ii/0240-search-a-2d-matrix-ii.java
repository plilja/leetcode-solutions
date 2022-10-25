class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int b = matrix[0].length;
        for (int y = 0; y < matrix.length; ++y) {
            int a = 0;
            if (matrix[y][0] > target) {
                break;
            }
            while (a < b) {
                int middle = (a + b) / 2;
                int value = matrix[y][middle];
                if (value < target) {
                    a = middle + 1;
                } else {
                    b = middle;
                }
            }
            if (a < matrix[y].length && matrix[y][a] == target) {
                return true;
            }
        }
        return false;
    }
}