class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int fivePercent = (int) Math.ceil(0.05 * arr.length);
        double sum = 0;
        int count = 0;
        for (int i = fivePercent; i < arr.length - fivePercent; ++i) {
            sum += arr[i];
            count++;
        }
        return sum / count;
    }
}