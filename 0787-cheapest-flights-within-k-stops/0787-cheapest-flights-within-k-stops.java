class Solution {
    private static long BIG = Integer.MAX_VALUE;
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        long[][] cost = new long[k + 2][n];
        Arrays.fill(cost[0], BIG);
        cost[0][src] = 0;
        for (int i = 1; i <= k + 1; ++i) {
            for (int j = 0; j < n; ++j) {
                cost[i][j] = cost[i - 1][j];
            }
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                if (cost[i - 1][from] + price < cost[i][to]) {
                    cost[i][to] = cost[i - 1][from] + price;
                }
            }
        }
        if (cost[k + 1][dst] < BIG) {
            return (int) cost[k + 1][dst];
        } else {
            return -1;
        }
    }
}