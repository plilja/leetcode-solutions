class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int result = Integer.MIN_VALUE;
        TreeMap<Integer, Integer> valueToIndex = new TreeMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int v = nums[i];
            int rem = k - v - 1;
            var entry = valueToIndex.floorEntry(rem);
            if (entry != null) {
                result = Math.max(result, v + entry.getKey());
            }
            valueToIndex.put(v, i);
        }
        if (result == Integer.MIN_VALUE) {
            return -1;
        } else {
            return result;
        }
    }
}
