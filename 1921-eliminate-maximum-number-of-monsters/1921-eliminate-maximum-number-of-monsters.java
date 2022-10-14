class Solution {
    private static double EPS = 1e-9;
    
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (int i = 0; i < dist.length; ++i) {
            double d = dist[i];
            double s = speed[i];
            double arrival = d / s;
            pq.add(arrival);
        }
        int t = 0;
        int result = 0;
        while (!pq.isEmpty()) {
            double arrival = pq.poll();
            if (arrival - EPS <= t) {
                break;
            }
            result++;
            t++;
        }
        return result;
    }
}