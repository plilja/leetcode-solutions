class Solution {
    private static final double EPS = 1e-9;

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<int[]> points = List.of(p1, p2, p3, p4);
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (points.get(i)[0] == points.get(j)[0] && points.get(i)[1] == points.get(j)[1]) {
                    // duplicate points
                    return false;
                }
            }
        }
        List<Double> dists0 = dists(0, points);
        if (Math.abs(dists0.get(0) - dists0.get(1)) > EPS || Math.abs(dists0.get(1) - dists0.get(2)) < EPS) {
            return false;
        }
        for (int i = 1; i < 4; i++) {
            List<Double> dists2 = dists(i,  points);
            if (!distsEquals(dists0, dists2)) {
                return false;
            }
        }
        return true;
    }

    private boolean distsEquals(List<Double> dists1, List<Double> dists2) {
        for (int i = 0; i < 3; i++) {
            double d1 = dists1.get(i);
            double d2 = dists2.get(i);
            if (Math.abs(d1 - d2) > EPS) {
                return false;
            }
        }
        return true;
    }

    private List<Double> dists(int i, List<int[]> points) {
        List<Double> result = new ArrayList<>();
        for (int j = 0; j < points.size(); j++) {
            if (j != i) {
                result.add(dist(points.get(i), points.get(j)));
            }
        }
        Collections.sort(result);
        return result;
    }

    private double dist(int[] p1, int[] p2) {
        int dx = Math.abs(p1[0] - p2[0]);
        int dy = Math.abs(p1[1] - p2[1]);
        return Math.sqrt(dx * dx + dy * dy);
    }

}

