class FirstUnique {
    private final Map<Integer, Integer> counts = new HashMap<>();
    private final LinkedHashSet<Integer> unique = new LinkedHashSet<>();
    
    public FirstUnique(int[] nums) {
        for (int n : nums) {
            add(n);
        }
    }
    
    public int showFirstUnique() {
        if (unique.isEmpty()) {
            return -1;
        } else {
            return unique.iterator().next();
        }
    }
    
    public void add(int value) {
        int count = counts.merge(value, 1, (a, b) -> a + b);
        if (count == 1) {
            unique.add(value);
        } else if (count == 2) {
            unique.remove(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */