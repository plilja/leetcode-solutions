class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int[][] result = new int[mat1.length][mat2[0].length];
        for (int y = 0; y < mat1.length; ++y) {
            for (int x = 0; x < mat2[0].length; ++x) {
                int val = 0;
                for (int d = 0; d < mat1[0].length; ++d) {
                    val += mat1[y][d] * mat2[d][x];
                }
                result[y][x] = val;
            }
        }
        return result;
    }
}