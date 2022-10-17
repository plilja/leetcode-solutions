class RandomizedSet {
    private final Random random = new Random();
    private final Map<Integer, Integer> elemToIdx = new HashMap<>();
    private final ArrayList<Integer> values = new ArrayList<>();

    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if (elemToIdx.containsKey(val)) {
            return false;
        } else {
            values.add(val);
            elemToIdx.put(val, values.size() - 1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (!elemToIdx.containsKey(val)) {
            return false;
        } else {
            int idx = elemToIdx.get(val);
            elemToIdx.remove(val);
            int prevLast = values.get(values.size() - 1);
            values.remove((int) values.size() - 1);
            if (val != prevLast) {
                elemToIdx.put(prevLast, idx);
                values.set(idx, prevLast);
            }
            return true;
        }
    }
    
    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
