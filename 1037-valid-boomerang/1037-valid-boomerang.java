class Solution {
    public boolean isBoomerang(int[][] points) {
        if (isSamePoint(points[0], points[1])
                || isSamePoint(points[0], points[2])
                || isSamePoint(points[1], points[2])
        ) {
            return false;
        }
        double dx = (double) points[0][0] - points[1][0];
        double dy = (double) points[0][1] - points[1][1];
        if (dx == 0D) {
            // Valid if third point is not also on the same x line
            return points[0][0] != points[2][0];
        }
        double slope = dy / dx;
        double a = points[0][1] - slope * points[0][0];
        // try to fit third point on line defined by y = slope * x + a
        double y = points[2][0] * slope + a;
        return Math.abs(points[2][1] - y) > 1e-9;
    }

    private boolean isSamePoint(int[] p1, int[] p2) {
        return p1[0] == p2[0]
                && p1[1] == p2[1];
    }
}

