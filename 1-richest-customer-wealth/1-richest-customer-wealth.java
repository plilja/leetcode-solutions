class Solution {
    public int maximumWealth(int[][] accounts) {
        int result = 0;
        for (int[] customerAccounts : accounts) {
            int wealth = 0;
            for (int account : customerAccounts) {
                wealth += account;
            }
            result = Math.max(result, wealth);
        }
        return result;
    }
}
