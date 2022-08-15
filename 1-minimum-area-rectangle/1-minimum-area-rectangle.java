class Solution {
    record HorizontalLine(int x1, int x2){}
    
    public int minAreaRect(int[][] points) {
        Map<HorizontalLine, List<Integer>> horizontalLineToY = new HashMap<>();
        for (int i = 0; i < points.length - 1; ++i) {
            var p1 = points[i];
            for (int j = i + 1; j < points.length; ++j) {
                var p2 = points[j];
                if (p1[1] == p2[1] && p1[0] != p2[0]) {
                    var line = new HorizontalLine(Math.min(p1[0], p2[0]), Math.max(p1[0], p2[0]));
                    horizontalLineToY.computeIfAbsent(line, k -> new ArrayList<>()).add(p1[1]);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (var entry : horizontalLineToY.entrySet()) {
            var line = entry.getKey();
            int dx = line.x2() - line.x1();
            Integer prev = null;
            List<Integer> yIdx = entry.getValue();
            Collections.sort(yIdx);
            for (int y : yIdx) {
                if (prev != null && prev != y) {
                    int dy = Math.abs(prev - y);
                    int area = dx * dy;
                    result = Math.min(area, result);
                }
                prev = y;
            }
        }
        if (result == Integer.MAX_VALUE) {
            return 0;
        } else {
            return result;
        }
    }
}
