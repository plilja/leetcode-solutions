class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int a = 0;
        int b = m * n - 1;
        while (a < b) {
            int middle = a + (b - a) / 2;
            int value = getValueAtIndex(matrix, middle);
            if (value < target) {
                a = middle + 1;
            } else {
                b = middle;
            }
        }
        return getValueAtIndex(matrix, a) == target;
    }
    
    private int getValueAtIndex(int[][] matrix, int index) {
        int n = matrix[0].length;
        int y = index / n;
        int x = index % n;
        return matrix[y][x];
    }
}
