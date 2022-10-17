import java.math.*;

class Solution {
    public boolean splitString(String s) {
        for (int i = 1; i < s.length(); ++i) {
            String sub = s.substring(0, i);
            BigInteger value = new BigInteger(sub);
            if (solve(s, i, value.subtract(BigInteger.ONE))) {
                return true;
            }
        }
        return false;
    }
    
    public boolean solve(String s, int i, BigInteger next) {
        if (i == s.length()) {
            return true;
        }
        for (int j = i + 1; j <= s.length(); ++j) {
            String sub = s.substring(i, j);
            BigInteger value = new BigInteger(sub);
            if (value.equals(next) && solve(s, j, value.subtract(BigInteger.ONE))) {
                return true;
            }
        }
        return false;
    }
}