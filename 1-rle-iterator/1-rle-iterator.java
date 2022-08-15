class RLEIterator {
    private final int[] encoding;
    private int pointer;
    private int leftAtPointer;

    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
        this.pointer = 0;
        this.leftAtPointer = encoding[0];
    }
    
    public int next(int n) {
        if (pointer >= encoding.length) {
            return -1;
        }
        int nRem = n;
        while (nRem > leftAtPointer) {
            pointer += 2;
            if (pointer >= encoding.length) {
                return -1;
            }
            nRem -= leftAtPointer;
            leftAtPointer = encoding[pointer];
        }
        leftAtPointer -= nRem;
        return encoding[pointer + 1];
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */
