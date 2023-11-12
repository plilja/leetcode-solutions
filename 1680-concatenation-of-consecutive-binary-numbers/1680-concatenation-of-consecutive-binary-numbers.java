class Solution {
    private static final int M = 1000000007;

    public int concatenatedBinary(int n) {
        long result = 0;
        long p = 1;
        for (long i = n; i >= 1; i--) {
            result += i * p;
            result %= M;
            int lengthInBinary = Integer.toBinaryString((int) i).length();
            p = p * (long) Math.pow(2, lengthInBinary);
            p %= M;
        }
        return (int) result;
    }
}
