class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> deltas = new TreeMap<>();
        for (int[] trip : trips) {
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];
            deltas.merge(from, numPassengers, (a, b) -> a + b);
            deltas.merge(to, -numPassengers, (a, b) -> a + b);
        }
        int acc = 0;
        for (var entry : deltas.entrySet()) {
            acc += entry.getValue();
            if (acc > capacity) { 
                return false;
            }
        }
        return true;
    }
}
