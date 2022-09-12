class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
        int last = nums[nums.length - 1];
        if (last == 0) {
            dp.computeIfAbsent(nums.length - 1, k -> new HashMap<>()).put(last, 2);
        } else {
            dp.computeIfAbsent(nums.length - 1, k -> new HashMap<>()).put(last, 1);
            dp.computeIfAbsent(nums.length - 1, k -> new HashMap<>()).put(-last, 1);
        }
        for (int i = nums.length - 2; i >= 0; --i) {
            int n = nums[i];
            Map<Integer, Integer> canReach = new HashMap<>();
            for (var entry : dp.get(i + 1).entrySet()) {
                if (n == 0) {
                    canReach.merge(entry.getKey() - n, 2 * entry.getValue(), (a, b) -> a + b);
                } else {
                    canReach.merge(entry.getKey() - n, entry.getValue(), (a, b) -> a + b);
                    canReach.merge(entry.getKey() + n, entry.getValue(), (a, b) -> a + b);
                }
            }
            dp.put(i, canReach);
        }
        return dp.get(0).getOrDefault(target, 0);
    }
}
