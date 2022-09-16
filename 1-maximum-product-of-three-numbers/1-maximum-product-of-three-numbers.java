class Solution {
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> pqSmallest = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> pqLargest = new PriorityQueue<>();
        for (int n : nums) {
            pqSmallest.add(n);
            while (pqSmallest.size() > 2) {
                pqSmallest.poll();
            }
            pqLargest.add(n);
            while (pqLargest.size() > 3) {
                pqLargest.poll();
            }
        }
        int result = Integer.MIN_VALUE;
        result = pqLargest.poll() * pqLargest.poll() * pqLargest.peek();
        result = Math.max(result, pqSmallest.poll() * pqSmallest.poll() * pqLargest.poll());
        return result;
    }
}
