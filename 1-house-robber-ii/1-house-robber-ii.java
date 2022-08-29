class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dpLastHouseNotRobbed = new int[nums.length];
        int[] dpLastHouseRobbed = new int[nums.length];
        dpLastHouseNotRobbed[nums.length - 1] = 0;
        dpLastHouseRobbed[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 1; --i) {
            dpLastHouseNotRobbed[i] = dpLastHouseNotRobbed[i + 1]; // do not rob house i
            dpLastHouseRobbed[i] = dpLastHouseRobbed[i + 1]; // do not rob house i
            if (i + 2 < nums.length) {
                dpLastHouseNotRobbed[i] = Math.max( // house i robbed
                    dpLastHouseNotRobbed[i],
                    dpLastHouseNotRobbed[i + 2] + nums[i]
                );
                dpLastHouseRobbed[i] = Math.max( // house i robbed
                    dpLastHouseRobbed[i],
                    dpLastHouseRobbed[i + 2] + nums[i]
                );
            } else {
                dpLastHouseRobbed[i] = Math.max( // house i robbed
                    dpLastHouseRobbed[i],
                    nums[i]
                );
                dpLastHouseNotRobbed[i] = Math.max( // house i robbed
                    dpLastHouseNotRobbed[i],
                    nums[i]
                );
            }
        }
        return Math.max(
            dpLastHouseRobbed[1],
            dpLastHouseNotRobbed[2] + nums[0]
        );
        
    }
}
