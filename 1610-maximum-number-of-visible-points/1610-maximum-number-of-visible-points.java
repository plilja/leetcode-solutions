class Solution {
    private static final double EPS = 1e-9;
    
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> pointsByDegrees = new ArrayList<>(2 * points.size());
        int x = location.get(0);
        int y = location.get(1);
        int atLocation = 0;
        for (var point : points) {
            double pointX = point.get(0) - x;
            double pointY = point.get(1) - y;
            if (pointX == 0D && pointY == 0D) {
                atLocation++;
            } else {
                double angleRadians = Math.atan2(pointY, pointX);
                double angleDegrees = Math.toDegrees(angleRadians);
                pointsByDegrees.add(angleDegrees);
            }
        }
        Collections.sort(pointsByDegrees);
        int size = pointsByDegrees.size();
        for (int i = 0; i < size; ++i) {
            pointsByDegrees.add(pointsByDegrees.get(i) + 360);
        }
        
        int result = 0;
        int endPointer = 0;
        for (int i = 0; i < size; ++i) {
            double startAngle = pointsByDegrees.get(i);
            double endAngle = startAngle + angle + EPS;
            while (pointsByDegrees.get(endPointer) < endAngle) {
                endPointer++;
            }
            result = Math.max(result, endPointer - i);
        }
        return result + atLocation;
    }
}
