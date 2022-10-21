class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>(); 
        for (String op : operations) {
            if ("C".equals(op)) {
                stack.pollLast();
            } else if ("D".equals(op)) {
                int last = stack.peekLast();
                stack.add(2 * last);
            } else if ("+".equals(op)) {
                int last = stack.pollLast();
                int lastToLast = stack.peekLast();
                stack.add(last); // add it back
                stack.add(last + lastToLast);
            } else {
                stack.add(Integer.parseInt(op));
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pollLast();
        }
        return result;
    }
}