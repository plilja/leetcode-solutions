class MovingAverage {
    private final Deque<Integer> slidingNumbers = new ArrayDeque<>();
    private final int size;
    private double slidingWindowSum = 0;

    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        while (slidingNumbers.size() >= size) {
            int oldest = slidingNumbers.poll();
            slidingWindowSum -= oldest;
        }
        slidingWindowSum += val;
        slidingNumbers.add(val);
        return slidingWindowSum / slidingNumbers.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
