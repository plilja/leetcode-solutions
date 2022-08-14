class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        Map<Character, Integer> neededCharCounts = new HashMap<>();
        for (String word : words2) {
            Map<Character, Integer> neededCharCountsForWord = letterCounts(word);
            for (var entry : neededCharCountsForWord.entrySet()) {
                int prev = neededCharCounts.getOrDefault(entry.getKey(), 0);
                neededCharCounts.put(entry.getKey(), Math.max(entry.getValue(), prev));
            }
        }
        List<String> result = new ArrayList<>();
        for (String word : words1) {
            Map<Character, Integer> charCounts = letterCounts(word);
            boolean match = true;
            for (var entry : neededCharCounts.entrySet()) {
                if (charCounts.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                    match = false;
                    break;
                }
            }
            if (match) {
                result.add(word);
            }
        }
        return result;
    }
    
    private Map<Character, Integer> letterCounts(String str) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < str.length(); ++i) {
            result.merge(str.charAt(i), 1, (a, b) -> a + b);
        }
        return result;
    }
}
