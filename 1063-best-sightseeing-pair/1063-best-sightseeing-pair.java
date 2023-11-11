class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int result = Integer.MIN_VALUE;
        int bestLeft = values[0];
        for (int j = 1; j < values.length; ++j) {
            int score = bestLeft + values[j] - j;
            result = Math.max(result, score);
            bestLeft = Math.max(bestLeft, values[j] + j);
        }
        return result;
    }
}