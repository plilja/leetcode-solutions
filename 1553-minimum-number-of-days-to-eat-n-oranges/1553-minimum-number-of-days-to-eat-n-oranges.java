class Solution {
    public int minDays(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        dp.put(1, 1);
        return solve(n, dp);
    }
    
    private int solve(int n, Map<Integer, Integer> dp) {
        Integer cached = dp.get(n);
        if (cached != null) {
            return cached;
        }
        int sub1 = solve(n / 2, dp) + 1 + (n % 2);
        int sub2 = solve(n / 3, dp) + 1 + (n % 3);
        int result = Math.min(sub1, sub2);
        dp.put(n, result);
        return result;
    }
}