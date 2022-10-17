class Solution {
    private static long MOD = 1000000007;
    
    public int maxSumMinProduct(int[] nums) {
        long[] sums = new long[nums.length];
        long acc = 0;
        for (int i = 0; i < nums.length; ++i) {
            acc += nums[i];
            sums[i] = acc;
        }
        int[] smallerLeft = calcSmallerLeft(nums);
        int[] smallerRight = calcSmallerRight(nums);
        long result = 0;
        for (int i = 0; i < nums.length; ++i) {
            long left = smallerLeft[i] >= 0 ? sums[smallerLeft[i]] : 0;
            long right = sums[smallerRight[i] - 1];
            long sub = nums[i] * (right - left);
            result = Math.max(result, sub);
        }
        return (int) (result % MOD);
    }
    
    private int[] calcSmallerLeft(int[] nums) {
        Deque<Elem> stack = new ArrayDeque<>();
        int[] smallerLeft = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            int value = nums[i];
            while (!stack.isEmpty() && stack.peekLast().value() > value) {
                stack.pollLast();
            } 
            if (stack.isEmpty()) {
                smallerLeft[i] = -1;
            } else {
                smallerLeft[i] = stack.peekLast().index();
            }
            stack.add(new Elem(i, value));
        }
        return smallerLeft;
    }
    
    private int[] calcSmallerRight(int[] nums) {
        Deque<Elem> stack = new ArrayDeque<>();
        int[] smallerRight = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; --i) {
            int value = nums[i];
            while (!stack.isEmpty() && stack.peekLast().value() >= value) {
                stack.pollLast();
            } 
            if (stack.isEmpty()) {
                smallerRight[i] = nums.length;
            } else {
                smallerRight[i] = stack.peekLast().index();
            }
            stack.add(new Elem(i, value));
        }
        return smallerRight;
    }
    
    record Elem(int index, int value) {
    }
}
