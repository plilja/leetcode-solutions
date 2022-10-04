class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums2Counts = new HashMap<>();
        for (int n : nums2) {
            nums2Counts.merge(n, 1, (a, b) -> a + b);
        }
        List<Integer> result = new ArrayList<>();
        for (int n : nums1) {
            int k = nums2Counts.merge(n, -1, (a, b) -> a + b);
            if (k >= 0) {
                result.add(n);
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            arr[i] = result.get(i); 
        }
        return arr;
    }
}