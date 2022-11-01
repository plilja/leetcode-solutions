class Solution {
    private static final double EPS = 1e-9;
    
    public int minSpeedOnTime(int[] dist, double hour) {
        int a = 1;
        int b = (int) 1e7;
        while (a < b) {
            int middle = (a + b) / 2;
            if (!arrivesOnTime(dist, hour, middle)) {
                a = middle + 1;
            } else {
                b = middle;
            }
        }
        return arrivesOnTime(dist, hour, a) ? a : -1;
    }
    
    private boolean arrivesOnTime(int[] dist, double hour, double speed) {
        double t = 0;
        for (int i = 0; i < dist.length; ++i) {
            int stationDist = dist[i];
            double timeTaken = stationDist / speed;
            t += timeTaken - EPS;
            if (i < dist.length - 1) {
                t = Math.ceil(t);
            }
        }
        return t < hour;
    }
}