class Solution {
    public int trailingZeroes(int n) {
        int fives = 0;
        int twos = 0;
        for (int i = 2; i <= n; ++i) {
            int j = i;
            while (j % 2 == 0) {
                j /= 2;
                twos++;
            }
            while (j % 5 == 0) {
                j /= 5;
                fives++;
            }
        }
        return Math.min(twos, fives);
    }
}