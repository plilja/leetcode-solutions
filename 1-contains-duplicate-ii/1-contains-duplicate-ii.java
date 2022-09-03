class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numToBiggestIndex = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int n = nums[i];
            Integer prevIndex = numToBiggestIndex.get(n);
            if (prevIndex != null && i - prevIndex <= k) {
                return true;
            }
            numToBiggestIndex.put(n, i);
        }
        return false;
    }
}
