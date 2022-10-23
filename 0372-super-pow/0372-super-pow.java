import java.math.*;

class Solution {
    private static final int MOD = 1337;
    
    public int superPow(int a, int[] b) {
        StringBuilder sb = new StringBuilder();
        for (int d : b) {
            sb.append(d);
        }
        return solve(a % MOD, new BigInteger(sb.toString()));
    }
    
    private int solve(int a, BigInteger b) {
        if (BigInteger.ZERO.equals(b)) {
            return 1;
        } else if (BigInteger.ONE.equals(b)) {
            return a;
        } else if (b.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            int t = solve(a, b.divide(BigInteger.TWO));
            return t * t % MOD;
        } else {
            int t = solve(a, b.subtract(BigInteger.ONE));
            return a * t % MOD;
        }
    }
}