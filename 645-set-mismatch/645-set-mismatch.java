class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        Integer removed = null;
        Integer duplicated = null;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 != nums[i]) {
                if (nums[i - 1] == nums[i]) {
                    duplicated = nums[i];
                } else {
                    removed = nums[i] - 1;
                }
            }
        }
        if (removed == null) {
            if (nums[0] != 1) {
                removed = 1;
            } else {
                removed = nums[nums.length - 1] + 1;
            }
        }
        return new int[]{duplicated, removed};
    }
}

