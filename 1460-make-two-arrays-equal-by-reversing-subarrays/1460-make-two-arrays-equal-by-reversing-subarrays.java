class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        return getCounts(target).equals(getCounts(arr));
    }
    
    private Map<Integer, Integer> getCounts(int[] nums) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int n : nums) {
            result.merge(n, 1, (a, b) -> a + b);
        }
        return result;
    }
}
