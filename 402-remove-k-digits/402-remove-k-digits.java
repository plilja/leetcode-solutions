class Solution {
    public String removeKdigits(String num, int k) {
        int rem = k;
        var stack = new ArrayDeque<Character>();
        for (int i = 0; i < num.length(); ++i) {
            char c = num.charAt(i);
            while (rem > 0 && !stack.isEmpty() && stack.peekLast() > c) {
                rem--;
                stack.pollLast();
            }
            stack.addLast(c);
        }
        while (!stack.isEmpty() && stack.peekFirst() == '0') {
            stack.pollFirst();
        }
        while (!stack.isEmpty() && rem > 0) {
            stack.pollLast();
            rem--;
        }
        if (stack.isEmpty()) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }
}
