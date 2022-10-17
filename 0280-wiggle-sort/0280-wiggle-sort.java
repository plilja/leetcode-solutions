class Solution {
    public void wiggleSort(int[] nums) {
        int[] sortedCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedCopy);
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; ++i) {
            if (i % 2 == 0) {
                nums[i] = sortedCopy[left++];
            } else {
                nums[i] = sortedCopy[right--];
            }
        }
    }
}