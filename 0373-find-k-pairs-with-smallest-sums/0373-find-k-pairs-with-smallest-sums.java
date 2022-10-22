class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Item> pq = new PriorityQueue<>((a, b) -> {
            return a.sum - b.sum;
        });
        pq.add(new Item(nums1[0] + nums2[0], 0, 0));
        Set<Item> visited = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        while (result.size() < k && !pq.isEmpty()) {
            Item item = pq.poll();
            if (visited.contains(item)) {
                continue;
            }
            visited.add(item);
            result.add(List.of(nums1[item.index1], nums2[item.index2]));
            if (item.index1 + 1 < nums1.length) {
                pq.add(new Item(nums1[item.index1 + 1] + nums2[item.index2], item.index1 + 1, item.index2));
            }
            if (item.index2 + 1 < nums2.length) {
                pq.add(new Item(nums1[item.index1] + nums2[item.index2 + 1], item.index1, item.index2 + 1));
            }
        }
        return result;
    }
    
    private record Item(int sum, int index1, int index2) {}
}