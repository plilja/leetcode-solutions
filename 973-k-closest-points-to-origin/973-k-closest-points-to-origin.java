class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Elem> result = new PriorityQueue<>((a, b) -> (int) Math.signum(b.dist() - a.dist()));
        for (int[] point : points) {
            double dist = distSquared(point);
            result.add(new Elem(point, dist));
            if (result.size() > k) {
                result.poll();
            }
        }
        int[][] returnValue = new int[k][2];
        for (int i = 0; i < Math.min(k, points.length); i++) {
            returnValue[i] = result.poll().point();
        }
        return returnValue;
    }
    
    private double distSquared(int[] point) {
        double x = (double) point[0];
        double y = (double) point[1];
        return x*x + y*y;
    
    
    private record Elem(int[] point, double dist) {
    }
}}
