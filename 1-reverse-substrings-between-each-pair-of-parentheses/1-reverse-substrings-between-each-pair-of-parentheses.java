class Solution {
    public String reverseParentheses(String s) {
        char[] letters = s.toCharArray();
        Deque<Integer> leftParen = new ArrayDeque<>();
        for (int i = 0; i < letters.length; ++i) {
            char c = letters[i];
            if (c == '(') {
                leftParen.add(i);
            } else if (c == ')') {
                int start = leftParen.pollLast();
                reverse(letters, start, i);
            } 
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < letters.length; ++i) {
            char c = letters[i];
            if (c != '(' && c != ')') {
                result.append(c);
            }
        }
        return result.toString();
    }
    
    private void reverse(char[] letters, int start, int end) {
        int middle = (end - start + 1) / 2;
        for (int i = 0; i < middle; ++i) {
            char leftTmp = letters[start + i];
            letters[start + i] = letters[end - i];
            letters[end - i] = leftTmp;
        }
    }
}
