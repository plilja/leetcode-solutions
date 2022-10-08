class Solution {
    public int validSubarrays(int[] nums) {
        Deque<Integer> stackValue = new ArrayDeque<>();
        Deque<Integer> stackIndex = new ArrayDeque<>();
        int result = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            int v = nums[i];
            while (!stackValue.isEmpty() && stackValue.peekLast() >= v) {
                stackValue.pollLast();
                stackIndex.pollLast();
            }
            if (stackIndex.isEmpty()) {
                result += nums.length - i;
            } else {
                result += stackIndex.peekLast() - i;
            }
            stackValue.add(v);
            stackIndex.add(i);
        }
        return result;
    }
}