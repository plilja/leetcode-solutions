class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int acc = 0;
        int result = 0;
        for (int i = 0; i < calories.length; ++i) {
            acc += calories[i];
            if (i - k >= 0) {
                acc -= calories[i - k];
            }
            if (i >= k - 1) {
                if (acc < lower) {
                    result--;
                } else if (acc > upper) {
                    result++;
                }
            }
        }
        return result;
    }
}