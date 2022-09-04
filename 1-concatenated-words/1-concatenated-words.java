class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] wordsArr) {
        Set<String> words = new HashSet<>();
        for (String word : wordsArr) {
            words.add(word);
        }
        List<String> result = new ArrayList<>();
        for (String word : wordsArr) {
            words.remove(word);
            boolean[] concatenated = new boolean[word.length() + 1];
            concatenated[word.length()] = true;
            for (int i = word.length() - 1; i >= 0; --i) {
                StringBuilder subWord = new StringBuilder();
                for (int j = i; j < word.length() && !concatenated[i]; ++j) {
                    subWord.append(word.charAt(j));
                    if (words.contains(subWord.toString())) {
                        concatenated[i] = concatenated[j + 1];
                    }
                }
            }
            if (concatenated[0]) {
                result.add(word);
            }
            words.add(word);
        }
        return result;
    }
}
