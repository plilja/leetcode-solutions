class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int next = 1;
        int yTop = 0;
        int yBottom = n - 1;
        int xLeft = 0;
        int xRight = n - 1;
        while (xLeft <= xRight) {
            if (xRight == xLeft) {
                result[yTop][xLeft] = next;
                next++;
                break;
            }
            for (int x = xLeft; x <= xRight; ++x) {
                result[yTop][x] = next;
                next++;
            }
            for (int y = yTop + 1; y <= yBottom; ++y) {
                result[y][xRight] = next;
                next++;
            }
            for (int x = xRight - 1; x >= xLeft; --x) {
                result[yBottom][x] = next;
                next++;
            }
            for (int y = yBottom - 1; y >= yTop + 1; --y) {
                result[y][xLeft] = next;
                next++;
            }
            xLeft++;
            xRight--;
            yTop++;
            yBottom--;
        }
        return result;
    }
}
