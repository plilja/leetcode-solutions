class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int a = numbers[left];
            int b = numbers[right];
            if (a + b == target) {
                return new int[]{left + 1, right + 1};
            } else if (a + b < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
