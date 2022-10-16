class Solution {
    public int findMaxK(int[] numsArr) {
        Set<Integer> nums = new HashSet<>();
        for (int n : numsArr) {
            nums.add(n);
        }
        int best = Integer.MIN_VALUE;
        for (int n : numsArr) {
            if (nums.contains(-n)) {
                best = Math.max(best, n);
            }
        }
        if (best == Integer.MIN_VALUE) {
            return -1;
        } else {
            return best;
        }
    }
}