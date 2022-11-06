class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < values.length; ++i) {
            items.add(new Item(values[i], labels[i]));
        }
        items.sort((a, b) -> b.value - a.value);
        Map<Integer, Integer> labelCount = new HashMap<>();
        int score = 0;
        int numRemaining = numWanted;
        for (Item item : items) {
            int alreadyUsed = labelCount.getOrDefault(item.label, 0);
            if (alreadyUsed < useLimit) {
                numRemaining--;
                score += item.value;
                labelCount.put(item.label, alreadyUsed + 1);
            }
            if (numRemaining == 0) {
                break;
            }
        }
        return score;
    }
    
    private record Item(int value, int label) {
    }
}