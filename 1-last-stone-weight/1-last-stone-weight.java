class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int heaviest = pq.poll();
            int secondHeaviest = pq.poll();
            if (heaviest != secondHeaviest) {
                pq.add(heaviest - secondHeaviest);
            }
        }
        if (pq.size() == 1) {
            return pq.poll();
        } else {
            return 0;
        }
    }
}
