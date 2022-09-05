class SORTracker {
    private int query = 1;
    private final PriorityQueue<Location> pq1 = new PriorityQueue<>((a, b) -> {
        return -compareLocations(a, b);
    });
    private final PriorityQueue<Location> pq2 = new PriorityQueue<>((a, b) -> {
        return compareLocations(a, b);
    });

    public SORTracker() {
    }
    
    private static int compareLocations(Location a, Location b) {
        if (a.score != b.score) {
            return b.score - a.score;
        } else {
            return a.name().compareTo(b.name);
        }
    }
    
    public void add(String name, int score) {
        pq2.add(new Location(name, score));
        while (!pq1.isEmpty() && !pq2.isEmpty() && compareLocations(pq1.peek(), pq2.peek()) > 0)  {
            Location a = pq1.poll();
            Location b = pq2.poll();
            pq1.add(b);
            pq2.add(a);
        }
    }
    
    public String get() {
        while (pq1.size() < query) {
            pq1.add(pq2.poll());
        }
        query++;
        return pq1.peek().name();
    }
    
    record Location (String name, int score) {
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */
