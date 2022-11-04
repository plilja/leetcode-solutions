class Solution {
    public int minAddToMakeValid(String s) {
        int balance = 0;
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                if (balance == 0) {
                    result++; // need to add a '('
                } else {
                    balance--;
                }
            } else {
                throw new IllegalArgumentException("Encountered unexpected character " + c);
            }
        }
        result += balance;
        return result;
    }
}