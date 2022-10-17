class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> distinct = new HashSet<>();
        for (int n : nums) {
            if (n > 0) {
                distinct.add(n);
            }
        }
        return distinct.size();
    }
}
