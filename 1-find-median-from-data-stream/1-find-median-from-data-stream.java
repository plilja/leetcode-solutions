class MedianFinder {
    private PriorityQueue<Integer> smaller = new PriorityQueue<>((a, b) -> b - a);
    private PriorityQueue<Integer> larger = new PriorityQueue<>((a, b) -> a - b);

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if (!larger.isEmpty() && num > larger.peek()) {
            larger.add(num);
        } else {
            smaller.add(num);
        }
        while (smaller.size() > larger.size() + 1) {
            int value = smaller.poll();
            larger.add(value);
        }
        while (larger.size() > smaller.size()) {
            int value = larger.poll();
            smaller.add(value);
        }
    }
    
    public double findMedian() {
        var sm = smaller;
        var lg = larger;
        if (smaller.size() - 1 == larger.size()) {
            return (double) smaller.peek();
        } else {
            double a = (double)smaller.peek();
            double b = (double)larger.peek();
            return (a + b) / 2;
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
