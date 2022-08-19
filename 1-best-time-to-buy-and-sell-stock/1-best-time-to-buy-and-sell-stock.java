class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int runningMin = prices[0];
        for (int price : prices) {
            runningMin = Math.min(runningMin, price);
            result = Math.max(result, price - runningMin);
        }
        return result;
    }
}
