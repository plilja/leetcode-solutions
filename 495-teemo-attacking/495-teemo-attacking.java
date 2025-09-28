class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        for (int i = 0; i < timeSeries.length; ++i) {
            int t = timeSeries[i];
            if (i < timeSeries.length - 1) {
                int next = timeSeries[i + 1];
                result += Math.min(duration, next - t);
            } else {
                result += duration;
            }
        }
        return result;
    }
}
