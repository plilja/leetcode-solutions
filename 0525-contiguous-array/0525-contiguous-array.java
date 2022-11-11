class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> diffIndex = new HashMap<>();
        int oddCount = 0;
        int evenCount = 0;
        int result = 0;
        diffIndex.put(0, -1); // the empty array
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
            int diff = evenCount - oddCount;
            if (diffIndex.containsKey(diff)) {
                result = Math.max(result, i - diffIndex.get(diff));
            }
            diffIndex.merge(diff, i, (a, b) -> Math.min(a, b));
        }
        return result;
    }
}