class Solution {
    public int[] sortedSquares(int[] nums) {
        int positivePointer = 0;
        while (positivePointer < nums.length && nums[positivePointer] < 0) {
            positivePointer++;
        }
        int negativePointer = positivePointer - 1;
        int[] result = new int[nums.length];
        int i = 0;
        while (negativePointer >= 0 || positivePointer < nums.length) {
            if (negativePointer >= 0 && positivePointer < nums.length) {
                int neg = nums[negativePointer];
                int pos = nums[positivePointer];
                if (-neg < pos) {
                    result[i] = neg * neg;
                    negativePointer--;
                } else {
                    result[i] = pos * pos;
                    positivePointer++;
                }
            } else if (negativePointer >= 0) {
                int neg = nums[negativePointer];
                result[i] = neg * neg;
                negativePointer--;
            } else {
                int pos = nums[positivePointer];
                result[i] = pos * pos;
                positivePointer++;
            }
            i++;
        }
        return result;
    }
}