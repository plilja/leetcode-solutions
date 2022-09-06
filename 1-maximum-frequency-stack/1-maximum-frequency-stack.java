class FreqStack {
    
    record Elem (int value, int pushTime) implements Comparable<Elem> {
        @Override
        public int compareTo(Elem other) {
            return other.pushTime - pushTime;
        }
    }
    
    private int nextPushTime = 0;
    private TreeMap<Integer, TreeSet<Elem>> countToValues = new TreeMap<>();
    private Map<Integer, Integer> valueToCount = new HashMap<>();

    public FreqStack() {
        
    }
    
    public void push(int val) {
        int newCount = valueToCount.merge(val, 1, (a, b) -> a + b);
        countToValues.computeIfAbsent(newCount, k -> new TreeSet<>()).add(new Elem(val, nextPushTime));
        nextPushTime++;
    }
    
    public int pop() {
        while (countToValues.lastEntry().getValue().isEmpty()) {
            countToValues.pollLastEntry();
        }
        var entry = countToValues.lastEntry();
        var elem = entry.getValue().first();
        entry.getValue().remove(elem);
        valueToCount.merge(elem.value(), -1, (a, b) -> a + b);
        return elem.value();
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
