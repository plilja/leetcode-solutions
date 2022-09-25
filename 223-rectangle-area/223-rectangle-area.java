class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaRec1 = area(ax1, ay1, ax2, ay2);
        int areaRec2 = area(bx1, by1, bx2, by2);
        int areaIntersect = area(Math.max(ax1, bx1), Math.max(ay1, by1), Math.min(ax2, bx2), Math.min(ay2, by2));
        return areaRec1 + areaRec2 - areaIntersect;
    }
    
    private int area(int bottomLeftX, int bottomLeftY, int topRightX, int topRightY) {
        return Math.max(0, topRightX - bottomLeftX) * Math.max(0, topRightY - bottomLeftY);
    }
}