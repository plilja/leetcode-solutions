class Solution {
    public String decodeString(String s) {
        return decodeStringHelper(s);
    }
    
    private String decodeStringHelper(String s) {
        StringBuilder result = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '[') {
                int j = i;
                while (j - 1 >= 0 && s.charAt(j - 1) >= '0' && s.charAt(j - 1) <= '9') {
                    j--;
                }
                stack.add(j);
            } else if (c == ']') {
                int start = stack.pollLast();
                if (stack.isEmpty()) {
                    int idx = s.indexOf('[', start);
                    int k = Integer.parseInt(s.substring(start, idx));
                    String sub = decodeStringHelper(s.substring(idx + 1, i));
                    for (int j = 0; j < k; ++j) {
                        result.append(sub);
                    }
                }
            } else if (stack.isEmpty()) {
                if (c < '0' || c > '9') {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }
}
