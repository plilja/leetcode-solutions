import java.math.*;

class Solution {
    private static final int MOD = 1000000007;

    public int maxPerformance(int n, int[] speeds, int[] efficiencies, int k) {
        List<Engineer> engineers = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            engineers.add(new Engineer(speeds[i], efficiencies[i]));
        }
        engineers.sort((a, b) -> (int) (a.efficiency - b.efficiency));
        BigInteger result = BigInteger.valueOf(0);
        PriorityQueue<Long> pq = new PriorityQueue<>();
        BigInteger runningSum = BigInteger.ZERO;
        for (int i = n - 1; i >= 0; --i) {
            var engineer = engineers.get(i);
            pq.add(engineer.speed);
            runningSum = runningSum.add(BigInteger.valueOf(engineer.speed));
            while (pq.size() > k) {
                long speed = pq.poll();
                runningSum = runningSum.subtract(BigInteger.valueOf(speed));
            }
            BigInteger minEfficiency = BigInteger.valueOf(engineer.efficiency);
            BigInteger current = runningSum.multiply(minEfficiency);
            if (result.compareTo(current) < 0) {
                result = current;
            }
        }
        return result.mod(BigInteger.valueOf(MOD)).intValue();
    }

    private record Engineer(long speed, long efficiency) {
    }
}