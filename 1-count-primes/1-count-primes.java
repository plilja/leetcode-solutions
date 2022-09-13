class Solution {
    public int countPrimes(int n) {
        boolean[] sieve = new boolean[n];
        for (int i = 2; i < n; ++i) {
            sieve[i] = true;
        }
        for (int m = 2; m < n; ++m) {
            if (sieve[m]) {
                int i = 2 * m;
                while (i < sieve.length) {
                    sieve[i] = false;
                    i += m;
                }
            }
        }
        int result = 0;
        for (int i = 2; i < n; ++i) {
            result += sieve[i] ? 1 : 0;
        }
        return result;
    }
}
