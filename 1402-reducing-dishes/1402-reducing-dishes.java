class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int result = 0;
        int current = 0;
        int sum = 0;
        for (int i = satisfaction.length - 1; i >= 0; --i) {
            sum += satisfaction[i];
            current += sum;
            result = Math.max(result, current);
        }
        return result;
    }
}