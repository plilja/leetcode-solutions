class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int oddPointer = 0;
        int evenPointer = 0;
        while (oddPointer < nums.length && evenPointer < nums.length) {
            while (oddPointer < nums.length && nums[oddPointer] % 2 == 0) {
                oddPointer++;
            }
            while (evenPointer < nums.length && nums[evenPointer] % 2 == 1) {
                evenPointer++;
            }
            if (evenPointer < nums.length && oddPointer < nums.length) {
                if (evenPointer > oddPointer) {
                    swap(nums, evenPointer, oddPointer);
                    evenPointer++;
                    oddPointer++;
                } else {
                    evenPointer++;
                }
            }
        }
        return nums;
    }
    
    private void swap(int[] nums, int a, int b) {
        int aTmp = nums[a];
        nums[a] = nums[b];
        nums[b] = aTmp;
    }
}