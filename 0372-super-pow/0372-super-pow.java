import java.math.*;

class Solution {
    private static final int MOD = 1337;
    
    public int superPow(int a, int[] b) {
        long acc = 1;
        for (int i = 0; i < b.length; ++i) {
            int d = b[i];
            long accPow10 = 1;
            for (int j = 0; j < 10; ++j) {
                accPow10 = accPow10 * acc % MOD;
            }
            acc = accPow10;
            for (int j = 0; j < d; ++j) {
                acc = acc * ((long)a) % MOD;
            }
        }
        return (int) acc;
    }
    
}