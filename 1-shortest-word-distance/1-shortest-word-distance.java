class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        TreeSet<Integer> word1Indexes = new TreeSet<>();
        for (int i = 0; i < wordsDict.length; ++i) {
            if (wordsDict[i].equals(word1)) {
                word1Indexes.add(i);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; ++i) {
            if (wordsDict[i].equals(word2)) {
                Integer prev = word1Indexes.floor(i);
                if (prev != null) {
                    result = Math.min(result, i - prev);
                }
                Integer next = word1Indexes.ceiling(i);
                if (next != null) {
                    result = Math.min(result, next - i);
                }
            }
        }
        return result;
    }
}
