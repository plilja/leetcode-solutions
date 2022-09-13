class Solution {
    private static final Random random = new Random();
    private final Map<Integer, List<Integer>> numToIndexes = new HashMap<>();

    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int value = nums[i];
            numToIndexes.computeIfAbsent(value, k -> new ArrayList<>()).add(i);
        }
    }
    
    public int pick(int target) {
        var indexes = numToIndexes.get(target);
        return indexes.get(random.nextInt(indexes.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
