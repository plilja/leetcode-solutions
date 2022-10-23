class Solution {
    public int integerReplacement(int n) {
        Deque<Long> q = new ArrayDeque<>();
        Deque<Integer> costs = new ArrayDeque<>();
        q.add((long)n);
        costs.add(0);
        while (true) {
            long m = q.poll();
            int cost = costs.poll();
            if (m == 1) {
                return cost;
            }
            if (m % 2 == 0) {
                q.add(m / 2);
                costs.add(cost + 1);
            } else {
                q.add(m - 1);
                costs.add(cost + 1);
                q.add(m + 1);
                costs.add(cost + 1);
            }
        }
    }
}