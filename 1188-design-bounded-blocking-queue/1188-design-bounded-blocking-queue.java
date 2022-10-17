class BoundedBlockingQueue {
    private final Deque<Integer> queue = new ArrayDeque<>();
    private final int capacity;
    
    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
    }
    
    public void enqueue(int element) throws InterruptedException {
        synchronized (queue) {
            while (queue.size() == capacity) {
                queue.wait();
            }
        }
        boolean added = false;
        synchronized (queue) {
            if (queue.size() < capacity) {
                queue.add(element);
                added = true;
                queue.notifyAll();
            }
        }
        if (!added) {
            enqueue(element);
        }
    }
    
    public int dequeue() throws InterruptedException {
        synchronized (queue) {
            while (queue.isEmpty()) {
                queue.wait();
            }
        }
        Integer result = null;
        synchronized (queue) {
            if (!queue.isEmpty()) {
                result = queue.pollFirst();
                queue.notifyAll();
            }
        }
        if (result == null) {
            return dequeue();
        } else {
            return result;
        }
    }
    
    public int size() {
        return queue.size();
    }
}
