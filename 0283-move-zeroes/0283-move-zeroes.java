class Solution {
    public void moveZeroes(int[] nums) {
       int zeroCount = 0; 
       for (int i = 0; i < nums.length; ++i) {
           int val = nums[i];
           if (val == 0) {
               zeroCount++;
           } else {
               nums[i - zeroCount] = val;
           }
       }
       for (int j = 0; j < zeroCount; ++j) {
           nums[nums.length - 1 - j] = 0;
       }
    }
}
