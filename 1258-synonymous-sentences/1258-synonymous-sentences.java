class Solution {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, Set<String>> thesaurus = makeThesaurus(synonyms);
        String[] words = text.split(" ");
        List<String> result = new ArrayList<>();
        solve("", 0, words, thesaurus, result);
        Collections.sort(result);
        return result;
    }
    
    private void solve(String current, int pointer, String[] words, Map<String, Set<String>> thesaurus, List<String> result) {
        if (pointer == words.length) {
            result.add(current);
        } else {
            String word = words[pointer];
            for (String synonym : getSynonyms(word, thesaurus)) {
                if (current.length() == 0) {
                    solve(synonym, pointer + 1, words, thesaurus, result);
                } else {
                    solve(current + " " + synonym, pointer + 1, words, thesaurus, result);
                }
            }
        }
    }
    
    private Set<String> getSynonyms(String word, Map<String, Set<String>> thesaurus) {
        Deque<String> q = new ArrayDeque<>();
        q.add(word);
        Set<String> result = new HashSet<>();
        while (!q.isEmpty()) {
            String synonym = q.poll();
            if (result.contains(synonym)) {
                continue;
            }
            result.add(synonym);
            for (String w : thesaurus.getOrDefault(synonym, Set.of())) {
                q.add(w);
            }
        }
        return result;
    }
    
    private Map<String, Set<String>> makeThesaurus(List<List<String>> synonyms) {
        Map<String, Set<String>> thesaurus = new HashMap<>();
        for (List<String> synonymPair : synonyms) {
            String a = synonymPair.get(0);
            String b = synonymPair.get(1);
            thesaurus.computeIfAbsent(a, k -> new HashSet<>()).add(b);
            thesaurus.computeIfAbsent(b, k -> new HashSet<>()).add(a);
        }
        return thesaurus;
    }
}
