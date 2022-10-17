class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int numEmpty = 0;
        int numFull = numBottles;
        int numDrank = 0;
        while (numFull > 0 || numEmpty >= numExchange) {
            if (numFull > 0) {
                numEmpty += numFull;
                numDrank += numFull;
                numFull = 0;
            } else {
                numFull = numEmpty / numExchange;
                numEmpty = numEmpty % numExchange;
            }
        }
        return numDrank;
    }
}
