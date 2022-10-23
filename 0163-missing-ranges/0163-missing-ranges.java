class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int prev = lower - 1;
        for (int n : nums) {
            if (prev + 1 < n) {
                int a = prev + 1;
                int b = n - 1;
                if (a == b) {
                    result.add(String.valueOf(a));
                } else {
                    result.add("%d->%d".formatted(a, b));
                }
            }
            prev = n;
        }
        if (prev < upper) {
            int a = prev + 1;
            int b = upper;
            if (a == b) {
                result.add(String.valueOf(a));
            } else {
                result.add("%d->%d".formatted(a, b));
            }
        }
        return result;
    }
}