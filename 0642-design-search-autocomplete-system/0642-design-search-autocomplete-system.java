class AutocompleteSystem {
    private StringBuilder currentSentence = new StringBuilder();
    private final TreeMap<String, Integer> sentences = new TreeMap<>();

    public AutocompleteSystem(String[] sentencesArr, int[] times) {
        for (int i = 0; i < times.length; ++i) {
            String sentence = sentencesArr[i];
            int hot = times[i];
            sentences.put(sentence, hot);
        }
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            // end sentence
            sentences.merge(currentSentence.toString(), 1, (a, b) -> a + b);
            currentSentence = new StringBuilder();
            return List.of();
        } else {
            currentSentence.append(c);
            TreeSet<Pair> threeHottest = new TreeSet<>((a, b) -> {
                if (a.hot != b.hot) {
                    return b.hot - a.hot;
                } else {
                    return a.sentence.compareTo(b.sentence);
                }
            });
            for (var entry : sentences.tailMap(currentSentence.toString()).entrySet()) {
                if (!entry.getKey().startsWith(currentSentence.toString())) {
                    break;
                }
                Pair p = new Pair(entry.getValue(), entry.getKey());
                threeHottest.add(p);
                if (threeHottest.size() > 3) {
                    threeHottest.pollLast();
                }
            }
            List<String> result = new ArrayList<>();
            for (Pair p : threeHottest) {
                result.add(p.sentence);
            }
            return result;
        }
    }
    
    private record Pair(int hot, String sentence) {}
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */