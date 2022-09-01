/*
[1] => true
[1, 2] => true
[1, -1, 3] => true, change -1 to 2
[1, -1, 2] => true
*/
class Solution {
    public boolean checkPossibility(int[] nums) {
        int changesRequired = 0;
        for (int i = 0; i < nums.length && changesRequired <= 1; ++i) {
            int prev = Integer.MIN_VALUE;
            if (i > 0) {
                prev = nums[i - 1];
            }
            int next = Integer.MAX_VALUE;
            if (i < nums.length - 1) {
                next = nums[i + 1];
            }
            int curr = nums[i];
            if (next < curr) {
                if (next >= prev) {
                    nums[i] = next;
                    curr = next;
                    changesRequired++;
                }
            }
            if (prev > curr) {
                nums[i] = prev;
                changesRequired++;
            }
        }
        return changesRequired <= 1;
    }
}
