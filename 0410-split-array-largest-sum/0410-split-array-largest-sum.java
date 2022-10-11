class Solution {
    public int splitArray(int[] nums, int k) {
        int a = 0;
        int b = 0;
        for (int n : nums) {
            a = Math.max(a, n);
            b += n;
        }
        while (a < b) {
            int middle = (a + b) / 2;
            if (!canSplit(nums, middle, k)) {
                a = middle + 1;
            } else {
                b = middle;
            }
        }
        return a;
    }
    
    private boolean canSplit(int[] nums, int size, int k) {
        int numSplits = 1;
        int currentSplit = 0;
        for (int n : nums) {
            if (n > size) {
                return false;
            }
            if (currentSplit + n <= size) {
                currentSplit += n;
            } else {
                currentSplit = n;
                numSplits++;
            }
        }
        return numSplits <= k;
    }
}