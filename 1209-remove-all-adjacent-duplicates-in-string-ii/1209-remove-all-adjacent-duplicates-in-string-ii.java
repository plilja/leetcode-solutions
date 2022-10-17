/*

(1, d), (3, e), (1, d), (2, b), (3, c), (1, b), (1, d), (2, a)

*/
class Solution {
    record CharCount (char c, int count) {}
    
    public String removeDuplicates(String s, int k) {
        Deque<CharCount> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.add(new CharCount(c, 1));
            } else {
                CharCount last = stack.peekLast();
                if (last.c == c) {
                    stack.pollLast();
                    stack.add(new CharCount(c, last.count + 1));
                } else {
                    stack.add(new CharCount(c, 1));
                }
            }
            while (!stack.isEmpty() && stack.peekLast().count >= k) {
                CharCount last = stack.pollLast();
                if (last.count > k) {
                    stack.add(new CharCount(last.c, last.count - k));
                }
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            CharCount first = stack.pollFirst();
            for (int i = 0; i < first.count; ++i) {
                result.append(first.c);
            }
        }
        return result.toString();
    }
    
}
