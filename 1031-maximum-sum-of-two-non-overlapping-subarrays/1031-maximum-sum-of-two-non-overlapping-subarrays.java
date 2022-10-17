class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] firstLenDpLeft = calcBestSubArraySumOfLength(nums, firstLen, 0, 1);
        int[] secondLenDpLeft = calcBestSubArraySumOfLength(nums, secondLen, 0, 1);
        int[] firstLenDpRight = calcBestSubArraySumOfLength(nums, firstLen, nums.length - 1, -1);
        int[] secondLenDpRight = calcBestSubArraySumOfLength(nums, secondLen, nums.length - 1, -1);
        int result = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i + 1 >= firstLen && i + secondLen + 1 <= nums.length) {
                result = Math.max(result, firstLenDpLeft[i] + secondLenDpRight[i + 1]);
            }
            if (i + 1 >= secondLen && i + firstLen + 1 <= nums.length) {
                result = Math.max(result, secondLenDpLeft[i] + firstLenDpRight[i + 1]);
            }
        }
        return result;
    }
    
    private int[] calcBestSubArraySumOfLength(int[] nums, int len, int start, int delta) {
        int[] result = new int[nums.length];
        int acc = 0;
        for (int i = start; i >= 0 && i < nums.length; i += delta) {
            acc += nums[i];
            int otherEnd = i - delta * len;
            if (otherEnd >= 0 && otherEnd < nums.length) {
                acc -= nums[otherEnd];
            }
            int prev = i - delta;
            if (prev >= 0 && prev < nums.length) {
                result[i] = Math.max(result[prev], acc);
            } else {
                result[i] = acc;
            }
        }
        return result;
    }
}
