class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int start = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (i + 1 >= nums.length || nums[i + 1] > n + 1) {
                if (start == n) {
                    result.add(String.valueOf(start));
                } else {
                    result.add("%d->%d".formatted(start, n));
                }
                if (i + 1 < nums.length) {
                    start = nums[i + 1];
                }
            }
        }
        return result;
    }
}

