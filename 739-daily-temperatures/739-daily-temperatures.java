class Solution {
    record Day(int index, int temp) {}
    
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Day> stack = new ArrayDeque<>();
        for (int i = temperatures.length - 1; i >= 0; --i) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && stack.peekLast().temp() <= temp) {
                stack.pollLast();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peekLast().index() - i;
            }
            stack.add(new Day(i, temp));
        }
        return result;
    }
}
