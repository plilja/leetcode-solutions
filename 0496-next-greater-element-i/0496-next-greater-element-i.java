class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> num2ToIndex = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; --i) {
            num2ToIndex.put(nums2[i], i);
        }
        int[] nextGreater = new int[nums2.length];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = nums2.length -1; i >= 0; --i) {
            int n = nums2[i];
            while (!q.isEmpty() && q.peekLast() <= n) {
                q.pollLast();
            }
            if (q.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = q.peekLast();
            } 
            q.add(n);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            result[i] = nextGreater[num2ToIndex.get(nums1[i])];
        }
        return result;
    }
}
