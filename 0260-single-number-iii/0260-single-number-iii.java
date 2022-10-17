class Solution {
    public int[] singleNumber(int[] nums) {
        int acc = 0;
        for (int n : nums) {
            acc ^= n;
        }
        int lastBit = acc & (-acc);
        int a = 0;
        for (int n : nums) {
            if ((n & lastBit) != 0) {
                a ^= n;
            }
        }
        int b = acc ^ a;
        return new int[]{a, b};
    }
}