class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int a = 0;
        int b = 0;
        for (int w : weights) {
            b += w;
        }
        while (a < b) {
            int middle = a + (b - a) / 2;
            if (!canShip(weights, days, middle)) {
                a = middle + 1;
            } else {
                b = middle;
            }
        }
        return a;
    }
    
    private boolean canShip(int[] weights, int days, int capacity) {
        int daysNeeded = 1;
        int currentDay = 0;
        for (int weight : weights) {
            if (weight > capacity) {
                return false;
            }
            if (currentDay + weight > capacity) {
                currentDay = weight;
                daysNeeded++;
            } else {
                currentDay += weight;
            }
        }
        return daysNeeded <= days;
    }
}
