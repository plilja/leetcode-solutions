class Solution {
    public boolean isReflected(int[][] pointsArr) {
        Map<Integer, TreeSet<Integer>> yToXs = new HashMap<>();
        for (int[] point : pointsArr) {
            int x = point[0];
            int y = point[1];
            yToXs.computeIfAbsent(y, k -> new TreeSet<>()).add(x);
        }
        Double reflection = null;
        for (var xsSet : yToXs.values()) {
            var xs = new ArrayList<>(xsSet);
            for (int i = 0; i < xs.size() && i <= xs.size() - 1 - i; ++i) {
                int left = xs.get(i);
                int right = xs.get(xs.size() - i - 1);
                double reflectionPoint = (left + right) / 2D;
                if (reflection == null) {
                    reflection = reflectionPoint;
                } else if (Math.abs(reflection - reflectionPoint) > 1e-8) {
                    return false;
                }
            }
        }
        return true;
    }
}
