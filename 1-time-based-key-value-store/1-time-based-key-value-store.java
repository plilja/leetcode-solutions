class TimeMap {
    private Map<String, TreeMap<Integer, String>> internalMap = new HashMap<>();

    
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        internalMap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        var m = internalMap.computeIfAbsent(key, k -> new TreeMap<>());
        var entry = m.floorEntry(timestamp);
        if (entry == null) {
            return "";
        } else {
            return entry.getValue();
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
