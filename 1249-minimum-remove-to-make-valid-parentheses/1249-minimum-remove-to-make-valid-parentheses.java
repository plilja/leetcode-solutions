/*

(a(b(c

*/
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;
        int[] rightParen = new int[s.length() + 1];
        rightParen[s.length()] = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            char c = s.charAt(i);
            if (c == ')') {
                rightParen[i] = rightParen[i + 1] + 1;
            } else {
                rightParen[i] = rightParen[i + 1];
            }
        }
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                if (balance < rightParen[i]) {
                    balance++;
                    result.append(c);
                }
            } else if (c == ')') {
                if (balance > 0) {
                    balance--;
                    result.append(c);
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
