class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else if (a[0] == b[0]) {
                return 0;
            } else {
                return 1;
            }
        });
        int result = 0;
        int i = 0;
        while (i < points.length) {
            int right = points[i][1];
            result++;
            while (i + 1 < points.length && points[i + 1][0] <= right) {
                i++;
                right = Math.min(right, points[i][1]);
            }
            i++;
        }
        return result;
    }
}