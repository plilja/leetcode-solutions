class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int index = -1;
        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            Arrays.sort(nums);
        } else {
            int minIndex = index + 1;
            for (int i = index + 2; i < nums.length; ++i) {
                if (nums[i] > nums[index] && nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
            }
            int tmp = nums[minIndex];
            nums[minIndex] = nums[index];
            nums[index] = tmp;
            Arrays.sort(nums, index + 1, nums.length);
        }
        
    }
}
