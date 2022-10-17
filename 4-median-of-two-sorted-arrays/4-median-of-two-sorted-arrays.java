
class Solution {
    private static int INF = Integer.MAX_VALUE;
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int totalSize = nums1.length + nums2.length;
        int target = (totalSize + 1) / 2;
        int a = 0;
        int b = nums1.length;
        while (true) {
            int middle = (a + b) / 2;
            int leftIndex = middle - 1;
            int rightIndex = target - middle - 1;
            int left = leftIndex < 0 ? -INF : nums1[leftIndex];
            int right = rightIndex < 0 ? -INF : nums2[rightIndex];
            int leftNext = leftIndex + 1 >= nums1.length ? INF : nums1[leftIndex + 1];
            int rightNext = rightIndex + 1 >= nums2.length ? INF : nums2[rightIndex + 1];
            if (rightNext < left) {
                b = middle;
            } else if (leftNext < right) {
                a = middle + 1;
            } else {
                // solved
                double n1 = Math.max(left, right);
                if (totalSize % 2 == 0) {
                    double n2 = Math.min(leftNext, rightNext);
                    return (n1 + n2) / 2;
                } else {
                    return n1;
                }
            }
            
        }
    }
}
