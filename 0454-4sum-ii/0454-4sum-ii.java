class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> m1 = combos(nums1, nums2);
        Map<Integer, Integer> m2 = combos(nums3, nums4);
        int result = 0;
        for (var entry : m1.entrySet()) {
            result += m2.getOrDefault(-entry.getKey(), 0) * entry.getValue();
        }
        return result;
    }

    private Map<Integer, Integer> combos(int[] numsA, int[] numsB) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int a : numsA) {
            for (int b : numsB) {
                result.merge(a + b, 1, Integer::sum);
            }
        }
        return result;
    }
}