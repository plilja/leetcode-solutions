class Solution {
    public boolean find132pattern(int[] nums) {
        TreeMap<Integer, Integer> counts = new TreeMap<>();
        for (int i = 0; i < nums.length; ++i) {
            counts.merge(nums[i], 1, (a, b) -> a + b);
        }
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            int val = nums[i];
            counts.merge(val, -1, (a, b) -> a + b);
            if (counts.get(val) == 0) {
                counts.remove(val);
            }
            Integer secondSmallest = counts.ceilingKey(smallest + 1);
            smallest = Math.min(smallest, val);
            if (secondSmallest != null && val > smallest && val > secondSmallest) {
                return true;
            }
        }
        return false;
    }
}
