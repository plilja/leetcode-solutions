import java.math.*;

class Solution {
    private static final int MOD = 1000000007;

    public int maxPerformance(int n, int[] speeds, int[] efficiencies, int k) {
        List<Engineer> engineers = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            engineers.add(new Engineer(speeds[i], efficiencies[i]));
        }
        engineers.sort((a, b) -> (int) (a.efficiency - b.efficiency));
        long result = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long runningSum = 0;
        for (int i = n - 1; i >= 0; --i) {
            Engineer engineer = engineers.get(i);
            pq.add(engineer.speed);
            runningSum += engineer.speed;
            while (pq.size() > k) {
                long speed = pq.poll();
                runningSum -= speed;
            }
            long current = runningSum * engineer.efficiency;
            result = Math.max(result, current);
        }
        return (int) (result % MOD);
    }

    private record Engineer(long speed, long efficiency) {
    }
}
