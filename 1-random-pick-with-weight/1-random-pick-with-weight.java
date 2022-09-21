class Solution {
    private final Random random = new Random();
    private final int totalSum;
    private final TreeMap<Integer, Integer> probToValue = new TreeMap<>();

    public Solution(int[] w) {
        int sum = 0;
        for (int n : w) {
            sum += n;
        }
        totalSum = sum;
        int acc = 0;
        for (int i = 0; i < w.length; ++i) {
            probToValue.put(acc, i);
            acc += w[i];
        }
    }
    
    public int pickIndex() {
        int i = random.nextInt(totalSum);
        return probToValue.floorEntry(i).getValue();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
