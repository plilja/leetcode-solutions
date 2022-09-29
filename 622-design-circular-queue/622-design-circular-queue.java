class MyCircularQueue {
    private final int[] buffer;
    private int size = 0;
    private int pointer = 0;

    public MyCircularQueue(int k) {
        buffer = new int[k];
    }
    
    public boolean enQueue(int value) {
        if (size < buffer.length) {
            buffer[pointer] = value;
            size++;
            pointer = (pointer + 1) % buffer.length;
            return true;
        } else {
            return false;
        }
        
    }
    
    public boolean deQueue() {
        if (size == 0) {
            return false;
        } else {
            size--;
            return true;
        }
    }
    
    public int Front() {
        if (size > 0) {
            int index = pointer - size;
            if (index < 0) {
                index += buffer.length;
            }
            return buffer[index];
        } else {
            return -1;
        }
    }
    
    public int Rear() {
        if (size > 0) {
            int index = pointer - 1;
            if (index < 0) {
                index += buffer.length;
            }
            return buffer[index];
        } else {
            return -1;
        }
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == buffer.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */