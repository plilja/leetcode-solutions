class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        Integer biggestPositiveLeft = null;
        Integer smallestNegativeLeft = null;
        for (int n : nums) {
            if (n == 0) {
                biggestPositiveLeft = null;
                smallestNegativeLeft = null;
            } else if (n > 0) {
                if (biggestPositiveLeft != null) {
                    biggestPositiveLeft *= n;
                } else {
                    biggestPositiveLeft = n;
                }
                if (smallestNegativeLeft != null) {
                    smallestNegativeLeft *= n;
                }
            } else {
                Integer biggestPositiveLeftTmp = biggestPositiveLeft;
                biggestPositiveLeft = smallestNegativeLeft;
                if (biggestPositiveLeft != null) {
                    biggestPositiveLeft *= n;
                }
                smallestNegativeLeft = biggestPositiveLeftTmp;
                if (smallestNegativeLeft != null) {
                    smallestNegativeLeft *= n;
                } else {
                    smallestNegativeLeft = n;
                }
            }
            result = Math.max(n, result);
            if (biggestPositiveLeft != null) {
                result = Math.max(result, biggestPositiveLeft);
            }
        }
        return result;
    }
}
