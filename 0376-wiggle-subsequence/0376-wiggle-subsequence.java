class Solution {
    public int wiggleMaxLength(int[] nums) {
        int[] dpInc = new int[nums.length];
        int[] dpDec = new int[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            dpInc[i] = 1;
            dpDec[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dpInc[i] = Math.max(dpInc[i], dpDec[j] + 1);
                }
                if (nums[j] > nums[i]) {
                    dpDec[i] = Math.max(dpDec[i], dpInc[j] + 1);
                }
            }
            result = Math.max(Math.max(result, dpInc[i]), dpDec[i]);
        }
        return result;
    }
}