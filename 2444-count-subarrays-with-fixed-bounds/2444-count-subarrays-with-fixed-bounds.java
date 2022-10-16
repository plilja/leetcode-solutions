class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        if (minK > maxK) {
            return 0;
        }
        int rangeIndex = nums.length;
        int minIndex = nums.length;
        int maxIndex = nums.length;
        long result = 0;
        for (int i = 0; i < nums.length; ++i) {
            int v = nums[i];
            if (v >= minK && v <= maxK) {
                rangeIndex = Math.min(rangeIndex, i);
            }
            if (v == minK) {
                minIndex = i;
            } else if (v < minK) {
                rangeIndex = nums.length;
                minIndex = nums.length;
                maxIndex = nums.length;
            } 
            if (v == maxK) {
                maxIndex = i;
            } else if (v > maxK) {
                rangeIndex = nums.length;
                minIndex = nums.length;
                maxIndex = nums.length;
            }
            if (minIndex <= i && maxIndex <= i) {
                result += Math.min(minIndex, maxIndex) - rangeIndex + 1;
            }
        }
        return result;
    }
}