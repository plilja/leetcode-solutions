class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            stack.add(nums[i]);
        }
        int[] result = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && stack.peekLast() <= nums[i]) {
                stack.pollLast();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peekLast();
            }
            stack.add(nums[i]);
        }
        return result;
    }
}