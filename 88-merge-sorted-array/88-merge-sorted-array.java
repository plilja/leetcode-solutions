class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int store = nums1.length - 1;
        int pointer1 = m - 1;
        int pointer2 = n - 1;
        while (pointer1 >= 0 || pointer2 >= 0) {
            boolean take1 = false;
            boolean take2 = false;
            if (pointer1 < 0) {
                take2 = true;
            } else if (pointer2 < 0) {
                take1 = true;
            } else if (nums1[pointer1] > nums2[pointer2]) {
                take1 = true;   
            } else {
                take2 = true;
            }
            if (take1) {
                nums1[store] = nums1[pointer1];
                pointer1--;
            }
            if (take2) {
                nums1[store] = nums2[pointer2];
                pointer2--;
            }
            store--;
        }
    }
}
