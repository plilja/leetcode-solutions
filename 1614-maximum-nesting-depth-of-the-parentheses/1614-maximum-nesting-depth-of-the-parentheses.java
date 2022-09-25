class Solution {
    public int maxDepth(String s) {
        int result = 0;
        Deque<Integer> leftParen = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                leftParen.add(i);
            } else if (c == ')') {
                int j = leftParen.pollLast();
                if (leftParen.isEmpty()) {
                    String sub = s.substring(j + 1, i);
                    int subDepth = 1 + maxDepth(sub);
                    result = Math.max(result, subDepth);
                }
            }
        }
        return result;
    }
}