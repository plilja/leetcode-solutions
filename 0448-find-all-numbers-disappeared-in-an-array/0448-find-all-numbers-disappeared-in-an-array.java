class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        Set<Integer> result = new HashSet<>();
        for (int i = 1; i <= n; ++i) {
            result.add(i);
        }
        for (int j : nums) {
            result.remove(j);
        }
        return new ArrayList<>(result);
    }
}