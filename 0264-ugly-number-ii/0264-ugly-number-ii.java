class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);
        List<Long> uglyNumbers = new ArrayList<>();
        while (uglyNumbers.size() < n) {
            long k = pq.poll();
            if (uglyNumbers.isEmpty() || uglyNumbers.get(uglyNumbers.size() - 1) != k) {
                uglyNumbers.add(k);
                pq.add(k * 2);
                pq.add(k * 3);
                pq.add(k * 5);
            }
        }
        return uglyNumbers.get(n - 1).intValue();
    }
}