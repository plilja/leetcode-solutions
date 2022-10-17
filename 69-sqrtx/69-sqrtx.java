class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        long a = 1;
        long b = x - 1;
        while (a < b) {
            long middle = a + (b - a) / 2;
            if (middle * middle < x && (middle + 1) * (middle + 1) <= x) {
                a = middle + 1;
            } else {
                b = middle;
            }
        }
        return (int)a;
    }
}
