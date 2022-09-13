class Solution {
    public int myAtoi(String s) {
        int start = -1;
        int end = -1;
        int sign = 1;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (start == -1) {
                if (c == '-') {
                    start = i + 1;
                    sign = -1;
                } else if (c == '+') {
                    start = i + 1;
                } else if (c >= '0' && c <= '9') {
                    start = i;
                } else if (c != ' ') {
                    return 0; // not valid
                }
            } else if (end == -1) {
                if (c < '0' || c > '9') {
                    end = i - 1;
                }
            }
        }
        if (start == -1) {
            return 0; // Not valid, only spaces
        } else if (end == -1) {
            end = s.length() - 1; // Digits all the way to the end
        }
        long result = 0;
        for (int i = start; i <= end; ++i) {
            int digit = (int) (s.charAt(i) - '0');
            result = 10 * result + sign * digit;
            if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return (int) result;
    }
}
