class Solution {
    public int hammingDistance(int x, int y) {
        int xCurrent = x;
        int yCurrent = y;
        int result = 0;
        while (xCurrent != 0 || yCurrent != 0) {
            if ((xCurrent & 1) != (yCurrent & 1)) {
                result++;
            }
            xCurrent >>= 1;
            yCurrent >>= 1;
        }
        return result;
    }
}
