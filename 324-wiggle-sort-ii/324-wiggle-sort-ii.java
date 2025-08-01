class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int i = (sorted.length - 1) / 2;
        int j = 0;
        int k = sorted.length - 1;
        while (i >= 0) {
            nums[j++] = sorted[i];
            i--;
            if (j < nums.length) {
                nums[j++] = sorted[k];
            }
            k--;
        }
    }
}

