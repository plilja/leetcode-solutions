class CustomStack {
    private final ArrayList<Integer> list = new ArrayList<>();
    private final int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if (list.size() < maxSize) {
            list.add(x);
        }
    }
    
    public int pop() {
        if (list.isEmpty()) {
            return -1;
        } else {
            int result = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return result;
        }
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, list.size()); ++i) {
            list.set(i, list.get(i) + val);
        }
    }
}