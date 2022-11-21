class Solution {
    public int countCharacters(String[] words, String chars) {
        var charCounts = getCharCounts(chars);
        int result = 0;
        for (String w : words) {
            var wordCharCounts = getCharCounts(w);
            boolean valid = wordCharCounts.entrySet().stream()
                .allMatch(entry -> charCounts.getOrDefault(entry.getKey(), 0) >= entry.getValue());
            if (valid) {
                result += w.length();
            }
        }
        return result;
    }
    
    private Map<Character, Integer> getCharCounts(String s) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            result.merge(c, 1, (a, b) -> a + b);
        }
        return result;
    }
}