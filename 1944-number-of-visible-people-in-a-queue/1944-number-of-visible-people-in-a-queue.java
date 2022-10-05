class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int[] result = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = heights.length - 1; i >= 0; --i) {
            int h = heights[i];
            int canSee = 0;
            while (!stack.isEmpty() && stack.peekLast() <= h) {
                stack.pollLast();
                canSee++;
            }
            if (!stack.isEmpty()) {
                canSee++;
            }
            stack.add(h);
            result[i] = canSee;
        }
        return result;
    }
}