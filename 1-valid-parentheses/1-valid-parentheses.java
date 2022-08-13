class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            switch (c) {
                    case '[' -> stack.add(']');
                    case '(' -> stack.add(')');
                    case '{' -> stack.add('}');
                    case ']', ')', '}' -> {
                        if (stack.isEmpty()) {
                            return false;
                        }
                        char expectedRight = stack.pollLast();
                        if (expectedRight != c) {
                            return false;
                        }
                    }
            }
        }
        return stack.isEmpty();
    }
}
