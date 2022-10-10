class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            int count = 0;
            int c = i;
            while (c != 0) {
                if ((c & 1) != 0) {
                    count++;
                }
                c >>= 1;
            }
            result[i] = count;
        }
        return result;
    }
}