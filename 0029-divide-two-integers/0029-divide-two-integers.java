class Solution {
    public int divide(int dividend, int divisor) {
        long result = helper(dividend, divisor);
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }
    
    private long helper(long dividend, long divisor) {
        if (dividend < 0 && divisor < 0) {
            return helper(-dividend, -divisor);
        }
        if (dividend < 0 || divisor < 0) {
            return -helper(Math.abs(dividend), Math.abs(divisor));
        }
        if (divisor > dividend) {
            return 0;
        }
        long n = 1;
        long acc = divisor;
        while (acc + acc <= dividend) {
            acc = acc + acc;
            n = n + n;
        }
        return n + helper(dividend - acc, divisor);
    }
}