class Solution {
    private static final int MOD = 1000000007;
    
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        Map<Integer, Integer> twoSumCounts = new HashMap<>();
        long result = 0;
        for (int i = 0; i < arr.length; ++i) {
            int v = arr[i];
            int rem = target - v;
            result += twoSumCounts.getOrDefault(rem, 0);
            result %= MOD;
            for (int j = 0; j < i; ++j) {
                int y = arr[j];
                int sum = v + y;
                twoSumCounts.merge(sum, 1, (a, b) -> a + b);
            }
        }
        return (int) result;
    }
}