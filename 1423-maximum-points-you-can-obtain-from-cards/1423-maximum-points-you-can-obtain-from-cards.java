class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int acc = 0;
        Deque<Integer> kNumbers = new ArrayDeque<>();
        for (int i = 0; i < k; ++i) {
            int points = cardPoints[i];
            kNumbers.addFirst(points);
            acc += points;
        }
        int result = acc;
        for (int i = 0; i < k; ++i) {
            int points = cardPoints[cardPoints.length - 1 - i];
            int otherEnd = kNumbers.poll();
            acc += points;
            acc -= otherEnd;
            result = Math.max(result, acc);
        }
        return result;
    }
}
