class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; ++i) {
            int[] p1 = points[i];
            Map<Long, List<Integer>> distToPoints = new HashMap<>();
            for (int j = 0; j < points.length; ++j) {
                int[] p2 = points[j];
                int dx = Math.abs(p1[0] - p2[0]);
                int dy = Math.abs(p1[1] - p2[1]);
                long distSquared = dx * dx + dy * dy;
                distToPoints.computeIfAbsent(distSquared, k -> new ArrayList<>()).add(j);
            }
            for (var entry : distToPoints.entrySet()) {
                if (entry.getValue().size() >= 2) {
                    result += 2 * binom(entry.getValue().size(), 2);
                }
            }
        }
        return result;
    }
    
    private int binom(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }
    
    private int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; ++i) {
            result *= i;
        }
        return result;
    }
}