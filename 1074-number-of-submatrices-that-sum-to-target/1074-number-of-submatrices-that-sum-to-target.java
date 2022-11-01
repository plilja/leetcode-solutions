class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int[][] sum = new int[matrix.length + 1][matrix[0].length + 1];
        sum[0][0] = matrix[0][0];
        for (int x = 1; x < matrix[0].length; ++x) {
            sum[0][x] = sum[0][x - 1] + matrix[0][x];
        }
        for (int y = 1; y < matrix.length; ++y) {
            int acc = 0;
            for (int x = 0; x < matrix[0].length; ++x) {
                acc += matrix[y][x];
                sum[y][x] = sum[y - 1][x] + acc;
            }
        }
        int result = 0;
        for (int x1 = 0; x1 < matrix[0].length; ++x1) {
            for (int x2 = x1; x2 < matrix[0].length; ++x2) {
                Map<Integer, Integer> prevBand = new HashMap<>();
                prevBand.put(0, 1); // all the way to the top
                for (int y = 0; y < matrix.length; ++y) {
                    int band = sum[y][x2];
                    if (x1 > 0) {
                        band -= sum[y][x1 - 1]; 
                    }
                    // want => target = band - prevBand
                    int rem = band - target;
                    int count = prevBand.getOrDefault(rem, 0);
                    result += count;
                    prevBand.merge(band, 1, (a, b) -> a + b);
                }
            }
        }
        return result;
    }
}