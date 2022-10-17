class HitCounter {
    private final TreeMap<Integer, Integer> hitCount = new TreeMap<>();
    private int lastHit = -1;

    public HitCounter() {
        
    }
    
    public void hit(int timestamp) {
        if (lastHit == timestamp) {
            hitCount.merge(timestamp, 1, (a, b) -> a + b);
        } else {
            int prevHits = 0;
            if (lastHit != -1) {
                prevHits = hitCount.get(lastHit);
            }
            hitCount.put(timestamp, prevHits + 1);
            lastHit = timestamp;
        }
    }
    
    public int getHits(int timestamp) {
        int limit = timestamp - 60 * 5;
        var val = hitCount.floorEntry(timestamp);
        if (val != null && val.getKey() > limit) {
            var valLimit = hitCount.floorEntry(limit);
            int result = val.getValue();
            if (valLimit != null) {
                result -= valLimit.getValue();
            }
            return result;
        } else {
            return 0;
        }
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
