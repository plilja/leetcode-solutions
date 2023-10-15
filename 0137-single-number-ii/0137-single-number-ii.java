class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; ++i) {
            int bit = 1 << i;
            int count = 0;
            for (int n : nums) {
                if ((n & bit) != 0) {
                    count++;
                }
            }
            if (count % 3 == 1) {
                result |= bit;
            }
        }
        return result;
    }
}