class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordToCount = new HashMap<>();
        for (String word : words) {
            wordToCount.merge(word, 1, (a, b) -> a + b);
        }
        TreeMap<Integer, TreeSet<String>> countToWord = new TreeMap<>((a, b) -> b - a);
        for (var entry : wordToCount.entrySet()) {
            countToWord.computeIfAbsent(entry.getValue(), g -> new TreeSet<>()).add(entry.getKey());
        }
        List<String> result = new ArrayList<>();
        for (var entry : countToWord.entrySet()) {
            for (String word : entry.getValue()) {
                result.add(word);
                if (result.size() == k) {
                    break;
                }
            }
            if (result.size() == k) {
                break;
            }
        }
        return result;
    }
}
