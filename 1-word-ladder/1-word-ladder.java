class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        var graph = buildGraph(beginWord, wordList);
        Map<String, Integer> dists = new HashMap<>();
        Deque<String> q = new ArrayDeque<>();
        q.add(beginWord);
        dists.put(beginWord, 1);
        while (!q.isEmpty()) {
            String word = q.poll();
            int dist = dists.get(word);
            for (String neighbourWord : graph.get(word)) {
                if (!dists.containsKey(neighbourWord)) {
                    dists.put(neighbourWord, dist + 1);
                    q.add(neighbourWord);
                }
            }
        }
        return dists.getOrDefault(endWord, 0);
    }
    
    private Map<String, List<String>> buildGraph(String beginWord, List<String> wordList) {
        Map<String, List<String>> result = new HashMap<>();
        for (int i = -1; i < wordList.size() - 1; ++i) {
            String word;
            if (i == -1) {
                word = beginWord;
            } else {
                word = wordList.get(i);
            }
            for (int j = i + 1; j < wordList.size(); ++j) {
                String otherWord = wordList.get(j);
                if (areAdjacent(word, otherWord)) {
                    result.computeIfAbsent(word, k -> new ArrayList<>()).add(otherWord);
                    result.computeIfAbsent(otherWord, k -> new ArrayList<>()).add(word);
                }
            }
        }
        return result;
    }
    
    private boolean areAdjacent(String word1, String word2) {
        if (word1.length() != word2.length()) {
            throw new IllegalArgumentException("Words %s and %s have different lengths".formatted(word1, word2));
        }
        int diff = 0;
        for (int i = 0; i < word1.length(); ++i) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
        }
        return diff <= 1;
    }
}
