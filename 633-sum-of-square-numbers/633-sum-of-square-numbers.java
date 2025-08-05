class Solution {
    public boolean judgeSquareSum(int c) {
        long lim = (long) Math.sqrt(c);
        for (long a = 0; a <= lim; ++a) {
            long aSquared = a * a;
            long rem = c - aSquared;
            long b = (long) Math.sqrt(rem);
            if (aSquared + b * b == c) {
                return true;
            }
        }
        return false;
    }
}

