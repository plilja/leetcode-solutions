class Solution {
    public boolean isArmstrong(int n) {
        int len = String.valueOf(n).length();
        long sum = 0;
        long curr = n;
        while (curr != 0) {
            long digit = curr % 10;
            curr /= 10;
            long power = 1;
            for (int i = 0; i < len; ++i) {
                power *= digit;
                if (power > n) {
                    return false;
                }
            }
            sum += power;
        }
        return (long) n == sum;
    }
}
