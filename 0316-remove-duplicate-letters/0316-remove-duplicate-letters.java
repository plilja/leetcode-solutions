class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, TreeSet<Integer>> charsToIndexes = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            charsToIndexes.computeIfAbsent(c, k -> new TreeSet<>()).add(i);
        }
        StringBuilder result = new StringBuilder();
        while (!charsToIndexes.isEmpty()) {
            int indexWithAllCharsToRight = s.length() - 1;
            for (var indexes : charsToIndexes.values()) {
                indexWithAllCharsToRight = Math.min(indexWithAllCharsToRight, indexes.last());
            }
            int indexOfCharToPlant = -1;
            char charToPlant = '?';
            for (var entry : charsToIndexes.entrySet()) {
                int firstIndex = entry.getValue().first();
                if (firstIndex > indexWithAllCharsToRight) {
                    continue;
                }
                if (indexOfCharToPlant == -1 || entry.getKey() < charToPlant) {
                    indexOfCharToPlant = firstIndex;
                    charToPlant = entry.getKey();
                }
            }
            charsToIndexes.remove(charToPlant);
            result.append(charToPlant);
            for (var entry : charsToIndexes.entrySet()) {
                while (entry.getValue().first() < indexOfCharToPlant) {
                    entry.getValue().remove(entry.getValue().first());
                }
            }
        }
        return result.toString();
    }
}