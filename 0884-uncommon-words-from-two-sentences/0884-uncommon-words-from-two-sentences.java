class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> wordCounts = new HashMap<>();
        addWords(s1, wordCounts);
        addWords(s2, wordCounts);
        List<String> result = new ArrayList<>();
        for (var entry : wordCounts.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        return result.toArray(new String[]{});
    }
    
    private void addWords(String s, Map<String, Integer> wordCounts) {
        String[] words = s.split(" ");
        for (String w : words) {
            wordCounts.merge(w, 1, (a, b) -> a + b);
        }
    }
}