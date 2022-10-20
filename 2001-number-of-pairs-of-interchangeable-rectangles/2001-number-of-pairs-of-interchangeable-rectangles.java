class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        long result = 0;
        Map<Integer, Map<Integer, Long>> rects = new HashMap<>();
        for (int[] rectangle : rectangles) {
            int width = rectangle[0];
            int height = rectangle[1];
            int d = gcd(width, height);
            long newCount = rects
                .computeIfAbsent(width / d, k-> new HashMap<>())
                .merge(height / d, 1L, (a, b) -> a + b);
            if (newCount > 1) {
                result += newCount - 1;
            }
        }
        return result;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}