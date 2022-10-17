class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dpVal = new int[nums.length];
        int[] dpCount = new int[nums.length];
        int lis = -1;
        for (int i = nums.length - 1; i >= 0; --i) {
            dpVal[i] = 1;
            dpCount[i] = 1;
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] > nums[i]) {
                    if (dpVal[j] + 1 > dpVal[i]) {
                        dpVal[i] = dpVal[j] + 1;
                        dpCount[i] = dpCount[j];
                    } else if (dpVal[j] + 1 == dpVal[i]) {
                        dpCount[i] += dpCount[j];
                    }
                }
            }
            lis = Math.max(lis, dpVal[i]);
        }
        int result = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (dpVal[i] == lis) {
                result += dpCount[i];
            }
        }
        return result;
    }
}