class Solution {
    public int minDays(int n) {
        Map<Integer, Integer> visited = new HashMap<>();
        PriorityQueue<Item> q = new PriorityQueue<>((a, b) -> {
            if (a.oranges != b.oranges) {
                return a.oranges - b.oranges;
            }
            return a.cost - b.cost;
        });
        q.add(new Item(0, n));
        int best = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            var item = q.poll();
            int oranges = item.oranges;
            int cost = item.cost;
            if (cost > best) {
                continue;
            }
            if (oranges == 0) {
                best = Math.min(best, cost);
            }
            if (visited.getOrDefault(oranges, Integer.MAX_VALUE) <= cost) {
                continue;
            }
            visited.put(oranges, cost);
            
            // eat 1
            q.add(new Item(cost + 1, oranges - 1));
            
            // eat half
            if (oranges % 2 == 0) {
                q.add(new Item(cost + 1, oranges / 2));
            }
            
            // eat two thirds
            if (oranges % 3 == 0) {
                q.add(new Item(cost + 1, oranges / 3));
            }
        }
        return best;
    }
    
    private record Item(int cost, int oranges) {
    }
    
}