class Solution {
    public boolean isPerfectSquare(int num) {
        long a = 1;
        long b = num;
        while (a < b) {
            long middle = (a + b) / 2;
            long square = middle * middle;
            if (square == num) {
                return true;
            } else if (square < num) {
                a = middle + 1;
            } else {
                b = middle;
            }
        }
        return a * a == (long) num;
    }
}