class PhoneDirectory {
    private final int maxNumber;
    private final TreeSet<Integer> recycled = new TreeSet<Integer>();
    private int lastUsed = -1;

    public PhoneDirectory(int maxNumbers) {
        this.maxNumber = maxNumbers - 1;
    }
    
    public int get() {
        if (!recycled.isEmpty()) {
            int result = recycled.iterator().next();
            recycled.remove(result);
            return result;
        } else if (lastUsed + 1 <= maxNumber) {
            lastUsed++;
            return lastUsed;
        } else {
            return -1;
        }
    }
    
    public boolean check(int number) {
        return recycled.contains(number) || (lastUsed < number && number <= maxNumber);
    }
    
    public void release(int number) {
        if (number <= maxNumber && number >= 0 && number <= lastUsed) {
            recycled.add(number);
        }
    }
}