class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 1 / (x * myPow(x, -n - 1));
        } else if (n % 2 == 1) {
            return x * myPow(x, n - 1);
        } else {
            int nHalf = n / 2;
            double sub = myPow(x, nHalf);
            return sub * sub;
        }
    }
}
