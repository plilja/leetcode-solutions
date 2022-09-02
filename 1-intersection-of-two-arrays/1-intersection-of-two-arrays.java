class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Uniq = new HashSet<>();
        for (int n : nums1) {
            nums1Uniq.add(n);
        }
        Set<Integer> nums2Uniq = new HashSet<>();
        for (int n : nums2) {
            nums2Uniq.add(n);
        }
        nums1Uniq.retainAll(nums2Uniq);
        int[] result = new int[nums1Uniq.size()];
        int i = 0;
        for (int n : nums1Uniq) {
            result[i] = n;
            i++;
        }
        return result;
    }
}
