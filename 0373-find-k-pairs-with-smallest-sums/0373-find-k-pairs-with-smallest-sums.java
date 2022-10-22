class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Item> pq = new PriorityQueue<>((a, b) -> {
            return a.sum - b.sum;
        });
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums1.length; ++i) {
            pq.add(new Item(nums1[i] + nums2[0], i, 0));
        }
        while (result.size() < k && !pq.isEmpty()) {
            Item item = pq.poll();
            result.add(List.of(nums1[item.index1], nums2[item.index2]));
            if (item.index2 + 1 < nums2.length) {
                pq.add(new Item(nums1[item.index1] + nums2[item.index2 + 1], item.index1, item.index2 + 1));
            }
        }
        return result;
    }
    
    private record Item(int sum, int index1, int index2) {}
}