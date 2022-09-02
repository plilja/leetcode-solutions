/*

[1, 1, 2, 2, 3]

*/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int a = 0;
        int b = nums.length / 2 - 1;
        while (a < b) {
            int middle = a + (b - a) / 2;
            int idx = 2 * middle;
            int val = nums[idx];
            int val2 = nums[idx + 1];
            if (val == val2) {
                a = middle + 1;
            } else {
                b = middle;
            }
        }
        if (nums[2*a] != nums[2*a + 1]) {
            return nums[2*a];
        } else {
            return nums[2 * (a + 1)]; // last element
        }
        
    }
}
