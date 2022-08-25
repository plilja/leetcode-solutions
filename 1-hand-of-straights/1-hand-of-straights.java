class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> cardCount = new TreeMap<>();
        for (int card : hand) {
            cardCount.merge(card, 1, (a, b) -> a + b);
        }
        while (!cardCount.isEmpty()) {
            var smallestEntry = cardCount.firstEntry();
            int smallest = smallestEntry.getKey();
            int smallestCount = smallestEntry.getValue();
            if (smallestCount == 1) {
                cardCount.remove(smallest);
            } else {
                cardCount.merge(smallest, -1, (a, b) -> a + b);
            }
            for (int i = 1; i < groupSize; ++i) {
                int newCount = cardCount.merge(smallest + i, -1, (a, b) -> a + b);
                if (newCount == -1) {
                    return false;
                } else if (newCount == 0) {
                    cardCount.remove(smallest + i);
                }
            }
            
        }
        return true;
    }
}
