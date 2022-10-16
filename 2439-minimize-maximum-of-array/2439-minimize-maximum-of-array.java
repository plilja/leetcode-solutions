class Solution {
    public int minimizeArrayValue(int[] nums) {
        double sum = 0;
        long result = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            double n = nums[i];
            sum += n;
            int sub = (int) Math.ceil(sum / (i + 1));
            result = Math.max(result, sub);
        }
        return (int) result;
    }
}