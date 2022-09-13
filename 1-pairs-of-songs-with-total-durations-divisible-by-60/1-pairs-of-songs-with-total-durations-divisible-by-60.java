class Solution {
    public int numPairsDivisibleBy60(int[] times) {
        int result = 0;
        Map<Integer, Integer> songTimeToCount = new HashMap<>();
        for (int time : times) {
            int timeMod60 = time % 60;
            int rem = (60 - timeMod60) % 60;
            result += songTimeToCount.getOrDefault(rem, 0);
            songTimeToCount.merge(timeMod60, 1, (a, b) -> a + b);
        }
        return result;
    }
}
