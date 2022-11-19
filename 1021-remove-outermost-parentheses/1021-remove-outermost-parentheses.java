class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.add(i);
            } else if (c == ')') {
                int j = stack.pollLast();
                if (stack.isEmpty()) {
                    result.append(s.substring(j + 1, i));
                }
            } else {
                throw new IllegalArgumentException("Unknown character " + c + " encountered");
            }
        }
        return result.toString();
    }
}