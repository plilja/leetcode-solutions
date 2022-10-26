class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int sum = nums[i] + nums[j];
                int a = j + 1;
                int b = nums.length;
                while (a < b) {
                    int middle = (a + b) / 2;
                    int value = nums[middle];
                    if (sum + value < target) {
                        a = middle + 1;
                    } else {
                        b = middle;
                    }
                }
                if (a <= nums.length) {
                    int t = a - j - 1;
                    result += t;
                }
            }
        }
        return result;
    }
}