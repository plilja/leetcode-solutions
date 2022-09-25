class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int a = 0;
        int b = nums.length;
        while (a < b) {
            int middle = (a + b) / 2;
            long v1 = middle > 0 ? nums[middle - 1] : Long.MIN_VALUE;
            long v2 = nums[middle];
            long v3 = middle < nums.length - 1 ? nums[middle + 1] : Long.MIN_VALUE;
            if (v1 < v2 && v2 > v3) {
                return middle;
            } else if (v1 < v2) {
                // Sloping up
                a = middle + 1;
            } else {
                // Sloping down
                b = middle;
            } 
        }
        return a;
    }
}