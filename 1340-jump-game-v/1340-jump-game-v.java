class Solution {
    public int maxJumps(int[] arr, int d) {
        int result = 0;
        Map<Integer, Integer> dp = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            result = Math.max(result, solve(arr, d, i, dp));
        }
        return result;
    }
    
    private int solve(int[] arr, int d, int i, Map<Integer, Integer> dp) {
        Integer cached = dp.get(i);
        if (cached != null) {
            return cached;
        }
        int result = 1;
        for (int x = 1; x <= d; ++x) {
            if (i - x < 0) {
                break;
            }
            if (arr[i - x] >= arr[i]) {
                break;
            }
            result = Math.max(result, solve(arr, d, i - x, dp) + 1);
        }
        for (int x = 1; x <= d; ++x) {
            if (i + x >= arr.length) {
                break;
            }
            if (arr[i + x] >= arr[i]) {
                break;
            }
            result = Math.max(result, solve(arr, d, i + x, dp) + 1);
        }
        dp.put(i, result);
        return result;
    }
}