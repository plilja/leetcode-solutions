/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (!sea.hasShips(topRight, bottomLeft)) {
            return 0;
        }
        int x1 = bottomLeft[0];
        int y1 = bottomLeft[1];
        int x2 = topRight[0];
        int y2 = topRight[1];
        if (x1 == x2 && y1 == y2) {
            return 1;
        }
        if (x2 - x1 > y2 - y1) {
            int xMiddle = x1 + (x2 - x1) / 2;
            int result = 0;
            result += countShips(sea, new int[]{xMiddle, y2}, new int[]{x1, y1});
            result += countShips(sea, new int[]{x2, y2}, new int[]{xMiddle + 1, y1});
            return result;
        } else {
            int yMiddle = y1 + (y2 - y1) / 2;
            int result = 0;
            result += countShips(sea, new int[]{x2, yMiddle}, new int[]{x1, y1});
            result += countShips(sea, new int[]{x2, y2}, new int[]{x1, yMiddle + 1});
            return result;
        }
    }
}