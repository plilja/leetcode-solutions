class Solution {
    public int integerBreak(int n) {
        int result = 0;
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 1; i < n; ++i) {
            result = Math.max(result, i * solve(n - i, cache));
        }
        return result;
    }
    
    private int solve(int n, Map<Integer, Integer> cache) {
        Integer cached = cache.get(n);
        if (cached != null) {
            return cached;
        }
        int result = n;
        for (int i = 1; i < n; ++i) {
            result = Math.max(result, i * solve(n - i, cache));
        }
        cache.put(n, result);
        return result;
    }
}