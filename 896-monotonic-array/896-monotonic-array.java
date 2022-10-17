class Solution {
    public boolean isMonotonic(int[] nums) {
        Boolean increasing = null;
        for (int i = 1; i < nums.length; ++i) {
            int curr = nums[i];
            int prev = nums[i - 1];
            if (prev > curr) {
                if (increasing == null) {
                    increasing = false;
                } else if (increasing) {
                    return false;
                }
            } 
            if (prev < curr) {
                if (increasing == null) {
                    increasing = true;
                } else if (!increasing) {
                    return false;
                }
            }
        }
        return true;
    }
}
