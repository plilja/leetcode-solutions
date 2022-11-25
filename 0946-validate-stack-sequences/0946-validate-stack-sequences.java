class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        for (int v : pushed) {
            stack.add(v);
            while (!stack.isEmpty() && stack.peekLast() == popped[i]) {
                stack.pollLast();
                i++;
            }
        }
        return i == popped.length;
    }
}