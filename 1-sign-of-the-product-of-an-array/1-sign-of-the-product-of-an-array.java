class Solution {
    public int arraySign(int[] nums) {
        int result = 1;
        for (int n : nums) {
            result *= n;
            if (result > 0) {
                result = 1;
            }
            if (result < 0) {
                result = -1;
            }
        }
        return result;
    }
}
