class Solution {
    // min = -2147483648
    // max = 2147483647
    private static int OVERFLOW_LIMIT = Integer.MAX_VALUE / 10 + 1;
    private static int UNDERFLOW_LIMIT = Integer.MIN_VALUE / 10 - 1;
    
    public int reverse(int x) {
        int sign = (int) Math.signum(x);
        int rem = Math.abs(x);
        int result = 0;
        while (rem != 0) {
            int digit = rem % 10;
            if (x > 0) {
                if (result >= OVERFLOW_LIMIT) {
                    return 0;
                }
            } else {
                if (result <= UNDERFLOW_LIMIT) {
                    return 0;
                }
            }
            result = 10 * result;
            if (x > 0) {
                if (result > Integer.MAX_VALUE - digit) {
                    return 0;
                }
            } else {
                if (result < Integer.MIN_VALUE + digit) {
                    return 0;
                }
            }
            result = result + sign * digit;
            rem /= 10;
        }
        return result;
    }
}
