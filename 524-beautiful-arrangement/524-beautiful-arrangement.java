class Solution {
    public int countArrangement(int n) {
        Set<Integer> nums = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        return helper(1, nums);
    }

    private int helper(int index, Set<Integer> remaining) {
        if (remaining.isEmpty()) {
            return 1;
        }
        int result = 0;
        for (int n : remaining) {
            if (index % n == 0 || n % index == 0) {
                result += helper(index + 1, except(remaining, n));
            }
        }
        return result;
    }

    private Set<Integer> except(Set<Integer> set, int n) {
        var result = new HashSet<>(set);
        result.remove(n);
        return result;
    }
}
