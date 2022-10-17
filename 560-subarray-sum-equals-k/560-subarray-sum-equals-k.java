class Solution {
    public int subarraySum(int[] nums, int k) {
        int acc = 0;
        Map<Integer, Integer> leftSums = new HashMap<>();
        int result = 0;
        leftSums.put(0, 1);
        for (int i = 0; i < nums.length; ++i) {
            int n = nums[i];
            acc += n;
            int rem = acc - k;
            result += leftSums.getOrDefault(rem, 0);
            leftSums.merge(acc, 1, (a, b) -> a + b);
        }
        return result;
    }
}
