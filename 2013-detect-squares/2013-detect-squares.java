class DetectSquares {
    private final Map<Integer, List<Integer>> xToY = new HashMap<>();
    private final Map<YPair, Map<Integer, Integer>> yPairToX = new HashMap<>(); 

    public DetectSquares() {
    }
    
    public void add(int[] point) {
        int x1 = point[0];
        int y1 = point[1];
        var pointsWithSameX = xToY.computeIfAbsent(x1, k -> new ArrayList<>());
        for (int y2 : pointsWithSameX) {
            if (y1 != y2) {
                var yPair = new YPair(Math.min(y1, y2), Math.max(y1, y2));
                yPairToX.computeIfAbsent(yPair, k -> new HashMap<>())
                        .merge(x1, 1, (a, b) -> a + b);
            }
        }
        pointsWithSameX.add(y1);
    }
    
    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];
        int result = 0;
        for (int y2 : xToY.getOrDefault(x1, List.of())) {
            int dy = Math.abs(y1 - y2);
            if (y1 != y2) {
                var yPair = new YPair(Math.min(y1, y2), Math.max(y1, y2));
                var yPairs = yPairToX.getOrDefault(yPair, Map.of());
                result += yPairs.getOrDefault(x1 - dy, 0);
                result += yPairs.getOrDefault(x1 + dy, 0);
            }
        }
        return result;
    }
    
    private record YPair(int y1, int y2) {
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */