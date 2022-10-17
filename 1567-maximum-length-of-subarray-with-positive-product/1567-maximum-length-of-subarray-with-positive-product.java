class Solution {
    public int getMaxLen(int[] nums) {
        int result = 0;
        int start = 0;
        List<Integer> negativeIndexes = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            if (num == 0) {
                negativeIndexes.clear();
                start = i + 1;
            } else if (num < 0) {
                negativeIndexes.add(i);
            }
            if (negativeIndexes.size() % 2 == 0) {
                result = Math.max(result, i - start + 1);
            } else {
                result = Math.max(result, i - negativeIndexes.get(0));
            }
        }
        return result;
    }
}
