class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int[] p1 = points[0];
        int time = 0;
        for (int i = 1; i < points.length; ++i) {
            int[] p2 = points[i];
            int dx = Math.abs(p1[0] - p2[0]);
            int dy = Math.abs(p1[1] - p2[1]);
            time += Math.max(dy, dx);
            p1 = p2;
        }
        return time;
    }
}