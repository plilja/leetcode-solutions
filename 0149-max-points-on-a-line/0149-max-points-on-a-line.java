import java.math.*;

class Solution {
    public int maxPoints(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; ++i) {
            Map<Line, Integer> lineToCount = new HashMap<>();
            int verticalLineCount = 0;
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < points.length; ++j) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                BigDecimal dx = BigDecimal.valueOf(x1 - x2);
                BigDecimal dy = BigDecimal.valueOf(y1 - y2);
                if (!BigDecimal.ZERO.equals(dy)) {
                    BigDecimal slope = dx.divide(dy, 12, RoundingMode.HALF_UP);
                    BigDecimal offset = BigDecimal.valueOf(y1).subtract(slope.multiply(BigDecimal.valueOf(x1)));
                    Line line = new Line(slope, offset);
                    lineToCount.merge(line, 1, (a, b) -> a + b);
                } else {
                    verticalLineCount++;
                }
            }
            result = Math.max(result, verticalLineCount + 1);
            for (int lineCount : lineToCount.values()) {
                result = Math.max(result, lineCount + 1);
            }
        }
        return result;
    }
    
    private record Line (BigDecimal slope, BigDecimal offset) {
    }
}