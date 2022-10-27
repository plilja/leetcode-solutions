/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */
class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dims = binaryMatrix.dimensions();
        int rows = dims.get(0);
        int cols = dims.get(1);
        int b = cols;
        for (int y = 0; y < rows; ++y) {
            int a = 0;
            while (a < b) {
                int middle = (a + b) / 2;
                int value = binaryMatrix.get(y, middle);
                if (value == 0) {
                    a = middle + 1;
                } else {
                    b = middle;
                }
            }
        }
        if (b == cols) {
            return -1;
        } else {
            return b;
        }
    }
}