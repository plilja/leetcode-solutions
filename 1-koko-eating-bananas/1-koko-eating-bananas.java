class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int n : piles) {
            max = Math.max(n, max);
        }
        int a = 1;
        int b = max;
        while (a < b) {
            int eatSpeed = a + (b - a) / 2;
            int timeTaken = 0;
            for (int n : piles) {
                timeTaken += (n + eatSpeed - 1) / eatSpeed;
            }
            if (timeTaken <= h) {
                b = eatSpeed;
            } else {
                a = eatSpeed + 1;
            }
        }
        return a;
    }
}
