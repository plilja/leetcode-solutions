class Solution {
    public int maxDistToClosest(int[] seats) {
        int[] distLeft = new int[seats.length];
        int left = -seats.length - 1; // no one is close if sitting at the edge
        for (int i = 0; i < seats.length; ++i) {
            if (seats[i] == 1) {
                left = i;
            }
            distLeft[i] = i - left;
        }
        int[] distRight = new int[seats.length];
        int right = 2 * seats.length + 1; // no one is close if sitting at the edge
        for (int i = seats.length - 1; i >= 0; --i) {
            if (seats[i] == 1) {
                right = i;
            }
            distRight[i] = right - i;
        }
        int result = 0;
        for (int i = 0; i < seats.length; ++i) {
            result = Math.max(result, Math.min(distLeft[i], distRight[i]));
        }
        return result;
    }
}