class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        int[] suffixProduct = new int[nums.length];
        int acc = 1;
        for (int i = 0; i < nums.length; ++i) {
            acc *= nums[i];
            prefixProduct[i] = acc;
        }
        acc = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            acc *= nums[i];
            suffixProduct[i] = acc;
        }
        int result[] = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            int prod = 1;
            if (i > 0) {
                prod *= prefixProduct[i - 1];
            }
            if (i < nums.length - 1) {
                prod *= suffixProduct[i + 1];
            }
            result[i] = prod;
        }
        return result;
    }
}
