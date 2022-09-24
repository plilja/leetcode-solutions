class MyHashMap {
    private static int SIZE = 100000;
    private final List[] table = new List[SIZE];

    public MyHashMap() {
        
    }
    
    public void put(int key, int value) {
        List<Entry> entries = (List<Entry>) table[key % SIZE];
        if (entries == null) {
            entries = new ArrayList<Entry>();
            table[key % SIZE] = entries;
        }
        boolean exists = false;
        for (int i = 0; i < entries.size() && !exists; ++i) {
            var entry = entries.get(i);
            if (entry.key() == key) {
                entries.set(i, new Entry(key, value));
                exists = true;
            }
        }
        if (!exists) {
            entries.add(new Entry(key, value));
        }
    }
    
    public int get(int key) {
        List<Entry> entries = (List<Entry>) table[key % SIZE];
        if (entries != null) {
            return entries.stream()
                .filter(entry -> entry.key() == key)
                .map(entry -> entry.value())
                .findAny()
                .orElse(-1);
        } else {
            return -1;
        }
    }
    
    public void remove(int key) {
        List<Entry> entries = (List<Entry>) table[key % SIZE];
        if (entries != null) {
            entries.removeIf(entry -> entry.key() == key);
            if (entries.isEmpty()) {
                table[key] = null;
            }
        }
    }
    
    private record Entry (int key, int value) {
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */