class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] rowPrefixSums = new int[mat.length][mat[0].length];
        for (int y = 0; y < mat.length; ++y) {
            int acc = 0;
            for (int x = 0; x < mat[0].length; ++x) {
                acc += mat[y][x];
                rowPrefixSums[y][x] = acc;
            }
        }
        int[][] result = new int[mat.length][mat[0].length];
        for (int y = 0; y < mat.length; ++y) {
            for (int x = 0; x < mat[0].length; ++x) {
                int total = 0;
                for (int y2 = Math.max(0, y - k); y2 < Math.min(mat.length, y + k + 1); ++y2) {
                    int sum = rowPrefixSums[y2][Math.min(mat[0].length - 1, x + k)];
                    if (x - k - 1 >= 0) {
                        sum -= rowPrefixSums[y2][x - k - 1];
                    }
                    total += sum;
                }
                result[y][x] = total;
            }
        }
        return result;
    }
}