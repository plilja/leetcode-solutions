class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = 0;
        for (int v : rolls) {
            sum += v;
        }
        int totalSum = mean * (m + n);
        int nSum = totalSum - sum;
        int minPossible = n * 1;
        int maxPossible = n * 6;
        if (minPossible <= nSum && nSum <= maxPossible) {
            int[] result = new int[n];
            int k = nSum / n;
            int rem = nSum;
            for (int i = 0; i < n; ++i) {
                result[i] = k;
                rem -= k;
            }
            for (int i = 0; i < n && rem > 0; ++i) {
                result[i]++;
                rem--;
            }
            return result;
        } else {
            return new int[]{};
        }
    }
}