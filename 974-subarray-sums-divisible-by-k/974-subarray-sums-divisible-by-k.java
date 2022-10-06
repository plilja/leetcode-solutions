class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> prefixSums = new HashMap<>();
        int result = 0;
        int acc = 0;
        prefixSums.put(0, 1);
        for (int n : nums) {
            acc += n;
            acc %= k;
            if (acc < 0) {
                acc += k;
            }
            result += prefixSums.getOrDefault(acc, 0);
            prefixSums.merge(acc, 1, (a, b) -> a + b);
        }
        return result;
    }
}