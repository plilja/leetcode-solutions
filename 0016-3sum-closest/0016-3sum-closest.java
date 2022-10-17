class Solution {
    private static int LARGE = 1000000000;
    
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = LARGE;
        for (int i = 0; i < nums.length; ++i) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
                if (sum > target) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return result;
    }
}