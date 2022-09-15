class Solution {
    public int maxProfit(int[] prices) {
        int balance = 0;
        int holding = 0;
        for (int i = 0; i < prices.length; ++i) {
            int price = prices[i];
            if (i + 1 < prices.length) {
                int nextPrice = prices[i + 1];
                if (price <= nextPrice) {
                    if (holding == 0) {
                        balance -= price;
                        holding = 1;
                    }
                } else {
                    if (holding == 1) {
                        balance += price;
                        holding = 0;
                    }
                }
            } else {
                if (holding == 1) {
                    balance += price;
                    holding = 0;
                }
            }
        }
        return balance;
    }
}
