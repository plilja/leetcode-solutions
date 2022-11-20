class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Deque<Integer>> m = new HashMap<>();
        for (int i = 0; i < nums2.length; ++i) {
            int v = nums2[i];
            m.computeIfAbsent(v, k -> new ArrayDeque<>()).add(i);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            int v = nums1[i];
            result[i] = m.get(v).poll();
        }
        return result;
    }
}